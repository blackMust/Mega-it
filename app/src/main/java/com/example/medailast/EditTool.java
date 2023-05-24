package com.example.medailast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class EditTool extends AppCompatActivity {
    private EditText return_date;
    private EditText borrowed_date;
    private EditText desc;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_tool);

        //        -----------------------------------------
        Objects.requireNonNull(getSupportActionBar()).setTitle("hammer");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //        -----------------------------------------

        return_date = findViewById(R.id.return_date);
        borrowed_date = findViewById(R.id.borrowed_date);
        desc = findViewById(R.id.description);
        btn = findViewById(R.id.edit_tool);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(EditTool.this, "the tool edited", Toast.LENGTH_SHORT).show();
            }
        });

        return_date.setText("13/12/2023");
        desc.setText("this is an exmple of a description");
        borrowed_date.setText("02/05/2023");

        return_date.setEnabled(false);
        desc.setKeyListener(null);
        borrowed_date.setEnabled(false);


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
//    }
 }
}