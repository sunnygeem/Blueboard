package com.se.blueboard;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import utils.Utils;

public class LecturePage extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lecture);

        // 전달 받은 intent의 lectureName으로 변경
        setLectureName(getIntent().getExtras().getString("lectureName"));

        // Home button
        Button homeButton = findViewById(R.id.goto_main);
        homeButton.setOnClickListener(view -> {
            Utils.gotoPage(getApplicationContext(), HomePage.class);
        });
        // Announcement button
        Button announcementButton = findViewById(R.id.goto_announcement);
        announcementButton.setOnClickListener(view -> {
            Utils.gotoPage(getApplicationContext(), AnnouncementPage.class);
        });
        // User & Group button
        Button userGroupButton = findViewById(R.id.goto_userGroup);
        userGroupButton.setOnClickListener(view -> {
            Utils.gotoPage(getApplicationContext(), GroupsPage.class);
        });
        // LectureContents button
        Button lectureContentsButton = findViewById(R.id.goto_lectureContents);
        lectureContentsButton.setOnClickListener(view -> {
            Utils.gotoPage(getApplicationContext(), ContentsPage.class);
        });
        // Attendance button
        Button attendanceButton = findViewById(R.id.goto_attendance);
        attendanceButton.setOnClickListener(view -> {
            Utils.gotoPage(getApplicationContext(), AttendancePage.class);
        });
    }

    // Parameter로 lectureName을 받아 cover의 lecture name을 변경하는 메소드
    public void setLectureName(String lectureName) {
        TextView coverLectureName = findViewById(R.id.cover_lecture_name);
        coverLectureName.setText(lectureName);
    }
}
