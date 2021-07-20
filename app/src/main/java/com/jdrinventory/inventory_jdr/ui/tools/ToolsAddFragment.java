package com.jdrinventory.inventory_jdr.ui.tools;

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

public class ToolsAddFragment extends Fragment {
    private ToolsAddFragment ToolsAddViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ToolsAddViewModel =
                new ViewModelProvider(this).get(com.jdrinventory.inventory_jdr.ui.tools.ToolsAddViewModel.class);
        View root = inflater.inflate(R.layout.character_detail, container, false);
        final TextView textView = root.findViewById(R.id.text_obj);
        ToolsAddViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
