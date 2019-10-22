package com.example.adopy_adoptapetnearby;

import android.app.DownloadManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.ImageView;

import com.example.adopy_adoptapetnearby.UI_utilities.Adapters.PetsAdapter;
import com.example.adopy_adoptapetnearby.Utilities.Interfaces.CardListener;
import com.example.adopy_adoptapetnearby.Utilities.Models.PetModel;
import com.example.adopy_adoptapetnearby.Utilities.PetPageActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PetsAdapter petsAdapter;
    private List<PetModel> petModelArrayList;
    private FloatingActionButton fab;
    private FirebaseAuth mAuth;
    private FirebaseUser user;
    private final static int SELECT_IMAGE = 100;
    private static final int OPEN_CAMERA = 200;
    private ImageView image;
    private Date petBirthday;
    private Bitmap bitmap;
    private Boolean isImmunized;
    private StorageTask uploadTask;
    private Uri ImageUri;
    private String namePet;
    private StorageReference storageReference;

    private FirebaseFirestore FB;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        GridLayoutManager linearLayoutManager = new GridLayoutManager(this,2);
        petModelArrayList = new ArrayList<>();
        petsAdapter = new PetsAdapter(petModelArrayList, this);
        fab = findViewById(R.id.fab);
        mAuth = FirebaseAuth.getInstance();
        FB = FirebaseFirestore.getInstance();
        bitmap = null;
        url = "";
        petBirthday = Calendar.getInstance().getTime();
        storageReference = FirebaseStorage.getInstance().getReference();
        recyclerView = findViewById(R.id.recycler_home);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(petsAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
        petsAdapter.setCardListener(new CardListener() {
            @Override
            public void onCardClicked(int position, View view) {

                Intent intent = new Intent(SearchActivity.this, PetPageActivity.class);
                startActivity(intent);

            }

            @Override
            public void onCardLongClicked(int position, View view) {

            }
        });

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.Callback() {
            @Override
            public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
                return 0;
            }

            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

                PetModel petModel = petModelArrayList.get(i);
                //PopUpWindow(petModel,i);


            }
        });

        itemTouchHelper.attachToRecyclerView(recyclerView);

        //GetAllPetsToDashbord();
    }

    //search data
    private void firebaseSerch (String i_SearchText) {

    }
}
