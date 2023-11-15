package model;

import java.util.Date;
import java.util.List;

public class Reply extends Message {
    // Additional Fields
    private String rootMessage;

    // Constructor
    private Reply(String id, String receiverId, String senderId, String title,
                  String content, Date date, List<String> replies,
                  List<String> files, boolean isRead, String rootMessage) {
        super(id, receiverId, senderId, title, content, date, replies, files, isRead);
        this.rootMessage = rootMessage;
    }

    // Named Constructor
    public static Reply makeReply() {
        // named constructor
        // TODO: implement
        return new Reply(null, null, null, null, null, null, null, null, false, null);
    }

    // Methods (If additional methods are needed for Reply, add them here)
}

