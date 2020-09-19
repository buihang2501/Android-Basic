package hangbt.hust.recyclerview.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import hangbt.hust.recyclerview.R;
import hangbt.hust.recyclerview.data.Student;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    @NonNull
    private final List<Student> students = new ArrayList<>();

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student,parent,false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Student student = students.get(position);
        holder.bindData(student);
    }

    public void updateData(List<Student> newStudents){
        students.clear();
        students.addAll(newStudents);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return students.size();
    }


    static class StudentViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageAvatar;
        private TextView textId;

        public StudentViewHolder(View itemView){
            super((itemView));
            imageAvatar = itemView.findViewById(R.id.imageAvatar);
            textId = itemView.findViewById(R.id.textId);
            itemView.setOnClickListener(view -> {
                    int visibility = imageAvatar.getVisibility() == View.VISIBLE ? View.GONE:View.VISIBLE;
                    imageAvatar.setVisibility(visibility);
            });
        }

        public void bindData(Student student){
            textId.setText("" + student.getId());
            Glide.with(itemView.getContext())
                    .load(student.getAvatarUrl())
                    .error(R.drawable.ic_launcher_background)
                    .placeholder(R.color.colorAccent)
                    .into(imageAvatar);

        }
    }
}
