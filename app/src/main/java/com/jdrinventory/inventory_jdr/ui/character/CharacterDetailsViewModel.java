package com.jdrinventory.inventory_jdr.ui.character;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.jdrinventory.inventory_jdr.model.data.Character;
import com.jdrinventory.inventory_jdr.model.data.Tool;
import com.jdrinventory.inventory_jdr.model.repository.CharacterRepository;
import com.jdrinventory.inventory_jdr.model.repository.ToolRepository;

import java.util.List;

public class CharacterDetailsViewModel extends AndroidViewModel {
    private CharacterRepository characterRepository;
    private ToolRepository toolRepository;

    public CharacterDetailsViewModel(Application application) {
        super(application);
        this.characterRepository = new CharacterRepository(application);
        this.toolRepository = new ToolRepository(application);

    }

    public Character getCharacter(long characterId) {
        return characterRepository.getCharacter(characterId);
    }

    public List<Tool> getToolsForCharacter(long characterId) {
        return toolRepository.getToolsForCharacter(characterId).getValue();
    }

    public void addTool(Tool tool) {
        toolRepository.insert(tool);
    }
    public void deleteCharacter(Character character) { characterRepository.delete(character); }
}
