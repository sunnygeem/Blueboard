package com.se.blueboard;

import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import utils.Utils;

public class ProfilePage extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        Button editButton = findViewById(R.id.edit);
        editButton.setOnClickListener(view -> {
            Utils.gotoPage(getApplicationContext(), EditProfilePage.class);
        });

        Button homeButton = findViewById(R.id.icon_home);
        homeButton.setOnClickListener(view -> {
            Utils.gotoPage(getApplicationContext(), HomePage.class);
        });


    }
}
