package com.example.a10_recyclerviewwithonclicklistenerjava.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.example.a10_recyclerviewwithonclicklistenerjava.R;
import com.example.a10_recyclerviewwithonclicklistenerjava.adapter.CustomAdapter;
import com.example.a10_recyclerviewwithonclicklistenerjava.model.Member;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Context context;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        List<Member> members = prepareMember();
        refreshAdapter(members);
    }

    private void refreshAdapter(List<Member> members) {
        CustomAdapter adapter = new CustomAdapter(this, members);
        recyclerView.setAdapter(adapter);
    }

    public void openItemDaetails(Member member){
        Log.d("@@@", "item is clicied " + member.getTv_name());
    }


    private List<Member> prepareMember() {
        List<Member> members = new ArrayList<>();

        for (int i = 0; i < 30; i++){
            members.add(new Member("Odilbek " + i, "+998-97-775-17-79"));
        }

        return members;
    }

    void initViews(){
        context = this;
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 1));
    }
}