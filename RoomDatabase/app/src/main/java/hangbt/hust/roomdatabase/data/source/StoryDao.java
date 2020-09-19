package hangbt.hust.roomdatabase.data.source;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import hangbt.hust.roomdatabase.data.model.Story;

@Dao
public interface StoryDao {
//crud
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertStory(Story story);

    @Query("SELECT * FROM tbl_short_story")
    List<Story> getAllStory();

}
