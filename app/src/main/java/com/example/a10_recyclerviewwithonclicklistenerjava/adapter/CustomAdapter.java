package com.example.a10_recyclerviewwithonclicklistenerjava.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a10_recyclerviewwithonclicklistenerjava.R;
import com.example.a10_recyclerviewwithonclicklistenerjava.activity.MainActivity;
import com.example.a10_recyclerviewwithonclicklistenerjava.model.Member;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter {
    MainActivity activity;
    List<Member> members;

    public CustomAdapter(MainActivity activity, List<Member> members) {
        this.activity = activity;
        this.members = members;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_activity_view, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
       Member member = members.get(position);
        if (holder instanceof CustomViewHolder) {
            LinearLayout lay_clik = ((CustomViewHolder) holder).lay_clik;
            TextView tv_name = ((CustomViewHolder) holder).tv_name;
            TextView tv_tel_name = ((CustomViewHolder) holder).tv_tel_number;

            tv_name.setText(member.getTv_name());
            tv_tel_name.setText(member.getTv_tel_number());
            lay_clik.setOnClickListener((v) -> {
                activity.openItemDaetails(member);
            });
        }
    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    private class CustomViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_name, tv_tel_number;
        public View view;
        private LinearLayout lay_clik;

        public CustomViewHolder(View v) {
            super(v);
            view = v;
            tv_name = view.findViewById(R.id.tv_name);
            tv_tel_number = view.findViewById(R.id.tv_tel_number);
            lay_clik = view.findViewById(R.id.item_layout);
        }
    }
}
