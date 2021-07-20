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
    List<Character> getAllCharacters();

    @Query("SELECT * FROM Character WHERE character_id IN (:character_ids)")
    LiveData<List<Character>> findCharactersById(long[] character_ids);

    @Transaction
    @Query("SELECT * FROM Character WHERE first_name = :first AND last_name = :last LIMIT 1")
    List<Character> findCharacterByName(String first, String last);

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
    Character getCharacter(long character_id);
}