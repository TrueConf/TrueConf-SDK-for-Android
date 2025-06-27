package com.trueconf.sample;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.trueconf.sample.databinding.ActivityChatBinding;
import com.trueconf.sdk.TrueConfSDK;

import java.util.Objects;

public class ChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TrueConfSDK.getInstance().setFallbackActivity(ChatActivity.class);
        ActivityChatBinding binding = ActivityChatBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(binding.container.getId(), new ChatPageFragment(), null)
                    .commit();
        }
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Chat");
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
