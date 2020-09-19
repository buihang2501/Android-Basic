package hangbt.hust.roomasync.data.source.local;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import hangbt.hust.roomasync.data.model.Student;

@Dao
public interface StudentDAO {
    //CRUD
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void create(Student student);

    @Query("Select * from Student")
    List<Student> getAll();

    @Query("Select * from Student Where id = :studentId")
    Student getById(String studentId);

    @Update
    void update(Student student);

    @Delete
    void delete(Student student);
}
