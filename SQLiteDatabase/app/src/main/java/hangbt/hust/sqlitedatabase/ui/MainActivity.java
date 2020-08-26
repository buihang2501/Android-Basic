package hangbt.hust.sqlitedatabase.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import hangbt.hust.sqlitedatabase.R;
import hangbt.hust.sqlitedatabase.data.Database;
import hangbt.hust.sqlitedatabase.data.Job;

public class MainActivity extends AppCompatActivity {

    Database database;

    private RecyclerView recyclerJob;
    private JobAdapter jobAdapter = new JobAdapter();
    private List<Job> jobs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //tạo database
        database = new Database(this,"note.sqlite",null,1);
        //tạo bảng
        String sql = "create table if not exists Job" +
                "(ID integer primary key autoincrement ," +
                "Name nvarchar(200))";
        database.queryData(sql);
        //insert data
        sql = "insert into Job values";
        database.queryData(sql +
                "(null,'Làm bài tập Android')," +
                "(null,'Làm lý thuyết OOP')," +
                "(null,'Xem video Database')," +
                "(null,'Đi ngủ đúng giờ')," +
                "(null,'Ăn uống healthy')," +
                "(null,'Dậy sớm')");

        //get data
        recyclerJob = findViewById(R.id.recyclerJob);

        initView();
        initData(database);

    }

    private void initView() {
        recyclerJob.setAdapter(jobAdapter);
    }

    private void initData(Database database) {
        Cursor cursor = database.getData("select * from Job");
        while(cursor.moveToNext()){
            String name = cursor.getString(1);
            jobs.add(new Job(cursor.getInt(0),name));
        }

        jobAdapter.updateData(jobs);
    }

}
