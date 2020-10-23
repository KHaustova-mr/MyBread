package com.example.mybread.saveData;

import android.content.Context;
import android.graphics.Bitmap;

import com.example.mybread.model.Recipe;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class RecipeOnFile {
    public static String saveImage(Context context, Bitmap bitmap){
        return null;
    }

    public static void saveRecipe(Context context, Recipe recipe){
        File internalStorageDir = context.getFilesDir();
        File file = new File(internalStorageDir.getAbsolutePath()+"/recipes/recipe_"+recipe.getId());

        try {
            FileOutputStream outputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(recipe);
            objectOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Recipe> getRecipes(Context context){
        File internalStorageDir = context.getFilesDir();
        File dir = new File(internalStorageDir.getAbsolutePath()+"/recipes/"); //path указывает на директорию
        ArrayList<Recipe> recipes = new ArrayList<>();
        if (!dir.exists()) {
            dir.mkdir();
        }
        for ( File file : dir.listFiles() ) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

                Recipe recipe = (Recipe) objectInputStream.readObject();
                recipes.add(recipe);
                System.out.println(recipe);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return recipes;
    }

}
