package noosc.project.otrs.login.animation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import noosc.project.otrs.login.R;
import noosc.project.otrs.login.core.login.LoginActivity;

/**
 * Created by Fauziyyah Faturahma on 7/10/2017.
 */

public class Spalshscreen extends Activity {


    // Splash screen timer
    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animation_splashscreen);

        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent sp = new Intent(Spalshscreen.this, LoginActivity.class);
                startActivity(sp);

                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}

