package com.example.medailast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.example.medailast.Adapters.AdapterProjectEmployee;
import com.google.android.material.tabs.TabLayout;

import java.util.Objects;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        //        -----------------------------------------
        Objects.requireNonNull(getSupportActionBar()).setTitle("Admin");
        //        -----------------------------------------


        TabLayout tabLayout;
        ViewPager2 v2;
        AdapterProjectEmployee adapter;

        tabLayout = findViewById(R.id.tab_layout);
        v2 = findViewById(R.id.view_pager);
        adapter = new AdapterProjectEmployee(this);
        v2.setAdapter(adapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                v2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        v2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayout.getTabAt(position).select();
            }
        });
    }




    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.principale, menu);
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
        } else if (item.getItemId() == R.id.addEmployee) {
            Intent intent1 = new Intent(this, FormEmployee.class);
            startActivity(intent1);
            return true;
        }else if (item.getItemId() == R.id.addproject) {
            Intent intent = new Intent(this, FormAddProject.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);

        }
}