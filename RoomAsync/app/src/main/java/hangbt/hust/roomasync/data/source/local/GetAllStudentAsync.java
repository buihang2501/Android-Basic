package hangbt.hust.roomasync.data.source.local;

import android.os.AsyncTask;

import java.util.List;

import hangbt.hust.roomasync.data.handle.OnDataLoadedCallback;
import hangbt.hust.roomasync.data.model.Student;

public class GetAllStudentAsync extends AsyncTask<Void, Void, List<Student>> {
    private StudentDAO studentDAO;
    private OnDataLoadedCallback<List<Student>> listener;

    public GetAllStudentAsync(StudentDAO studentDAO, OnDataLoadedCallback<List<Student>> listener) {
        this.studentDAO = studentDAO;
        this.listener = listener;
    }

    @Override
    protected List<Student> doInBackground(Void... voids) {
        return studentDAO.getAll();
    }

    @Override
    protected void onPostExecute(List<Student> students) {
        if (students == null) {
            listener.onFailure(new Exception("Data is null"));
            return;
        }
        listener.onSuccess(students);
    }
}
