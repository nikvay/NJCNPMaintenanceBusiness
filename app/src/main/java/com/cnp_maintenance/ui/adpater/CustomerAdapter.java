package com.cnp_maintenance.ui.adpater;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.cnp_maintenance.R;
import com.cnp_maintenance.ui.activity.AddCustomerActivity;
import com.cnp_maintenance.ui.module.CustomerModule;
import com.cnp_maintenance.ui.module.Products;

import java.util.ArrayList;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.MyViewHolder> implements Filterable {
    private Context mContext;
    private ArrayList<CustomerModule> customerModuleArrayList;
    private ArrayList<CustomerModule> arrayListFiltered;

    public CustomerAdapter(Context mContext, ArrayList<CustomerModule> customerModuleArrayList) {
        this.mContext = mContext;
        this.customerModuleArrayList = customerModuleArrayList;
        this.arrayListFiltered = customerModuleArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row_item_customer_adapter, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
//        final HomeModule homeModule = homeModuleArrayList.get(position);

        holder.iv_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, AddCustomerActivity.class);
                intent.putExtra("EDITCUSTOMER","edtcustomer");
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return customerModuleArrayList.size();
    }


    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString().replaceAll("\\s","").toLowerCase().trim();
                if (charString.isEmpty() || charSequence.equals("")) {
                    customerModuleArrayList = arrayListFiltered;
                } else {
                    ArrayList<CustomerModule> filteredList = new ArrayList<>();
                    for (int i = 0; i < customerModuleArrayList.size(); i++) {

                        String productName=customerModuleArrayList.get(i).getName().replaceAll("\\s","").toLowerCase().trim();
                        if (productName.contains(charString)) {
                            filteredList.add(customerModuleArrayList.get(i));
                        }
                    }
                    if (filteredList.size() > 0) {
                        customerModuleArrayList = filteredList;
                    } else {
                        customerModuleArrayList = arrayListFiltered;
                    }

                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = customerModuleArrayList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                customerModuleArrayList = (ArrayList<CustomerModule>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_edit;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_edit = itemView.findViewById(R.id.iv_edit);
        }
    }

}
