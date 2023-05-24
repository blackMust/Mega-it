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

public class AddTool extends AppCompatActivity {
    private EditText tool_name;
    private EditText date_return;
    private EditText desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tool);

        //        -----------------------------------------
        Objects.requireNonNull(getSupportActionBar()).setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //        -----------------------------------------

        tool_name = findViewById(R.id.tool_name);
        date_return = findViewById(R.id.returndate);
        desc = findViewById(R.id.description);
        Button save_tool = findViewById(R.id.save_tool);

        save_tool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userInput = tool_name.getText().toString().trim();
                String userInput1 = date_return.getText().toString().trim();
                String userInput2 = desc.getText().toString().trim();
                if (userInput.isEmpty()) {
                    tool_name.setError("Please fill in this field");
                } else {
                    // The field is filled, you can proceed with further actions
                }
                if (userInput1.isEmpty()) {
                    date_return.setError("Please fill in this field");
                } else {
                    // The field is filled, you can proceed with further actions
                }
                if (userInput2.isEmpty()) {
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