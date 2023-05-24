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

import java.util.Objects;

public class FormEmployee extends AppCompatActivity {
    private EditText employee_name;
    private EditText phone;
    private EditText email;
    private Button save_emp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_employee);

        //        -----------------------------------------
        Objects.requireNonNull(getSupportActionBar()).setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //        -----------------------------------------

        employee_name = findViewById(R.id.employee_name);
        phone = findViewById(R.id.phone_employee);
        email = findViewById(R.id.employee_email);
        save_emp = findViewById(R.id.save_emp);

        save_emp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userInput = employee_name.getText().toString().trim();
                String userInput1 = phone.getText().toString().trim();
                String userInput2 = email.getText().toString().trim();
                if (userInput.isEmpty()) {
                    employee_name.setError("Please fill in this field");
                } else {
                    // The field is filled, you can proceed with further actions
                }
                if (userInput1.isEmpty()) {
                    phone.setError("Please fill in this field");
                } else {
                    // The field is filled, you can proceed with further actions
                }
                if (userInput2.isEmpty()) {
                    email.setError("Please fill in this field");
                } else {
                    // The field is filled, you can proceed with further actions
                }
            }
        });

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