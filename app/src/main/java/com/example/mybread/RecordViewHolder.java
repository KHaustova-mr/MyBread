package com.example.mybread;


import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mybread.model.Record;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class RecordViewHolder extends RecyclerView.ViewHolder {
    protected TextView messageText;
    protected TextView messageDate;

    public RecordViewHolder(@NonNull View itemView) {
        super(itemView);
        messageText = itemView.findViewById(R.id.name);
        messageDate = itemView.findViewById(R.id.recordDateView);
    }

    public void bind(Record record) {
        messageText.setText(record.text);
        DateFormat fmt = new SimpleDateFormat("MMM-F");
        messageDate.setText(fmt.format(record.date));
    }
}
