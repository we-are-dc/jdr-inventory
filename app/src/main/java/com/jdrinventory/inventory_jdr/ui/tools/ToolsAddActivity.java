package com.jdrinventory.inventory_jdr.ui.tools;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.jdrinventory.inventory_jdr.R;

public class ToolsAddActivity extends Fragment {
    private ToolsAddActivity toolsAddViewModel;

    public View onCreateView(
        @NonNull LayoutInflater inflater,
        ViewGroup container,
        Bundle savedInstanceState
    ) {
        ToolsAddViewModel toolsAddViewModel = new ViewModelProvider(this).get(ToolsAddViewModel.class);

        View root = inflater.inflate(R.layout.character_detail, container, false);

        return root;
    }
}
