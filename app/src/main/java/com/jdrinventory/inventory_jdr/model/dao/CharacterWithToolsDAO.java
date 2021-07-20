package com.jdrinventory.inventory_jdr.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Query;
import androidx.room.Transaction;

import com.jdrinventory.inventory_jdr.model.data.CharacterWithTools;

import java.util.List;

@Dao
public interface CharacterWithToolsDAO {
    @Transaction
    @Query("SELECT * FROM Character WHERE character_id = :characterId")
    public LiveData<CharacterWithTools> getCharacterWithTools(long characterId);

    @Transaction
    @Query("SELECT * FROM Character")
    public LiveData<List<CharacterWithTools>> getCharactersWithTools();
}