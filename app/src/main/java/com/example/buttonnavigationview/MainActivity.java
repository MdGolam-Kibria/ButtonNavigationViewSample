package com.example.buttonnavigationview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    FrameLayout fragment;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intfind();
        repleaseFragment(new Home());
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

    }

    private void intfind() {
        fragment = findViewById(R.id.fragment);
        bottomNavigationView = findViewById(R.id.navigationView);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {

            case R.id.home:
                repleaseFragment(new Home());
                return true;
            case R.id.notification:
                repleaseFragment(new Notification());
                return true;
            case R.id.menu:
              repleaseFragment(new MenuF());
                return true;
        }

        return false;

    }

    private void repleaseFragment(Fragment fragment) {
        FragmentTransaction fm;
        fm = getSupportFragmentManager().beginTransaction().add(R.id.fragment, fragment);
        fm.commit();
    }
}
