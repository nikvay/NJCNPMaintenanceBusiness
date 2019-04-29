package com.cnp_maintenance.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.cnp_maintenance.R;
import com.cnp_maintenance.ui.activity.AddCustomerActivity;
import com.cnp_maintenance.ui.adpater.CustomerAdapter;
import com.cnp_maintenance.ui.module.CustomerModule;

import java.util.ArrayList;


public class MyCustomerFragment extends Fragment {


    Context mContext;
    Button btn_add_customer;
    RecyclerView recycler_customer;
    ArrayList<CustomerModule> customerModuleArrayList = new ArrayList<>();
    CustomerAdapter customerAdapter;
    EditText edt_search_customer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_my_customer, container, false);
        mContext=getContext();


        find_All_IDs(view);
        events();

        return view;
    }

    private void find_All_IDs(View view) {

        recycler_customer = view.findViewById(R.id.recycler_customer);
        btn_add_customer = view.findViewById(R.id.btn_add_customer);
        edt_search_customer=view.findViewById(R.id.edt_search_customer);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        recycler_customer.setLayoutManager(linearLayoutManager);
        recycler_customer.setHasFixedSize(true);



        customerModuleArrayList.add(new CustomerModule("Vishal"));
        customerModuleArrayList.add(new CustomerModule("Vishal"));
        customerModuleArrayList.add(new CustomerModule("Vishal"));
        customerModuleArrayList.add(new CustomerModule("Vishal"));
        customerModuleArrayList.add(new CustomerModule("Vishal"));

        customerAdapter = new CustomerAdapter(mContext, customerModuleArrayList);
        recycler_customer.setAdapter(customerAdapter);
        customerAdapter.notifyDataSetChanged();
    }

    private void events() {


        edt_search_customer.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                customerAdapter.getFilter().filter(edt_search_customer.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        btn_add_customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, AddCustomerActivity.class);
                intent.putExtra("ADDCUSTOMER","addcudtomer");
                startActivity(intent);
            }
        });
    }
}
