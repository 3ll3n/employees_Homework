import db.SqlRunner;

public class Department {
    private int id;
    private String title;

    public Department(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void save() {
//        String sql = String.format();
//        this.id = SqlRunner.executeUpdate(sql);
//        SqlRunner.closeConnection();
    }
}