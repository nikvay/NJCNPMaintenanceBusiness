package com.cnp_maintenance.ui.adpater;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.cnp_maintenance.R;
import com.cnp_maintenance.ui.module.Products;
import java.util.ArrayList;


public class ProductStockRecyclerAdapter extends RecyclerView.Adapter<ProductStockRecyclerAdapter.MyDataHolder>  implements Filterable {

    private ArrayList<Products> products;
    private Context context;
    private ArrayList<Products> arrayListFiltered;

    public ProductStockRecyclerAdapter(Context context, ArrayList<Products> products) {
        this.context = context;
        this.products = products;
        this.arrayListFiltered=products;
    }

    @Override
    public int getItemCount() {
        return products==null?0:products.size();
    }

    @Override
    public MyDataHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_row_item_adapter_stock, parent, false);
        MyDataHolder myDataHolder = new MyDataHolder(v);
        return myDataHolder;
    }

    @Override
    public void onBindViewHolder(final MyDataHolder holder, final int position) {
        final Products product = products.get(position);
        holder.txt_name.setText(product.getName());
        holder.txt_quantity.setText("Stock: " + product.getStock());

       /* holder.iv_view_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, StockDetailsActivity.class);
                intent.putExtra("product", products.get(position));
                context.startActivity(intent);
            }
        });*/



        setScaleAnimation(holder.itemView);
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString().replaceAll("\\s","").toLowerCase().trim();
                if (charString.isEmpty() || charSequence.equals("")) {
                    products = arrayListFiltered;
                } else {
                    ArrayList<Products> filteredList = new ArrayList<>();
                    for (int i = 0; i < products.size(); i++) {

                        String productName=products.get(i).getName().replaceAll("\\s","").toLowerCase().trim();
                        if (productName.contains(charString)) {
                            filteredList.add(products.get(i));
                        }
                    }
                    if (filteredList.size() > 0) {
                        products = filteredList;
                    } else {
                        products = arrayListFiltered;
                    }

                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = products;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                products = (ArrayList<Products>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class MyDataHolder extends RecyclerView.ViewHolder {

        TextView txt_name, txt_quantity, txt_view_details;
        ImageView iv_view_details;

        public MyDataHolder(View view) {
            super(view);
            txt_name = view.findViewById(R.id.txt_name);
            txt_quantity =  view.findViewById(R.id.txt_quantity);
            iv_view_details = view.findViewById(R.id.iv_view_details);
        }
    }

    private void setScaleAnimation(View view) {
        ScaleAnimation anim = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        anim.setDuration(300);
        view.startAnimation(anim);
    }
}
