package com.example.mybread;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    LinearLayout contentLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        contentLinearLayout = (LinearLayout) findViewById(R.id.content_linearLayout);
        setContentView(R.layout.activity_main);
        for(int i = 0; i < 10; i++){
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
            tv1.setText("text1");
            tv2.setText("text2");
            layout2.addView(tv1);
            layout2.addView(tv2);
            contentLinearLayout.addView(itemLinearLayout);
        }
    }

    public void AddClick(View view) {
        Intent intent = new Intent(getApplicationContext(), NewRecipe.class);
        startActivity(intent);
    }


}
