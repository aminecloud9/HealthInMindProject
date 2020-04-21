package course.labs.healthinmind.screens;

import android.content.Context;
import android.graphics.drawable.Drawable;

import java.util.HashMap;
import java.util.Map;

import course.labs.healthinmind.R;
import course.labs.healthinmind.common.Form;

public class ImageFormMapper {
    private Context context;
    private Map<Form, Drawable> formImageMap = new HashMap<Form,Drawable>(){{
        put(Form.PILL, context.getDrawable(R.drawable.ic_date_range));
    }};

    public Drawable getImage(Form form){
        return formImageMap.get(form);
    }
}
