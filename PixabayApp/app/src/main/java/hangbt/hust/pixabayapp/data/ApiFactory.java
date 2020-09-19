package hangbt.hust.pixabayapp.data;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiFactory {
    private static PixabayApi pixabayApi;

    private ApiFactory() {

    }

    public static PixabayApi getPixabayApi() {
        if (pixabayApi == null) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            httpClient.addInterceptor(logging);

            pixabayApi = new Retrofit.Builder()
                    .baseUrl(PixabayApi.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build()
                    .create(PixabayApi.class);
        }
        return pixabayApi;
    }
}
