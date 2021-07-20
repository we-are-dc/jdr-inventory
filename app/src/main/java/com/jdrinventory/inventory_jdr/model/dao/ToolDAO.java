package com.jdrinventory.inventory_jdr.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.jdrinventory.inventory_jdr.model.data.Tool;

import java.util.List;

@Dao
public interface ToolDAO {
    @Query("SELECT * FROM Tool")
    LiveData<List<Tool>> getAllTools();

    @Query("SELECT * FROM Tool WHERE tool_id IN (:tool_ids)")
    LiveData<List<Tool>> findToolById(long[] tool_ids);

    @Query("SELECT * FROM Tool WHERE characterCreatorId = :characterId")
    LiveData<List<Tool>> getToolsForCharacter(long characterId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMultipleTools(Tool... tools);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Tool tool);

    @Update
    void update(Tool tool);

    @Delete
    void delete(Tool tool);

    @Transaction
    @Query("DELETE FROM Tool")
    void deleteAll();

    @Transaction
    @Query("SELECT * FROM Tool WHERE tool_id = :tool_id")
    LiveData<Tool> getTool(long tool_id);
}
