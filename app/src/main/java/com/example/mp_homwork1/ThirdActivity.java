package com.example.mp_homwork1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mp_homwork1.R;

public class ThirdActivity extends AppCompatActivity {

    Button Add, Sub, Mul, Div, Next;
    EditText Ed1, Ed2;
    TextView La1;
    String Num_1, Num_2;
    Integer I_Number1, I_Number2, Result;
    boolean NextEdit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Ed1 = (EditText) findViewById(R.id.Ed1);
        Ed2 = (EditText) findViewById(R.id.Ed2);
        Add = (Button) findViewById(R.id.Add);
        Sub = (Button) findViewById(R.id.Sub);
        Mul = (Button) findViewById(R.id.Mul);
        Div = (Button) findViewById(R.id.Div);
        Next = (Button) findViewById(R.id.Next);
        La1 = (TextView) findViewById(R.id.La1);


        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NextEdit = !NextEdit;
            }
            });

        Add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (Ed1.getText().length() == 0 || Ed2.getText().length() == 0) {
                    Toast.makeText(ThirdActivity.this, "공백을 둘 수 없습니다.", Toast.LENGTH_SHORT).show();
                } else {
                    Num_1 = Ed1.getText().toString();
                    Num_2 = Ed2.getText().toString();
                    I_Number1 = Integer.parseInt(Num_1);
                    I_Number2 = Integer.parseInt(Num_2);
                    Result = I_Number1 + I_Number2;
                    La1.setText(Result.toString());
                    Ed1.setText("");
                    Ed2.setText("");
                }
            }
        });
        Sub.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (Ed1.getText().length() == 0 || Ed2.getText().length() == 0) {
                    Toast.makeText(ThirdActivity.this, "공백을 둘 수 없습니다.", Toast.LENGTH_SHORT).show();
                } else {
                    Num_1 = Ed1.getText().toString();
                    Num_2 = Ed2.getText().toString();
                    I_Number1 = Integer.parseInt(Num_1);
                    I_Number2 = Integer.parseInt(Num_2);
                    Result = I_Number1 - I_Number2;
                    La1.setText(Result.toString());
                    Ed1.setText("");
                    Ed2.setText("");
                }
            }
        });
        Mul.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (Ed1.getText().length() == 0 || Ed2.getText().length() == 0) {
                    Toast.makeText(ThirdActivity.this, "공백을 둘 수 없습니다.", Toast.LENGTH_SHORT).show();
                } else {
                    Num_1 = Ed1.getText().toString();
                    Num_2 = Ed2.getText().toString();
                    I_Number1 = Integer.parseInt(Num_1);
                    I_Number2 = Integer.parseInt(Num_2);
                    Result = I_Number1 * I_Number2;
                    La1.setText(Result.toString());
                    Ed1.setText("");
                    Ed2.setText("");
                }
            }
        });
        Div.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (Ed1.getText().length() == 0 || Ed2.getText().length() == 0) {
                    Toast.makeText(ThirdActivity.this, "공백을 둘 수 없습니다.", Toast.LENGTH_SHORT).show();
                } else if (Ed2.getText().toString().equals("0")) {
                    Toast.makeText(ThirdActivity.this, "0으로 나눌 수 없습니다.", Toast.LENGTH_SHORT).show();
                } else {
                    Num_1 = Ed1.getText().toString();
                    Num_2 = Ed2.getText().toString();
                    I_Number1 = Integer.parseInt(Num_1);
                    I_Number2 = Integer.parseInt(Num_2);
                    Result = I_Number1 / I_Number2;
                    La1.setText(Result.toString());
                    Ed1.setText("");
                    Ed2.setText("");
                }
            }
        });
    }

    public void Numbering (View v){
        switch (v.getId()) {
            case R.id.Num0:
                if (NextEdit == false)
                    Ed1.setText("0");
                else
                    Ed2.setText("0");
                break;
            case R.id.Num1:
                if (NextEdit == false)
                    Ed1.setText("1");
                else
                    Ed2.setText("1");
                break;
            case R.id.Num2:
                if (NextEdit == false)
                    Ed1.setText("2");
                else
                    Ed2.setText("2");
                break;
            case R.id.Num3:
                if (NextEdit == false)
                    Ed1.setText("3");
                else
                    Ed2.setText("3");
                break;
            case R.id.Num4:
                if (NextEdit == false)
                    Ed1.setText("4");
                else
                    Ed2.setText("4");
                break;
            case R.id.Num5:
                if (NextEdit == false)
                    Ed1.setText("5");
                else
                    Ed2.setText("5");
                break;
            case R.id.Num6:
                if (NextEdit == false)
                    Ed1.setText("6");
                else
                    Ed2.setText("6");
                break;
            case R.id.Num7:
                if (NextEdit == false)
                    Ed1.setText("7");
                else
                    Ed2.setText("7");
                break;
            case R.id.Num8:
                if (NextEdit == false)
                    Ed1.setText("8");
                else
                    Ed2.setText("8");
                break;
            case R.id.Num9:
                if (NextEdit == false)
                    Ed1.setText("9");
                else
                    Ed2.setText("9");
                break;
        }
    }
}
