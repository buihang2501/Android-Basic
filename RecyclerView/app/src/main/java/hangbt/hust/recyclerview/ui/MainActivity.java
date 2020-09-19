package hangbt.hust.recyclerview.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import hangbt.hust.recyclerview.R;
import hangbt.hust.recyclerview.data.Student;

public class MainActivity extends AppCompatActivity {

    private StudentAdapter studentAdapter = new StudentAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        List<Student> students = new ArrayList<>();
        //init data
        for(int i=0; i<50; i++){
            students.add(new Student(20173050+i, UUID.randomUUID().toString(), "KHMT04"));
        }

        studentAdapter.updateData(students);
    }

    private void initView(){
        RecyclerView recyclerStudents = findViewById(R.id.recyclerStudents);
        recyclerStudents.setAdapter(studentAdapter);
    }
}
