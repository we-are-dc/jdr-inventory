package com.jdrinventory.inventory_jdr.ui.tools;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.jdrinventory.inventory_jdr.model.data.Tool;
import com.jdrinventory.inventory_jdr.model.repository.ToolRepository;

public class ToolsAddViewModel extends AndroidViewModel {
    private ToolRepository mRepository;

    public ToolsAddViewModel(Application application) {
        super(application);
        this.mRepository = new ToolRepository(application);
    }

    public LiveData<Tool> getTool(long toolId) {
        return mRepository.getTool(toolId);
    }

    public void addTool(Tool tool) {
        mRepository.insert(tool);
    }
}