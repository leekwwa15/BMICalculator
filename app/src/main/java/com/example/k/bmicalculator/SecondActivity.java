package com.example.k.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    public TextView displayResultText;
    public ImageView displayResultImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        displayResultText = findViewById(R.id.textViewResult);
        displayResultImage = findViewById(R.id.imageViewResult);

        Intent intent = getIntent();
        if(intent.hasExtra(MainActivity.BMI_RESULT)){
            String result = String.valueOf(intent.getDoubleExtra(MainActivity.BMI_RESULT, 0));
            double BMI = Double.parseDouble(result);
            if(BMI < 18.5){
                displayResultText.setVisibility(View.VISIBLE);
                displayResultText.setText("Under weight");
                displayResultImage.setImageResource(R.drawable.under);
            } else if(BMI >= 18.5 && BMI < 25){
                displayResultText.setVisibility(View.VISIBLE);
                displayResultText.setText("Normal");
                displayResultImage.setImageResource(R.drawable.normal);
            } else if(BMI >= 25){
                displayResultText.setVisibility(View.VISIBLE);
                displayResultText.setText("Over weight");
                displayResultImage.setImageResource(R.drawable.over);
            }
        }

    }
}
