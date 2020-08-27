package hangbt.hust.sqlitedao.data.source.dao;

import java.util.List;

import hangbt.hust.sqlitedao.data.model.Student;

public interface StudentDAO {
    void create(Student student);

    List<Student> getAll();

    void update(Student student);

    void delete(Student student);
}
