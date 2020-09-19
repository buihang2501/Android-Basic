package hangbt.hust.roomasync.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.UUID;

@Entity(tableName = Student.TABLE_NAME)
public class Student {
    public static final String TABLE_NAME = "Student";
    @PrimaryKey
    @ColumnInfo(name = "id")
    public String id;
    @ColumnInfo(name = "name")
    public String name;
    @ColumnInfo(name = "className")
    public String className;

    public Student(String id) {
        this.id = id;
        this.name = UUID.randomUUID().toString();
        this.className = "KHMT04 - K62";
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                '}';
    }
}
