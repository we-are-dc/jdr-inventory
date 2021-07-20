package com.jdrinventory.inventory_jdr.model.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.jdrinventory.inventory_jdr.model.AppDatabase;
import com.jdrinventory.inventory_jdr.model.dao.ToolDAO;
import com.jdrinventory.inventory_jdr.model.data.Tool;

import java.util.List;

public class ToolRepository {
    private ToolDAO mToolDAO;

    public ToolRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        mToolDAO = db.toolDao();
    }

    LiveData<List<Tool>> getAllTools() {
        return mToolDAO.getAllTools();
    }

    void insert(Tool tool) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            mToolDAO.insert(tool);
        });
    }

    void insertMultipleTools(Tool... tools) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            mToolDAO.insertMultipleTools(tools);
        });
    }

    void delete(Tool tool) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            mToolDAO.delete(tool);
        });
    }

    void deleteAll() {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            mToolDAO.deleteAll();
        });
    }
}
