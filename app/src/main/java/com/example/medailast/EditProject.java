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

public class EditProject extends AppCompatActivity {
    private EditText title_project;
    private EditText date_start;
    private EditText date_end;
    private Button edit_project;
    private EditText client_name;
    private EditText address;
    private EditText phone;
    private EditText email;
    private EditText employee_name;
    private EditText desc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_project);

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

        title_project.setText("exemple");
        date_start.setText("12/03/2023");
        date_end.setText("06/06/2023");
        client_name.setText("mustapha");
        address.setText("morocco");
        phone.setText("0653788937");
        email.setText("exemple@gmail.com");
        employee_name.setText("hanan");
        desc.setText("the best project hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh ever");

//        disactivate the editable view
        title_project.setEnabled(false);
        date_start.setEnabled(false);
        date_end.setEnabled(false);
        client_name.setEnabled(false);
        address.setEnabled(false);
        phone.setEnabled(false);
        email.setEnabled(false);
        employee_name.setEnabled(false);
        desc.setKeyListener(null);



        edit_project = findViewById(R.id.edit_project);
        edit_project.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(EditProject.this, "the project will be edit", Toast.LENGTH_SHORT).show();
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