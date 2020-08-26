package hangbt.hust.sqlitedatabase.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import hangbt.hust.sqlitedatabase.R;
import hangbt.hust.sqlitedatabase.data.Database;
import hangbt.hust.sqlitedatabase.data.Job;

public class JobAdapter extends RecyclerView.Adapter<JobAdapter.JobViewHolder> {

    private List<Job> jobs = new ArrayList<>();

    @NonNull
    @Override
    public JobViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_job,parent,false);
        return new JobViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JobViewHolder holder, int position) {
        Job job = jobs.get(position);
        holder.bindData(job);
    }

    public void updateData(List<Job> jobList){
        jobs.clear();
        jobs.addAll(jobList);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return jobs.size();
    }

    static class JobViewHolder extends RecyclerView.ViewHolder{

        private TextView textName;
        private Button buttonEdit, buttonDelete;

        public JobViewHolder(@NonNull View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.textJob);
            buttonEdit = itemView.findViewById(R.id.buttonEdit);
            buttonDelete = itemView.findViewById(R.id.buttonDelete);

        }

        public void bindData(final Job job){
            textName.setText(job.getName());
        }
    }
}
