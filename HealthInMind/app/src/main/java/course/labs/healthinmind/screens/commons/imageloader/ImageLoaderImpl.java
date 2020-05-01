package course.labs.healthinmind.screens.commons.imageloader;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import androidx.annotation.DrawableRes;

import com.squareup.picasso.Picasso;

public class ImageLoaderImpl implements ImageLoader{
    private Context context;

    public ImageLoaderImpl(Context context) {
        this.context = context;
    }

    @Override
    public void loadImage(@DrawableRes int resId, ImageView target) {
//        Picasso.with(context).load(resId).fit().into(target);
    }
}
