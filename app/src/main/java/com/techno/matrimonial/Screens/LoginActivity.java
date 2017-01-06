package com.techno.matrimonial.Screens;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import com.techno.matrimonial.Api.ApiFunctions;
import com.techno.matrimonial.Global.AnimUtils;
import com.techno.matrimonial.Global.Global;
import com.techno.matrimonial.Listener.OnApiCallListener;
import com.techno.matrimonial.MatrimonialApplication;
import com.techno.matrimonial.Model.DeviceInfo;
import com.techno.matrimonial.Model.Login;
import com.techno.matrimonial.Model.LoginDetails;
import com.techno.matrimonial.R;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends Activity implements OnApiCallListener {

    TextView txt_TC;
    Button btn_login;
    EditText et_login_user, et_login_password;
    DeviceInfo deviceInfo;
    ApiFunctions apiFunctions;
    private SimpleDraweeView circleImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //for fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Fresco.initialize(this);
        setContentView(R.layout.activity_login);
        apiFunctions = new ApiFunctions(this, this);
        btn_login = (Button) findViewById(R.id.btn_login);
        et_login_user = (EditText) findViewById(R.id.et_login_user);
        et_login_password = (EditText) findViewById(R.id.et_login_password);


        //for TC text size
        String s = getString(R.string.login_TC);
        SpannableString ss1 = new SpannableString(s);
        ss1.setSpan(new RelativeSizeSpan(1.5f), 37, 57, 0); // set size

        // ss1.setSpan(new ForegroundColorSpan(Color.RED), 37, 57, 0);// set color
        txt_TC = (TextView) findViewById(R.id.txt_TC);
        txt_TC.setText(ss1);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validate()) {
                    String email = et_login_user.getText().toString();
                    String password = et_login_password.getText().toString();

                    Global.storePreference(et_login_user.getText().toString(), "User_Login");
                    Global.storePreference(et_login_password.getText().toString(), "User_Password");
                    Global.storePreference("IsLogin", true);

                    deviceInfo = new DeviceInfo();
                    Login login = new Login(email, password, deviceInfo);
                  ///  apiFunctions.userLogin(Api.MainUrl + Api.ActionLogin, login);
                    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                }

            }
        });

        if (Global.getPreference("IsLogin", false)) {
            startActivity(new Intent(getApplicationContext(), HomeActivity.class));
        }

        //for animation
        AnimUtils.activityenterAnim(LoginActivity.this);
    }

    @Override
    public void onFailure(final String message) {
        /*stop API calling from background*/
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //Handle UI here
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();

            }
        });
    }

    @Override
    public void onSuccess(int responseCode, final String responseString, String url) {
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //Handle UI here
                //Toast.makeText(getApplicationContext(), responseString, Toast.LENGTH_LONG).show();
                //startActivity((new Intent(getApplicationContext(), HomeActivity.class)));

                Gson gson = new Gson();
                LoginDetails loginDetails;
                String json;
                JSONObject jsonObject = null;

                try {
                    SharedPreferences.Editor prefsEditor = MatrimonialApplication.sharedPref.edit();//store and retrieve a class object in shared preference
                    jsonObject = new JSONObject(responseString);
                    loginDetails = gson.fromJson(jsonObject.toString(), LoginDetails.class);
                    json = gson.toJson(loginDetails, LoginDetails.class);
                    prefsEditor.putString("LoginDetails", json);
                    prefsEditor.commit();
                    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /*For Validation*/
    public boolean validate() {
        boolean valid = true;

        String name = et_login_user.getText().toString();
        String password = et_login_password.getText().toString();

        if (name.trim().isEmpty()) {
            et_login_user.setError("Enter UserID");
            valid = false;
        } else {
            et_login_user.setError(null);
        }
        if (password.trim().isEmpty()) {
            et_login_password.setError("Enter Password");
            valid = false;
        } else {
            et_login_password.setError(null);
        }


        return valid;
    }
}
