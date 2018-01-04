package com.example.oscar.wallet.Views.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.oscar.wallet.R;

import java.util.List;

/**
 * Created by oscar on 14/12/2017.
 */

public class ItemOverviewAdapter extends BaseAdapter {
    Context context;
    List<Overview> items;

    public ItemOverviewAdapter(Context context, List<Overview> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i)
    {
        return items.get(i).getId();
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        View view=convertView;
        LayoutInflater inflater= LayoutInflater.from(context);
        view=inflater.inflate(R.layout.item_list,null);
        TextView txtTitle= (TextView)view.findViewById(R.id.txt_title);
        TextView txtSubtitle=(TextView)view.findViewById(R.id.txt_subtitle);
        TextView txtAmmount=(TextView)view.findViewById(R.id.txt_ammount);
        txtTitle.setText(items.get(i).getTitle());
        txtSubtitle.setText(items.get(i).getSubtitle());
        txtAmmount.setText(items.get(i).getAmount().toString());
    return view;
    }
}
