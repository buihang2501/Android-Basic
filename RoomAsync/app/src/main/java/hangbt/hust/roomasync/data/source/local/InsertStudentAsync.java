package hangbt.hust.roomasync.data.source.local;

import android.os.AsyncTask;

import hangbt.hust.roomasync.data.model.Student;

//Generic Type
//Student, void, void
public class InsertStudentAsync extends AsyncTask<Student, Void, Void> {

    private StudentDAO studentDAO;

    public InsertStudentAsync(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    protected Void doInBackground(Student... students) {
        for (Student student : students) {
            studentDAO.create(student);
        }
        return null;
    }
}
