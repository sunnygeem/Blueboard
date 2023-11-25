package com.se.blueboard;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.google.firebase.Firebase;
import com.se.blueboard.databinding.ProfileBinding;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Base64;

import model.User;
import utils.FirebaseController;
import utils.MyCallback;
import utils.Utils;

public class ProfilePage extends AppCompatActivity {

    FirebaseController controller = new FirebaseController();

    public static User currentUser = User.makeUser();

    Utils util = Utils.makeUtils();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.profile);
        ProfileBinding binding = DataBindingUtil.setContentView(this, R.layout.profile);

        ImageView imageView = findViewById(R.id.profile_image);

        // profile image test
        // 1. 이미지를 bitmap으로 가져옴
        Bitmap image = BitmapFactory.decodeResource(this.getResources(), R.drawable.profile);
        // 2. bitmap 을 string으로 변환
        String imgString = bitmapToString(image);
        Log.d("Bitmap", imgString);

        // binding test
        currentUser = new User("1", "1", "문서진/MoonSeojin", "한양대학교", "컴퓨터소프트웨어학부", "sj1226m@hanyang.ac.kr", imgString, null, null, null, null, 3, 2021019834);

        if(util.isAdmin(currentUser)){
            TextView adminView = findViewById(R.id.admin);
            adminView.setVisibility(View.INVISIBLE);
        }

        String maskingStudentId = util.masking(String.valueOf(currentUser.getStudentId()));
        String in = currentUser.getInstitution().concat("\n" + currentUser.getMajor());

        binding.setUsername(currentUser.getName());
        binding.setEmail(currentUser.getEmail());
        binding.setStudentId("(" + maskingStudentId + ")");
        binding.setIn(in);

        Bitmap imgBitmap = stringToBitmap(imgString);
        imageView.setImageBitmap(imgBitmap);


        // TODO: LoginPage에서 id intent로 받아서 parameter 입력
//        controller.getUserData("tmp", new MyCallback() {
//            @Override
//            public void onSuccess(Object object) {
//                currentUser = (User) object;
//                Log.d("onSuccessGetUserDataProfile", currentUser.toString());
//
//                // 관리자일 경우에만 표시
//                if(util.isAdmin(currentUser)){
//                    TextView adminView = findViewById(R.id.admin);
//                    adminView.setVisibility(View.INVISIBLE);
//                }
//
//                String maskingStdentId = util.masking(String.valueOf(currentUser.getStudentId()));
//
//                binding.setUsername(currentUser.getName());
//                binding.setEmail(currentUser.getEmail());
//                binding.setStudentId(maskingStdentId);
//                binding.setIn(currentUser.getInstitution());
//
//            }
//
//            @Override
//            public void onFailure(Exception e) {
//                Log.d("GetUserDataProfile", e.getMessage());
//            }
//        });

        // 개인정보 수정 버튼
        Button editButton = findViewById(R.id.edit);
        editButton.setOnClickListener(view -> {
            Utils.gotoPage(getApplicationContext(), EditProfilePage.class);
        });

        // 홈 버튼
        Button homeButton = findViewById(R.id.icon_home);
        homeButton.setOnClickListener(view -> {
            Utils.gotoPage(getApplicationContext(), HomePage.class);
        });

        // 알림 버튼
        Button notiButton = findViewById(R.id.icon_notification);
        notiButton.setOnClickListener(view -> {
            Utils.gotoPage(getApplicationContext(), NotificationPage.class);
        });
    }
    public String bitmapToString(Bitmap bitmap){
        String image = "";
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        image = Base64.getEncoder().encodeToString(byteArray);
        return image;
    }

    public Bitmap stringToBitmap(String data){
        Bitmap bitmap = null;
        byte[] byteArray = Base64.getDecoder().decode(data);
        ByteArrayInputStream stream = new ByteArrayInputStream(byteArray);
        bitmap = BitmapFactory.decodeStream(stream);
        return bitmap;
    }
}
