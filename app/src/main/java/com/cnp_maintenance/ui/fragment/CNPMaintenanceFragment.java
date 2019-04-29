package com.cnp_maintenance.ui.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cnp_maintenance.R;


public class CNPMaintenanceFragment extends Fragment {

    Context mContext;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_cnpmaintenance, container, false);
        mContext=getContext();

        find_All_IDs(view);
        events();
        return view;
    }

    private void find_All_IDs(View view) {
    }

    private void events() {
    }

}
