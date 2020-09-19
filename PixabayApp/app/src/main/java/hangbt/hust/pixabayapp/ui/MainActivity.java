package hangbt.hust.pixabayapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.SearchView;

import java.util.List;

import hangbt.hust.pixabayapp.R;
import hangbt.hust.pixabayapp.data.ApiFactory;
import hangbt.hust.pixabayapp.data.Hit;
import hangbt.hust.pixabayapp.data.PixabayApi;
import hangbt.hust.pixabayapp.data.SearchImagesResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerHits;
    private HitAdapter hitAdapter = new HitAdapter();
    private SearchView searchHit;

    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
    }

    private void initView() {
        recyclerHits = findViewById(R.id.recyclerHits);
        recyclerHits.setAdapter(hitAdapter);
        searchHit = findViewById(R.id.searchView);

        searchHit.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                searchImages(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                searchImages(s);
                return false;
            }
        });

        hitAdapter.setListener(this::openDetail);
    }

    private void initData() {
        searchImages("food");
    }

    private void searchImages(String q){
        ApiFactory.getPixabayApi()
                .searchImages(PixabayApi.KEY, q)
                .enqueue(new Callback<SearchImagesResponse>() {
                    @Override
                    public void onResponse(Call<SearchImagesResponse> call, Response<SearchImagesResponse> response) {
                        List<Hit> hits = response.body().getHits();
                        Log.d(TAG, "onResponse: " + hits);
                        hitAdapter.updateData(hits);
                    }

                    @Override
                    public void onFailure(Call<SearchImagesResponse> call, Throwable t) {

                    }
                });
    }

    public void openDetail(Hit hit){
        getSupportFragmentManager().beginTransaction()
                .add(R.id.constrainMain, DetailFragment.newInstance(hit))
                .addToBackStack(null)
                .commit();
    }
}