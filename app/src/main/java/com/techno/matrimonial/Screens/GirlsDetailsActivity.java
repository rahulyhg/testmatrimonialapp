package com.techno.matrimonial.Screens;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.facebook.drawee.view.SimpleDraweeView;
import com.techno.matrimonial.CustomUi.ZoomableActivity;
import com.techno.matrimonial.Fragment.ContactInfoFragmentTab;
import com.techno.matrimonial.Fragment.PersonalInfoFragmentTab;
import com.techno.matrimonial.Global.AnimUtils;
import com.techno.matrimonial.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arbaz on 4/7/16.
 */
public class GirlsDetailsActivity extends AppCompatActivity implements View.OnClickListener {
    Button button;
    private SimpleDraweeView circleImage;
    LinearLayout layout_personal_info, layout_Contact_info;

    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_girls_details);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        circleImage = (SimpleDraweeView) findViewById(R.id.girls_details_profile);
        final Uri imageUri = Uri.parse("http://www.montana.edu/nativeamerican/images/Images/avatar_woman.jpg");
        circleImage.setImageURI(imageUri);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        //for animationa
        AnimUtils.activitySlideUpAnim(GirlsDetailsActivity.this);
        circleImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri data = imageUri;
                startActivity(new Intent(getApplicationContext(), ZoomableActivity.class).setData(data).putExtra("img_url", data));

            }
        });

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new PersonalInfoFragmentTab(), "Personal Info");
        adapter.addFragment(new ContactInfoFragmentTab(), "Contact Info");
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {


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

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
