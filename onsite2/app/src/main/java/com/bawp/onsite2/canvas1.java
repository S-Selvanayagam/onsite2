package com.bawp.onsite2;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class canvas1 extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;
    private viewmodel model;
    Button switchbt;
    CustomView customView;

    public canvas1() {
        // Required empty public constructor
    }


    public static canvas1 newInstance(String param1, String param2) {
        canvas1 fragment = new canvas1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_canvas, container, false);
        switchbt =v.findViewById(R.id.button3);
        customView =v.findViewById(R.id.c1);
        return v;
    }
    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        model = new ViewModelProvider(requireActivity()).get(viewmodel.class);
        switchbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View item) {
                Log.v("In Fragment1", customView.toString());
                model.selectItem(customView);
            }
        });
    }

}