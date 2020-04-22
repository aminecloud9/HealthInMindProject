package course.labs.healthinmind.screens.addmedicine;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Spinner;

import java.util.List;

import course.labs.healthinmind.R;
import course.labs.healthinmind.screens.addmedicine.reminders.StringQuantityMapper;
import course.labs.healthinmind.screens.views.BaseObservableViewMvc;

public  class AddReminderDialogWindow extends
        BaseObservableViewMvc<AddReminderDialogWindow.AddReminderDialogListener>
        implements AdapterView.OnItemSelectedListener {

    public interface AddReminderDialogListener{

        void onValidate(int hour, int minute, String quantity);

        void onCancel();
    }
    private NumberPicker hour;
    private NumberPicker minute;



    private String selectedItem;
    private StringQuantityMapper quantityMapper;
    public AddReminderDialogWindow(LayoutInflater layoutInflater, ViewGroup parent, StringQuantityMapper quantityMapper) {
        this.quantityMapper = quantityMapper;
        setRootView(layoutInflater.inflate(R.layout.dialog_window,parent,true));
        setUpComponents();
    }

    private void setUpComponents(){
        setUpTimeChooser();
        setQuantityToTakeSpinner();
        setUpValidateButtonClick();
        setUpCancelButton();
    }
    private void setUpTimeChooser() {
        hour = findViewById(R.id.np_reminder_hour);
        minute = findViewById(R.id.np_reminder_minute);
        hour.setMinValue(0);hour.setMaxValue(23);
        minute.setMinValue(0);minute.setMaxValue(59);
    }


    private void setQuantityToTakeSpinner() {
        Spinner quantityToTake;
        quantityToTake = findViewById(R.id.spnr_reminder_quantity);
        List<String> quantities = quantityMapper.getStringArray();


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getContext(),
                R.layout.spinner_text_view,
                quantities
        );

        adapter.setDropDownViewResource(R.layout.spinner_text_view);
        quantityToTake.setAdapter(adapter);
        quantityToTake.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        selectedItem = (String) adapterView.getItemAtPosition(i);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private void setUpValidateButtonClick() {
        Button validateButton;
        validateButton = findViewById(R.id.btn_validate_reminder);
        validateButton.setOnClickListener(v -> {
            for (AddReminderDialogListener listener : getListeners()){
                listener.onValidate(hour.getValue(), minute.getValue(), selectedItem);
            }
        });
    }

    private void setUpCancelButton() {
        Button cancelButton;
        cancelButton = findViewById(R.id.btn_cancel_reminder);
        cancelButton.setOnClickListener(v ->{
            for (AddReminderDialogListener listener : getListeners()){
                listener.onCancel();
            }
        });
    }


}
