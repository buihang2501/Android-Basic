package hangbt.hust.sqlitedao.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import hangbt.hust.sqlitedao.R;
import hangbt.hust.sqlitedao.data.model.Student;
import hangbt.hust.sqlitedao.data.source.AppDatabase;
import hangbt.hust.sqlitedao.data.source.dao.StudentDAO;
import hangbt.hust.sqlitedao.data.source.dao.StudentDaoImpl;

public class StudentApdater extends RecyclerView.Adapter<StudentApdater.StudentViewHolder> {

    private List<Student> students = new ArrayList<>();

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

    @Override
    public int getItemCount() {
        return students.size();
    }

    public void updateData(List<Student> studentList){
        students.clear();
        students.addAll(studentList);
        notifyDataSetChanged();
    }

    static class StudentViewHolder extends RecyclerView.ViewHolder {

        private TextView textName;
        private Button buttonDelete, buttonUpdate;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.textName);
            buttonDelete = itemView.findViewById(R.id.buttonDelete);
            buttonUpdate = itemView.findViewById(R.id.buttonEdit);
        }

        public void bindData(final Student student){
            textName.setText(student.getName());
            buttonDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AppDatabase database = AppDatabase.getInstance(view.getContext());
                    StudentDAO studentDAO = new StudentDaoImpl(database);
                    studentDAO.delete(student);
                }
            });
        }
    }
}
