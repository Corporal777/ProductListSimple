package com.lessons.productlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.MyViewHolder> {
    ProductListAdapter adapter;
    Context context;
    List<Product> list = new ArrayList<>();

    public ProductListAdapter(Context context, List<Product> list) {
        this.context = context;
        this.list = list;
    }


    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);

        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Product product = list.get(position);

        holder.tvProduct.setText(product.getName());
        holder.tvId.setText(product.getId());


        holder.tvProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, list.size());

            }
        });
    }

    @Override
    public int getItemCount() {
        if (this.list != null) {
            return this.list.size();
        }

        return 0;
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvId;
        TextView tvProduct;


        public MyViewHolder(View view) {
            super(view);

            tvId = view.findViewById(R.id.tv_id);
            tvProduct = view.findViewById(R.id.tv_product);

        }
    }


}
