package com.example.medailast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.medailast.Adapters.AdapterManageEmployee;
import com.example.medailast.Models.ManagmentEmployeeFig;

import java.util.ArrayList;
import java.util.Objects;

public class ManagementEmployee extends AppCompatActivity {
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_management_employee);

        //        -----------------------------------------
        Objects.requireNonNull(getSupportActionBar()).setTitle("employee");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //        -----------------------------------------

        recyclerView = findViewById(R.id.manage_employee);
        ArrayList<ManagmentEmployeeFig> list_title = new ArrayList<>();
        @SuppressLint("UseCompatLoadingForDrawables") Drawable myDrawable = getResources().getDrawable(R.drawable.ic_add_task2);
        list_title.add(new ManagmentEmployeeFig(myDrawable, "Score"));
        @SuppressLint("UseCompatLoadingForDrawables") Drawable myDrawable1 = getResources().getDrawable(R.drawable.ic_historic_work);
        list_title.add(new ManagmentEmployeeFig(myDrawable1, "Historic"));
        @SuppressLint("UseCompatLoadingForDrawables") Drawable myDrawable2 = getResources().getDrawable(R.drawable.ic_tools);
        list_title.add(new ManagmentEmployeeFig(myDrawable2, "Tools"));
        AdapterManageEmployee adapter = new AdapterManageEmployee(list_title, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_employee_manager, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.setting){
            Intent intent3 = new Intent(this, SettingApp.class);
            startActivity(intent3);
            return true;
        } else if (item.getItemId() == R.id.log_out) {
            Intent intent2 = new Intent(this, Login2.class);
            intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent2);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}