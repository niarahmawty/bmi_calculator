package com.ubl.bmi_calculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText weightInput;
    private EditText heightInput;
    private EditText ageInput;
    private RadioGroup genderGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weightInput = findViewById(R.id.weightInput);
        heightInput = findViewById(R.id.heightInput);
        ageInput = findViewById(R.id.ageInput);
        genderGroup = findViewById(R.id.genderGroup);
        Button calculateButton = findViewById(R.id.calculateButton);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        String weightText = weightInput.getText().toString();
        String heightText = heightInput.getText().toString();
        String ageText = ageInput.getText().toString();
        int selectedGenderId = genderGroup.getCheckedRadioButtonId();
        String gender = selectedGenderId == R.id.maleRadio ? "Male" : "Female";

        if (!weightText.isEmpty() && !heightText.isEmpty() && !ageText.isEmpty() && selectedGenderId != -1) {
            double weight = Double.parseDouble(weightText);
            double height = Double.parseDouble(heightText) / 100; // Convert height from cm to meters

            double bmi = weight / (height * height);
            String bmiCategory;

            if (bmi < 18.5) {
                bmiCategory = "You are underweight";
            } else if (bmi > 25) {
                bmiCategory = "You are overweight";
            } else {
                bmiCategory = "You are a healthy weight";
            }

            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
            intent.putExtra("bmi_value", String.format("%.2f", bmi));
            intent.putExtra("bmi_category", bmiCategory);
            intent.putExtra("age", Integer.parseInt(ageText));
            intent.putExtra("gender", gender);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Please enter all fields", Toast.LENGTH_SHORT).show();
        }
    }
}
