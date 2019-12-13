package com.example.android.shopping;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.android.shopping.Fragments.CategoriesFragment;
import com.example.android.shopping.Fragments.FavouriteFragment;
import com.example.android.shopping.Fragments.HomeFragment;
import com.example.android.shopping.Fragments.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class LogActivity extends AppCompatActivity {
     BottomNavigationView bottomNavigationView;
     FragmentManager fragmentManager;
     FragmentTransaction fragmentTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        bottomNavigationView=findViewById(R.id.navigation);
        fragmentManager=getSupportFragmentManager();
        loadFragment(new HomeFragment());
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.home:
                        loadFragment(new HomeFragment());
                         return true;
                    case R.id.categories:
                        loadFragment(new CategoriesFragment());
                        return true;
                    case R.id.favourite:
                        loadFragment(new FavouriteFragment());
                        return true;
                    case R.id.profile:
                        loadFragment(new ProfileFragment());
                        return true;
                        default:return true;
                }
            }
        });
                                              }
public void loadFragment(Fragment fragment){
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame,fragment);
        fragmentTransaction.commit();
}
}
