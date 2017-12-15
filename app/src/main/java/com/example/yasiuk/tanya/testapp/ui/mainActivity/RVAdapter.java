package com.example.yasiuk.tanya.testapp.ui.mainActivity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yasiuk.tanya.testapp.R;
import com.example.yasiuk.tanya.testapp.databinding.ItemRvMainBinding;
import com.example.yasiuk.tanya.testapp.ui.singleItem.SingleItemActivity;

import java.util.List;

/**
 * Created by tanya on 13.12.17.
 */

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.Holder> {

    private Context context;
    private List<ItemViewModel> itemsList;

    public RVAdapter(Context context, List<ItemViewModel> itemsList) {
        this.context = context;
        this.itemsList = itemsList;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_rv_main, parent, false);
        return new Holder(root);
    }

    @Override
    public void onBindViewHolder(Holder holder, final int position) {
        holder.binding.setItem(itemsList.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, SingleItemActivity.class);
                intent.putExtra("TITLE", itemsList.get(position).title);
                intent.putExtra("URL", itemsList.get(position).url);
                intent.putExtra("BODY", itemsList.get(position).body);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }




    public static class Holder extends RecyclerView.ViewHolder{

        ItemRvMainBinding binding;

        public Holder(final View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);

        }
    }
}
