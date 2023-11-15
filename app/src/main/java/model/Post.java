package model;

import java.util.Date;
import java.util.List;

public class Post extends LectureContent {
    // Additional Fields
    private Date uploadTime;
    private List<String> comments;

    // Constructor
    private Post(String id, String title, int week, Date deadline,
                 String type, List<String> files, String detail,
                 Date uploadTime, List<String> comments) {
        super(id, title, week, deadline, type, files, detail);
        this.uploadTime = uploadTime;
        this.comments = comments;
    }

    // Named Constructor
    public static Post makePost() {
        // named constructor
        // TODO: implement
        return new Post(null, null, 0, null, null, null, null, null, null);
    }

    // Methods (If additional methods are needed for Post, add them here)
}

