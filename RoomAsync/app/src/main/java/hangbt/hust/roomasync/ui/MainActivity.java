package hangbt.hust.roomasync.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import hangbt.hust.roomasync.R;
import hangbt.hust.roomasync.data.handle.OnDataLoadedCallback;
import hangbt.hust.roomasync.data.model.Student;
import hangbt.hust.roomasync.data.source.local.AppDatabase;
import hangbt.hust.roomasync.data.source.local.GetAllStudentAsync;
import hangbt.hust.roomasync.data.source.local.InsertStudentAsync;
import hangbt.hust.roomasync.data.source.local.StudentDAO;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private StudentDAO studentDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
    }

    private void initView() {
    }

    private void initData() {
        AppDatabase database = AppDatabase.getInstance(this);
        studentDAO = database.studentDAO();

        insertData();
        getData();
    }

    private void insertData() {
        for (int i = 0; i < 50; i++) {
            new InsertStudentAsync(studentDAO).execute(new Student(String.valueOf(20173050 + i)));
        }
    }

    private void getData() {
        OnDataLoadedCallback<List<Student>> callback = new OnDataLoadedCallback<List<Student>>() {
            @Override
            public void onSuccess(List<Student> students) {
                Log.d(TAG, "onSuccess: " + students);;

            }

            @Override
            public void onFailure(Exception exception) {
                Log.e(TAG, "onFailure: ",exception );
            }
        };

        new GetAllStudentAsync(studentDAO,callback).execute();
    }
}