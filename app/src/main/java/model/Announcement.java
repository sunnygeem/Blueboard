package model;

import java.util.Date;
import java.util.List;

public class Announcement {
    // Fields
    private String id;
    private String detail;
    private Date uploadTime;
    private List<String> files;
    private String title;
    private List<String> comments;

    // Constructor
    private Announcement(String id, String detail, Date uploadTime,
                         List<String> files, String title, List<String> comments) {
        this.id = id;
        this.detail = detail;
        this.uploadTime = uploadTime;
        this.files = files;
        this.title = title;
        this.comments = comments;
    }

    // Named Constructor
    public static Announcement makeAnnouncement() {
        // named constructor
        // TODO: implement
        return new Announcement(null, null, null, null, null, null);
    }

    // Methods (If additional methods are needed for Announcement, add them here)
}

