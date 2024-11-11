package com.ubl.bmi_calculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView bmiValueText = findViewById(R.id.bmiValueText);
        TextView bmiCategoryText = findViewById(R.id.bmiCategoryText);
        TextView ageText = findViewById(R.id.ageText);
        TextView genderText = findViewById(R.id.genderText);
        Button backButton = findViewById(R.id.backButton); // Tambahkan ini

        String bmiValue = getIntent().getStringExtra("bmi_value");
        String bmiCategory = getIntent().getStringExtra("bmi_category");
        int age = getIntent().getIntExtra("age", 0);
        String gender = getIntent().getStringExtra("gender");

        bmiValueText.setText(bmiValue);
        bmiCategoryText.setText(bmiCategory);
        ageText.setText("Age: " + age);
        genderText.setText("Gender: " + gender);

        backButton.setOnClickListener(new View.OnClickListener() { // Tambahkan listener
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); // Menutup ResultActivity agar tidak kembali ke halaman ini saat menekan tombol back pada perangkat
            }
        });
    }
}
