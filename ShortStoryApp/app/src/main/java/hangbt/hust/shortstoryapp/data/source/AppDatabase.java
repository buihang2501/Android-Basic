package hangbt.hust.shortstoryapp.data.source;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import hangbt.hust.shortstoryapp.data.model.ShortStory;

@Database(entities = {ShortStory.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static final String DB_NAME = "short_story.db";
    private static AppDatabase instance;

    public abstract ShortStoryDao storyDao();

    public static AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, AppDatabase.class, DB_NAME)
                    .createFromAsset(DB_NAME)
                    .fallbackToDestructiveMigration()
                    .build();
        }

        return instance;
    }
}
