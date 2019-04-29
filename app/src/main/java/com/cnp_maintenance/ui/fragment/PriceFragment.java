package com.cnp_maintenance.ui.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.cnp_maintenance.R;
import com.cnp_maintenance.ui.adpater.ProductTypeAdapter;
import com.cnp_maintenance.ui.module.ProductTypeModel;
import com.cnp_maintenance.utils.ProductTypeNotifier;

import java.util.ArrayList;
import java.util.List;

public class PriceFragment extends Fragment {

    Context mContext;
    private List<String> productType = new ArrayList<>();
    private Spinner spinnerSC;
    private RecyclerView recyclerSC;
    private String mProductType = null;
    private ProductTypeModel productTypeModel;
    private ProductTypeAdapter productTypeAdapter;
    private ArrayList<ProductTypeModel> arrayListtype = new ArrayList<>();
    private ArrayAdapter<String> productCatAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_price, container, false);

        mContext=getContext();


        find_All_IDs(view);
        events();

        return view;
    }
    private void find_All_IDs(View view) {

        spinnerSC =view.findViewById(R.id.spinnerSC);
        recyclerSC =view.findViewById(R.id.recyclerSC);







        productType.clear();
        productType.add("Local");
        productType.add("Export");


        productCatAdapter = new ArrayAdapter<String>(mContext, R.layout.spinner_item, productType);
        productCatAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinnerSC.setAdapter(productCatAdapter);
        final LinearLayoutManager managerPT = new LinearLayoutManager(mContext);
        recyclerSC.setLayoutManager(managerPT);
        recyclerSC.setHasFixedSize(true);





    }

    private void events() {

        for(int i=0;i<=10;i++) {
            productTypeModel = new ProductTypeModel();
            productTypeModel.setId("1");
            productTypeModel.setType_name("Multistage Pumps");
            arrayListtype.add(productTypeModel);
        }
        productTypeAdapter = new ProductTypeAdapter(arrayListtype, mContext);
        recyclerSC.setAdapter(productTypeAdapter);

    }

}
