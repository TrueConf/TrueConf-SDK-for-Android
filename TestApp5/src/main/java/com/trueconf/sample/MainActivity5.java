package com.trueconf.sample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.trueconf.sdk.TrueConfSDK;
import com.trueconf.sdk.presentation.views.TCExtraButton;

import java.util.ArrayList;

public class MainActivity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        EdgeToEdge.enable(this);
        super.onCreate(savedInstanceState);
        setTitle("Example 5. Customization of the interface");
        TrueConfSDK.getInstance().setFallbackActivity(MainActivity5.class);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(getWindow().getDecorView(), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return WindowInsetsCompat.CONSUMED;
        });

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, new PlaceholderFragment5())
                    .commit();
        }

        ArrayList<TCExtraButton> buttons = new ArrayList<>();
        View.OnClickListener onClickListener = btn ->
                ((AppCompatActivity) btn.getContext())
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .add(com.trueconf.sdk.R.id.container_call, new EmptyFragment())
                        .addToBackStack(null)
                        .commit();

        View.OnClickListener onClickListener2 = btn -> {
            Intent emptyActivity = new Intent (this, FirstActivity.class);
            startActivity(emptyActivity);
        };

        buttons.add(new TCExtraButton("button 1", onClickListener));
        buttons.add(new TCExtraButton("button 2", onClickListener2));
        TrueConfSDK.getExtraButtonController().setNewExtraButtons(buttons);
    }
}
