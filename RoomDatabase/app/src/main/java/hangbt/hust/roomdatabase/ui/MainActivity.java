package hangbt.hust.roomdatabase.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import hangbt.hust.roomdatabase.R;
import hangbt.hust.roomdatabase.data.base.BaseAsyncTask;
import hangbt.hust.roomdatabase.data.model.Story;
import hangbt.hust.roomdatabase.data.source.AppDatabase;
import hangbt.hust.roomdatabase.data.source.StoryDao;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private StoryDao storyDao;
    private BaseAsyncTask.OnDataLoadedListener<List<Story>> listener = new BaseAsyncTask.OnDataLoadedListener<List<Story>>() {
        @Override
        public void onSuccess(List<Story> data) {
            Log.d(TAG, "onSuccess: " + data);
        }

        @Override
        public void onFailure(Exception e) {
            Log.e(TAG, "onFailure: ", e);
        }
    };

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
        storyDao = AppDatabase.getInstance(this).storyDao();

        new BaseAsyncTask<Void, List<Story>>()
                .setOnDataLoadedListener(listener)
                .onExecute(new BaseAsyncTask.OnExecuteListener<Void, List<Story>>() {
                    @Override
                    public List<Story> onExecute(Void aVoid) {
                        return storyDao.getAllStory();
                    }
                })
                .execute();
    }
}