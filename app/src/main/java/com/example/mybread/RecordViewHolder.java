package com.example.mybread;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mybread.model.Record;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class RecordViewHolder extends RecyclerView.ViewHolder {
    protected TextView recipeName;
    protected TextView recipeCreationDate;
    protected ImageView recipeImage;

    public RecordViewHolder(@NonNull View itemView) {
        super(itemView);
        recipeName = itemView.findViewById(R.id.name);
        recipeCreationDate = itemView.findViewById(R.id.recordDateView);
        recipeImage = itemView.findViewById(R.id.avatar_imageView);
    }

    public void bind(Record record) {
        recipeName.setText(record.text);
        DateFormat fmt = new SimpleDateFormat("MMM-FF");
        recipeCreationDate.setText(fmt.format(record.date));
    }
}
