package course.labs.healthinmind.screens;

import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import course.labs.healthinmind.reminders.data.abstractions.Reminder;

public class RemindersRecyclerAdapter extends RecyclerView.Adapter<RemindersRecyclerAdapter.RemindersViewHolder> implements AddMedicineViewMvc.ListenerForReminders{

    public interface Listener {
        void onReminderClicked(ReminderDto reminderDto);
    }

    public RemindersRecyclerAdapter(Listener listener, ViewMvcFactory mViewMvcFactory) {
        this.listener = listener;
        this.mViewMvcFactory = mViewMvcFactory;
    }

    static class RemindersViewHolder extends RecyclerView.ViewHolder {

        private final AddMedicineViewMvc medicineViewMvc;

        public RemindersViewHolder(AddMedicineViewMvc viewMvc) {
            super(viewMvc.getRootView());
            medicineViewMvc = viewMvc;
        }


    }
    private final Listener listener;

    private final ViewMvcFactory mViewMvcFactory;
    private List<ReminderDto> mReminders = new ArrayList<>();
    @Override
    public void onReminderClicked(ReminderDto reminderDto) {
        listener.onReminderClicked(reminderDto);
        DialogWindow dialogWindow = new DialogWindow() {
            @Override
            public void onItemClicked() {

            }
        }
    }

    @NonNull
    @Override
    public RemindersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        AddMedicineViewMvc viewMvc = mViewMvcFactory.getAddMedicineViewMvc(parent);
        viewMvc.registerListener(this);
        return new RemindersViewHolder(viewMvc);
    }

    @Override
    public void onBindViewHolder(@NonNull RemindersViewHolder holder, int position) {
        holder.medicineViewMvc.bindReminders(mReminders.get(position));
    }

    @Override
    public int getItemCount() {
        return mReminders.size();
    }

    public void bindReminders(){

    }

}
