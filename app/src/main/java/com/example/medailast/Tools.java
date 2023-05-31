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
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.medailast.Adapters.AdapterTools;
import com.example.medailast.Adapters.EmployeeAdapter;
import com.example.medailast.Models.EmployeeModel;
import com.example.medailast.Models.ToolsModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Objects;

public class Tools extends AppCompatActivity {
    private RecyclerView all_tools;
    private ArrayList<ToolsModel> list_tools;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tools);
        all_tools = findViewById(R.id.all_tools);

        //        -----------------------------------------
        Objects.requireNonNull(getSupportActionBar()).setTitle("Employee");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //        -----------------------------------------
        list_tools = new ArrayList<>();
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://192.168.1.21/rest api/api/post tools/post.php";
//        get the data from the server
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for (int i=0; i<response.length(); i++){
                    String num = "";
                    String returnit = "";
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        num = jsonObject.getString("nameTool");
                        returnit = jsonObject.getString("returnit");
                        if (returnit.equals("1")){
                            list_tools.add(new ToolsModel(num, "has been returned"));
                        }else{
                            list_tools.add(new ToolsModel(num, jsonObject.getString("return_date")));
                        }



                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }

                AdapterTools adapterTools = new AdapterTools(Tools.this);
                adapterTools.setTool_list(list_tools);

                all_tools.setAdapter(adapterTools);
                all_tools.setLayoutManager(new LinearLayoutManager(Tools.this));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(Tools.this, "error the internet", Toast.LENGTH_SHORT).show();;
            }
        });
        queue.add(request);




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