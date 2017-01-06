package com.techno.matrimonial.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.techno.matrimonial.Adapter.BoysCandidatesAdapter;
import com.techno.matrimonial.Adapter.SortListCandidatesAdapter;
import com.techno.matrimonial.R;

import java.util.ArrayList;

/**
 * Created by arbaz on 2/7/16.
 */
public class SortlistFragment extends Fragment {
    private RecyclerView recyclerView;
    private SortListCandidatesAdapter gAdapter;
    Toolbar toolbar;
    public SortlistFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_sortlist, container, false);
        toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle("Sortlist");
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view_sortlisted);

        final ArrayList<String> arr = new ArrayList<String>();
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        arr.add("a");
        arr.add("b");


        gAdapter = new SortListCandidatesAdapter(arr, getActivity());
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(gAdapter);

        return rootView;
    }
}
