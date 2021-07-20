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
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.jdrinventory.inventory_jdr.R;
import com.jdrinventory.inventory_jdr.model.data.Character;
import com.jdrinventory.inventory_jdr.model.repository.CharacterRepository;

public class CharacterListFragment extends Fragment{
    private CharacterListViewModel characterListViewModel;

    public View onCreateView(
        @NonNull LayoutInflater inflater,
        ViewGroup container,
        Bundle savedInstanceState
        // Character character
    ) {
        this.characterListViewModel = new ViewModelProvider(this)
            .get(CharacterListViewModel.class);


        Character character = new Character("Jean", "Valjean", 100);
        Log.i("meeeeeeeerde", character.getFirstName());
        this.characterListViewModel.getDAO().insert(character);

        View root = inflater.inflate(R.layout.character_list, container, false);
        // this.character = character;


        return root;
    }
}
