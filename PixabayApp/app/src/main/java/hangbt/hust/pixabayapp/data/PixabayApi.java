package hangbt.hust.pixabayapp.data;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PixabayApi {
    String BASE_URL = "https://pixabay.com/";
    String KEY = "11705223-2e906401dbe44ed955bacd2ac";

    @GET("api")
    Call<SearchImagesResponse> searchImages(@Query("key") String key,
                                           @Query("q") String q);

}
