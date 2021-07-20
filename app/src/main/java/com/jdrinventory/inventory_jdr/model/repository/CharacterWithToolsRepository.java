package com.jdrinventory.inventory_jdr.model.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.jdrinventory.inventory_jdr.model.AppDatabase;
import com.jdrinventory.inventory_jdr.model.dao.CharacterWithToolsDAO;
import com.jdrinventory.inventory_jdr.model.data.CharacterWithTools;

import java.util.List;

public class CharacterWithToolsRepository {
    private CharacterWithToolsDAO mCharacterWithToolsDAO;

    public CharacterWithToolsRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        mCharacterWithToolsDAO = db.characterWithToolsDao();
    }

    LiveData<CharacterWithTools> getCharacterWithTools(long characterId) {
        return mCharacterWithToolsDAO.getCharacterWithTools(characterId);
    }

    LiveData<List<CharacterWithTools>> getCharactersWithTools() {
        return mCharacterWithToolsDAO.getCharactersWithTools();
    }
}
