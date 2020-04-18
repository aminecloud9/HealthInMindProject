package course.labs.healthinmind.screens.addmedicine.reminders;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import course.labs.healthinmind.screens.ViewMvcFactory;
import course.labs.healthinmind.screens.addmedicine.AddMedicineViewMvc;

public class RemindersRecyclerAdapter extends RecyclerView.Adapter<RemindersRecyclerAdapter.RemindersViewHolder> {

    public interface Listener {
        void onReminderClicked(ReminderDto reminderDto);
    }



    static class RemindersViewHolder extends RecyclerView.ViewHolder {

        private final ReminderView reminderView;

        public RemindersViewHolder(ReminderView viewMvc) {
            super(viewMvc.getRootView());
            reminderView = viewMvc;
        }


    }
//    private final Listener listener;
    private final ViewMvcFactory mViewMvcFactory;

    private List<ReminderDto> mReminders = new ArrayList<>();

    public RemindersRecyclerAdapter(ViewMvcFactory mViewMvcFactory) {
//        this.listener = listener;
        this.mViewMvcFactory = mViewMvcFactory;
    }

    @NonNull
    @Override
    public RemindersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ReminderView reminderView = mViewMvcFactory.getReminderView(parent);
//        viewMvc.registerListener(this);
        return new RemindersViewHolder(reminderView);
    }

    @Override
    public void onBindViewHolder(@NonNull RemindersViewHolder holder, int position) {
        holder.reminderView.bindReminder(mReminders.get(position));
    }

    @Override
    public int getItemCount() {
        return mReminders.size();
    }

    public List<LocalTime> getTakingTimes(){
        return mReminders.stream().
                map(ReminderDto::getTime).
                collect(Collectors.toList());
    }

}
