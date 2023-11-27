package com.se.blueboard;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import model.Message;
import utils.Utils;

public class MessageViewPage extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_view);

        // 뒤로가기 버튼
        Button back = findViewById(R.id.icon_back);
        back.setOnClickListener(view -> {
            Utils.gotoPage(this, MessageBoxPage.class);
        });
    }
}
