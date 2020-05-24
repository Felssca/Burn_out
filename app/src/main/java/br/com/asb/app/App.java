package br.com.asb.app;

import android.app.Application;
import android.content.Context;

public class  App extends Application {

    private static Context context;
    private static App instance;

    public App(){
        super.onCreate();
        App.context = App.getAppContext();

    }

    public static App getInstance() {

        if (instance == null)
            instance = new App();
        return instance;
    }



    public void onCreate() {
        super.onCreate();
        App.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return App.context;
    }





}
