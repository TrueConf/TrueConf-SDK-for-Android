package com.trueconf.sample;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.trueconf.sample.databinding.ActivityMainBinding;
import com.trueconf.sample.databinding.FragmentPlaceholderBinding;
import com.trueconf.sdk.TrueConfSDK;

public class MainActivity2 extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Example 2. Parse protocol link");
        TrueConfSDK.getInstance().setFallbackActivity(MainActivity2.class);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(binding.container.getId(), new PlaceholderFragment())
                    .commit();
        }
    }

    public static class PlaceholderFragment extends Fragment {

        private FragmentPlaceholderBinding binding;

        public PlaceholderFragment() {
            super(R.layout.fragment_placeholder);
        }

        @Override
        public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            binding = FragmentPlaceholderBinding.bind(view);
            var mETLink = binding.etLink;
            binding.btnParseLink.setOnClickListener(btn -> {
                var link = mETLink.getText().toString().trim();
                if (!TextUtils.isEmpty(link)) {
                    TrueConfSDK.getVisicallManager().parseProtocolLink(link);
                }
            });
            binding.btnClear.setOnClickListener(btn -> mETLink.setText(""));
        }
    }
}

