package course.labs.healthinmind.screens.views;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.annotation.StringRes;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public abstract class BaseViewMvc implements ViewMvc {

    private static final String TAG_DATE_PARSE_ERROR = "date_parse_error";
    private static final String MY_DATE_FORMAT = "dd/MM/yyyy";
    public static final Calendar MY_CALENDAR = Calendar.getInstance();
    private View mRootView;

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

    protected DateFormat getDateFormat(){
       return SimpleDateFormat.getDateInstance();
    }


    protected Date setTextToDate(TextView editText) {
        Date date = new Date();
        try {
            date = getDateFormat().parse(setTextToString(editText));
        } catch (ParseException e) {
            Log.e(TAG_DATE_PARSE_ERROR, Objects.requireNonNull(e.getMessage()));
        }
        return date;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    protected LocalTime setTextToTime(EditText editText) {
        return LocalTime.parse(setTextToString(editText));
    }

    protected void updateLabel(TextView editText) {
        editText.setText(getDateFormat().format(MY_CALENDAR.getTime()));
    }

    protected int setTextToInt(EditText editText) {
        return Integer.parseInt(setTextToString(editText));
    }

    protected String setTextToString(TextView editText) {
        return editText.getText().toString();
    }


    protected void inflateCalenderSetDateFrom(View view, TextView textView) {

        view.setOnClickListener(new View.OnClickListener() {
            DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    // TODO Auto-generated method stub
                    MY_CALENDAR.set(Calendar.YEAR, year);
                    MY_CALENDAR.set(Calendar.MONTH, monthOfYear);
                    MY_CALENDAR.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                    updateLabel(textView);
                }

            };

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(getContext(), date, MY_CALENDAR
                        .get(Calendar.YEAR), MY_CALENDAR.get(Calendar.MONTH),
                        MY_CALENDAR.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }
}
