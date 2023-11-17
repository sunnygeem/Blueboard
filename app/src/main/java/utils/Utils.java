package utils;

import android.content.Context;
import android.widget.Toast;

public class Utils implements Utilities {
    public static void toastTest(Context context, String text) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }
    public static Utils makeUtils() {
        // named constructor
        // TODO: implement
        return new Utils();
    }

    public boolean isAdmin() {
        // 관리자인지 확인
        // TODO: implement
        return true;
    }

    public boolean fileAvail() {
        // 업로드 가능한 파일인지(크기, 포맷)
        // TODO: implement
        return true;
    }

    public boolean lengthAvail(String str, int length) {
        // 입력 받은 문자열 길이 체크, 문자열과 함께 길이를 argument로 제공
        // TODO: implement
        return str.length() <= length;
    }

    public void sortBy() {
        // 정렬
        // TODO: implement
    }

    public void filterBy() {
        // 필터링
        // TODO: implement
    }

    public void search(String attribute, String searchString) {
        // 검색 기능, 해당 attribute에 주어진 string이 있는지 확인
        // TODO: implement
    }

    public void gotoPage(String page) {
        // 해당 페이지로 이동(포워딩)
        // TODO: implement
    }

    public void showErrMsg(String errorMessage) {
        // 에러 메시지 출력
        // TODO: implement
    }

    public void pushAlarm() {
        // 푸시 알림 기능
        // TODO: implement
    }

    public String masking(String personalInfo) {
        // 개인정보 마스킹
        // TODO: implement
        return "masked info"; // 마스킹된 정보 반환
    }

    public void pagination() {
        // 메시지나 공지사항에서 사용
        // TODO: implement
    }

}
