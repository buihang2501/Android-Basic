package hangbt.hust.sqlitedao.data.source;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import hangbt.hust.sqlitedao.data.model.Student;

public class AppDatabase extends SQLiteOpenHelper {

    private static final String DB_NAME = "student.db";
    private static final int DB_VERSION = 1;

    private static AppDatabase instance;

    private AppDatabase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public static AppDatabase getInstance(Context context){
        if(instance == null){
            instance = new AppDatabase(context, DB_NAME, null, DB_VERSION);
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS Student(" +
                Student.ID+" integer primary key," +
                Student.NAME+" nvarchar(200)," +
                Student.CLASS_NAME+" nvarchar(200))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+Student.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
