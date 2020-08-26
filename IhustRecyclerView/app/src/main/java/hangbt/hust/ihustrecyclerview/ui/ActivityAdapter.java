package hangbt.hust.ihustrecyclerview.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import hangbt.hust.ihustrecyclerview.R;
import hangbt.hust.ihustrecyclerview.data.HustActivity;

public class ActivityAdapter extends RecyclerView.Adapter<ActivityAdapter.ActivityViewHolder> {

    private List<HustActivity> hustActivities = new ArrayList<>();

    @NonNull
    @Override
    public ActivityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_activity,parent,false);
        return new ActivityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ActivityViewHolder holder, int position) {
        HustActivity hustActivity = hustActivities.get(position);
        holder.bindData(hustActivity);
    }

    @Override
    public int getItemCount() {
        return hustActivities.size();
    }

    public void updateData(List<HustActivity> activities){
        hustActivities.clear();
        hustActivities.addAll(activities);
        notifyDataSetChanged();
    }

    static class ActivityViewHolder extends RecyclerView.ViewHolder {

        private TextView textDay, textWeekDay, textActivity, textTime, textStatus;
        public ActivityViewHolder(@NonNull View itemView) {
            super(itemView);
            textDay = itemView.findViewById(R.id.textDay);
            textTime = itemView.findViewById(R.id.textTime);
            textActivity = itemView.findViewById(R.id.textActivityName);
            textWeekDay = itemView.findViewById(R.id.textWeekDay);
            textStatus = itemView.findViewById(R.id.textStatus);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(),textActivity.getText(),Toast.LENGTH_SHORT).show();
                }
            });
        }

        public void bindData(HustActivity hustActivity){
            textDay.setText(hustActivity.getDay());
            textWeekDay.setText(hustActivity.getWeekDay());
            textTime.setText(hustActivity.getTime());
            textActivity.setText(hustActivity.getName());
            int visibility = hustActivity.isStatus() ? View.VISIBLE : View.GONE;
            textStatus.setVisibility(visibility);
        }
    }
}
