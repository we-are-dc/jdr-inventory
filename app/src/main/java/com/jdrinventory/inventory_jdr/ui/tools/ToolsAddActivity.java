package com.jdrinventory.inventory_jdr.ui.tools;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.jdrinventory.inventory_jdr.R;
import com.jdrinventory.inventory_jdr.model.data.Character;
import com.jdrinventory.inventory_jdr.model.data.Tool;
import com.jdrinventory.inventory_jdr.ui.character.CharacterAddActivity;
import com.jdrinventory.inventory_jdr.ui.character.CharacterListActivity;
import com.jdrinventory.inventory_jdr.ui.tools.ToolsAddViewModel;
import com.jdrinventory.inventory_jdr.ui.tools.ToolsAddActivity;

import org.jetbrains.annotations.NotNull;

public class ToolsAddActivity extends AppCompatActivity {
    private ToolsAddViewModel toolsAddViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Define the layout corresponding to this activity
        setContentView(R.layout.tool_add);

        ToolsAddViewModel toolsAddViewModel  = new ViewModelProvider(this).get(ToolsAddViewModel.class);

        // Get form fields
        EditText toolNameInput = findViewById(R.id.tool_name_input);
        EditText toolDescriptionInput = findViewById(R.id.tool_description_input);
        EditText toolClutterInput = findViewById(R.id.tool_clutter_input);

        // Get submit button
        Button characterSubmitButton = findViewById(R.id.tool_submit_button);

        characterSubmitButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String[] data = {
                                toolNameInput.getText().toString(),
                                toolDescriptionInput.getText().toString(),
                                toolClutterInput.getText().toString()
                        };

                        if (validateData(data)) {
                            Tool tool = new Tool(
                                    toolNameInput.getText().toString(),
                                    toolDescriptionInput.getText().toString(),
                                    Integer.parseInt(toolClutterInput.getText().toString())
                            );
                            toolsAddViewModel.addTool(tool);
                            Toast.makeText(ToolsAddActivity.this, "Objet créé.", Toast.LENGTH_SHORT).show();
                          //  startActivity(new Intent(ToolsAddActivity.this, CharacterListActivity.class));
                            //finish();
                        } else {
                            Toast.makeText(ToolsAddActivity.this, "Impossible de créer l'objet", Toast.LENGTH_SHORT).show();
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
