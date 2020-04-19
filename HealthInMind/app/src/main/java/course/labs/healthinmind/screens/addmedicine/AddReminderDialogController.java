package course.labs.healthinmind.screens.addmedicine;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.FragmentManager;

import java.time.LocalTime;

import course.labs.healthinmind.screens.ViewMvcFactory;
import course.labs.healthinmind.screens.addmedicine.reminders.ReminderDto;
import course.labs.healthinmind.screens.addmedicine.reminders.StringQuantityMapper;

public  class AddReminderDialogController extends AppCompatDialogFragment
        implements AddReminderDialogWindow.AddReminderDialogListener {

    interface DialogControllerListener{
        void onValidate(ReminderDto reminderDto);
        void onCancel();
    }

    private AddReminderDialogWindow addReminderDialogWindow;
    private StringQuantityMapper quantityMapper;
    private DialogControllerListener listener;
    private ViewMvcFactory viewMvcFactory;
    private Dialog dialog;
    public AddReminderDialogController(StringQuantityMapper quantityMapper, ViewMvcFactory viewMvcFactory) {
        this.quantityMapper = quantityMapper;
        this.viewMvcFactory = viewMvcFactory;


    }

    @Override
    public void onValidate(int hour, int minute, String quantity) {
        listener.onValidate(new ReminderDto(
                LocalTime.of(hour,minute),
                quantityMapper.getValue(quantity)
                )
        );
    }

    @Override
    public void onCancel() {
        listener.onCancel();
    }

    public void setListener(DialogControllerListener listener) {
        this.listener = listener;
    }

   @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return addReminderDialogWindow.getRootView();
    }

    @Override
    public void onStart() {
        super.onStart();
        addReminderDialogWindow.registerListener(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        addReminderDialogWindow.unregisterListener(this);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        addReminderDialogWindow = viewMvcFactory.getAddReminderDialogWindow(null,quantityMapper);
        AlertDialog.Builder  builder = new AlertDialog.Builder(getActivity());
        builder.setView(addReminderDialogWindow.getRootView()).setTitle("Reminder");
        dialog = builder.create();
        return dialog;
    }

    public void show(FragmentManager fragmentManager){
        this.show(fragmentManager,"TAG");
    }

}
