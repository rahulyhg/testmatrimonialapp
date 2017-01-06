package com.techno.matrimonial.Fragment;


import com.techno.matrimonial.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/**
 * Created by arbaz on 11/7/16.
 */
public class PersonalInfoFragmentTab extends Fragment {

    public PersonalInfoFragmentTab() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_personal_info_tab, container, false);
        return rootview;
    }
}
