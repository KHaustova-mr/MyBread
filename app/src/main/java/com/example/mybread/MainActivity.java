package com.example.mybread;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mybread.model.Recipe;
import com.example.mybread.model.Record;
import com.example.mybread.saveData.RecipeOnFile;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    LinearLayout contentLinearLayout;
    protected RecyclerView recordList;
    protected RecordListAdapter recordListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //contentLinearLayout =  findViewById(R.id.content_linearLayout);
        //ArrayList<Recipe> recipes = RecipeOnFile.getRecipes(this);
        //System.out.println(recipes);
        recordListAdapter = new RecordListAdapter();
        recordList = findViewById(R.id.recordList);
        recordList.setLayoutManager(new LinearLayoutManager(this));
        recordList.setAdapter(recordListAdapter);

        recordList.setLayoutManager(new LinearLayoutManager(this));
        recordList.setAdapter(recordListAdapter);
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
            contentLinearLayout.addView(itemLinearLayout);}*/
    }

    public void AddClick(View view) {
        Intent intent = new Intent(getApplicationContext(), NewRecipe.class);
        startActivity(intent);
    }

    public void DelClick(View view) {
        TextView search = (TextView)findViewById(R.id.editText);
        search.setText("");
    }

   /*  final EditText editText = (EditText)findViewById(R.id.editText);
   public void onTextChanged(CharSequence s, int start, int before, int count) {
//только что заменены
        String strCatName = editText.getText().toString();
        editText=
    }*/
}

