package hangbt.hust.sqlitedao.data.model;

import android.content.ContentValues;
import android.database.Cursor;

public class Student {
    public final static String TABLE_NAME = "Student";
    public final static String ID = "id";
    public final static String NAME = "name";
    public final static String CLASS_NAME = "className";

    private String id, name, className;

    public Student(Cursor cursor){
        this.id = cursor.getString(cursor.getColumnIndex(Student.ID));
        this.name = cursor.getString(cursor.getColumnIndex(Student.NAME));
        this.className = cursor.getString(cursor.getColumnIndex(Student.CLASS_NAME));
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", className='" + className + '\'' +
                '}';
    }

    public Student(String id, String name, String className) {
        this.id = id;
        this.name = name;
        this.className = className;
    }

    public ContentValues getContentValues(){
        ContentValues contentValues = new ContentValues();
        contentValues.put(Student.ID, id);
        contentValues.put(Student.NAME, name);
        contentValues.put(Student.CLASS_NAME, className);
        return contentValues;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getClassName() {
        return className;
    }
}
