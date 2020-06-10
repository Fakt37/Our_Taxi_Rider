package com.example.ourtaxirider;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.ourtaxirider.Common.Common;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomSheetRiderFragment extends BottomSheetDialogFragment {
    String mLocation, mDestination;

    boolean isTapOnMap;

    TextView txtCalculate, txtLocation, txtDestination;
    public static BottomSheetRiderFragment newInstance (String location, String destination, boolean isTapOnMap)
    {
        BottomSheetRiderFragment f = new BottomSheetRiderFragment();
        Bundle args = new Bundle();
        args.putString("location", location);
        args.putString("destination", destination);
        args.putBoolean("isTapOnMap", isTapOnMap);
        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLocation = getArguments().getString("location");
        mDestination = getArguments().getString("destination");
        isTapOnMap = getArguments().getBoolean("isTapOnMap");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_sheet_rider,container,false);
        txtLocation = (TextView) view.findViewById(R.id.txtLocation);
        txtDestination = (TextView) view.findViewById(R.id.txtDestination);
        txtCalculate = (TextView) view.findViewById(R.id.txtCalculate);


        if (!isTapOnMap) {
            txtLocation.setText(mLocation);
            txtDestination.setText(mDestination);
        }
        return view;
    }
}
