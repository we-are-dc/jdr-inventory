package com.jdrinventory.inventory_jdr.model.dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CharacterDAO {
    @Query("SELECT * FROM Character")
    LiveData<List<Character>> getAll();

    @Query("SELECT * FROM Character WHERE characterId IN (:characterIds)")
    LiveData<List<Character>> loadAllByIds(int[] characterIds);

    @Query("SELECT * FROM character WHERE first_name LIKE :first AND last_name LIKE :last LIMIT 1")
    LiveData<Character> findByName(String first, String last);

    @Insert
    void insert(Character character);

    @Update
    void update(Character character);

    @Delete
    void delete(Character character);

    void deleteAll();
}