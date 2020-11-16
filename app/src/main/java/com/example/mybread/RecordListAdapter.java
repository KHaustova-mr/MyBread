package com.example.mybread;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mybread.model.Record;

import java.util.ArrayList;
import java.util.List;

public class RecordListAdapter  extends RecyclerView.Adapter{

    public List<Record> messageList = new ArrayList<>();
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.record_in_main,parent,false);
        return new RecordViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((RecordViewHolder) holder).bind(messageList.get(position));
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }
}
