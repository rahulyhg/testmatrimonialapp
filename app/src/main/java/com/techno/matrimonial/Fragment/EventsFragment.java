package com.techno.matrimonial.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.techno.matrimonial.Adapter.EventsListAdapter;
import com.techno.matrimonial.Adapter.GirlsCandidatesAdapter;
import com.techno.matrimonial.R;

import java.util.ArrayList;

/**
 * Created by arbaz on 2/7/16.
 */
public class EventsFragment extends Fragment {
    private RecyclerView recyclerView;
    private EventsListAdapter gAdapter;
    Toolbar toolbar;
    // Required empty public constructor
    public EventsFragment() {
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
                R.layout.fragment_events, container, false);
        toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle("Events");
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view_events);
        final ArrayList<String> arr = new ArrayList<String>();
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        arr.add("a");
        arr.add("b");
        arr.add("c");
        arr.add("e");
        arr.add("f");
        arr.add("g");

        gAdapter = new EventsListAdapter(arr, getActivity());
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(gAdapter);

        return rootView;
    }
}
