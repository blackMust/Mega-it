package com.example.medailast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.medailast.Adapters.AdapterTools;
import com.example.medailast.Models.ToolsModel;

import java.util.ArrayList;
import java.util.Objects;

public class Tools extends AppCompatActivity {
    private RecyclerView all_tools;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tools);
        all_tools = findViewById(R.id.all_tools);

        //        -----------------------------------------
        Objects.requireNonNull(getSupportActionBar()).setTitle("Employee");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //        -----------------------------------------

        ArrayList<ToolsModel> list_tools = new ArrayList<>();
        list_tools.add(new ToolsModel("hammer", "12/07/2023"));
        list_tools.add(new ToolsModel("hammer23", "01/07/2023"));
        list_tools.add(new ToolsModel("hammer33", "28/07/2023"));
        list_tools.add(new ToolsModel("hammer55", "22/07/2023"));
        list_tools.add(new ToolsModel("hammer4", "02/07/2023"));

        AdapterTools adapterTools = new AdapterTools(this);
        adapterTools.setTool_list(list_tools);

        all_tools.setAdapter(adapterTools);
        all_tools.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_tools, menu);
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
        }else if (item.getItemId() == R.id.addtool) {
            Intent intent = new Intent(this, AddTool.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}