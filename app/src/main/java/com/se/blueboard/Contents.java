package com.se.blueboard;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Contents extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.contents);
        // Dummy data for recyclerView test
        ArrayList<String> testDataSet = new ArrayList<>();
        for(int i = 0; i < 20; i++) {
            testDataSet.add("test" + i);
        }

        RecyclerView recyclerView = findViewById(R.id.lectureContents_recyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        CustomAdapter customAdapter = new CustomAdapter(testDataSet);

        recyclerView.setAdapter(customAdapter);
    }
}
