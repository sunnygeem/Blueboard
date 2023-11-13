package utils;

public interface Utilities {
    boolean isAdmin();
    boolean fileAvail();
    boolean lengthAvail(String str, int length);
    void sortBy();
    void filterBy();
    void search(String attribute, String searchString);
    void gotoPage(String page);
    void showErrMsg(String errorMessage);
    void pushAlarm();
    String masking(String personalInfo);
    void pagination();
}
