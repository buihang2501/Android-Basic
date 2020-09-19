package hangbt.hust.shortstoryapp.data.source;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import hangbt.hust.shortstoryapp.data.model.ShortStory;

@Dao
public interface ShortStoryDao {

    @Query("SELECT * FROM tbl_short_story")
    List<ShortStory> getAllStory();

    @Query("SELECT * FROM tbl_short_story WHERE id = :id")
    ShortStory getStory(Integer id);

    @Update
    Void updateStory(ShortStory story);

}
