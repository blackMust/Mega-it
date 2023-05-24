package com.example.medailast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class SettingApp extends AppCompatActivity {
    private EditText name;
    private EditText phone;
    private EditText email;
    private EditText password;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_app);

        //        -----------------------------------------
        Objects.requireNonNull(getSupportActionBar()).setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //        -----------------------------------------

        name = findViewById(R.id.title_project);
        phone = findViewById(R.id.date_start);
        email = findViewById(R.id.email);
        btn = findViewById(R.id.edit_employee);
        password = findViewById(R.id.password);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SettingApp.this, "the text will be edited", Toast.LENGTH_SHORT).show();
            }
        });

        email.setEnabled(false);
        phone.setEnabled(false);
        name.setEnabled(false);
        password.setEnabled(false);

        name.setText("Mestapha");
        phone.setText("0645678798");
        email.setText("mm@medai.com");
        password.setText("hellohhh");
    }
}