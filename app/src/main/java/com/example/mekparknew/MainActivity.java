package com.example.mekparknew;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import loginsignup.Fragmentlogin;


public class MainActivity extends AppCompatActivity {
    private final String TAG = "LoginHomePage";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        replaceFragment (new Fragmentlogin());

    }
    private void replaceFragment(Fragmentlogin fragmentlogin) {
        Log.e(TAG,"replaceFragment");
       FragmentManager fm= getSupportFragmentManager();
        androidx.fragment.app.FragmentTransaction ft=fm.beginTransaction();
         ft.replace(R.id.fragment_container,fragmentlogin);
         ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
         ft.commit();
    }

}
