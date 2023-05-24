package com.example.medailast.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.medailast.fragments.Employee;
import com.example.medailast.fragments.Project;


public class AdapterProjectEmployee extends FragmentStateAdapter {
    public AdapterProjectEmployee(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
         switch (position){
             case 0:
                 return new Project();
             case 1:
                 return new Employee();
             default:
                 return new Project();
         }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
