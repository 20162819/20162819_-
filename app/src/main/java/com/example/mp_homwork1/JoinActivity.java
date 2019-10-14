package com.example.mp_homwork1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mp_homwork1.R;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JoinActivity extends MainActivity {

    //public static Context mContext;
    //private SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        final EditText idText = (EditText) findViewById(R.id.idText);
        final EditText pwText = (EditText) findViewById(R.id.pwText);
        final EditText nameText = (EditText) findViewById(R.id.nameText);
        final EditText phNumText = (EditText) findViewById(R.id.phNumText);
        final EditText adrText = (EditText) findViewById(R.id.adrText);

        Button join = (Button) findViewById(R.id.join);
        final RadioButton acc =(RadioButton) findViewById(R.id.acc);


        Button check_id = (Button)findViewById(R.id.checkID);

        check_id.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                try{
                    BufferedReader br = new BufferedReader(new FileReader(getFilesDir()+(idText.getText()+".txt")));
                    Toast.makeText(getApplicationContext(), idText.getText()+"는 이미 있는 아이디입니다.", Toast.LENGTH_SHORT).show();
                }catch (FileNotFoundException t){
                    t.printStackTrace();
                    Toast.makeText(getApplicationContext(), "사용 가능한 아이디입니다", Toast.LENGTH_SHORT).show();
                }
            }
        });

        join.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                final String pw = pwText.getText()+"";
                String val_symbol = "([0-9].*[!,@,#,^,&,*,(,)])|([!,@,#,^,&,*,(,)].*[0-9])";
                String val_alpha = "([a-z].*[A-Z])|([A-Z].*[a-z])";

                Pattern pattern_symbol = Pattern.compile(val_symbol);
                Pattern pattern_alpha = Pattern.compile(val_alpha);

                Matcher matcher_symbol = pattern_symbol.matcher(pw);
                Matcher matcher_alpha = pattern_alpha.matcher(pw);

                //약관 동의여부 확인
                if (acc.isChecked()) {
                    //비어있는 정보 입력칸이 없는지 확인
                    if(idText.getText().length() != 0 && pwText.getText().length() != 0 && nameText.getText().length() != 0 &&
                    phNumText.getText().length() != 0 && adrText.getText().length() != 0) {
                        //비밀번호 유효성 판단
                        if((matcher_symbol.find() && matcher_alpha.find() && pwText.getText().length()>=8)) {

                            try {
                                String idText1 = idText.getText() + ".txt";
                                BufferedWriter bw = new BufferedWriter(new FileWriter(getFilesDir() + idText1, false));
                                bw.write(pwText.getText() + "");
                                bw.close();
                                Toast.makeText(getApplicationContext(), idText.getText() + "님 가입을 환영합니다.", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);
                            } catch (Exception e) {
                                e.printStackTrace();
                                Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                            }

                            Intent relogintent = new Intent(JoinActivity.this, MainActivity.class);
                            JoinActivity.this.startActivity(relogintent);
                        }
                        else{
                            Toast.makeText(JoinActivity.this, "숫자, 특수문자, 영문자(대/소)가 포함되어야 합니다.", Toast.LENGTH_LONG).show();
                        }
                    }
                    else {
                        Toast.makeText(JoinActivity.this, "정보를 모두 입력해 주십시오.", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(JoinActivity.this, "약관에 동의해 주십시오.", Toast.LENGTH_LONG).show();
                }
            }
            });

        }
    }





