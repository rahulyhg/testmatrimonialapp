package com.techno.matrimonial.Screens;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import com.techno.matrimonial.Global.Global;
import com.techno.matrimonial.R;

/**
 * Created by arbaz on 19/7/16.
 */
public class SplashActivity extends Activity {
    // Splash screen timer
    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //for fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        // Call isNetworkAvailable class
        if (!isNetworkAvailable()) {
            // Create an Alert Dialog
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            // Set the Alert Dialog Message
            builder.setMessage("Internet Connection Required")
                    .setCancelable(false)
                    .setPositiveButton("Retry",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                                    int id) {
                                    // Restart the Activity
                                    Intent intent = getIntent();
                                    finish();
                                    startActivity(intent);
                                }
                            });
            AlertDialog alert = builder.create();
            alert.show();
        } else {
            // Locate the button in check_internet_connection.xml

            if (!isNetworkAvailable()) {
                AlertDialog.Builder builder = new AlertDialog.Builder(
                        SplashActivity.this);
                builder.setMessage("Internet Connection Required")
                        .setCancelable(false)
                        .setPositiveButton("Retry",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(
                                            DialogInterface dialog,
                                            int id) {

                                        // Restart the activity
                                        Intent intent = new Intent(
                                                SplashActivity.this,
                                                SplashActivity.class);
                                        finish();
                                        startActivity(intent);

                                    }

                                });
                AlertDialog alert = builder.create();
                alert.show();

            } else {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // This method will be executed once the timer is over
                        // Start your app main activity

                        if (Global.getPreference("IsLogin", false)) {
                            startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                        }
                        else
                        {
                            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                        }

                        // close this activity
                        finish();
                    }
                }, SPLASH_TIME_OUT);
            }
        }
    }


    // Private class isNetworkAvailable
    private boolean isNetworkAvailable() {
        // Using ConnectivityManager to check for Network Connection
        ConnectivityManager connectivityManager = (ConnectivityManager) this
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager
                .getActiveNetworkInfo();
        return activeNetworkInfo != null;
    }

}
