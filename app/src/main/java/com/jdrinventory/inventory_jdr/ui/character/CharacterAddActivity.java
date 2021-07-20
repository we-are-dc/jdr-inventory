package com.jdrinventory.inventory_jdr.ui.character;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.room.util.StringUtil;

import com.jdrinventory.inventory_jdr.R;
import com.jdrinventory.inventory_jdr.model.data.Character;

import org.jetbrains.annotations.NotNull;

import java.util.List;

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
                    String[] data = {
                        characterFirstnameInput.getText().toString(),
                        characterLastnameInput.getText().toString(),
                        characterFirstnameInput.getText().toString()
                    };

                    if (validateData(data)) {
                        Character character = new Character(
                            characterFirstnameInput.getText().toString(),
                            characterLastnameInput.getText().toString(),
                            Integer.parseInt(characterMaxPodsInput.getText().toString())
                        );
                        characterAddViewModel.addCharacter(character);
                        Toast.makeText(CharacterAddActivity.this, "Personnage créé.", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(CharacterAddActivity.this, CharacterListActivity.class));
                        finish();
                    } else {
                        Toast.makeText(CharacterAddActivity.this, "Impossible de créer le personnage", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        );
    }

    private boolean validateData(@NotNull String... data) {
        boolean isValid = true;

        for (String value:data) {
            if (
                value == null ||
                value.equals("")
            ) {
                isValid = false;
                break;
            }
        }

        return isValid;
    }
}
