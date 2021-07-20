package com.jdrinventory.inventory_jdr.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import com.jdrinventory.inventory_jdr.model.data.Tool;

import java.util.List;

@Dao
public interface ToolDAO {
    @Query("SELECT * FROM tool")
    LiveData<List<Tool>> getAllTools();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMultipleTools(Tool... tools);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Tool tool);

    @Delete
    void delete(Tool tool);

    @Transaction
    @Query("DELETE FROM Tool")
    void deleteAll();
}
