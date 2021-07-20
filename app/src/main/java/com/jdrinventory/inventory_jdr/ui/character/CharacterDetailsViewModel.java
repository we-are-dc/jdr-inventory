package com.jdrinventory.inventory_jdr.ui.character;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CharacterDetailsViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public CharacterDetailsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
