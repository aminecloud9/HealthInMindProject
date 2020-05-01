package course.labs.healthinmind.screens;

import android.content.Context;
import android.widget.ImageView;

import androidx.annotation.DrawableRes;

import com.squareup.picasso.Picasso;

import course.labs.healthinmind.R;
import course.labs.healthinmind.common.Form;

public class FormIconLoader {
    private Context context;


    public FormIconLoader(Context context) {
        this.context = context;
    }

    public void loadFormIcon(Form form, ImageView imageView){
         switch (form){

             case PILL:
                 loadIcon(imageView, R.drawable.ic_date_range);
                 break;
             case LIQUID:
                 loadIcon(imageView, R.drawable.ic_date_range);
                 break;
             case TABLET:
                 loadIcon(imageView, R.drawable.ic_date_range);
                 break;
             case CAPSULES:
                 loadIcon(imageView, R.drawable.ic_date_range);
                 break;
             case TOPICAL_MEDICINES:
                 loadIcon(imageView, R.drawable.ic_date_range);
                 break;
             case SUPPOSITORIES:
                 loadIcon(imageView, R.drawable.ic_date_range);
                 break;
             case DROPS:
                 loadIcon(imageView, R.drawable.ic_date_range);
                 break;
             case INHALERS:
                 loadIcon(imageView, R.drawable.ic_date_range);
                 break;
             case INJECTIONS:
                 loadIcon(imageView, R.drawable.ic_pills_medicine_item);
                 break;
             case IMPANTS_OR_PATCHES:
                 loadIcon(imageView, R.drawable.ic_date_range);
                 break;
         }
    }

    private void loadIcon(ImageView imageView, @DrawableRes int iconId) {
        Picasso
                .get()
                .load(iconId)
                .error(R.drawable.ic_pills_solid)
                .fit()
                .into(imageView);
    }
}
