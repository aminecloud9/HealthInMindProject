package course.labs.healthinmind.roomdatabase;

import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;

import course.labs.healthinmind.database.HealthData;

@RunWith(AndroidJUnit4.class)
abstract public class BaseRoomTest {
    protected HealthData db;

    @Before
    public void createDb(){
        Context context = ApplicationProvider.getApplicationContext();
        db = Room.inMemoryDatabaseBuilder(context,HealthData.class).build();
    }

    @After
    public void closeDb(){
        db.close();
    }
}
