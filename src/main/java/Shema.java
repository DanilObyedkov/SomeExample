public class Shema {

       Long Id;
    String Title;
    String Update_At;

    public Shema() {

    }

    @Override
    public String toString() {
        return "Shema{" +
                "Id=" + Id +
                ", Title='" + Title + '\'' +
                ", Update_At='" + Update_At + '\'' +
                '}';
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getUpdate_At() {
        return Update_At;
    }

    public void setUpdate_At(String update_At) {
        Update_At = update_At;
    }

    public Shema(Long id, String title, String update_At) {
        Id = id;
        Title = title;
        Update_At = update_At;
    }


}
