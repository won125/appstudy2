package com.taewon.bmicheck;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtheight,edtweight;
    Button btnBMICheck;
    TextView result;
    ImageView bmipic;
    double height,weight,bmi_result;
    String strHeight,strWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("BMI 검사");

        edtheight = findViewById(R.id.height);
        edtweight = findViewById(R.id.weight);
        btnBMICheck = findViewById(R.id.btnBMICheck);
        result = findViewById(R.id.result);
        bmipic = findViewById(R.id.bmipic);

        btnBMICheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //try {
                strHeight = edtheight.getText().toString();
                strWeight = edtweight.getText().toString();
                if(strHeight.equals("")){
                    Toast.makeText(getApplicationContext(),"키를 입력해 주십시오.",Toast.LENGTH_SHORT).show();;
                }else if(strWeight.equals("")){
                    Toast.makeText(getApplicationContext(),"몸무게를 입력해 주십시오.",Toast.LENGTH_SHORT).show();;
                }else {
                    height = Double.parseDouble(edtheight.getText().toString());
                    weight = Double.parseDouble(edtweight.getText().toString());
                    bmi_result = weight / Math.pow((height * 0.01), 2);
                    if (bmi_result <= 18.5) {
                        result.setText("저체중입니다.");
                        bmipic.setVisibility(View.VISIBLE);
                        bmipic.setImageResource(R.drawable.thin);

                    } else if (18.5 < bmi_result && bmi_result < 23.0) {
                        result.setText("정상입니다.");
                        bmipic.setVisibility(View.VISIBLE);
                        bmipic.setImageResource(R.drawable.good);
                    } else if (23.0 <= bmi_result && bmi_result < 24.9) {
                        result.setText("과체중입니다.");
                        bmipic.setVisibility(View.VISIBLE);
                        bmipic.setImageResource(R.drawable.ob);
                    } else if (25.0 <= bmi_result) {
                        result.setText("비만입니다.");
                        bmipic.setVisibility(View.VISIBLE);
                        bmipic.setImageResource(R.drawable.ob);
                    }
                }
                //}catch (NumberFormatException e){
                 //   Toast.makeText(getApplicationContext(),"키 또는 몸무게를 입력해 주십시오.",Toast.LENGTH_SHORT).show();;
                //}catch (ArithmeticException e){
                 //   Toast.makeText(getApplicationContext(),"0으로 나누지 마십시오.",Toast.LENGTH_SHORT).show();;
                //}

            }
        });
    }
}