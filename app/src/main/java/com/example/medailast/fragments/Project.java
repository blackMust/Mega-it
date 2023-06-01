package com.example.medailast.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.medailast.Adapters.ProjectAdapter;
import com.example.medailast.Models.GlobleValues;
import com.example.medailast.Models.Project_model;
import com.example.medailast.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Project extends Fragment {
    private RecyclerView rc_add_project;
    ArrayList<Project_model> project_models;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_project, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rc_add_project = view.findViewById(R.id.all_project);
        project_models = new ArrayList<>();

        RequestQueue queue = Volley.newRequestQueue(view.getContext());
        String host = new GlobleValues().getHost();
        String url = "http://"+host+"/rest api/api/post project/post.php";
//        get the data from the server
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for (int i=0; i<response.length(); i++){
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        String id = jsonObject.getString("id");
                        String nomProjet = jsonObject.getString("nomProjet");
                        String prenomClient = jsonObject.getString("prenomClient");
                        String start_date = jsonObject.getString("start_date");
                        String date_end = jsonObject.getString("date_end");
                        String phone = jsonObject.getString("phone");
                        String email = jsonObject.getString("email");
                        String note = jsonObject.getString("note");
                        String status = jsonObject.getString("status");
                        if (status.equals("1"))
                            status = "in progress";
                        else
                            status = "Pending";
                        project_models.add(new Project_model(nomProjet,  status,  id,  nomProjet,  prenomClient,  start_date,  date_end,  phone,  email,  note));

                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }

                ProjectAdapter adapter = new ProjectAdapter(view.getContext());
                adapter.setProject_list(project_models);
                rc_add_project.setAdapter(adapter);
                rc_add_project.setLayoutManager(new LinearLayoutManager(view.getContext()));
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