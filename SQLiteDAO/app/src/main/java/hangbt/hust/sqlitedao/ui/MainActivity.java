package hangbt.hust.sqlitedao.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import hangbt.hust.sqlitedao.R;
import hangbt.hust.sqlitedao.data.model.Student;
import hangbt.hust.sqlitedao.data.source.AppDatabase;
import hangbt.hust.sqlitedao.data.source.dao.StudentDAO;
import hangbt.hust.sqlitedao.data.source.dao.StudentDaoImpl;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerStudent;
    private StudentApdater studentApdater = new StudentApdater();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();

    }

    private void initView() {
        recyclerStudent.setAdapter(studentApdater);
    }

    private void initData() {
        AppDatabase database = AppDatabase.getInstance(this);
        StudentDAO studentDAO = new StudentDaoImpl(database);

        for(int i=0; i<10; i++){
            String name = "" + (char) ((int)('A') + i);
            studentDAO.create(new Student(String.valueOf(i),name, "11" ));
        }

        List<Student> students = studentDAO.getAll();
        Log.d("TAG","initData: " + students);

        studentApdater.updateData(students);

//        studentDAO.update(new Student("0","Hang","KHMT04"));
//        students = studentDAO.getAll();
//        Log.d("TAG","getData: " + students);
//
//        studentDAO.delete(new Student("1","B","11"));
//        students = studentDAO.getAll();
//        Log.d("TAG","getData: " + students);
//
    }
}
