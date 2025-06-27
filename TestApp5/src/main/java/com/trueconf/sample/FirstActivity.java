package com.trueconf.sample;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Example 5. Customization of the interface");
        setContentView(R.layout.activity_empty);

        Button btnNext = findViewById(R.id.btnBackToCall);
        btnNext.setText("NEXT");

        btnNext.setOnClickListener(view -> {
            Intent intent = new Intent(this, EmptyActivity.class);
            startActivity(intent);
        });
    }
}