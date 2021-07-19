package com.jdrinventory.inventory_jdr.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

@Dao
public interface CharacterWithToolsDAO {
    @Transaction
    @Query("SELECT * FROM Character WHERE characterId = :characterId")
    public LiveData<CharacterWithToolsDAO> getCharacterWithTools(int characterId);

    @Transaction
    @Query("SELECT * FROM Character")
    public LiveData<List<CharacterWithToolsDAO>> getCharactersWithTools();

    void deleteAll();
}