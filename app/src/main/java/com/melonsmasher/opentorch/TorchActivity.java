package com.melonsmasher.opentorch;

import android.hardware.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class TorchActivity extends AppCompatActivity implements View.OnClickListener {

    private ToggleButton mSwitch;
    private Camera mCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_torch);
        mCamera = Camera.open();
        mSwitch = (ToggleButton) findViewById(R.id.toggleButton);
        mSwitch.setOnClickListener(this);
        mSwitch.setChecked(false);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.toggleButton:
                if (mSwitch.isChecked()) {
                    Camera.Parameters p = mCamera.getParameters();
                    p.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                    mCamera.setParameters(p);
                    mCamera.startPreview();
                } else {
                    mCamera.stopPreview();
                    mCamera.release();
                    mCamera = Camera.open();
                }
        }
    }
}
