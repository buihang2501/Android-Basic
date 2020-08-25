package hangbt.hust.ihustrecyclerview.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import hangbt.hust.ihustrecyclerview.R;
import hangbt.hust.ihustrecyclerview.data.HustActivity;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerActivity;
    private ActivityAdapter activityAdapter = new ActivityAdapter();
    private List<HustActivity> hustActivities = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerActivity = findViewById(R.id.recyclerActivity);

        initView();
        initData();
    }

    private void initView() {
        recyclerActivity.setAdapter(activityAdapter);
    }

    private void initData() {
        hustActivities.add(new HustActivity("Thành viên tham gia Câu lạc bộ",
                "21","21/01 - 31/07 00:00","Thứ 3",false));
        hustActivities.add(new HustActivity("Khảo sát thực tập",
                "21","21/01 - 31/07 00:00","Thứ 3",true));
        hustActivities.add(new HustActivity("Cài đặt Bluezone",
                "21","21/01 - 31/07 00:00","Thứ 3",false));
        hustActivities.add(new HustActivity("Họp lớp kỳ 20192",
                "21","21/01 - 31/07 00:00","Thứ 3",true));
        hustActivities.add(new HustActivity("Tôi ở nhà vẫn sáng tạo thả ga",
                "21","21/01 - 31/07 00:00","Thứ 3",false));
        hustActivities.add(new HustActivity("BK Got talent",
                "21","21/01 - 31/07 00:00","Thứ 3",true));
        hustActivities.add(new HustActivity("Tham gia hiến máu 20192",
                "21","21/01 - 31/07 00:00","Thứ 3",false));

        hustActivities.add(new HustActivity("Thành viên tham gia Câu lạc bộ",
                "21","21/01 - 31/07 00:00","Thứ 3",false));
        hustActivities.add(new HustActivity("Khảo sát thực tập",
                "21","21/01 - 31/07 00:00","Thứ 3",true));
        hustActivities.add(new HustActivity("Cài đặt Bluezone",
                "21","21/01 - 31/07 00:00","Thứ 3",false));
        hustActivities.add(new HustActivity("Họp lớp kỳ 20192",
                "21","21/01 - 31/07 00:00","Thứ 3",true));
        hustActivities.add(new HustActivity("Tôi ở nhà vẫn sáng tạo thả ga",
                "21","21/01 - 31/07 00:00","Thứ 3",false));
        hustActivities.add(new HustActivity("BK Got talent",
                "21","21/01 - 31/07 00:00","Thứ 3",true));
        hustActivities.add(new HustActivity("Tham gia hiến máu 20192",
                "21","21/01 - 31/07 00:00","Thứ 3",false));

        hustActivities.add(new HustActivity("Thành viên tham gia Câu lạc bộ",
                "21","21/01 - 31/07 00:00","Thứ 3",false));
        hustActivities.add(new HustActivity("Khảo sát thực tập",
                "21","21/01 - 31/07 00:00","Thứ 3",true));
        hustActivities.add(new HustActivity("Cài đặt Bluezone",
                "21","21/01 - 31/07 00:00","Thứ 3",false));
        hustActivities.add(new HustActivity("Họp lớp kỳ 20192",
                "21","21/01 - 31/07 00:00","Thứ 3",true));
        hustActivities.add(new HustActivity("Tôi ở nhà vẫn sáng tạo thả ga",
                "21","21/01 - 31/07 00:00","Thứ 3",false));
        hustActivities.add(new HustActivity("BK Got talent",
                "21","21/01 - 31/07 00:00","Thứ 3",true));
        hustActivities.add(new HustActivity("Tham gia hiến máu 20192",
                "21","21/01 - 31/07 00:00","Thứ 3",false));

        hustActivities.add(new HustActivity("Thành viên tham gia Câu lạc bộ",
                "21","21/01 - 31/07 00:00","Thứ 3",false));
        hustActivities.add(new HustActivity("Khảo sát thực tập",
                "21","21/01 - 31/07 00:00","Thứ 3",true));
        hustActivities.add(new HustActivity("Cài đặt Bluezone",
                "21","21/01 - 31/07 00:00","Thứ 3",false));
        hustActivities.add(new HustActivity("Họp lớp kỳ 20192",
                "21","21/01 - 31/07 00:00","Thứ 3",true));
        hustActivities.add(new HustActivity("Tôi ở nhà vẫn sáng tạo thả ga",
                "21","21/01 - 31/07 00:00","Thứ 3",false));
        hustActivities.add(new HustActivity("BK Got talent",
                "21","21/01 - 31/07 00:00","Thứ 3",true));
        hustActivities.add(new HustActivity("Tham gia hiến máu 20192",
                "21","21/01 - 31/07 00:00","Thứ 3",false));

        activityAdapter.updateData(hustActivities);
    }
}
