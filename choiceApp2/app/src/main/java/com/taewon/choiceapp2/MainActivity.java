package com.taewon.choiceapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnCount;
    EditText edtCost;
    RadioGroup ageGroup;
    RadioButton rdChild,rdAdult,rdOldman;
    CheckBox chkCard;
    TextView resultCost;
    int cost;
    double result,discount,chkdiscount=1.0;
    String strCost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCount = findViewById(R.id.btncount);
        edtCost = findViewById(R.id.edtcost);
        ageGroup = findViewById(R.id.ageGroup);
        rdChild = findViewById(R.id.rdChild);
        rdAdult = findViewById(R.id.rdAdult);
        rdOldman = findViewById(R.id.rdOldman);
        chkCard = findViewById(R.id.chkCard);
        resultCost = findViewById(R.id.resultCost);

        btnCount.setEnabled(false);

        ageGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId){
                    case R.id.rdChild:
                        discount = 0.5;
                        break;
                    case R.id.rdAdult:
                        discount = 1.0;
                        break;
                    case R.id.rdOldman:
                        discount = 0.7;
                        break;
                }
                if(checkedId == R.id.rdChild || checkedId == R.id.rdAdult || checkedId == R.id.rdOldman){
                    btnCount.setEnabled(true);
                }
            }
        });

        chkCard.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    chkdiscount = 0.8;
                }else{
                    chkdiscount = 1.0;
                }
            }
        });


        btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strCost = edtCost.getText().toString();
                if(strCost.equals("")) {
                    Toast.makeText(getApplicationContext(), "금액을 설정해 주십시오.", Toast.LENGTH_SHORT).show();
                }else{
                    cost = Integer.parseInt(edtCost.getText().toString());
                    result = cost * discount * chkdiscount;
                    resultCost.setText("지불해야 할 요금은" + (int)result + "원 입니다.");
                    ageGroup.clearCheck();
                    chkCard.setChecked(false);
                }
            }
        });







    }
}