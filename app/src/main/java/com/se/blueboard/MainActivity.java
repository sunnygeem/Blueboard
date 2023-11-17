package com.se.blueboard;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import utils.Utils;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // main screen (9 buttons)
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Firestore test
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        Button firestoreButton = findViewById(R.id.firestore);
        firestoreButton.setOnClickListener(v -> {
            // Add a new document with a generated id.
            Map<String, Object> data = new HashMap<>();
            data.put("name", "Tokyo");
            data.put("country", "Japan");

            db.collection("cities")
                    .add(data)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Log.d(TAG, "DocumentSnapshot written with ID: " + documentReference.getId());
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.w(TAG, "Error adding document", e);
                        }
                    });
        });

        // Login button
        Button loginButton = findViewById(R.id.login);
        loginButton.setOnClickListener(view -> {
            Utils.gotoPage(getApplicationContext(), LoginPage.class);
            
        });

        // Announcement button
        Button announcementButton = findViewById(R.id.announcement);
        announcementButton.setOnClickListener(view -> {
            Utils.gotoPage(getApplicationContext(), AnnouncementPage.class);
            
        });

        // Attendance button
        Button attendanceButton = findViewById(R.id.attendance);
        attendanceButton.setOnClickListener(view -> {
            Utils.gotoPage(getApplicationContext(), AttendancePage.class);
        });

        // Contents button
        Button contentsButton = findViewById(R.id.contents);
        contentsButton.setOnClickListener(view -> {
            Utils.gotoPage(getApplicationContext(), ContentsPage.class);
        });

        // Groups button
        Button groupsButton = findViewById(R.id.groups);
        groupsButton.setOnClickListener(view -> {
            Utils.gotoPage(getApplicationContext(), GroupsPage.class);
        });

        // Home button
        Button homeButton = findViewById(R.id.home);
        homeButton.setOnClickListener(view -> {
            Utils.gotoPage(getApplicationContext(), HomePage.class);
        });

        // Lecture button
        Button lectureButton = findViewById(R.id.lecture);
        lectureButton.setOnClickListener(view -> {
            Utils.gotoPage(getApplicationContext(), LecturePage.class);
        });

        // Message button
        Button messageButton = findViewById(R.id.message);
        messageButton.setOnClickListener(view -> {
            Utils.gotoPage(getApplicationContext(), MessagePage.class);
        });

        // Profile button
        Button profileButton = findViewById(R.id.profile);
        profileButton.setOnClickListener(view -> {
            Utils.gotoPage(getApplicationContext(), ProfilePage.class);
        });

    }
}