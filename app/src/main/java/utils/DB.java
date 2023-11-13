package utils;

public class DB implements Database {
    public static DB makeDB() {
        // named constructor
        // TODO: implement
        return new DB();
    }

    public boolean connectDB() {
        // TODO: implement
        return true;
    }

    public boolean disconnectDB() {
        // TODO: implement
        return true;
    }

    public boolean addData() {
        // 데이터를 처음 추가할 때
        // TODO: implement
        return true;
    }

    public boolean updateData() {
        // 이미 존재하는 데이터를 업데이트할 때
        // TODO: implement
        return true;
    }

    public boolean loadData() {
        // DB에서 데이터를 가져와서 해당하는 class의 변수를 return
        // TODO: implement
        return true;
    }

    public boolean deleteData() {
        // TODO: implement
        return true;
    }

    public boolean uploadFile() {
        // firebase의 storage에 파일을 저장하고 그 파일들의 정보를 firestore에 저장
        // TODO: implement
        return true;
    }

    public boolean downloadFile() {
        // firebase의 storage에서 파일을 다운로드
        // TODO: implement
        return true;
    }
}
