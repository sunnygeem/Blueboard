package com.se.blueboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.se.blueboard.makeLecture.MakeLecturePageOne;

import adapter.MainLectureAdapter;
import model.Lecture;
import utils.Utils;

public class HomePage extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        GridView lectureGridView = (GridView) findViewById(R.id.main_lectureGridView);
        MainLectureAdapter mainLectureAdapter = new MainLectureAdapter();

        // Test Lecture list
        Lecture testLecture1 = Lecture.makeLecture("12345", "Software Engineering", "15",
                null, null, null, null, null);
        Lecture testLecture2 = Lecture.makeLecture("12346", "AI", "15",
                null,null, null, null, null);
        Lecture testLecture3 = Lecture.makeLecture("12348", "fu", "15",
                null, null, null, null,null);
        Lecture testLecture4 = Lecture.makeLecture("15245", "test", "15",
                null, null, null, null,null);

        mainLectureAdapter.addLecture(testLecture1);
        mainLectureAdapter.addLecture(testLecture2);
        mainLectureAdapter.addLecture(testLecture3);
        mainLectureAdapter.addLecture(testLecture4);
        // ------------------------------------

        lectureGridView.setAdapter(mainLectureAdapter);

        // Item click 시 이벤트: 해당 강의 화면으로 이동
        lectureGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // Click한 강의의 이름, ID를 intent에 담아 LecturePage에 전달
                Lecture clickedLecture = (Lecture) mainLectureAdapter.getItem(i);
                Intent intent = new Intent(getApplicationContext(), LecturePage.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("lectureName", clickedLecture.getName());
                intent.putExtra("lectureID", clickedLecture.getId());
                startActivity(intent);
            }
        });

        // 강의 생성 버튼
        Button makeLectureButton = findViewById(R.id.main_makeLecture);
        makeLectureButton.setOnClickListener(view -> {
            Utils.gotoPage(getApplicationContext(), MakeLecturePageOne.class);
        });
    }
}
