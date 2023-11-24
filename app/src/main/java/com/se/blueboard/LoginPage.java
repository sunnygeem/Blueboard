package com.se.blueboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import model.Account;
import utils.Utils;

import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;


public class LoginPage extends AppCompatActivity {
    private FirebaseAuth auth = null;
    private FirebaseAuth firebaseAuth;

    private Button buttonRegister;
    private Button buttonLogin;
    
    // login 작업에 사용
    private EditText userID;
    private EditText userPW;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        auth = FirebaseAuth.getInstance();

        // 회원가입
        buttonRegister = (Button) findViewById(R.id.register_bt);
        buttonRegister.setOnClickListener(view -> {
            Utils.gotoPage(getApplicationContext(), Create.class);
        });

        // 로그인
        userID = (EditText) findViewById(R.id.user_id);
        userPW = (EditText) findViewById(R.id.user_pw);
        buttonLogin =  (Button) findViewById(R.id.login_bt);
        buttonLogin.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                login(userID.getText().toString(), userPW.getText().toString());
            }
        });



    }

    public void login(String id, String pw){
        if(!id.equals("") && !pw.equals("")){
            auth.signInWithEmailAndPassword(id, pw).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        buttonLogin.setOnClickListener(view -> {
                            Utils.gotoPage(getApplicationContext(), HomePage.class);
                        });
                    }
                    else{
                        // 로그인 실패
                        if(task.getException() instanceof FirebaseAuthInvalidUserException){
                            Toast.makeText(
                                    getBaseContext(), "존재하지 않는 ID입니다.", Toast.LENGTH_SHORT
                            ).show();
                        }
                        else if(task.getException() instanceof FirebaseAuthInvalidCredentialsException){
                            Toast.makeText(
                                    getBaseContext(), "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT
                            ).show();
                        }
                    }
                }
            });
        }
    }
}
