package com.cnp_maintenance.ui.fragment;

import android.content.Context;
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
import android.widget.EditText;
import android.widget.TextView;

import com.cnp_maintenance.R;
import com.cnp_maintenance.ui.adpater.ProductStockRecyclerAdapter;
import com.cnp_maintenance.ui.module.Products;

import java.util.ArrayList;


public class StockFragment extends Fragment  {

    Context mContext;
    RecyclerView recyclerViewStock;
    TextView txt_no_data_found;
    EditText edt_search_stock;
    ArrayList<Products> arrayList_products=new ArrayList<>();
    ProductStockRecyclerAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_stock, container, false);
        mContext = getActivity();
        find_All_IDs(view);
        events();

        return view;
    }

    private void events() {
        for(int i=0;i<=10;i++)
        {
            arrayList_products.add(new Products("CDL/CDLF","20"));
        }

        adapter = new ProductStockRecyclerAdapter(getActivity(), arrayList_products);
        recyclerViewStock.setAdapter(adapter);
        adapter.notifyDataSetChanged();



        edt_search_stock.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                adapter.getFilter().filter(edt_search_stock.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    private void find_All_IDs(View view) {
        recyclerViewStock=view.findViewById(R.id.recyclerViewStock);
        txt_no_data_found=view.findViewById(R.id.txt_no_data_found);
        edt_search_stock=view.findViewById(R.id.edt_search_stock);

        LinearLayoutManager linearlayout = new LinearLayoutManager(getActivity());
        linearlayout.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewStock.setLayoutManager(linearlayout);
    }

}
