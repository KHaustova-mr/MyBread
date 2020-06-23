package com.example.mybread;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mybread.model.Recipe;
import com.example.mybread.model.RecipeOnFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class NewRecipe extends AppCompatActivity {
    static final int GALLERY_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_recipe);
    }

    public void newImageOnClick(View view) {
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, GALLERY_REQUEST);
    }
    String filePath;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);

        Bitmap bitmap = null;
        ImageView imageView = (ImageView) findViewById(R.id.new_recipe_image_view);

        switch(requestCode) {
            case GALLERY_REQUEST:
                if(resultCode == RESULT_OK){
                    Uri selectedImage = imageReturnedIntent.getData();
                    String[] filePathColumn = {MediaStore.Images.Media.DATA};
                    Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
                    cursor.moveToFirst();

                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                    filePath = cursor.getString(columnIndex);
                    cursor.close();
                    try {
                        bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImage);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    imageView.setImageBitmap(bitmap);
                }
        }
    }

    EditText TextId, TextSite, TextRecipe;
    ImageView ImageRecipe;

    public void OkClick(View view) {
        TextId = (EditText) findViewById(R.id.name_new_recipeText);
        TextSite = (EditText) findViewById(R.id.edit_siteText);
        TextRecipe = (EditText) findViewById(R.id.name_blockText);
        ImageRecipe = (ImageView) findViewById(R.id.new_recipe_image_view);

        Recipe recipe = new Recipe();
        recipe.setId(TextId.getText().toString());
        recipe.setSite(TextSite.getText().toString());
        recipe.setText(TextRecipe.getText().toString());

        recipe.setPathimage("url картинки");

        System.out.println(recipe.toString());


        //RecipeOnFile newrecipe = new RecipeOnFile(TextId.getText().toString(), TextSite.getText().toString(), TextRecipe.getText().toString(), filePath);
    }
}
