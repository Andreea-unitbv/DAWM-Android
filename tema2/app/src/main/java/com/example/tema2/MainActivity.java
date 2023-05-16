package com.example.tema2;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.tema2.fragments.Fragment1;
import com.example.tema2.fragments.Fragment2;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get references to the two fragment containers
        FrameLayout container1 = findViewById(R.id.container1);
        FrameLayout container2 = findViewById(R.id.container2);

        // Create instances of your fragments
        Fragment1 fragment1 = new Fragment1();
        Fragment2 fragment2 = new Fragment2();

        // Get the FragmentManager
        FragmentManager fragmentManager = getSupportFragmentManager();

        // Begin the FragmentTransaction
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // Add the fragments to the containers
        fragmentTransaction.add(container1.getId(), fragment1);
        fragmentTransaction.add(container2.getId(), fragment2);

        // Commit the transaction
        fragmentTransaction.commit();
    }
}
