package utils;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;


import java.io.File;
import java.util.Collections;
import java.util.List;

import model.Account;
import model.User;

public class Utils implements Utilities {
    public enum Sort{
        ASCENDING, DESCENDING
    }
    public static void toastTest(Context context, String text) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }
    public static Utils makeUtils() {
        // named constructor
        // TODO: implement
        return new Utils();
    }

    public boolean isAdmin(User user) {
        // 관리자인지 확인
        // TODO: implement
        return true;
    }

    public boolean fileAvail(File file, long sizeLimit, List<String> formats) {
        // 업로드 가능한 파일인지(크기, 포맷)
        // 파일 선택하고 Uri, File로 바꾸는 과정 : https://stickode.tistory.com/922
        // Uri->File할 때, context가 필요한 것 같아서 File로 바꾼 다음 호출
        // TODO: implement
        long fileSize;
        String fileName, fileFormat;

        fileSize = file.length();
        fileName = file.getName();
        fileFormat = fileName.substring(fileName.lastIndexOf(".")+1);

        if (fileSize > sizeLimit || !formats.contains(fileFormat)) return false;
        else return true;
    }

    public boolean lengthAvail(String str, int length) {
        // 입력 받은 문자열 길이 체크, 문자열과 함께 길이를 argument로 제공
        return str != null && str.length() <= length;
    }

    // order가 ASCENDING이면 list 오름차순 정렬, DESCENDING이면 list 내림차순 정렬
    // 이외에는 아무것도 하지 않음
    public void sortBy(List<String> list, Sort order) {
        if (order == Sort.ASCENDING)
            Collections.sort(list);
        else if (order == Sort.DESCENDING)
            Collections.sort(list, Collections.reverseOrder());

        // debug
//        else
//            System.out.println("Invalid param order");
    }

    public void filterBy() {
        // 필터링
        // TODO: implement
    }

    public void search(String attribute, String searchString) {
        // 검색 기능, 해당 attribute에 주어진 string이 있는지 확인
        // TODO: implement
    }

    public static void gotoPage(Context curContext, Class<?> page) {
        // 해당 페이지로 이동(포워딩)
        // TODO: implement
        Intent intent = new Intent(curContext, page);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        curContext.startActivity(intent);
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
        // 홍길동 -> 홍*동
        // 0123456789 -> 01*****789
        // TODO: implement
        int length;
        int first, masked, end;
        String stars, maskedString;

        length = personalInfo.length();
        masked = length/2;
        first = (length - masked)/2;
        end = length - first - masked;

        // "*".repeat(masked) repeat이 왜안되지...
        stars = "";
        for (int i=0; i<masked; i++){
            stars += "*";
        }

        maskedString = personalInfo.substring(0,first)
                + stars
                + personalInfo.substring(length-end, length);

        return maskedString;//마스킹된 정보 반환
    }

    public void pagination() {
        // 메시지나 공지사항에서 사용
        // TODO: implement
    }

}
