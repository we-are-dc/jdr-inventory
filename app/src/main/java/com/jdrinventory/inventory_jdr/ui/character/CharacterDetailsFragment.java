package com.jdrinventory.inventory_jdr.ui.character;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.jdrinventory.inventory_jdr.R;

public class CharacterDetailsFragment extends Fragment {
    private CharacterListActivity CharacterDetailsViewModel;

    public View onCreateView(
        @NonNull LayoutInflater inflater,
        ViewGroup container,
        Bundle savedInstanceState
    ) {
        CharacterDetailsViewModel characterDetailsViewModel =
                new ViewModelProvider(this).get(CharacterDetailsViewModel.class);

        View root = inflater.inflate(R.layout.character_detail, container, false);

        return root;
    }
}
