package com.bawp.onsite2;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class canvas2 extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;
    CustomView customView;

    public canvas2() {
        // Required empty public constructor
    }


    public static canvas2 newInstance(String param1, String param2) {
        canvas2 fragment = new canvas2();
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
        View v= inflater.inflate(R.layout.fragment_canvas2, container, false);
        customView =v.findViewById(R.id.custom);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewmodel model = new ViewModelProvider(requireActivity()).get(viewmodel.class);

        model.getSelectedItem().observe(getViewLifecycleOwner(), new Observer<CustomView>() {
            @Override

            public void onChanged(CustomView item) {
                customView.path = item.path;
                customView.postInvalidate();

                Log.d("ola", customView.toString());
            }
        });
    }
}