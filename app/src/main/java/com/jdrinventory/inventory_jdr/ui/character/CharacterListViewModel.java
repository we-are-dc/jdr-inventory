package com.jdrinventory.inventory_jdr.ui.character;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.jdrinventory.inventory_jdr.model.dao.CharacterDAO;
import com.jdrinventory.inventory_jdr.model.repository.CharacterRepository;
import com.jdrinventory.inventory_jdr.model.data.Character;

public class CharacterListViewModel extends AndroidViewModel {
    private MutableLiveData<String> mText;
    private CharacterRepository mRepository;

    public CharacterListViewModel(Application application) {
        super(application);
        mRepository = new CharacterRepository(application);
    }

    public CharacterDAO getDAO() {
        return mRepository.mCharacterDAO;
    }

    public LiveData<Character> getCharacter(long characterId) {
        return mRepository.getCharacter(characterId);
    }

    public String getFirstname(long characterId) {
        LiveData<Character> character = this.getCharacter(characterId);
        return character.getValue().getFirstName();
    }
}
