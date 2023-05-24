package com.example.medailast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.Objects;

public class Score extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        //        -----------------------------------------
        Objects.requireNonNull(getSupportActionBar()).setTitle("employee");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //        -----------------------------------------

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