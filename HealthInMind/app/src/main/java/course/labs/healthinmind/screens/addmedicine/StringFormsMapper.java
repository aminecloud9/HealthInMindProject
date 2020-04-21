package course.labs.healthinmind.screens.addmedicine;

import android.content.Context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import course.labs.healthinmind.R;
import course.labs.healthinmind.common.Form;
import course.labs.healthinmind.screens.addmedicine.reminders.StringEnumMapper;

public class StringFormsMapper extends StringEnumMapper<Form> {

    public StringFormsMapper(Context context) {
        super(context);
        setEnumTypeMap(new HashMap<String, Form>(){{
            put(getKey(R.string.pill),Form.PILL);
            put(getKey(R.string.liquid),Form.LIQUID);
            put(getKey(R.string.tablet),Form.TABLET);
            put(getKey(R.string.capsules),Form.CAPSULES);
            put(getKey(R.string.topicalMedicines),Form.TOPICAL_MEDICINES);
            put(getKey(R.string.suppositories),Form.SUPPOSITORIES);
            put(getKey(R.string.drops),Form.DROPS);
            put(getKey(R.string.inhalers),Form.INHALERS);
            put(getKey(R.string.injections),Form.INJECTIONS);
            put(getKey(R.string.implantsOrPatches),Form.IMPANTS_OR_PATCHES);
        }});
    }
}
