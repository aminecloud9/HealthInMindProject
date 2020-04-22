package course.labs.healthinmind.screens;

import android.content.Context;
import android.graphics.drawable.Drawable;

import java.util.HashMap;
import java.util.Map;

import course.labs.healthinmind.R;
import course.labs.healthinmind.common.Form;

public class ImageFormMapper {
    private Context context;
    private Map<Form, Drawable> formImageMap;


    public ImageFormMapper(Context context) {
        this.context = context;
             formImageMap = new HashMap<Form,Drawable>(){{
            put(Form.INJECTIONS, context.getDrawable(R.drawable.ic_date_range));
            put(Form.CAPSULES, context.getDrawable(R.drawable.ic_date_range));
            put(Form.DROPS, context.getDrawable(R.drawable.ic_date_range));
            put(Form.IMPANTS_OR_PATCHES, context.getDrawable(R.drawable.ic_date_range));
            put(Form.INHALERS, context.getDrawable(R.drawable.ic_date_range));
            put(Form.LIQUID, context.getDrawable(R.drawable.ic_date_range));
            put(Form.PILL, context.getDrawable(R.drawable.ic_date_range));
            put(Form.SUPPOSITORIES, context.getDrawable(R.drawable.ic_date_range));
            put(Form.TABLET, context.getDrawable(R.drawable.ic_date_range));
            put(Form.TOPICAL_MEDICINES, context.getDrawable(R.drawable.ic_date_range));
        }};
    }

    public Drawable getImage(Form form){
        return formImageMap.get(form);
    }
}
