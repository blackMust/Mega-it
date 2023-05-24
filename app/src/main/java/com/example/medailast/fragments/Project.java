package com.example.medailast.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medailast.Adapters.ProjectAdapter;
import com.example.medailast.Models.Project_model;
import com.example.medailast.R;

import java.util.ArrayList;

public class Project extends Fragment {
    private RecyclerView rc_add_project;
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



        ArrayList<Project_model> project_models = new ArrayList<>();
        project_models.add(new Project_model("maria3", "still"));
        project_models.add(new Project_model("maria1", "still"));
        project_models.add(new Project_model("maria1", "still"));
        project_models.add(new Project_model("maria2", "still"));
        project_models.add(new Project_model("maria3", "still"));
        project_models.add(new Project_model("maria4", "still"));

        ProjectAdapter adapter = new ProjectAdapter(view.getContext());
        adapter.setProject_list(project_models);
        rc_add_project.setAdapter(adapter);
        rc_add_project.setLayoutManager(new LinearLayoutManager(view.getContext()));



    }
}