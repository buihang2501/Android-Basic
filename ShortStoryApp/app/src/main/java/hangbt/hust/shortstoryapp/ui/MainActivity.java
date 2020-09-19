package hangbt.hust.shortstoryapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import hangbt.hust.shortstoryapp.R;
import hangbt.hust.shortstoryapp.data.base.BaseAsyncTask;
import hangbt.hust.shortstoryapp.data.model.ShortStory;
import hangbt.hust.shortstoryapp.data.source.AppDatabase;
import hangbt.hust.shortstoryapp.data.source.ShortStoryDao;

public class MainActivity extends AppCompatActivity implements DetailStoryFragment.OnClickBookmarkListener {

    private static final String TAG = "MainActivity";

    private ShortStoryDao storyDao;

    private RecyclerView recyclerStory;
    private StoryAdapter storyAdapter = new StoryAdapter();

    private BaseAsyncTask.OnDataLoadedListener<List<ShortStory>> listener = new BaseAsyncTask.OnDataLoadedListener<List<ShortStory>>() {
        @Override
        public void onSuccess(List<ShortStory> data) {
            Log.d(TAG, "onSuccess: " + data);
            storyAdapter.updateData(data);
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
        getSupportActionBar().hide();

        initView();
        initData();
    }

    private void initView() {
        recyclerStory = findViewById(R.id.recyclerStory);
        recyclerStory.setAdapter(storyAdapter);

        storyAdapter.setListener(this::openDetail);
    }

    private void initData() {
        storyDao = AppDatabase.getInstance(this).storyDao();
        new BaseAsyncTask<Void, List<ShortStory>>()
                .setOnDataLoadedListener(listener)
                .onExecute(aVoid -> storyDao.getAllStory())
                .execute();
    }

    private void openDetail(ShortStory story, int position){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.constrainMain, DetailStoryFragment.newInstance(story, position))
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onAddBookmark(ShortStory story, int position) {
//        new BaseAsyncTask<Void, List<ShortStory>>()
//                .setOnDataLoadedListener(listener)
//                .onExecute(aVoid -> storyDao.getAllStory())
//                .execute();
    }
}
