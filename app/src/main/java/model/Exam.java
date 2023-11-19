package model;

import java.util.Date;
import java.util.List;

public class Exam extends LectureContent {
    // Additional Fields
    private Date date;
    private String location;

    // Constructor
    private Exam(String id, String title, int week, Date deadline,
                 String type, List<String> files, String detail,
                 Date date, String location) {
        super(id, title, week, deadline, type, files, detail);
        this.date = date;
        this.location = location;
    }

    // Named Constructor
    public static Exam makeExam() {
        // named constructor
        // TODO: implement
        return new Exam(null, null, 0, null, null, null, null, null, null);
    }

    // Methods (If additional methods are needed for Exam, add them here)

    // getter
    public Date getDate() {
        return date;
    }

    public String getLocation() {
        return location;
    }
}

