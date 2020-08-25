package hangbt.hust.ihustrecyclerview.data;

public class HustActivity {
    private String name, day, time , weekDay;
    private boolean status;

    public HustActivity(String name, String day, String time, String weekDay, boolean status) {
        this.name = name;
        this.day = day;
        this.time = time;
        this.weekDay = weekDay;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getDay() {
        return day;
    }

    public String getTime() {
        return time;
    }

    public String getWeekDay() {
        return weekDay;
    }

    public boolean isStatus() {
        return status;
    }
}
