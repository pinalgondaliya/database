package com.oscar.career.myapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.oscar.career.myapplication.appdatabase.Student;

import java.util.List;

public class RecAdapter extends RecyclerView.Adapter<RecAdapter.AppHolder> {

    List<Student> s;

    public RecAdapter(List<Student> s){
        this.s = s;
    }

    @NonNull
    @Override
    public AppHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rec_item,parent,false);

        return new AppHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AppHolder holder, int position) {
        holder.e.setText(String.valueOf(s.get(position).enrollNo));
        holder.n.setText(s.get(position).name);
    }

    @Override
    public int getItemCount() {
        return s.size();
    }

    class AppHolder extends RecyclerView.ViewHolder{

        public TextView n,e;

        public AppHolder(@NonNull View itemView) {
            super(itemView);

            n = itemView.findViewById(R.id.name);
            e = itemView.findViewById(R.id.enroll);
        }
    }

}
