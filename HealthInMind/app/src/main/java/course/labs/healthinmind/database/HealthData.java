package course.labs.healthinmind.database;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import course.labs.healthinmind.medecine.data.roomimplementation.MedicineDao;
import course.labs.healthinmind.medecine.data.roomimplementation.MedicineRoomImpl;
import course.labs.healthinmind.reminders.data.roomimplimentation.ReminderDao;
import course.labs.healthinmind.reminders.data.roomimplimentation.ReminderRoomImpl;
import course.labs.healthinmind.remindmedicine.RemindMedicineDao;
import course.labs.healthinmind.remindmedicine.RemindMedicineRoomImpl;

@Database(entities = {MedicineRoomImpl.class, RemindMedicineRoomImpl.class, ReminderRoomImpl.class}, version = 1)
@TypeConverters({Converters.class})
public abstract class HealthData extends RoomDatabase {
    private static HealthData instance;
    public abstract MedicineDao medicineDao();
    public abstract ReminderDao reminderDao();
    public abstract RemindMedicineDao remindMedicineDao();
    //the getter of instances from our room Db
    public static synchronized HealthData getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),HealthData.class,"medicine_database")
                    .fallbackToDestructiveMigration().addCallback(roomCallback).build();
        }
        return instance;
    }
    private static RoomDatabase.Callback roomCallback =new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };
    //What we can do in the Db Asynchronously
    private static class PopulateDbAsyncTask extends AsyncTask<Void,Void,Void> {
        private MedicineDao medicineDao;
        private PopulateDbAsyncTask(HealthData db){
            medicineDao = db.medicineDao();
        }
        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        protected Void doInBackground(Void... voids) {
//            medicineDao.insert(new MedicineRoomImpl("paracetamol","oval",250,3,20,new Reminder(LocalTime.now()),false,
//                    new Date(22-02-2020),true,new Date(22-05-2020),"take it when needed"));
            return null;
        }
    }
}
