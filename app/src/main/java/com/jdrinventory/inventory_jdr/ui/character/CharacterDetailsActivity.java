package com.jdrinventory.inventory_jdr.ui.character;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.jdrinventory.inventory_jdr.R;
import com.jdrinventory.inventory_jdr.model.data.Character;
import com.jdrinventory.inventory_jdr.model.data.Tool;
import com.jdrinventory.inventory_jdr.ui.tools.ToolsAddActivity;

public class CharacterDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CharacterDetailsViewModel characterDetailsViewModel = new ViewModelProvider(this).get(CharacterDetailsViewModel.class);

        // Define the layout corresponding to this activity
        setContentView(R.layout.character_detail);

        Intent intent = getIntent();
        long characterId = Long.parseLong(intent.getStringExtra("character_uuid"));

        Character character = characterDetailsViewModel.getCharacter(characterId);

        Tool tool1 = new Tool("Outil 1", "Description outil 1", 1);
        tool1.setCharacterCreatorId(characterId);
        characterDetailsViewModel.addTool(tool1);

        Tool tool2 = new Tool("Outil 2", "Description outil 2", 1);
        tool2.setCharacterCreatorId(characterId);
        characterDetailsViewModel.addTool(tool2);

        Tool tool3 = new Tool("Outil 3", "Description outil 3", 1);
        tool3.setCharacterCreatorId(characterId);
        characterDetailsViewModel.addTool(tool3);

        Tool tool4 = new Tool("Outil 4", "Description outil 4", 1);
        tool4.setCharacterCreatorId(characterId);
        characterDetailsViewModel.addTool(tool4);

        characterDetailsViewModel.getToolsForCharacter(characterId);

        TextView characterName = findViewById(R.id.character_details_firstname);
        characterName.setText(character.getFullname());

        ProgressBar progressBar = findViewById(R.id.character_details_progress_bar);
        progressBar.setMax(character.getPodsMax());
        progressBar.setProgress(character.getPodsCurrent());

        TextView characterPods = findViewById(R.id.character_details_pods_current);
        String tmpPods = character.getPodsCurrent() + "/" + character.getPodsMax();
        characterPods.setText(tmpPods);

        Button addTool = findViewById(R.id.character_details_add_tool);
        addTool.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String tempId = String.valueOf(characterId);
                    startActivity(
                        new Intent(CharacterDetailsActivity.this, ToolsAddActivity.class)
                            .putExtra("character_uuid", tempId)
                    );
                    finish();
                }
            }
        );

        Button editCharacter = findViewById(R.id.character_details_edit);
        editCharacter.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(
                        new Intent(CharacterDetailsActivity.this, CharacterEditActivity.class)
                            .putExtra("character_uuid", String.valueOf(character.getCharacterId()))
                    );
                    finish();
                }
            }
        );

        Button deleteCharacter = findViewById(R.id.character_details_delete);
        deleteCharacter.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    characterDetailsViewModel.deleteCharacter(character);
                    startActivity(
                        new Intent(CharacterDetailsActivity.this, CharacterListActivity.class)
                    );
                    finish();
                }
            }
        );
    }
}
