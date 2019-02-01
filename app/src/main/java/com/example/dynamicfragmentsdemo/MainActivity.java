package com.example.dynamicfragmentsdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Fragments");

        // Create and set Android Fragment as default.
        Fragment androidFragment = new AndroidFragment();
        this.setDefaultFragment(androidFragment);

        // Click this button to display android fragment.
        Button androidButton = (Button)findViewById(R.id.dynamic_fragment_android_button);
        androidButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment androidFragment = new AndroidFragment();
                replaceFragment(androidFragment);
            }
        });

        // Click this button to display windows fragment.
        Button windowsButton = (Button)findViewById(R.id.dynamic_fragment_windows_button);
        windowsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment windowsFragment = new WindowsFragment();
                replaceFragment(windowsFragment);
            }
        });

        // Click this button to display iOS fragment.
        Button iosButton = (Button)findViewById(R.id.dynamic_fragment_ios_button);
        iosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment iosFragment = new IOSFragment();
                replaceFragment(iosFragment);
            }
        });
    }

    // This method is used to set the default fragment that will be shown.
    private void setDefaultFragment(Fragment defaultFragment)
    {
        this.replaceFragment(defaultFragment);
    }

    // Replace current Fragment with the destination Fragment.
    public void replaceFragment(Fragment destFragment)
    {
        // First get FragmentManager object.
        FragmentManager fragmentManager = this.getSupportFragmentManager();

        // Begin Fragment transaction.
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // Replace the layout holder with the required Fragment object.
        fragmentTransaction.replace(R.id.containerFrameLayout, destFragment);

        // Commit the Fragment replace action.
        fragmentTransaction.commit();
    }
}
