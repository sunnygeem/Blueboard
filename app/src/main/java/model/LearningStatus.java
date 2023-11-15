package model;

public class LearningStatus {
    // Fields
    private String id;
    private String userId;
    private String courseId;
    private String contentId;
    private String status;

    // Constructor
    private LearningStatus(String id, String userId, String courseId, String contentId, String status) {
        this.id = id;
        this.userId = userId;
        this.courseId = courseId;
        this.contentId = contentId;
        this.status = status;
    }

    // Named Constructor
    public static LearningStatus makeLearningStatus() {
        // named constructor
        // TODO: implement
        return new LearningStatus(null, null, null, null, null);
    }

    // Methods
    public void setStatus(String newStatus) {
        // 출석, 지각, 결석 상태를 set
        // TODO: implement
    }

    public String getStatus() {
        // 해당 content에 대한 출석, 지각, 결석 상태를 get
        // TODO: implement
        return null;
    }
}

