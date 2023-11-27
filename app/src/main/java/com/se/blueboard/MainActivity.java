package com.se.blueboard;

import static android.content.ContentValues.TAG;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utils.MyCallback;
import utils.Utils;
import model.User;
import utils.FirebaseController;
import utils.Utils;

public class MainActivity extends AppCompatActivity {
    private static Context context;
    // 앱 실행시 권한 허가 필요
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            android.Manifest.permission.READ_EXTERNAL_STORAGE,
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
            android.Manifest.permission.POST_NOTIFICATIONS
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // main screen (9 buttons)
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        verifyStoragePermissions(this);
        // Firestore test
        Button firestoreButton = findViewById(R.id.firestore);
        firestoreButton.setOnClickListener(v -> {
            // FirebaseController test
            List<String> listA = new ArrayList<String>();
            listA.add("t1");
            listA.add("t2");

            User user = new User("abc5", "test", "test", "test", "test", "test", "test", listA, null, null, null, 1, 1);
            FirebaseController controller = new FirebaseController();
            // delete test
            // controller.deleteData("users", "abc1");
            // send test
            //controller.sendUserData(user);
            // get test
//            controller.getUserData("abc1", new MyCallback() {
//                @Override
//                public void onSuccess(Object object) {
//                    User user = (User) object;
//                    Log.d("onSuccess", user.toString());
//                }
//
//                @Override
//                public void onFailure(Exception e) {
//                    Log.d("GetUserData", e.getMessage());
//                }
//            });
            // update test
//            controller.updateData(user);
            // upload test

//            File dir =  Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
//            File file = dir.listFiles()[0];

//            File file = new File("/storage/emulated/0/Pictures/IMG_20231123_182503.jpg");
//            controller.uploadFile(file);
            String name = "1-CourseIntro.pdf";
            controller.downloadFile(name);
//            Log.d("TestTest", Environment.DIRECTORY_DOWNLOADS);
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

        Button pushButton = findViewById(R.id.push);
        pushButton.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(
                    getApplicationContext(),
                    0,
                    intent,
                    PendingIntent.FLAG_IMMUTABLE
            );

            Utils.makeUtils().pushAlarm(getApplicationContext(), "test_channel", 1, "title", "text", pendingIntent);
        });

    }

    public static Context getContext(){
        return MainActivity.context;
    }

    public static void verifyStoragePermissions(Activity activity) {
        // Check if we have write permission
        int permission = ActivityCompat.checkSelfPermission(activity, android.Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
    }

}