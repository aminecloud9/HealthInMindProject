package course.labs.healthinmind.screens;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RemindersRecyclerAdapter extends RecyclerView.Adapter {

    static class RemindersViewHolder extends RecyclerView.ViewHolder {

        private final AddMedicineViewMvc mViewMvc;

        public RemindersViewHolder(AddMedicineViewMvc viewMvc) {
            super(viewMvc.getRootView());
            mViewMvc = viewMvc;
        }

    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        AddMedicineViewMvc viewMvc = mViewMvcFactory.getQuestionsListItemViewMvc(parent);
        viewMvc.registerListener(this);
        return new RemindersViewHolder(viewMvc);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
