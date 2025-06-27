package com.trueconf.sample;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.trueconf.sample.databinding.ActivityMainBinding;
import com.trueconf.sdk.TrueConfSDK;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Example 3. Calling by Conference ID");
        TrueConfSDK.getInstance().setFallbackActivity(MainActivity3.class);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(binding.container.getId(), new PlaceholderFragment())
                    .commit();
        }
    }
}
