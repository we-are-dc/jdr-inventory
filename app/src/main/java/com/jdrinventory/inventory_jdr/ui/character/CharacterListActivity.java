package com.jdrinventory.inventory_jdr.ui.character;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.jdrinventory.inventory_jdr.R;
import com.jdrinventory.inventory_jdr.model.data.Character;
import com.jdrinventory.inventory_jdr.model.repository.CharacterRepository;

public class CharacterListActivity extends AppCompatActivity {
    private CharacterListViewModel characterListViewModel;
    private @NonNull LayoutInflater layoutInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Define the layout corresponding to this activity
        setContentView(R.layout.character_list);

        // Open access to the view model
        this.characterListViewModel = new ViewModelProvider(this)
            .get(CharacterListViewModel.class);

        // LiveData<List<Character>> characters = this.characterListViewModel.

        // Character character = new Character("Jean", "Valjean", 100);
        // Log.i("meeeeeeeerde", character.getFirstName());
        // this.characterListViewModel.getDAO().insert(character);

        // Character character2 = this.characterListViewModel.findCharacterByName("Jean", "Valjean");
        // Log.i("meeeeeeeerde", String.valueOf(character2.getCharacterId()));

        // View root = this.layoutInflater.inflate(R.layout.character_list, container, false);
        // this.character = character;
    }
}
