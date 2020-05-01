package course.labs.healthinmind.screens.commons.imageloader;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import androidx.annotation.DrawableRes;

public interface ImageLoader {
    void loadImage(@DrawableRes int resId, ImageView target);
}
