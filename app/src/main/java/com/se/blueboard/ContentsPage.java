package com.se.blueboard;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContentsPage extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contents);

        // Test Contents List
        String[] listAdmin = {"Admin1", "Admin2", "Admin3"};
        ArrayAdapter adminListAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listAdmin);

        ListView adminslistView = findViewById(R.id.lectureContents_contentsList);
        adminslistView.setAdapter(adminListAdapter);
    }
}