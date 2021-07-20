package com.jdrinventory.inventory_jdr.ui.character;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager.*;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jdrinventory.inventory_jdr.R;
import com.jdrinventory.inventory_jdr.model.data.Character;
import androidx.recyclerview.widget.GridLayoutManager;
import com.jdrinventory.inventory_jdr.model.repository.CharacterRepository;

import java.util.ArrayList;
import java.util.List;

public class CharacterListActivity extends AppCompatActivity {
    private static final String TAG = "CharacterListActivity";
    private CharacterListViewModel characterListViewModel;
    private ArrayList<String> mCardTitles = new ArrayList<>();
    private ArrayList<String> mCardReferences = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Define the layout corresponding to this activity
        setContentView(R.layout.character_list);

        // Open access to the view model
        this.characterListViewModel = new ViewModelProvider(this)
            .get(CharacterListViewModel.class);

        initData();

        Button addButton = findViewById(R.id.character_list_add);
        addButton.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(
                        new Intent(CharacterListActivity.this, CharacterAddActivity.class)
                    );
                    finish();
                }
            }
        );
    }

    private void initData() {
        this.characterListViewModel.addCharacter(new Character("Louis", "Joulain", 100));
        this.characterListViewModel.addCharacter(new Character("Maxence", "Lebard", 100));
        this.characterListViewModel.addCharacter(new Character("Sulyan", "Iggui", 100));
        this.characterListViewModel.addCharacter(new Character("Aurélien", "Devaux", 100));

        List<Character> characters = this.characterListViewModel.getAllCharacters();

        for (Character character:characters) {
            Log.i("clickclick", character.getFullname());
            mCardTitles.add(character.getFullname());
            mCardReferences.add(String.valueOf(character.getCharacterId()));
        }

        initRecyclerView();
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.character_details_recycler_view);
        CharacterListRecyclerViewAdapter adapter = new CharacterListRecyclerViewAdapter(mCardTitles, mCardReferences, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
    }
}
