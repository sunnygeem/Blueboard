package utils;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import model.Account;
import model.User;

public class FirebaseController {
    private FirebaseFirestore db;

    public FirebaseController() {
        // Connect to Firebase Firestore
        db = FirebaseFirestore.getInstance();
    }

    // Send User data to Firebase
    // firestore의 데이터 추가는 비동기 작업이라 return 으로 성공 여부 알 수 없음
    public void sendUserData(User user) {
        // Convert User data to Map<String, Object>
        Map<String, Object> userMap = new HashMap<>();
        userMap.put("id", user.getId());
        userMap.put("accountId", user.getAccountId());
        userMap.put("name", user.getName());
        userMap.put("institution", user.getInstitution());
        userMap.put("major", user.getMajor());
        userMap.put("email", user.getEmail());
        userMap.put("profile", user.getProfile());
        userMap.put("courses", user.getCourses());
        userMap.put("sentMessages", user.getSentMessages());
        userMap.put("receivedMessages", user.getReceivedMessages());
        userMap.put("alarms", user.getAlarms());
        userMap.put("grade", user.getGrade());
        userMap.put("studentId", user.getStudentId());

        // Add data to "users" collection
        db.collection("users")
                .document(user.getId())
                .set(userMap)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        // Data has been added successfully
                        Log.d("FirebaseController", "User data added successfully");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // Failed to add data
                        Log.e("FirebaseController", "Error adding user data", e);
                    }
                });
    }
}
