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
    private User(String id, String accountId, String name, String institution,
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

    // Named Constructor
    public static User makeUser() {
        // named constructor
        // TODO: implement
        return new User(null, null, null, null, null, null, null, null, null, null, null, 0, 0);
    }

    // Methods
    public List<String> getMyLec() {
        // 사용자는 자신이 학습하는 강의를, 관리자는 자신이 관리하는 강의를 가져옴
        // TODO: implement
        return null;
    }

    public User getInfo() {
        // 사용자/관리자의 정보 가져옴
        // TODO: implement
        return this; // 일단은 자기 자신 반환
    }

    public void editInfo() {
        // 정보 수정
        // TODO: implement
    }

    public List<String> getSentMsg() {
        // 자신이 보낸 메시지를 가져옴
        // TODO: implement
        return null;
    }

    public List<String> getReceivedMsg() {
        // 자신에게 온 메시지 가져옴 (필터링이나 정렬은 가져오고 나서 적용하는 게 맞을 듯)
        // 가져온 리스트를 `.size()` 하면 읽지 않은 메시지 개수 구할 수도 있음
        // TODO: implement
        return null;
    }

    public static List<String> getList() {
        // 메시지를 보낼 수 있는 사용자, 관리자 리스트 가져옴. 같은 강의에 속해있는 사람들
        // TODO: implement
        return null;
    }
<<<<<<< HEAD
=======

    public String getAccountId(){
        return this.accountId;
    }
>>>>>>> refs/remotes/origin/main
}

