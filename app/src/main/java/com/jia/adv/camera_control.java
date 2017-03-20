package com.jia.adv;

import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.jia.adv.camstuffs.DisplayMode;
import com.jia.adv.camstuffs.Mjpeg;
import com.jia.adv.camstuffs.MjpegView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class camera_control extends AppCompatActivity {

    private static final int TIMEOUT = 5;

    static String tempIP;

    @BindView(R.id.mjpegViewDefault)
    MjpegView mjpegView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_control);
        ButterKnife.bind(this);

        Bundle extras = getIntent().getExtras();

        final String serverIP = extras.getString("sendAddress");

        tempIP = "http://" + serverIP + ":8091/?action=stream";
    }

    private String getPreference(String key) {
        return PreferenceManager
                .getDefaultSharedPreferences(this)
                .getString(key, "");
    }

    private DisplayMode calculateDisplayMode() {
        int orientation = getResources().getConfiguration().orientation;
        return orientation == Configuration.ORIENTATION_LANDSCAPE ?
                DisplayMode.FULLSCREEN : DisplayMode.BEST_FIT;
    }

    private void loadIpCam() {
        Mjpeg.newInstance()
                .open(tempIP, TIMEOUT)
                .subscribe(
                        inputStream -> {
                            mjpegView.setSource(inputStream);
                            mjpegView.setDisplayMode(calculateDisplayMode());
                            mjpegView.showFps(true);
                        },
                        throwable -> {
                            Log.e(getClass().getSimpleName(), "mjpeg error", throwable);
                            Toast.makeText(this, "Error", Toast.LENGTH_LONG).show();
                        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadIpCam();
    }
}
