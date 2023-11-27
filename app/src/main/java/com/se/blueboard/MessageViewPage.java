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
import utils.FirebaseController;
import utils.Utils;

public class MessageViewPage extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_view);

        FirebaseController controller = new FirebaseController();

        // 메시지 객체 받아오기
//        Message message = Message.makeMessage(getIntent().getStringExtra("messageId"),)
        // 메시지 객체 받아오기
//        controller.getMessageData(message);

        // 뒤로가기 버튼
        Button back = findViewById(R.id.icon_back);
        back.setOnClickListener(view -> {
            Utils.gotoPage(this, MessageBoxPage.class, null);
        });

        // 삭제 버튼
        Button delete = findViewById(R.id.icon_delete);
        delete.setOnClickListener(view -> {
//            message.deleteMsg(message.getReceiverId()==MainActivity.loginUser.getAccountId());
        });


    }
}
