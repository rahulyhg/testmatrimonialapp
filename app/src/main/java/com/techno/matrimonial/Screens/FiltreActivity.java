package com.techno.matrimonial.Screens;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.Display;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.view.ViewGroup.LayoutParams;

import com.techno.matrimonial.CustomUi.RangeSeekBar;
import com.techno.matrimonial.Global.AnimUtils;
import com.techno.matrimonial.R;


/**
 * Created by arbaz on 5/7/16.
 */
public class FiltreActivity extends AppCompatActivity {
    Spinner spinner, spinner_edu_filter, spinner_caste_filter, spinner_subcaste_filter;
    TextView tv_age_limit;
    TextView dflt_select_city_txt, dflt_select_edu_txt, dflt_select_cast_txt, dflt_select_subcast_txt;
    RangeSeekBar rangeSeekbar;

    int preMin = -1;
    int preMax = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        dflt_select_city_txt = (TextView) findViewById(R.id.dflt_select_city_txt);
        dflt_select_edu_txt = (TextView) findViewById(R.id.dflt_select_edu_txt);
        dflt_select_cast_txt = (TextView) findViewById(R.id.dflt_select_cast_txt);
        dflt_select_subcast_txt = (TextView) findViewById(R.id.dflt_select_subcast_txt);


        spinner = new Spinner(getApplicationContext(), Spinner.MODE_DIALOG);
        spinner = (Spinner) findViewById(R.id.spinner_city);


        spinner_edu_filter = new Spinner(getApplicationContext(), Spinner.MODE_DIALOG);
        spinner_edu_filter = (Spinner) findViewById(R.id.spinner_edu_filter);


        spinner_caste_filter = new Spinner(getApplicationContext(), Spinner.MODE_DIALOG);
        spinner_caste_filter = (Spinner) findViewById(R.id.spinner_caste_filter);

        spinner_subcaste_filter = new Spinner(getApplicationContext(), Spinner.MODE_DIALOG);
        spinner_subcaste_filter = (Spinner) findViewById(R.id.spinner_subcaste_filter);


        tv_age_limit = (TextView) findViewById(R.id.tv_age_limit);

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, R.layout.spinner_bg, R.id.spinner_tv,
                getResources().getStringArray(R.array.city_name));
        spinner.setAdapter(spinnerArrayAdapter);
        spinner.setPrompt(dflt_select_city_txt.getText().toString());


        ArrayAdapter<String> spinnerArrayAdapterEdu = new ArrayAdapter<String>(this, R.layout.spinner_bg, R.id.spinner_tv,
                getResources().getStringArray(R.array.edu_filter));
        spinner_edu_filter.setAdapter(spinnerArrayAdapterEdu);
        spinner_edu_filter.setPrompt(dflt_select_edu_txt.getText().toString());

        ArrayAdapter<String> spinnerArrayAdapterCaste = new ArrayAdapter<String>(this, R.layout.spinner_bg, R.id.spinner_tv,
                getResources().getStringArray(R.array.caste_filter));
        spinner_caste_filter.setAdapter(spinnerArrayAdapterCaste);
        spinner_caste_filter.setPrompt(dflt_select_cast_txt.getText().toString());

        ArrayAdapter<String> spinnerArrayAdapterSubCaste = new ArrayAdapter<String>(this, R.layout.spinner_bg, R.id.spinner_tv,
                getResources().getStringArray(R.array.sub_caste_filter));
        spinner_subcaste_filter.setAdapter(spinnerArrayAdapterSubCaste);
        spinner_subcaste_filter.setPrompt(dflt_select_subcast_txt.getText().toString());

        RangeSeekBar rangeSeekbar = (RangeSeekBar) findViewById(R.id.rangeSeekbar);
        rangeSeekbar.setNotifyWhileDragging(true);
        rangeSeekbar.setOnRangeSeekBarChangeListener(new RangeSeekBar.OnRangeSeekBarChangeListener() {
            @Override
            public void onRangeSeekBarValuesChanged(RangeSeekBar bar, Object minValue, Object maxValue) {

                // Toast.makeText(getApplicationContext(), "Min Value- " + minValue + " & " + "Max Value- " + maxValue, Toast.LENGTH_LONG).show();
                tv_age_limit.setText(minValue + " - " + maxValue);
            }
        });
        //for animation

        AnimUtils.activitySlideUpAnim(FiltreActivity.this);

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}