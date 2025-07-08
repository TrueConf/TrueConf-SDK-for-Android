package com.trueconf.sample;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.Gravity;
import android.view.WindowManager;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.trueconf.sample.databinding.ActivityMainBinding;
import com.trueconf.sample.fragments.ConferenceFragmentCast;
import com.trueconf.sample.fragments.IncomingCallFragmentCast;
import com.trueconf.sample.fragments.PlaceCallFragmentCast;
import com.trueconf.sdk.TrueConfListener;
import com.trueconf.sdk.TrueConfSDK;

import java.util.HashMap;
import java.util.List;

public class MainActivity7 extends AppCompatActivity implements TrueConfListener.LayoutCallback {

    private HashMap<String, Rect> forcedCells = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        EdgeToEdge.enable(this);
        super.onCreate(savedInstanceState);
        setTitle("Example 7. Custom layout");
        TrueConfSDK.getInstance().setFallbackActivity(MainActivity7.class);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(getWindow().getDecorView(), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return WindowInsetsCompat.CONSUMED;
        });

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(binding.container.getId(), new PlaceholderFragment7())
                    .commit();
        }
        TrueConfSDK.getInstance().addTrueconfListener(this);
        TrueConfSDK.getVideoDeviceController().setDefaultCameraEnabled(true);
        TrueConfSDK.getAudioDeviceController().setDefaultMicEnabled(true);
        setCallLayoutParams();
        setCallCastFragments();

        // just example
        forcedCells.put("user1@trueconf.name", new Rect(0, 0, 400, 200));
        forcedCells.put("user2@trueconf.name", new Rect(30, 310, 400, 510));
    }

    private void setCallCastFragments() {
        TrueConfSDK.getCallScreenController().setPlaceCallFragment(new PlaceCallFragmentCast(R.layout.fragment_place_call_cast));
        TrueConfSDK.getCallScreenController().setReceiveCallFragment(new IncomingCallFragmentCast(R.layout.fragment_incoming_call_cast));
        TrueConfSDK.getCallScreenController().setConferenceFragment(new ConferenceFragmentCast(R.layout.fragment_conference_cast));
    }

    private void setCallLayoutParams() {
        final float scale = getResources().getDisplayMetrics().density;
        int height = (int) (400 * scale + 0.5f);
        WindowManager.LayoutParams params = new WindowManager.LayoutParams();
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.height = height;
        params.gravity = Gravity.BOTTOM;
        TrueConfSDK.getCallWindowController().setCallLayoutParams(params);
    }

    @Override
    protected void onDestroy() {
        TrueConfSDK.getInstance().removeTrueconfListener(this);
        super.onDestroy();
    }

    @Override
    public void onLayoutApplied(int pageNumber) {
    }

    @Override
    public void onCalculateCustomLayouts(List<String> conferencePeers) {
//        var customGfxLayout = GfxLayout.NewInstance("just description");
//        customGfxLayout.SetManualMode(true);
//        customGfxLayout.SetPageNumber(0);
//
//        for (String peerId : conferencePeers) {
//            var key = TrueConfSDK.removeInstanceSuffix(peerId);
//            var cell = forcedCells.get(key);
//
//            if (cell != null) {
//                customGfxLayout.SetUserCell(peerId, cell);
//            }
//        }
//        customGfxLayout.SetScreenArea(new Rect(200, 400, 400, 1200));
//        TrueConfSDK.getParticipantLayoutController().setCustomLayout(customGfxLayout);
//        TrueConfSDK.getParticipantLayoutController().showCustomPage(0, GfxLayout.MERGE);
    }
}
