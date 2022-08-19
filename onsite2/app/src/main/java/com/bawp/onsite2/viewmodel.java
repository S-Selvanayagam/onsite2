package com.bawp.onsite2;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class viewmodel extends ViewModel {

        private final MutableLiveData<CustomView> selectedItem = new MutableLiveData<CustomView>();
        public void selectItem(CustomView item) {

            selectedItem.setValue(item);
        }
        public LiveData<CustomView> getSelectedItem() {

            return selectedItem;
        }

}
