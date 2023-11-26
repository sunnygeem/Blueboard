package com.se.blueboard;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import adapter.MessageAdapter;
import model.Message;

public class MessagePage extends AppCompatActivity {

    private List<Message> messageList;
    private MessageAdapter messageAdapter;

    private static Context context;

    public static Context getContext() {
        return context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message);
        context = this;

        // Initialize the messageList with sample data
        messageList = new ArrayList<>();
        messageList.add(new Message("1", "Sender1", "Receiver1", "Title1", "Content1", new Date(), null, null, false));
        messageList.add(new Message("2", "Sender2", "Receiver2", "Title2", "Content2", new Date(), null, null, true));
        // Add more messages as needed

        // Initialize the MessageAdapter
        messageAdapter = new MessageAdapter(this, messageList);

        // Find the ListView in message.xml and set the adapter
        ListView messageListView = findViewById(R.id.message_messageList);
        messageListView.setAdapter(messageAdapter);
    }
}
