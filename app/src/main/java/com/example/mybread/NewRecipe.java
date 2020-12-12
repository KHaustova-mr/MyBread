package com.example.mybread;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mybread.model.Recipe;
import com.example.mybread.saveData.RecipeOnFile;

import java.io.IOException;


public class NewRecipe extends AppCompatActivity {
    static final int GALLERY_REQUEST = 1;
    EditText TextId, TextSite, TextRecipe;
    ImageView ImageRecipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_recipe);

        TextId = (EditText) findViewById(R.id.name_new_recipeText);
        TextSite = (EditText) findViewById(R.id.edit_siteText);
        TextRecipe = (EditText) findViewById(R.id.name_blockText);
        ImageRecipe = (ImageView) findViewById(R.id.new_recipe_image_view);
    }

    public void newImageOnClick(View view) {
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, GALLERY_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);
        String filePath;
        Bitmap bitmap = null;

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
                    ImageRecipe.setImageBitmap(bitmap);
                }
        }
    }

    public void SaveClick(View view){
        System.out.println("Нажатие на кнопку");
        Recipe recipe = new Recipe();
        recipe.setId(TextId.getText().toString());
        recipe.setSite(TextSite.getText().toString());
        recipe.setText(TextRecipe.getText().toString());

        RecipeOnFile.saveRecipe(this, recipe);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
