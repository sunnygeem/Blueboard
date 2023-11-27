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
import androidx.fragment.app.FragmentTransaction;

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
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class Create extends AppCompatActivity {
    private FirebaseAuth auth = null;
    private FirebaseAuth firebaseAuth;

    private Button buttonCompleteRegister;

    // login 작업에 사용
    private EditText newID;
    private EditText newPW;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account);

        auth = FirebaseAuth.getInstance();

        newID = (EditText) findViewById(R.id.square_id);
        newPW = (EditText) findViewById(R.id.square_pw);
        buttonCompleteRegister =  (Button) findViewById(R.id.reg_complete);
        buttonCompleteRegister.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                createAccount(newID.getText().toString(), newPW.getText().toString());
            }
        });
    }

    private void createAccount(String id, String pw){
        if(!id.equals("") && !pw.equals("")){
            if(!isValidPW(pw)){
                Toast.makeText(
                        getApplicationContext(), "비밀번호는 영문, 숫자, 특수 문자를 포함한 8자리 문자여야 합니다.’", Toast.LENGTH_SHORT
                ).show();
                return;
            }
            auth.createUserWithEmailAndPassword(id, pw).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(
                                getBaseContext(), "회원가입이 완료되었습니다. 로그인 화면으로 돌아가 로그인하세요.", Toast.LENGTH_SHORT
                        ).show();

                        buttonCompleteRegister.setOnClickListener(view -> {
                            Utils.gotoPage(getApplicationContext(), LoginPage.class, null);
                        });
                    }
                    else{
                        // 회원가입 오류
                        if(task.getException() instanceof FirebaseAuthUserCollisionException){
                            Toast.makeText(
                                    getApplicationContext(), "중복된 아이디입니다.", Toast.LENGTH_SHORT
                            ).show();
                        }
                    }
                }
            });
        }
    }

    private boolean isValidPW(String pw){
        // 영문, 숫자, 특수문자 조합의 8자리 이상인지 확인
        String regex = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$";
        return pw.matches(regex);
    }
}
