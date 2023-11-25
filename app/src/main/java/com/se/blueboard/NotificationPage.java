package com.se.blueboard;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class NotificationPage extends AppCompatActivity {

    @Override protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification);

        //사용자의 경우 과제 생성 알림 -> 제출 버튼, 그 외 모두 확인 버튼

    }

}
