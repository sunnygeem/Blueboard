package model;

import java.util.List;

public class Lecture {
    // Fields
    private String id;
    private String name;
    private String weeks;
    private String managerId;
    private List<String> managers;
    private List<String> students;
    private List<String> lectureContents;

    // Constructor
    private Lecture(String id, String name, String weeks, String managerId,
                    List<String> managers, List<String> students, List<String> lectureContents) {
        this.id = id;
        this.name = name;
        this.weeks = weeks;
        this.managerId = managerId;
        this.managers = managers;
        this.students = students;
        this.lectureContents = lectureContents;
    }

    // Named Constructor
    public static Lecture makeLecture() {
        // named constructor
        // TODO: implement
        return new Lecture(null, null, null, null, null, null, null);
    }

    // Methods
    public void addStudents(List<String> newStudents) {
        // 해당 강의에 수강 인원을 추가
        // 수강 인원을 리스트로 전달..? 이 안에서 해당 수강 인원이 DB에 있는지 없는지 확인 또한 진행
        // TODO: implement
    }

    public String getGroup() {
        // 해당 강의를 수강하는 사용자와, 관리하는 관리자를 가져옴
        // 사용자는 마스킹된 정보를, 관리자는 마스킹되지 않은 정보를 가져옴
        // TODO: implement
        return null;
    }

    public void addContent(String newContent) {
        // 콘텐츠를 리스트에 추가
        // TODO: implement
    }
}
