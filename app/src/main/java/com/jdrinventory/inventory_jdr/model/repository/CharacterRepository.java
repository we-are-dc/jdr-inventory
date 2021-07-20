package com.jdrinventory.inventory_jdr.model.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.jdrinventory.inventory_jdr.model.AppDatabase;
import com.jdrinventory.inventory_jdr.model.dao.CharacterDAO;
import com.jdrinventory.inventory_jdr.model.data.Character;

import java.util.List;

public class CharacterRepository {
    private CharacterDAO mCharacterDAO;

    CharacterRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        mCharacterDAO = db.characterDao();
    }

    LiveData<List<Character>> getAllCharacters() {
        return mCharacterDAO.getAllCharacters();
    }

    LiveData<List<Character>> findCharactersById(long[] characterIds) {
        return mCharacterDAO.findCharactersById(characterIds);
    }

    LiveData<Character> findCharacterByName(String first, String last) {
        return mCharacterDAO.findCharacterByName(first, last);
    }

    void insert(Character character) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            mCharacterDAO.insert(character);
        });
    }

    void update(Character character) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            mCharacterDAO.update(character);
        });
    }

    void delete(Character character) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            mCharacterDAO.delete(character);
        });
    }

    void deleteAll() {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            mCharacterDAO.deleteAll();
        });
    }
}
