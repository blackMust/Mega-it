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


import com.example.medailast.EditEmployee;
import com.example.medailast.ManagementEmployee;
import com.example.medailast.Models.EmployeeModel;
import com.example.medailast.R;

import java.util.ArrayList;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.ViewHolder>{
    private ArrayList<EmployeeModel> list_employee;
    private Context context;


    public EmployeeAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.employee_list_item, parent, false);
        EmployeeAdapter.ViewHolder viewHolder = new EmployeeAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(list_employee.get(holder.getAdapterPosition()).getName());

        String num_p = context.getString(R.string.status);
        num_p = num_p + list_employee.get(position).getNum_project();

        holder.num_project.setText(num_p);


        holder.menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(context, holder.menu);
                popupMenu.getMenuInflater().inflate(R.menu.menu_employee, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        // Handle menu item selection here
                        if (item.getItemId() == R.id.action_info){
                            Intent intent = new Intent(context, EditEmployee.class);
                            context.startActivity(intent);
                            return true;
                        } else if (item.getItemId() == R.id.action_Delete) {
                            confirmDialog(holder, list_employee.get(holder.getAdapterPosition()).getName());
                            return true;
                        }
                        return true;
                    }
                });
                popupMenu.show();
            }
        });

        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ManagementEmployee.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list_employee.size();
    }

    public void setList_employee(ArrayList<EmployeeModel> list_employee) {
        this.list_employee = list_employee;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView name, num_project;
        private ImageView menu;
        private CardView parent;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.employeeName);
            num_project = itemView.findViewById(R.id.num_project);
            menu = itemView.findViewById(R.id.menu);
            parent = itemView.findViewById(R.id.employeeList);

        }
    }
    void confirmDialog(ViewHolder holder, String id){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Delete an employee ?");
        builder.setMessage("Are you sure you want a delete this employee ?");
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
