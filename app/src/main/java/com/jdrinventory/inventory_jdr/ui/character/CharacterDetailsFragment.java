package com.jdrinventory.inventory_jdr.ui.character;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.jdrinventory.inventory_jdr.R;

public class CharacterDetailsFragment extends Fragment {
    private CharacterListFragment CharacterDetailsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        characterDetailsViewModel =
                new ViewModelProvider(this).get(CharacterDetailsViewModel.class);
        View root = inflater.inflate(R.layout.character_detail, container, false);
        final TextView textView = root.findViewById(R.id.text_obj);
        characterDetailsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
