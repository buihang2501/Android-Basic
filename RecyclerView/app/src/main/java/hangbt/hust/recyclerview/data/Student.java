package hangbt.hust.recyclerview.data;

import androidx.annotation.NonNull;

public class Student {
    @NonNull
    private final int id;
    @NonNull
    private final String name;
    @NonNull
    private final String className;

    public Student(int id, String name, String className) {
        this.id = id;
        this.name = name;
        this.className = className;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getClassName() {
        return className;
    }

    public String getAvatarUrl(){
        return "https://ctt-sis.hust.edu.vn/Content/Anh/anh_"+id+".jpg";
    }
}
