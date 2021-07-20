package com.jdrinventory.inventory_jdr.model.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.jdrinventory.inventory_jdr.model.AppDatabase;
import com.jdrinventory.inventory_jdr.model.dao.CharacterDAO;
import com.jdrinventory.inventory_jdr.model.data.Character;

import java.util.List;

public class CharacterRepository {
    public CharacterDAO mCharacterDAO;

    public CharacterRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        mCharacterDAO = db.characterDao();
    }

    public LiveData<List<Character>> getAllCharacters() {
        return mCharacterDAO.getAllCharacters();
    }

    public LiveData<List<Character>> findCharactersById(long[] characterIds) {
        return mCharacterDAO.findCharactersById(characterIds);
    }

    public LiveData<Character> getCharacter(long characterId) {
        return mCharacterDAO.getCharacter(characterId);
    }

    public LiveData<Character> findCharacterByName(String first, String last) {
        return mCharacterDAO.findCharacterByName(first, last);
    }

    public void insert(Character character) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            mCharacterDAO.insert(character);
        });
    }

    public void update(Character character) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            mCharacterDAO.update(character);
        });
    }

    public void delete(Character character) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            mCharacterDAO.delete(character);
        });
    }

    public void deleteAll() {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            mCharacterDAO.deleteAll();
        });
    }
}
