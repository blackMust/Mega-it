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

import com.example.medailast.Adapters.EmployeeAdapter;
import com.example.medailast.Models.EmployeeModel;
import com.example.medailast.R;

import java.util.ArrayList;


public class Employee extends Fragment {
    private RecyclerView rc_add_employee;
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

        ArrayList<EmployeeModel> employee_models = new ArrayList<>();
        employee_models.add(new EmployeeModel("mustapha", "0"));
        employee_models.add(new EmployeeModel("zakarai", "0"));
        employee_models.add(new EmployeeModel("abdolah", "1"));
        employee_models.add(new EmployeeModel("hiba", "0"));
        employee_models.add(new EmployeeModel("marwa", "1"));
        employee_models.add(new EmployeeModel("fatima", "2"));

        EmployeeAdapter adapter = new EmployeeAdapter(view.getContext());
        adapter.setList_employee(employee_models);
        rc_add_employee.setAdapter(adapter);
        rc_add_employee.setLayoutManager(new LinearLayoutManager(view.getContext()));


    }
}