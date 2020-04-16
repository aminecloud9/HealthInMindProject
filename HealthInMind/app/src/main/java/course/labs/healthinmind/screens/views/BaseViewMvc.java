package course.labs.healthinmind.screens.views;

import android.content.Context;
import android.view.View;

import androidx.annotation.StringRes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public abstract class BaseViewMvc implements ViewMvc {
    
    private View mRootView;
    private static final String MY_DATE_FORMAT = "dd/MM/yyyy";

    @Override
    public View getRootView() {
        return mRootView;
    }

    protected void setRootView(View rootView) {
        mRootView = rootView;
    }

    protected <T extends View> T findViewById(int id) {
        return getRootView().findViewById(id);
    }

    protected Context getContext() {
        return getRootView().getContext();
    }

    protected String getString(@StringRes int id) {
        return getContext().getString(id);
    }

    protected DateFormat  getDataFormat(){
       return SimpleDateFormat.getDateInstance();
    }

    protected DateFormat getTimeFormat(){
        return SimpleDateFormat.getTimeInstance();
    }
}
