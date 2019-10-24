package com.example.adopy_adoptapetnearby;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.example.adopy_adoptapetnearby.Utilities.Models.PetModel;
import com.google.gson.Gson;

public class PetPageActivity extends AppCompatActivity {

    PetModel pet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //String petStr = getIntent().getStringExtra("pet");
        Gson gson = new Gson();
        pet = gson.fromJson(getIntent().getStringExtra("pet"), PetModel.class);

        ImageView petImg = findViewById(R.id.pet_image);
        petImg.setImageBitmap(pet.getBitmap());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_favorite);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
