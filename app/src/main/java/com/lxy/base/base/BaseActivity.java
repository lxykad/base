package com.lxy.base.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.lxy.base.R;
import com.lxy.base.util.ActivityManager;
import com.lxy.base.util.SystemBarTintManager;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityManager.getInstance().addActivity(this);

        setTransLucentStatus(true);
        SystemBarTintManager tintManager = new SystemBarTintManager(this);
        tintManager.setStatusBarTintEnabled(true);
        tintManager.setStatusBarTintResource(R.color.status_bar_color);//通知栏所需颜色
    }



    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        ActivityManager.getInstance().removeActivity(this);
    }

    public void setTransLucentStatus(boolean on){
        Window window = getWindow();
        WindowManager.LayoutParams params = window.getAttributes();

        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            params.flags |= bits;
        } else {
            params.flags &= ~bits;
        }
        window.setAttributes(params);

    }
}
