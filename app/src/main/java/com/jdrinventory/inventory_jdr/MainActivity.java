package com.jdrinventory.inventory_jdr;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import com.jdrinventory.inventory_jdr.model.data.Character;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Character character = new Character("Jean", "Valjean", 100);
        Log.i("test", character.getFirstName());
        // Define the starting activity for the application
        // setContentView(R.layout.activity_main);

        // Import the navigation fragment
        // BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);

        // Add menu items to the tap bar
//        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
//            R.id.navigation_home,
//            R.id.navigation_dashboard,
//            R.id.navigation_notifications
//        )
//            .build();

        // Create navigation controller
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        // Link the navigation to the tap bar
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//        NavigationUI.setupWithNavController(bottomNavigationView, navController);
    }
}
