package com.example.medailast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.medailast.Models.GlobleValues;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

public class Login2 extends AppCompatActivity {
    private TextInputLayout textInputLayout;
    private TextInputLayout textInputLayout1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        getSupportActionBar().hide();
        textInputLayout = findViewById(R.id.password);


        textInputLayout1 = findViewById(R.id.email);



        RequestQueue queue = Volley.newRequestQueue(this);
        String host = new GlobleValues().getHost();
        String url = "http://"+host+"/rest api/api/post log/post.php";


        Button button = findViewById(R.id.login_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        String user = textInputLayout1.getEditText().getText().toString();
                        String pass =  textInputLayout.getEditText().getText().toString();
                            try {
                                JSONObject jsonObject = response.getJSONObject(0);
                                if(pass.equals(jsonObject.getString("username")) && user.equals(jsonObject.getString("password"))){
                                    openActivity();
                                }else{
                                    Toast.makeText(Login2.this, "wrong password or email", Toast.LENGTH_SHORT).show();
                                }

//                                Toast.makeText(Login2.this, jsonObject.getString("username") + " && " + jsonObject.getString("password"), Toast.LENGTH_SHORT).show();

                            } catch (JSONException e) {
                                throw new RuntimeException(e);
                            }


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        snackbare();
                    }
                });
                queue.add(request);
//                openActivity();
            }
        });
    }

    private void snackbare() {
        Toast.makeText(this, "error d'internet", Toast.LENGTH_LONG).show();
    }
    public void openActivity(){
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
        finish();
    }
}