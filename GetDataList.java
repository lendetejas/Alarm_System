package alarm_clock.com.alarm_clock;

public class GetDataList {

    String Datelist;
    String Timelist;
    String Title;
    String Priority_High;
    String Priority_Medium;
    String Priority_Low;


    public GetDataList(String Datelist, String Timelist, String Title) {
        this.Datelist = Datelist;
        this.Timelist = Timelist;
        this.Title = Title;
    }



    public String getDate() {
        return Datelist;
    }

    public void setDate(String date) {
        Datelist = date;
    }

    public String getTime() {
        return Timelist;
    }

    public void setTime(String time) {
        Timelist = time;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getPriority_High() {
        return Priority_High;
    }

    public void setPriority_High(String priority_High) {
        Priority_High = priority_High;
    }

    public String getPriority_Medium() {
        return Priority_Medium;
    }

    public void setPriority_Medium(String priority_Medium) {
        Priority_Medium = priority_Medium;
    }

    public String getPriority_Low() {
        return Priority_Low;
    }

    public void setPriority_Low(String priority_Low) {
        Priority_Low = priority_Low;
    }
}
