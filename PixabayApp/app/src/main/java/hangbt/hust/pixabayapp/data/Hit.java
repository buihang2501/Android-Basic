package hangbt.hust.pixabayapp.data;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Hit implements Serializable {
    @SerializedName("id")
    private int id;
    @SerializedName("tags")
    private String tags;
    @SerializedName("previewURL")
    private String previewUrl;
    @SerializedName("webformatURL")
    private String url;

    public Hit(){
    }

    public int getId() {
        return id;
    }

    public String getTags() {
        return tags;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public String getUrl() {
        return url;
    }
}
/*
"id": 195893,
        "pageURL": "https://pixabay.com/en/blossom-bloom-flower-195893/",
        "type": "photo",
        "tags": "blossom, bloom, flower",
        "previewURL": "https://cdn.pixabay.com/photo/2013/10/15/09/12/flower-195893_150.jpg"
        "previewWidth": 150,
        "previewHeight": 84,
        "webformatURL": "https://pixabay.com/get/35bbf209e13e39d2_640.jpg",
        "webformatWidth": 640,
        "webformatHeight": 360,
 */