package com.se.blueboard;

import static com.se.blueboard.HomePage.userLectureList;

import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import adapter.AttendanceListAdapter;
import model.LearningStatus;
import model.LectureContent;

public class AttendancePage extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.attendance);

        // Dummy Test Data
        ArrayList<LectureContent> lectureContentArrayList = new ArrayList<>();
        LectureContent c1 = LectureContent.makeLectureContent("1", "c1", 1,null,null,null,null);
        LectureContent c2 = LectureContent.makeLectureContent("2", "c2", 1,null,null,null,null);
        LectureContent c3 = LectureContent.makeLectureContent("3", "c3", 1,null,null,null,null);
        LectureContent c4 = LectureContent.makeLectureContent("4", "c4", 1,null,null,null,null);
        lectureContentArrayList.add(c1);
        lectureContentArrayList.add(c2);
        lectureContentArrayList.add(c3);
        lectureContentArrayList.add(c4);

        ArrayList<LearningStatus> statusList = new ArrayList<>();
        LearningStatus l1 = LearningStatus.makeLearningStatus("1", "abc1", "12345", "1","출석");
        LearningStatus l2 = LearningStatus.makeLearningStatus("2", "abc1", "12345", "2","결석");
        LearningStatus l3 = LearningStatus.makeLearningStatus("3", "abc1", "12345", "3","지각");
        LearningStatus l4 = LearningStatus.makeLearningStatus("4", "abc1", "12345", "4","출석");
        statusList.add(l1);
        statusList.add(l2);
        statusList.add(l3);
        statusList.add(l4);

        // Set ListView
        ListView listView = (ListView) findViewById(R.id.attendance_listView);
        AttendanceListAdapter attendanceListAdapter = new AttendanceListAdapter(lectureContentArrayList, statusList);
        listView.setAdapter(attendanceListAdapter);
    }
}
