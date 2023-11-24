package com.se.blueboard;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import adapter.ContentsListAdapter;
import model.LectureContent;

public class ContentsPage extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contents);

        // Test Dummy Data
        LectureContent lectureContent1 = LectureContent.makeLectureContent("test1", "test1", 1, null, null, null, null);
        LectureContent lectureContent2 = LectureContent.makeLectureContent("test2", "test2", 2, null, null, null, null);
        LectureContent lectureContent3 = LectureContent.makeLectureContent("test3", "test3", 3, null, null, null, null);
        LectureContent lectureContent4 = LectureContent.makeLectureContent("test4", "test4", 4, null, null, null, null);

        ArrayList<LectureContent> lectureContentsList = new ArrayList<>();
        lectureContentsList.add(lectureContent1);
        lectureContentsList.add(lectureContent2);
        lectureContentsList.add(lectureContent3);
        lectureContentsList.add(lectureContent4);


        ListView contentsListView = findViewById(R.id.lectureContents_contentsList);
        ContentsListAdapter contentsListAdapter = new ContentsListAdapter(lectureContentsList);
        contentsListView.setAdapter(contentsListAdapter);

    }
}