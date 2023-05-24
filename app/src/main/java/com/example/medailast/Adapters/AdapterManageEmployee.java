package com.example.medailast.Adapters;

import android.content.Context;
import android.content.Intent;
import android.media.MediaDrm;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import com.example.medailast.Historic;
import com.example.medailast.Models.ManagmentEmployeeFig;
import com.example.medailast.R;
import com.example.medailast.Score;
import com.example.medailast.Tools;

import java.util.ArrayList;

public class AdapterManageEmployee extends RecyclerView.Adapter<AdapterManageEmployee.ViewHolder>{
    private ArrayList<ManagmentEmployeeFig> list_title = new ArrayList<>();

    public AdapterManageEmployee(ArrayList<ManagmentEmployeeFig> list_title, Context context) {
        this.list_title = list_title;
        this.context = context;
    }

    private Context context;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.management_employee_fig, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(list_title.get(position).getTitle());
        holder.imageView.setImageDrawable(list_title.get(position).getImage());
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                switch (holder.getAdapterPosition()){
                    case 0:
                        intent = new Intent(context, Score.class);
                        context.startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(context, Historic.class);
                        context.startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(context, Tools.class);
                        context.startActivity(intent);
                        break;
                    default:

                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView title;
        private ImageView imageView;
        private RelativeLayout card;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title_management);
            imageView = itemView.findViewById(R.id.image_management);
            card = itemView.findViewById(R.id.card);
        }
    }

}
