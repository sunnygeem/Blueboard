package model;
import java.util.List;

public class User {
    // Fields
    private String id;
    private String accountId;
    private String name;
    private String institution;
    private String major;
    private String email;
    private String profile;
    private List<String> courses;
    private List<String> sentMessages;
    private List<String> receivedMessages;
    private List<String> alarms;
    private int grade;
    private long studentId;

    // Constructor
    // Firebase test 위해서 public으로 임시변경
    public User(String id, String accountId, String name, String institution,
                String major, String email, String profile, List<String> courses,
                List<String> sentMessages, List<String> receivedMessages,
                List<String> alarms, int grade, long studentId) {
        this.id = id;
        this.accountId = accountId;
        this.name = name;
        this.institution = institution;
        this.major = major;
        this.email = email;
        this.profile = profile;
        this.courses = courses;
        this.sentMessages = sentMessages;
        this.receivedMessages = receivedMessages;
        this.alarms = alarms;
        this.grade = grade;
        this.studentId = studentId;
    }
    private User() {}
    // Named Constructor
    public static User makeUser() {
        // named constructor
        // TODO: implement
        return new User();
    }

    public static User makeUser(String id, String accountId, String name, String institution,
                                String major, String email, String profile, List<String> courses,
                                List<String> sentMessages, List<String> receivedMessages,
                                List<String> alarms, int grade, long studentId) {
        return new User(id, accountId, name, institution, major, email, profile, courses, sentMessages, receivedMessages, alarms, grade, studentId);
    }

    // Methods
    public void editInfo() {
        // 정보 수정
        // TODO: implement
    }

    // getter
    public String getId() {
        return id;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", accountId='" + accountId + '\'' +
                ", name='" + name + '\'' +
                ", institution='" + institution + '\'' +
                ", major='" + major + '\'' +
                ", email='" + email + '\'' +
                ", profile='" + profile + '\'' +
                ", courses=" + courses +
                ", sentMessages=" + sentMessages +
                ", receivedMessages=" + receivedMessages +
                ", alarms=" + alarms +
                ", grade=" + grade +
                ", studentId=" + studentId +
                '}';
    }

    public String getInstitution() {
        return institution;
    }

    public String getMajor() {
        return major;
    }

    public String getEmail() {
        return email;
    }

    public List<String> getLectures() { return this.courses; }

    public String getProfile() {
        return profile;
    }

    public List<String> getCourses() {
        return courses;
    }

    public List<String> getSentMessages() {
        return sentMessages;
    }

    public List<String> getReceivedMessages() {
        return receivedMessages;
    }

    public List<String> getAlarms() {
        return alarms;
    }

    public int getGrade() {
        return grade;
    }

    public long getStudentId() {
        return studentId;
    }
}
