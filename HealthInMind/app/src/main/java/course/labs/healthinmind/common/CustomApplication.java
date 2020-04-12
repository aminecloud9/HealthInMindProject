package course.labs.healthinmind.common;

import android.app.Application;

import course.labs.healthinmind.common.dependencyinjection.CompositionRoot;

public class CustomApplication extends Application {

    private CompositionRoot mCompositionRoot;

    @Override
    public void onCreate() {
        super.onCreate();
        mCompositionRoot = new CompositionRoot(this);
    }

    public CompositionRoot getCompositionRoot() {
        return mCompositionRoot;
    }
}
