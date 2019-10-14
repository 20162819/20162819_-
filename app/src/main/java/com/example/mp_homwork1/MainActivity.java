package com.example.mp_homwork1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mp_homwork1.JoinActivity;
import com.example.mp_homwork1.R;
import com.example.mp_homwork1.ThirdActivity;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Pattern;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    //String login_id = ((JoinActivity)JoinActivity.mContext).id;
    //String login_pw = ((JoinActivity)JoinActivity.mContext).pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //((JoinActivity)JoinActivity.mContext).onStop();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //final String thisId = idText.getText().toString();
        //final String thisPw = pwText.getText().toString();

        Button login = (Button) findViewById(R.id.login);
        Button join = (Button) findViewById(R.id.join);

        login.setOnClickListener(new View.OnClickListener(){

            EditText thisId = (EditText) findViewById(R.id.idText);
            EditText thisPw = (EditText) findViewById(R.id.pwText);

            @Override
            public void onClick(View v) {

                if(thisId.getText().length() != 0 && thisPw.getText().length() != 0) {
                    try{
                        BufferedReader br1 = new BufferedReader(new FileReader(getFilesDir()+(thisId.getText()+".txt")));
                        Toast.makeText(getApplicationContext(), thisId.getText()+"님 환영합니다.", Toast.LENGTH_SHORT).show();

                        Intent loginIntent = new Intent(MainActivity.this, ThirdActivity.class);
                        MainActivity.this.startActivity(loginIntent);
                    }catch (FileNotFoundException t){
                        t.printStackTrace();
                        Toast.makeText(getApplicationContext(), "가입되지 않은 아이디입니다.", Toast.LENGTH_SHORT).show();
                    }
                }

               else {
                   Toast.makeText(getApplicationContext(),"아이디와 비밀번호를 모두 입력하세요.",Toast.LENGTH_LONG).show();
                };

            }
        });

        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(MainActivity.this, JoinActivity.class);
                MainActivity.this.startActivity(registerIntent);
            }
        });
    }
}