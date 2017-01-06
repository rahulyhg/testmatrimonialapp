package com.techno.matrimonial.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageButton;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.techno.matrimonial.Adapter.BoysCandidatesAdapter;
import com.techno.matrimonial.R;
import com.techno.matrimonial.Screens.FiltreActivity;

import java.util.ArrayList;

/**
 * Created by arbaz on 2/7/16.
 */
public class BoysFragment extends Fragment {
    private RecyclerView recyclerView;
    private BoysCandidatesAdapter gAdapter;
    ImageButton img_fab_boys;
    Toolbar toolbar;

    // Required empty public constructor
    public BoysFragment() {
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
        View rootView = inflater.inflate(
                R.layout.fragment_boys, container, false);
        toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle("Boys");

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view_boys);

        /*img_fab_boys = (ImageButton) rootView.findViewById(R.id.img_fab_boys);*/
        final FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.fab_boys);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), FiltreActivity.class));
            }
        });
       /* img_fab_boys.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), FiltreActivity.class));
            }
        });*/
        final ArrayList<String> arr = new ArrayList<String>();
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        arr.add("a");
        arr.add("b");
        arr.add("c");
        arr.add("e");
        arr.add("f");
        arr.add("g");

        gAdapter = new BoysCandidatesAdapter(arr, getActivity());
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(gAdapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (dy > 0 || dy < 0 && fab.isShown())
                    fab.hide();
            }

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {

                if (newState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE) {
                    fab.show();
                }
                super.onScrollStateChanged(recyclerView, newState);
            }
        });
        return rootView;
    }
}
