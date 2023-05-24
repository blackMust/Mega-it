package com.example.medailast.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.PopupMenu;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medailast.EditTool;
import com.example.medailast.R;
import com.example.medailast.Models.ToolsModel;

import java.util.ArrayList;

public class AdapterTools extends RecyclerView.Adapter<AdapterTools.ViewHolder>{
    public AdapterTools(Context context) {
        this.context = context;
    }

    public void setTool_list(ArrayList<ToolsModel> tool_list) {
        this.tool_list = tool_list;
    }

    private ArrayList<ToolsModel> tool_list = new ArrayList<>();
    private Context context;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tool_element, parent, false);
        AdapterTools.ViewHolder viewHolder = new AdapterTools.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(tool_list.get(position).getName());

        //String etat = getResources().getString(R.string.app_name);
        String etat = context.getString(R.string.return_date);
        etat = etat +" "+ tool_list.get(position).getDate();
        holder.date.setText(etat);


        holder.menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(context, holder.menu);
                popupMenu.getMenuInflater().inflate(R.menu.tooll_menu, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        // Handle menu item selection here
                        if (item.getItemId() == R.id.action_return){
                            Toast.makeText(context, "employee return the tool", Toast.LENGTH_SHORT).show();
                            return true;
                        } else if (item.getItemId() == R.id.action_Delete) {
                            confirmDialog(holder, tool_list.get(holder.getAdapterPosition()).getName());
                            return true;
                        }
                        return true;
                    }
                });
                popupMenu.show();
            }
        });
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, EditTool.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return tool_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView date;
        private ImageView menu;
        private CardView card;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.txtName);
            date = itemView.findViewById(R.id.status);
            menu = itemView.findViewById(R.id.option_tool);
            card = itemView.findViewById(R.id.parent);
        }
    }
    void confirmDialog(AdapterTools.ViewHolder holder, String id){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Delete a Tool ?");
        builder.setMessage("Are you sure you want a delete this Tool ?");
        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(context, "delete action", Toast.LENGTH_SHORT).show();
            }
        }).setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }
}
