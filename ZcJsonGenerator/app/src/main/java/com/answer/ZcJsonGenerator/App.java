package com.answer.ZcJsonGenerator;

import android.app.Application;
import com.answer.ZcJsonGenerator.common.crash.CrashHandler;

public class App extends Application {

    private static App sApp;

    @Override
    public void onCreate() {
        super.onCreate();
        sApp = this;
        //错误
        CrashHandler.init(this);
    }

    public static boolean isNightMode() {
        return getApp().getResources().getBoolean(R.bool.night_mode);
    }

    public static App getApp() {
        return sApp;
    }

}
