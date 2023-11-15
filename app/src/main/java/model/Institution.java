package model;

public class Institution {
    // Fields
    private String institution;
    private String major;

    // Constructor
    private Institution(String institution, String major) {
        this.institution = institution;
        this.major = major;
    }

    // Named Constructor
    public static Institution makeInstitution() {
        // named constructor
        // TODO: implement
        return new Institution(null, null);
    }
}

