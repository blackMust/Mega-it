package com.example.medailast.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.medailast.Adapters.EmployeeAdapter;
import com.example.medailast.Adapters.ProjectAdapter;
import com.example.medailast.Models.EmployeeModel;
import com.example.medailast.Models.Project_model;
import com.example.medailast.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class Employee extends Fragment {
    private RecyclerView rc_add_employee;
    private ArrayList<EmployeeModel> employee_models;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_employee, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rc_add_employee = view.findViewById(R.id.all_employee);
        employee_models = new ArrayList<>();

        RequestQueue queue = Volley.newRequestQueue(view.getContext());
        String url = "http://192.168.1.21/rest api/api/post - employee/post.php";
//        get the data from the server
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for (int i=0; i<response.length(); i++){
                    String num = "";
                    String nb_project = "";
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        num = jsonObject.getString("prenom") + " " + jsonObject.getString("nom");
                        nb_project = jsonObject.getString("nb_project");

                        employee_models.add(new EmployeeModel(num, nb_project));

                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }

                EmployeeAdapter adapter = new EmployeeAdapter(view.getContext());
                adapter.setList_employee(employee_models);
                rc_add_employee.setAdapter(adapter);
                rc_add_employee.setLayoutManager(new LinearLayoutManager(view.getContext()));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(view.getContext(), "error the internet", Toast.LENGTH_SHORT).show();;
            }
        });
        queue.add(request);

    }
}