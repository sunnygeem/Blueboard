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

    // Methods (If additional methods are needed for Institution, add them here)

    // getter
    public String getInstitution() {
        return institution;
    }

    public String getMajor() {
        return major;
    }
}

