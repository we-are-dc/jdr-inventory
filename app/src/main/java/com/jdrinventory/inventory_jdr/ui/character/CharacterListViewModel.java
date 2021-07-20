package com.jdrinventory.inventory_jdr.ui.character;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class CharacterListViewModel extends AndroidViewModel {
    private MutableLiveData<String> mText;

    public CharacterListFragment() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
