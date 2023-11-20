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

    private Announcement() {}

    // Named Constructor
    public static Announcement makeAnnouncement() {
        // named constructor
        // TODO: implement
        return new Announcement(null, null, null, null, null, null);
    }

    // Methods (If additional methods are needed for Announcement, add them here)

    // getter
    public String getId() {
        return id;
    }

    public String getDetail() {
        return detail;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public List<String> getFiles() {
        return files;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getComments() {
        return comments;
    }
}

