package com.example.k.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText editTextWeight, editTextHeight;
    public static final String BMI_RESULT = "com.example.k.bmicalculator.extra.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextWeight = findViewById(R.id.editTextWeight);
        editTextHeight = findViewById(R.id.editTextHeight);
    }

    public void calculateBMI(View view){
        if(TextUtils.isEmpty(editTextWeight.getText())) {
            editTextWeight.setError("Please enter your weight");
            return;
        } else if(TextUtils.isEmpty(editTextHeight.getText())){
            editTextHeight.setError("Please enter your height");
            return;
        } else {
            double BMI = 0;
            double weightValue = Double.parseDouble(editTextWeight.getText().toString());
            double heightValue = Double.parseDouble(editTextHeight.getText().toString());
            BMI = weightValue / (heightValue * weightValue);

            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra(BMI_RESULT, BMI);
            startActivity(intent);
        }
    }
}
