package ca.georgebrown.comp3074.pocketmealapp.ui.food;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FoodViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public FoodViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is food list fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}