package com.jdrinventory.inventory_jdr.ui.character;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.jdrinventory.inventory_jdr.model.data.Character;
import com.jdrinventory.inventory_jdr.model.repository.CharacterRepository;

public class CharacterAddViewModel extends AndroidViewModel {
    private CharacterRepository mRepository;

    public CharacterAddViewModel(Application application) {
        super(application);
        this.mRepository = new CharacterRepository(application);
    }

    public Character getCharacter(long characterId) {
        return mRepository.getCharacter(characterId);
    }

    public void addCharacter(Character character) {
        mRepository.insert(character);
    }
}
