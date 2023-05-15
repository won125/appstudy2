package com.taewon.choiceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    CheckBox checkBox;
    ImageView imgView,imgCheck;
    RadioButton radioDog,radioCat,radioRabbit;
    RadioGroup petGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkBox = findViewById(R.id.chkPicView);
        imgCheck = findViewById(R.id.imgPuppy);
        imgView = findViewById(R.id.pet);
        radioDog = findViewById(R.id.radioDog);
        radioCat = findViewById(R.id.radioCat);
        radioRabbit = findViewById(R.id.radioRabbit);
        petGroup = findViewById(R.id.petGroup);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    petGroup.clearCheck();
                    petGroup.setVisibility(View.VISIBLE);
                }else{
                    petGroup.setVisibility(View.INVISIBLE);
                }
            }
        });

        petGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.radioDog){
                    imgView.setImageResource(R.drawable.dog);
                }else if(checkedId == R.id.radioCat){
                    imgView.setImageResource(R.drawable.cat);
                }else if(checkedId == R.id.radioRabbit){
                    imgView.setImageResource(R.drawable.rabbit);
                }
            }
        });


    }
}