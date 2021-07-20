package com.jdrinventory.inventory_jdr.ui.character;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.jdrinventory.inventory_jdr.model.dao.CharacterDAO;
import com.jdrinventory.inventory_jdr.model.repository.CharacterRepository;
import com.jdrinventory.inventory_jdr.model.data.Character;

import java.util.List;
import java.util.Objects;

public class CharacterListViewModel extends AndroidViewModel {
    private final CharacterRepository mRepository;

    public CharacterListViewModel(Application application) {
        super(application);
        mRepository = new CharacterRepository(application);
    }

    public List<Character> getAllCharacters() {
        return mRepository.getAllCharacters();
    }

    public Character getCharacter(long characterId) {
        return mRepository.getCharacter(characterId);
    }

    public String getFirstname(long characterId) {
        Character character = this.getCharacter(characterId);
        return character.getFirstName();
    }

    public Character findCharacterByName(String first, String last) {
        return mRepository.findCharacterByName(first, last);
    }

    public void addCharacter(Character character) {
        mRepository.insert(character);
    }
}
