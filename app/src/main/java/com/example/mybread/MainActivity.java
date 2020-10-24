package com.example.mybread;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mybread.model.Recipe;
import com.example.mybread.saveData.RecipeOnFile;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    LinearLayout contentLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contentLinearLayout =  findViewById(R.id.content_linearLayout);
        ArrayList<Recipe> recipes = RecipeOnFile.getRecipes(this);
        System.out.println(recipes);
        /*for(Recipe recipe : recipes){
            LinearLayout itemLinearLayout = new LinearLayout(this);
            itemLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            itemLinearLayout.setOrientation(LinearLayout.HORIZONTAL);
            //children of paren linear layout
            ImageView iv = new ImageView(this);
            LinearLayout layout2 = new LinearLayout(this);
            layout2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            itemLinearLayout.setOrientation(LinearLayout.VERTICAL);
            itemLinearLayout.addView(iv);
            itemLinearLayout.addView(layout2);
            //children of layout2 LinearLayout
            TextView tv1 = new TextView(this);
            TextView tv2 = new TextView(this);
            tv1.setText(recipe.getId());
            tv2.setText(recipe.getText());
            layout2.addView(tv1);
            layout2.addView(tv2);
            contentLinearLayout.addView(itemLinearLayout);

        }*/




        for(Recipe recipe : recipes){
            ConstraintLayout itemConstraintLayout = new ConstraintLayout(this);
            itemConstraintLayout.setLayoutParams(new ConstraintLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.WRAP_CONTENT));
            ImageView imageView = new ImageView(this);
            TextView textView = new TextView(this);
            textView.setText(recipe.getId());
            textView.setLayoutParams(
                    new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT)
            );
            itemConstraintLayout.addView(imageView);
            itemConstraintLayout.addView(textView);
            contentLinearLayout.addView(itemConstraintLayout);
        }
    }

    public void AddClick(View view) {
        Intent intent = new Intent(getApplicationContext(), NewRecipe.class);
        startActivity(intent);
    }


}
