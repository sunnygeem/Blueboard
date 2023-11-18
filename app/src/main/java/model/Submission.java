package model;

import java.util.Date;

public class Submission {
    // Fields
    private String id;
    private String user;
    private String name;
    private Date date;

    // Constructor
    private Submission(String id, String user, String name, Date date) {
        this.id = id;
        this.user = user;
        this.name = name;
        this.date = date;
    }

    // Named Constructor
    public static Submission makeSubmission() {
        // named constructor
        // TODO: implement
        return new Submission(null, null, null, null);
    }

    // Methods
    public void addSubmission(String assignmentId, Submission newSubmission) {
        // Assignment나 Exam 클래스의 submission list에 추가함
        // TODO: implement
    }

    // getter
    public String getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }
}

