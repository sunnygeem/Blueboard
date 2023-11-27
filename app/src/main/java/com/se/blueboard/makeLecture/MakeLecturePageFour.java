package com.se.blueboard.makeLecture;

import static com.se.blueboard.makeLecture.MakeLecturePageOne.makingLecture;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.se.blueboard.HomePage;
import com.se.blueboard.R;

import java.util.ArrayList;

import model.User;
import utils.FirebaseController;
import utils.Utils;

public class MakeLecturePageFour extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.make_lecture_page_four);

        // 뒤로 가기 버튼
        Button backButton = (Button) findViewById(R.id.makeLecture_gotoBackFour);
        backButton.setOnClickListener(view -> {
            Utils.gotoPage(getApplicationContext(), MakeLecturePageTwo.class);
        });

        // 현재 수강 인원 수 출력
        TextView learningStudents = (TextView) findViewById(R.id.makeLecture_learningStudents);
        learningStudents.setText(makingLecture.getStudents().size() + " / " + makingLecture.getMaxStudents());

        // 사용자 검색 기능
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        ArrayList<String> studentList = new ArrayList<>();

        db.collection("users")
                .whereEqualTo("isManager", 0)
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        for (DocumentSnapshot document: queryDocumentSnapshots.getDocuments()) {
                            if (document.exists()) {
                                studentList.add(document.toObject(User.class).getStudentId() + "\t" + document.toObject(User.class).getName());
                                Log.d("successGetManagerList", document.toObject(User.class).toString());

                                // 관리자 ListView
                                ListView listView = findViewById(R.id.makeLecture_setManagers);
                                ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, studentList);

                                // 관리자 검색 기능
                                SearchView searchView = (SearchView) findViewById(R.id.makeLecture_searchManager);
                                searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                                    @Override
                                    public boolean onQueryTextSubmit(String s) {
                                        return false;
                                    }
                                    @Override
                                    public boolean onQueryTextChange(String s) {
                                        ArrayList<String> filteredManagerList = new ArrayList<>();
                                        for (int i = 0; i < studentList.size(); i++) {
                                            String manager = studentList.get(i);

                                            if (manager.toLowerCase().contains(s.toLowerCase()))
                                                filteredManagerList.add(manager);
                                        }

                                        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, filteredManagerList);
                                        listView.setAdapter(adapter);

                                        return false;
                                    }
                                });

                                // Set adapter
                                listView.setAdapter(adapter);
                                // Click Item
                                listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                                    @Override
                                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                        Utils.toastTest(getApplicationContext(), "studentList?");
                                        //                String selectedLecture = (String) listView.getItemAtPosition(i);
                                        //                String[] temp = selectedLecture.split("\t");
                                        //                makingLecture.setId(temp[0]);
                                        //                makingLecture.setName(temp[1]);
                                        //                Utils.gotoPage(getApplicationContext(), MakeLecturePageTwo.class);
                                    }
                                });
                            }
                            else
                                Log.d("ManagerList", "No such Document");
                        }
                    }
                });

        // 생성 버튼
        Button makeButton = (Button) findViewById(R.id.makeLecture_makeLectureButton);
        makeButton.setOnClickListener(view -> {
            FirebaseController controller = new FirebaseController();
            controller.updateData(makingLecture);
            Utils.gotoPage(getApplicationContext(), HomePage.class);
        });
    }
}
