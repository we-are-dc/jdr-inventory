package com.jdrinventory.inventory_jdr.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.jdrinventory.inventory_jdr.model.data.Tool;

import java.util.List;

@Dao
public interface ToolDAO {
    @Query("SELECT * FROM tool")
    LiveData<List<Tool>> getAll();

    @Insert
    void insertAll(Tool... tools);

    @Insert
    void insert(Tool tool);

    @Delete
    void delete(Tool tool);

    void deleteAll();
}
