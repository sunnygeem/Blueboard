package com.se.blueboard.makeLecture;

import static com.se.blueboard.makeLecture.MakeLecturePageOne.makingLecture;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.se.blueboard.HomePage;
import com.se.blueboard.R;

import utils.FirebaseController;
import utils.Utils;

public class MakeLecturePageThree extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.make_lecture_page_three);

        // 뒤로 가기 버튼
        Button backButton = (Button) findViewById(R.id.makeLecture_gotoBackThree);
        backButton.setOnClickListener(view -> {
            Utils.gotoPage(getApplicationContext(), MakeLecturePageTwo.class, null);
        });

        TextView learningStudents = (TextView) findViewById(R.id.makeLecture_learningStudents);
        learningStudents.setText(makingLecture.getStudents().size() + " / " + makingLecture.getMaxStudents());

        // 생성 버튼
        Button makeButton = (Button) findViewById(R.id.makeLecture_makeLectureButton);
        makeButton.setOnClickListener(view -> {
            FirebaseController controller = new FirebaseController();
            controller.updateData(makingLecture);
            Utils.gotoPage(getApplicationContext(), HomePage.class, null);
        });
    }
}
