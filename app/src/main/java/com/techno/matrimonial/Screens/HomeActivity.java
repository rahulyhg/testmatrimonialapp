package com.techno.matrimonial.Screens;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import com.techno.matrimonial.Fragment.AboutUsFragment;
import com.techno.matrimonial.Fragment.BoysFragment;
import com.techno.matrimonial.Fragment.EventsFragment;
import com.techno.matrimonial.Fragment.FeedbackFragment;
import com.techno.matrimonial.Fragment.GirlsFragment;
import com.techno.matrimonial.Fragment.Send_BioDataFragment;
import com.techno.matrimonial.Fragment.SettingsFragment;
import com.techno.matrimonial.Fragment.SortlistFragment;
import com.techno.matrimonial.Global.AnimUtils;
import com.techno.matrimonial.MatrimonialApplication;
import com.techno.matrimonial.Model.LoginDetails;
import com.techno.matrimonial.R;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    android.support.v4.app.Fragment fragment;
    private SimpleDraweeView circleImage;
    Toolbar toolbar;
    private FragmentManager fragmentManager;
    boolean doubleBackToExitPressedOnce = false;
    TextView hdr_view_profile, hdr_user_nmae;
    RelativeLayout hdr_layout_view_profile;
    LoginDetails loginDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_home);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        toolbar.setTitle("Girls");

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        /*  Set the home as default*/
        fragment = new GirlsFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
        navigationView.getMenu().getItem(0).setChecked(true);

        /*for nav header click*/

        Gson gson = new Gson();
        String json = MatrimonialApplication.sharedPref.getString("LoginDetails", "");
        LoginDetails usernameObj = gson.fromJson(json, LoginDetails.class);

        View headerLayout = navigationView.getHeaderView(0);
        circleImage = (SimpleDraweeView) headerLayout.findViewById(R.id.circle);
        hdr_layout_view_profile = (RelativeLayout) headerLayout.findViewById(R.id.hdr_layout_view_profile);
        hdr_view_profile = (TextView) headerLayout.findViewById(R.id.hdr_view_profile);
        hdr_user_nmae = (TextView) headerLayout.findViewById(R.id.hdr_user_nmae);

        final Uri imageUri = Uri.parse("http://services.imobbr.com/galeria/78/avatar.png");
        circleImage.setImageURI(imageUri);

       // String userfullname = usernameObj.getFirst_name()+" "+usernameObj.getLast_name();
       // hdr_user_nmae.setText(userfullname);

        hdr_layout_view_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), BoysDetailsActivity.class));
            }
        });

        //for animation
        AnimUtils.activityenterAnim(HomeActivity.this);

    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
/*        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
         else {
            super.onBackPressed();
        }*//*
        drawer.openDrawer(Gravity.LEFT);

        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);*/
        if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
            finish();
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_girls) {
            changeFragment(new GirlsFragment(), "Girls");
        } else if (id == R.id.nav_boys) {
            changeFragment(new BoysFragment(), "Boys");

        } else if (id == R.id.nav_sortlist) {
            changeFragment(new SortlistFragment(), "Sortlist");
        } else if (id == R.id.nav_events) {
            changeFragment(new EventsFragment(), "Events");
        } else if (id == R.id.nav_send_biodata) {
            changeFragment(new Send_BioDataFragment(), "Send Bio-Data");
        } else if (id == R.id.nav_feedback) {
            changeFragment(new FeedbackFragment(), "Feedback");
        } else if (id == R.id.nav_aboutus) {
            changeFragment(new AboutUsFragment(), "AboutUs");
        } else if (id == R.id.nav_settings) {
            changeFragment(new SettingsFragment(), "Settings");
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    void changeFragment(android.support.v4.app.Fragment fragment, String title) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        //for fragment aniation
        fragmentTransaction.setCustomAnimations(R.anim.activity_slide_in_left, R.anim.activity_slide_out_left);
        fragmentTransaction.replace(R.id.fragment_container, fragment).addToBackStack("null");
        fragmentTransaction.commit();
        //  toolbar.setTitle(title);
    }

}
