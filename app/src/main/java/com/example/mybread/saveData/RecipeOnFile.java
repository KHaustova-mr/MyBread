package com.example.mybread.saveData;

import android.content.Context;
import android.graphics.Bitmap;

import com.example.mybread.model.Recipe;

import java.io.File;
import java.util.ArrayList;

public class RecipeOnFile {
    public static String saveImage(Context context, Bitmap bitmap){

        return null;
    }

    public static void saveRecipe(Context context, Recipe recipe){
        File internalStorageDir = context.getFilesDir();
        File file = new File(internalStorageDir.getAbsolutePath()+"/recipes/");
        System.out.println();
    }

    public static ArrayList<Recipe> getRecipes(Context context){
        return null;
    }

}
