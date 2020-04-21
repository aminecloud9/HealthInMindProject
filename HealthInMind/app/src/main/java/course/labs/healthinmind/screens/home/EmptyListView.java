package course.labs.healthinmind.screens.home;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;

import course.labs.healthinmind.R;
import course.labs.healthinmind.screens.views.BaseViewMvc;

public class EmptyListView extends BaseViewMvc {
    private TextView tvDisplayedMessage;

    public EmptyListView(LayoutInflater layoutInflater, @Nullable ViewGroup parent, String displayedText) {
        setRootView(layoutInflater.inflate(R.layout.home_no_data, parent, false));
        tvDisplayedMessage = findViewById(R.id.tv_displayed_message);
        tvDisplayedMessage.setText(displayedText);
    }
}
