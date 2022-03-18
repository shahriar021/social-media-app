package com.example.socialmediaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Toast;


import com.example.socialmediaapp.databinding.ActivityMainBinding;
import com.example.socialmediaapp.fragements.addFragment;
import com.example.socialmediaapp.fragements.homefragement;
import com.example.socialmediaapp.fragements.notificationFragment;
import com.example.socialmediaapp.fragements.profileFragment;
import com.example.socialmediaapp.fragements.searchFragment;
import com.iammert.library.readablebottombar.ReadableBottomBar;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container,new homefragement());
        transaction.commit();

        binding.readblebottombar.setOnItemSelectListener(new ReadableBottomBar.ItemSelectListener() {
            @Override
            public void onItemSelected(int i) {

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                switch (i){
                    case 0:
                        transaction.replace(R.id.container,new homefragement());
                        Toast.makeText(MainActivity.this, "Home selected", Toast.LENGTH_SHORT).show();
                        break;

                    case 1:
                        transaction.replace(R.id.container,new notificationFragment());
                        Toast.makeText(MainActivity.this, "Notification selected", Toast.LENGTH_SHORT).show();
                        break;

                    case 2:
                        transaction.replace(R.id.container,new addFragment());
                        Toast.makeText(MainActivity.this, "Add selected", Toast.LENGTH_SHORT).show();
                        break;

                    case 3:
                        transaction.replace(R.id.container,new searchFragment());
                        Toast.makeText(MainActivity.this, "Search selected", Toast.LENGTH_SHORT).show();
                        break;

                    case 4:
                        transaction.replace(R.id.container,new profileFragment());
                        Toast.makeText(MainActivity.this, "Profile selected", Toast.LENGTH_SHORT).show();
                        break;
                }
                transaction.commit();
            }
        });
    }
}