package com.example.oscar.wallet.Views.Fragments;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.oscar.wallet.Adapters.ItemOverviewAdapter;
import com.example.oscar.wallet.Adapters.Overview;
import com.example.oscar.wallet.Adapters.OverviewAdapter;
import com.example.oscar.wallet.Interfaces.OnClickOverviewListener;
import com.example.oscar.wallet.R;
import com.example.oscar.wallet.Views.Activities.IncomeActivity;

import java.util.ArrayList;
import java.util.function.ToLongBiFunction;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class OverviewFragment extends Fragment {

    ArrayList<Overview> items;
  //  RecyclerView recyclerViewOverview;
    ListView listViewOverview;
    public OverviewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_overview,container,false);

        items= new ArrayList<>();
        listViewOverview= (ListView)view.findViewById(R.id.listview_overview);
       /* recyclerViewOverview= (RecyclerView) view.findViewById(R.id.recycler_view_overview);
        recyclerViewOverview.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));*/
        loadItemsRecyclerView();
        ItemOverviewAdapter adapter= new ItemOverviewAdapter(getActivity().getApplicationContext(),items);
        listViewOverview.setAdapter(adapter);
        listViewOverview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Overview overview= (Overview) adapterView.getItemAtPosition(i);
                navigateToListOperations(overview);
            }


        });
        /*  OverviewAdapter adapter= new OverviewAdapter(items);
        recyclerViewOverview.setAdapter(adapter);

        recyclerViewOverview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity().getApplicationContext(),"CLICK",Toast.LENGTH_SHORT).show();
            }
        });*/
        return view;
    }
    private void navigateToListOperations(Overview overview) {
       switch (overview.getId()){
           case 1:startActivity(new Intent(getActivity().getApplicationContext(), IncomeActivity.class));break;

       }
    }
    private void loadItemsRecyclerView() {
        items.add(new Overview(1,"Cuenta","saldo acumulado",232.3));
        items.add(new Overview(2,"Ingresos","saldo pendiente",100.3));
        items.add(new Overview(3,"Gastos","saldo fijo",40.3));

    }


}
