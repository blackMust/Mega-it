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

public class FormAddProject extends AppCompatActivity {
    private EditText title_project;
    private EditText date_start;
    private EditText date_end;
    private Button save_emp;
    private EditText client_name;
    private EditText address;
    private EditText phone;
    private EditText email;
    private EditText employee_name;
    private EditText desc;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_add_project);

        //        -----------------------------------------
        Objects.requireNonNull(getSupportActionBar()).setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //        -----------------------------------------

        title_project = findViewById(R.id.title_project);
        date_start = findViewById(R.id.date_start);
        date_end = findViewById(R.id.date_end);
        client_name = findViewById(R.id.client_name);
        address = findViewById(R.id.address);
        phone = findViewById(R.id.phone);
        email = findViewById(R.id.email);
        employee_name = findViewById(R.id.employee_name);
        desc = findViewById(R.id.description);



        save_emp = findViewById(R.id.save_project);

        save_emp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userInput = title_project.getText().toString().trim();
                String userInput1 = date_start.getText().toString().trim();
                String userInput2 = date_end.getText().toString().trim();
                String userInput3 = client_name.getText().toString().trim();
                String userInput4 = address.getText().toString().trim();
                String userInput5 = phone.getText().toString().trim();
                String userInput6 = email.getText().toString().trim();
                String userInput7 = employee_name.getText().toString().trim();
                String userInput8 = desc.getText().toString().trim();
                if (userInput.isEmpty()) {
                    title_project.setError("Please fill in this field");
                } else {
                    // The field is filled, you can proceed with further actions
                }
                if (userInput1.isEmpty()) {
                    date_start.setError("Please fill in this field");
                } else {
                    // The field is filled, you can proceed with further actions
                }
                if (userInput2.isEmpty()) {
                    date_end.setError("Please fill in this field");
                } else {
                    // The field is filled, you can proceed with further actions
                }
                if (userInput3.isEmpty()) {
                    client_name.setError("Please fill in this field");
                } else {
                    // The field is filled, you can proceed with further actions
                }
                if (userInput4.isEmpty()) {
                    address.setError("Please fill in this field");
                } else {
                    // The field is filled, you can proceed with further actions
                }
                if (userInput5.isEmpty()) {
                    phone.setError("Please fill in this field");
                } else {
                    // The field is filled, you can proceed with further actions
                }
                if (userInput6.isEmpty()) {
                    email.setError("Please fill in this field");
                } else {
                    // The field is filled, you can proceed with further actions
                }
                if (userInput7.isEmpty()) {
                    employee_name.setError("Please fill in this field");
                } else {
                    // The field is filled, you can proceed with further actions
                }
                if (userInput8.isEmpty()) {
                    desc.setError("Please fill in this field");
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