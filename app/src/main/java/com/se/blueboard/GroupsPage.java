package com.se.blueboard;

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

        // Test Administrators list
        String[] listAdmin = {"Admin1", "Admin2", "Admin3"};
        ArrayAdapter adminListAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listAdmin);

        ListView adminslistView = findViewById(R.id.userGroups_administratorsList);
        adminslistView.setAdapter(adminListAdapter);

        // Test users list
        String[] listUser = {"User1", "User2", "User3"};
        ArrayAdapter userListAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listUser);

        ListView userslistView = findViewById(R.id.userGroups_userList);
        userslistView.setAdapter(userListAdapter);
    }
}
