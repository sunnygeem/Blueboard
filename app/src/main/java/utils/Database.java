package utils;

public interface Database {
    boolean connectDB();
    boolean disconnectDB();
    boolean addData();
    boolean updateData();
    boolean loadData();
    boolean deleteData();
    boolean uploadFile();
    boolean downloadFile();
}
