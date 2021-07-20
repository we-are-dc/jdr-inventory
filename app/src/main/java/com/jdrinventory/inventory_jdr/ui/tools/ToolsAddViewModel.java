package com.jdrinventory.inventory_jdr.ui.tools;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.jdrinventory.inventory_jdr.model.data.Character;
import com.jdrinventory.inventory_jdr.model.data.Tool;
import com.jdrinventory.inventory_jdr.model.repository.CharacterRepository;
import com.jdrinventory.inventory_jdr.model.repository.ToolRepository;

public class ToolsAddViewModel extends AndroidViewModel {
    private ToolRepository toolRepository;
    private CharacterRepository characterRepository;

    public ToolsAddViewModel(Application application) {
        super(application);
        this.toolRepository = new ToolRepository(application);
        this.characterRepository = new CharacterRepository(application);
    }

    public LiveData<Tool> getTool(long toolId) {
        return toolRepository.getTool(toolId);
    }

    public void addTool(Tool tool) {
        toolRepository.insert(tool);
    }

    public Character getCharacter(long characterId) {
        return characterRepository.getCharacter(characterId);
    }
}