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

        // Admin이면 관리자 버튼 띄워주도록 수정할 것

        Button editButton = findViewById(R.id.edit);
        editButton.setOnClickListener(view -> {
            Utils.gotoPage(getApplicationContext(), EditProfilePage.class);
        });

        Button homeButton = findViewById(R.id.icon_home);
        homeButton.setOnClickListener(view -> {
            Utils.gotoPage(getApplicationContext(), HomePage.class);
        });

        Button notiButton = findViewById(R.id.icon_notification);
        notiButton.setOnClickListener(view -> {
            Utils.gotoPage(getApplicationContext(), NotificationPage.class);
        });
    }
}
