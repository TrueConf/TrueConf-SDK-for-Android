package com.trueconf.sample;

import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.trueconf.sdk.TrueConfSDK;

public class EmptyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Example 5. Customization of the interface");
        setContentView(R.layout.activity_empty);

        Button btnNext = findViewById(R.id.btnBackToCall);

        btnNext.setOnClickListener(view -> {
            TrueConfSDK.getConferenceManager().returnToCall(this);
        });
    }
}
