package utils;

import java.io.File;
import java.util.List;

import model.User;

public interface Utilities {
    boolean isAdmin(User user);
    boolean fileAvail(File file, long sizeLimit, List<String> formats);
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
