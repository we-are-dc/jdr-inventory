package com.jdrinventory.inventory_jdr.ui.tools;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class ToolsAddViewModel extends AndroidViewModel {
    private MutableLiveData<String> mText;

    public ToolsAddViewModel(Application application) {
        super(application);
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}