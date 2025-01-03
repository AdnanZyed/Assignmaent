package com.example.assignmaent;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    EventsFragment eventsFragment = new EventsFragment();
    ProfileFragment profileFragment = new ProfileFragment();
    com.example.assignmaent.ExploreFragment exploreFragment = new com.example.assignmaent.ExploreFragment();
    LocationFragment locationFragment = new LocationFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        bottomNavigationView = findViewById(R.id.bn_v);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.Explore);



        navigationView.setNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.Profile:

                    bottomNavigationView.setSelectedItemId(R.id.Profile);

                    break;

                case R.id.Message:
                      break;

                case R.id.calender:
                       break;

                case R.id.Book_mark:
                      break;

                case R.id.Contact_Us:
                    break;

                case R.id.nav_settings:
                     break;

                case R.id.Sign_Out:
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("تأكيد الخروج");
                    builder.setMessage("هل أنت متأكد أنك تريد الخروج؟");


                    builder.setPositiveButton("نعم", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });

                    builder.setNegativeButton("لا", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });

                    AlertDialog dialog = builder.create();
                    dialog.show();
                    break;
            }
            drawerLayout.closeDrawers();
            return true;
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.Explore);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Explore:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fl, exploreFragment)
                        .commit();
                return true;

            case R.id.Events:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fl, eventsFragment)
                        .commit();
                return true;

            case R.id.Location:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fl, locationFragment)
                        .commit();
                return true;

            case R.id.Profile:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fl, profileFragment)
                        .commit();
                return true;
        }
        return false;
    }
    @Override
    public void onBackPressed() {
        if (bottomNavigationView.getSelectedItemId() == R.id.Explore) {
            com.example.assignmaent.ExploreFragment exploreFragment = (com.example.assignmaent.ExploreFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.fl);

            if (exploreFragment != null && !exploreFragment.isDefaultTabSelected()) {
                exploreFragment.setDefaultTab();
                return;
            }
        }

        super.onBackPressed();
    }



}
