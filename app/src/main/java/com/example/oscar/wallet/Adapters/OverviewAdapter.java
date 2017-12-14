package com.example.oscar.wallet.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.oscar.wallet.R;

import java.util.ArrayList;

/**
 * Created by oscar on 14/12/2017.
 */

public class OverviewAdapter extends RecyclerView.Adapter<OverviewAdapter.OverviewViewHolder> implements View.OnClickListener{
     ArrayList<Overview> items;

     private  View.OnClickListener listener;
    public OverviewAdapter(ArrayList<Overview> items) {
        this.items = items;
    }

    @Override
    public OverviewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,null,false);
         view.setOnClickListener(this);
        return new OverviewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(OverviewViewHolder holder, int position) {
            holder.txtTitle.setText(items.get(position).getTitle());
            holder.txtSubtitle.setText(items.get(position).getSubtitle());
            holder.txtAmmount.setText(String.valueOf(items.get(position).getAmount()));

    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }

    @Override
    public void onClick(View view) {
            if(listener!= null){
                listener.onClick(view);
            }
    }

    public class OverviewViewHolder extends RecyclerView.ViewHolder {
         TextView txtTitle,txtSubtitle,txtAmmount;


        public OverviewViewHolder(View itemView) {
            super(itemView);
            txtTitle=(TextView)itemView.findViewById(R.id.txt_title);
            txtSubtitle=(TextView)itemView.findViewById(R.id.txt_subtitle);
            txtAmmount=(TextView)itemView.findViewById(R.id.txt_ammount);

        }
    }
}
