package model;

import java.util.Date;
import java.util.List;

public class Assignment extends LectureContent {
    // Additional Fields
    private Date uploadTime;
    private Date deadline;
    private List<String> submissions;

    // Constructor
    private Assignment(String id, String title, int week, Date deadline,
                       String type, List<String> files, String detail,
                       Date uploadTime, Date deadlineDate, List<String> submissions) {
        super(id, title, week, deadline, type, files, detail);
        this.uploadTime = uploadTime;
        this.deadline = deadlineDate;
        this.submissions = submissions;
    }

    // Named Constructor
    public static Assignment makeAssignment() {
        // named constructor
        // TODO: implement
        return new Assignment(null, null, 0, null, null, null, null, null, null, null);
    }

    // Methods (If additional methods are needed for Assignment, add them here)

    // getter
    public Date getUploadTime() {
        return uploadTime;
    }

    public Date getDeadline() {
        return deadline;
    }

    public List<String> getSubmissions() {
        return submissions;
    }
}

