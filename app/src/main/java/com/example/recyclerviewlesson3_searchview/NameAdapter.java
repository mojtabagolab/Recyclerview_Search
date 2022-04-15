package com.example.recyclerviewlesson3_searchview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class NameAdapter extends RecyclerView.Adapter<NameAdapter.viewholder>{

    List<NameModel> item;
    List<NameModel> filteritem;
    Context context;


    public NameAdapter(List<NameModel> item, Context context) {
        this.item = item;
        this.context = context;
        filteritem = new ArrayList<>();
        filteritem = item;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.nameitem , parent , false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        NameModel model = filteritem.get(position);
        holder.txtname.setText(model.getName());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context ,ActivityGetData.class);
                intent.putExtra("namekey" ,model.getName());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return filteritem.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        TextView txtname;
        CardView cardView;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            txtname = itemView.findViewById(R.id.txtshowname);
            cardView = itemView.findViewById(R.id.cardview);
        }
    }

    public void setFilter (String namefilter){
        namefilter =namefilter.toLowerCase();
        if (namefilter.isEmpty()){
            filteritem = new ArrayList<>();
            filteritem = item;
        }
        else {
            filteritem = new ArrayList<>();
            for (int i = 0 ; i < item.size() ; i++)
            {
                if (item.get(i).getName().toLowerCase().contains(namefilter)){
                    filteritem.add(item.get(i));
                }
            }
        }
        notifyDataSetChanged();
    }
}
