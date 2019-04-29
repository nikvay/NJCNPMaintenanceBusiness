package com.cnp_maintenance.ui.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.cnp_maintenance.MainActivity;
import com.cnp_maintenance.R;

public class HomeFragment extends Fragment {


    Context mContext;
    LinearLayout ll_cnp_maintenance, ll_my_customer, ll_check_stock, ll_check_price;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        mContext = getActivity();

        find_All_IDs(view);
        events();

        return view;
    }

    private void events() {
        ll_cnp_maintenance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) mContext).loadFragment(new CNPMaintenanceFragment());
            }
        });
        ll_my_customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) mContext).loadFragment(new MyCustomerFragment());

            }
        });
        ll_check_stock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ((MainActivity) mContext).loadFragment(new StockFragment());

            }
        });
        ll_check_price.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) mContext).loadFragment(new PriceFragment());
            }
        });

    }

    private void find_All_IDs(View view) {
        ll_cnp_maintenance = view.findViewById(R.id.ll_cnp_maintenance);
        ll_my_customer = view.findViewById(R.id.ll_my_customer);
        ll_check_stock = view.findViewById(R.id.ll_check_stock);
        ll_check_price = view.findViewById(R.id.ll_check_price);


    }


}
