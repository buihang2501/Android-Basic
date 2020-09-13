package hangbt.hust.shortstoryapp.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "tbl_short_story")
public class ShortStory implements Serializable {
    @PrimaryKey
    @ColumnInfo(name = "id")
    private Integer id;
    @ColumnInfo(name = "image")
    private String image;
    @ColumnInfo(name = "title")
    private String title;
    @ColumnInfo(name = "description")
    private String description;
    @ColumnInfo(name = "content")
    private String content;
    @ColumnInfo(name = "author")
    private String author;
    @ColumnInfo(name = "bookmark")
    private Integer bookmark;

    public ShortStory(Integer id, String image, String title, String description, String content, String author, Integer bookmark) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.description = description;
        this.content = content;
        this.author = author;
        this.bookmark = bookmark;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setBookmark(Integer bookmark) {
        this.bookmark = bookmark;
    }

    public Integer getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getBookmark() {
        return bookmark;
    }

    @Override
    public String toString() {
        return "ShortStory{" +
                "id=" + id +
                ", bookmark=" + bookmark +
                '}';
    }
}
