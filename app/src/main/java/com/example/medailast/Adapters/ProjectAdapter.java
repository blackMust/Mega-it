package com.example.medailast.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medailast.EditProject;
import com.example.medailast.Models.Project_model;
import com.example.medailast.R;

import java.util.ArrayList;

public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.ViewHolder>{

    private ArrayList<Project_model> project_list = new ArrayList<>();
    private Context context;

    @SuppressLint("NotifyDataSetChanged")
    public void setProject_list(ArrayList<Project_model> project_list) {
        this.project_list = project_list;
        notifyDataSetChanged();
    }

    public ProjectAdapter(Context context) {
        this.context = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.project_list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(project_list.get(position).getName());

        //String etat = getResources().getString(R.string.app_name);
        String etat = context.getString(R.string.status);
        etat = etat + project_list.get(position).getStatus();
        holder.status.setText(etat);


        holder.menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(context, holder.menu);
                popupMenu.getMenuInflater().inflate(R.menu.menu_project, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        // Handle menu item selection here
                        if (item.getItemId() == R.id.action_attach_an_employee){
                            Toast.makeText(context, "an employee will be attach selected", Toast.LENGTH_SHORT).show();
                            return true;
                        } else if (item.getItemId() == R.id.action_info) {
                            Intent intent = new Intent(context, EditProject.class);
                            context.startActivity(intent);
                            return true;
                        }
                        else if (item.getItemId() == R.id.action_Delete) {
                            confirmDialog(holder, project_list.get(holder.getAdapterPosition()).getName());
                            return true;
                        }
                        return true;
                    }
                });
                popupMenu.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return project_list.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView status;
        private ImageView menu;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.txtName);
            status = itemView.findViewById(R.id.status);
            menu = itemView.findViewById(R.id.menu);
        }
    }
    void confirmDialog(ProjectAdapter.ViewHolder holder, String id){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Delete a project ?");
        builder.setMessage("Are you sure you want a delete this project ?");
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
