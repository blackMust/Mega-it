package com.example.medailast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Historic extends AppCompatActivity {
    private ListView list_historic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historic);

        //        -----------------------------------------
        Objects.requireNonNull(getSupportActionBar()).setTitle("employee");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //        -----------------------------------------

        list_historic = findViewById(R.id.list_view);

        ArrayList<String> historic = new ArrayList<>();
        historic.add("12/05/2023, morning, afternoon, evening");
        historic.add("13/05/2023, morning, afternoon, evening");
        historic.add("14/05/2023, morning, afternoon");
        historic.add("15/05/2023, morning, evening");
        historic.add("16/05/2023, morning, afternoon");
        ArrayAdapter<String> adapter_list = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                historic
        );
        list_historic.setAdapter(adapter_list);
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