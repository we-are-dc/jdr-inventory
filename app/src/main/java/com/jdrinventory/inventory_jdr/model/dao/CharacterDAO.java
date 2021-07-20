package com.jdrinventory.inventory_jdr.model.dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.jdrinventory.inventory_jdr.model.data.Character;

import java.util.List;

@Dao
public interface CharacterDAO {

    @Transaction
    @Query("SELECT * FROM Character")
    LiveData<List<Character>> getAllCharacters();

    @Query("SELECT * FROM Character WHERE character_id IN (:character_ids)")
    LiveData<List<Character>> findCharactersById(long[] character_ids);

    @Query("SELECT * FROM character WHERE first_name LIKE :first AND last_name LIKE :last LIMIT 1")
    LiveData<Character> findCharacterByName(String first, String last);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Character character);

    @Update
    void update(Character character);

    @Delete
    void delete(Character character);

    @Transaction
    @Query("DELETE FROM Character")
    void deleteAll();

    @Transaction
    @Query("SELECT * FROM Character WHERE character_id = :character_id")
    LiveData<Character> getCharacter(long character_id);
}