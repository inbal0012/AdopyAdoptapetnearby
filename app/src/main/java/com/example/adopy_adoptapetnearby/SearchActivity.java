package com.example.adopy_adoptapetnearby;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.adopy_adoptapetnearby.UI_utilities.Adapters.PetsAdapter;
import com.example.adopy_adoptapetnearby.Utilities.Interfaces.CardListener;
import com.example.adopy_adoptapetnearby.Utilities.Interfaces.Gender;
import com.example.adopy_adoptapetnearby.Utilities.Models.PetModel;
import com.google.gson.Gson;

//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;
//import com.google.firebase.firestore.FirebaseFirestore;
//import com.google.firebase.storage.FirebaseStorage;
//import com.google.firebase.storage.StorageReference;
//import com.google.firebase.storage.StorageTask;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PetsAdapter petsAdapter;
    private List<PetModel> petModelArrayList;
    private final static int SELECT_IMAGE = 100;
    private static final int OPEN_CAMERA = 200;
    private ImageView image;
    private Date petBirthday;
    private Bitmap bitmap;
    private Boolean isImmunized;
    private Uri ImageUri;
    private String namePet;
    private String url;

    //Firebase
    //private FirebaseAuth mAuth;
    //private FirebaseUser user;
    //private StorageTask uploadTask;
    //private StorageReference storageReference;
    //private FirebaseFirestore FB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        GridLayoutManager linearLayoutManager = new GridLayoutManager(this,2);
        petModelArrayList = new ArrayList<>();
        petsAdapter = new PetsAdapter(petModelArrayList, this);
        //mAuth = FirebaseAuth.getInstance();
        //FB = FirebaseFirestore.getInstance();
        //storageReference = FirebaseStorage.getInstance().getReference();
        recyclerView = findViewById(R.id.recycler_home);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(petsAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
        petsAdapter.setCardListener(new CardListener() {
            @Override
            public void onCardClicked(int position, View view) {
                PetModel pet = petModelArrayList.get(position);
                Gson gson = new Gson();
                String petStr = gson.toJson(pet);
                Intent intent = new Intent(SearchActivity.this, PetPageActivity.class);
                intent.putExtra("pet", petStr);
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

        fillPetList();
        //GetAllPetsToDashbord();
    }

    private void fillPetList() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dog);
        petModelArrayList.add(new PetModel("dog", "nero", 4.2, Gender.Male, BitmapFactory.decodeResource(getResources(), R.drawable.dog)));
        petModelArrayList.add(new PetModel("cat", "laila", 2.7, Gender.Female, BitmapFactory.decodeResource(getResources(), R.drawable.cat)));
        petModelArrayList.add(new PetModel("cat", "nobles", 3.5, Gender.Male, BitmapFactory.decodeResource(getResources(), R.drawable.cat)));
        petModelArrayList.add(new PetModel("dog", "menesh", 0.9, Gender.Female, BitmapFactory.decodeResource(getResources(), R.drawable.dog)));
        petModelArrayList.add(new PetModel("iguana", "gourg", 0.5, Gender.Female, BitmapFactory.decodeResource(getResources(), R.drawable.iguana)));
        petModelArrayList.add(new PetModel("turtle", "slowy", 10.0, Gender.Male, BitmapFactory.decodeResource(getResources(), R.drawable.turtle)));
        petModelArrayList.add(new PetModel("chinchilla", "archy", 5.0, Gender.Male, BitmapFactory.decodeResource(getResources(), R.drawable.chinchilla)));
        petModelArrayList.add(new PetModel("rabbit", "carrot", 6.9, Gender.Female, BitmapFactory.decodeResource(getResources(), R.drawable.rabbit)));

        petsAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //petsAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }

    //search data
    private void firebaseSerch (String i_SearchText) {


    }
}
