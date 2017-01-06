package com.techno.matrimonial.Fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.techno.matrimonial.Adapter.GirlsCandidatesAdapter;
import com.techno.matrimonial.Global.AnimUtils;
import com.techno.matrimonial.R;
import com.techno.matrimonial.Screens.FiltreActivity;
import com.techno.matrimonial.Screens.GirlsDetailsActivity;

import java.util.ArrayList;

/**
 * Created by arbaz on 2/7/16.
 */
public class GirlsFragment extends Fragment {
    private RecyclerView recyclerView;
    private GirlsCandidatesAdapter gAdapter;
    ImageButton img_fab_girls;
    Toolbar toolbar;

    // Required empty public constructor
    public GirlsFragment() {

        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        Fresco.initialize(getActivity());
        View rootView = inflater.inflate(R.layout.fragment_girls, container, false);

        toolbar = (Toolbar)getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle("Girls");

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        final FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.fab_girls);

      
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), FiltreActivity.class));
            }
        });


        final ArrayList<String> arr = new ArrayList<String>();
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        arr.add("a");
        arr.add("b");
        arr.add("c");
        arr.add("e");
        arr.add("f");
        arr.add("g");

        gAdapter = new GirlsCandidatesAdapter(arr, getActivity());
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(gAdapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener(){
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy){
                if (dy > 0 ||dy<0 && fab.isShown())
                    fab.hide();
            }

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {

                if (newState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE){
                    fab.show();
                }
                super.onScrollStateChanged(recyclerView, newState);
            }
        });
        return rootView;

    }

}
