package com.se.blueboard;

import static com.se.blueboard.LecturePage.currentLecture;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.sql.Array;

public class GroupsPage extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.groups);

        ArrayAdapter adminListAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, currentLecture.getManagers());

        ListView adminslistView = findViewById(R.id.userGroups_administratorsList);
        adminslistView.setAdapter(adminListAdapter);

        ArrayAdapter userListAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, currentLecture.getStudents());
        ListView userslistView = findViewById(R.id.userGroups_userList);
        userslistView.setAdapter(userListAdapter);
    }
}
