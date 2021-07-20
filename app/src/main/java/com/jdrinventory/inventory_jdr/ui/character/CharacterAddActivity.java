package com.jdrinventory.inventory_jdr.ui.character;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.jdrinventory.inventory_jdr.R;
import com.jdrinventory.inventory_jdr.model.data.Character;

public class CharacterAddActivity extends AppCompatActivity {
    private CharacterAddViewModel characterAddViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Define the layout corresponding to this activity
        setContentView(R.layout.character_add);

        characterAddViewModel = new ViewModelProvider(this).get(CharacterAddViewModel.class);

        // Get form fields
        EditText characterFirstnameInput = findViewById(R.id.character_firstname_input);
        EditText characterLastnameInput = findViewById(R.id.character_lastname_input);
        EditText characterMaxPodsInput = findViewById(R.id.character_max_pods_input);

        // Get submit button
        Button characterSubmitButton = findViewById(R.id.character_submit_button);

        characterSubmitButton.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Character character = new Character(
                        characterFirstnameInput.getText().toString(),
                        characterLastnameInput.getText().toString(),
                        Integer.parseInt(characterMaxPodsInput.getText().toString())
                    );

                    characterAddViewModel.addCharacter(character);
                }
            }
        );
    }
}
