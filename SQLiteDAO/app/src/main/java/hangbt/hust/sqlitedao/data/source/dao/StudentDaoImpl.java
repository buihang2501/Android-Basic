package hangbt.hust.sqlitedao.data.source.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import hangbt.hust.sqlitedao.data.model.Student;
import hangbt.hust.sqlitedao.data.source.AppDatabase;

public class StudentDaoImpl implements StudentDAO{

    private SQLiteDatabase readableDb;
    private SQLiteDatabase writeableDb;

    public StudentDaoImpl(AppDatabase database) {
        this.readableDb = database.getReadableDatabase();
        this.writeableDb = database.getWritableDatabase();
    }

    @Override
    public void create(Student student) {
        ContentValues contentValues = student.getContentValues();
        writeableDb.insert(Student.TABLE_NAME,null,contentValues);
    }

    @Override
    public List<Student> getAll() {
        Cursor cursor = readableDb.query(Student.TABLE_NAME,null,null,null,null,null,null,null);
        cursor.moveToFirst();
        List<Student> students = new ArrayList<>();
        while(!cursor.isAfterLast()){
            Student student = new Student(cursor);
            students.add(student);
            cursor.moveToNext();
        }
        return students;
    }

    @Override
    public void update(Student student) {
        ContentValues contentValues = student.getContentValues();
        writeableDb.update(Student.TABLE_NAME,contentValues,Student.ID + "= ?",new String[]{student.getId()});
    }

    @Override
    public void delete(Student student) {
        ContentValues contentValues = student.getContentValues();
        writeableDb.delete(Student.TABLE_NAME,Student.ID + "= ?",new String[]{student.getId()});
    }
}
