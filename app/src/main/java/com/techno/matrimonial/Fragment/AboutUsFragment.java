package com.techno.matrimonial.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.techno.matrimonial.R;

/**
 * Created by arbaz on 2/7/16.
 */
public class AboutUsFragment extends Fragment {
    Toolbar toolbar;

    public AboutUsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle("AboutUs");
        View rootview = inflater.inflate(R.layout.fragment_aboutus, container, false);
        return rootview;
    }
}
