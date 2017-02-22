import db.SqlRunner;
import java.sql.ResultSet;

public class Employee {
    private int id;
    private String name;
    private double salary;
    private Department department;

    public Employee(String name, Department department, double salary) {
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void save() {
        int department_id = this.department.getId();
        String sql = String.format("INSERT INTO employees(name, salary, department_id) VALUES ('%s', %7.2f, %d);", this.name, this.salary, department_id);
        this.id = SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }

    public static void all() {
        String sql = "SELECT * FROM employees;";
        ResultSet rs = SqlRunner.executeQuery(sql);
        try {
            while (rs.next()) ; {
                String name = rs.getString("name");
                System.out.println(name);
                System.out.println();
            }
        }
        catch (Exception e) {
            System.err.println(e.getClass().getName() + " ; " + e.getMessage());
            System.exit(0);
        }
        finally {
            SqlRunner.closeConnection();
        }
    }

    public void getEmployeeDetails(){
        String sql = String.format("SELECT e.name, d.title department FROM employees e JOIN departments d ON d.id = e.department_id WHERE e.id = %d;", this.id);
        ResultSet rs = SqlRunner.executeQuery(sql);
        try{
            while (rs.next()){
                String name = rs.getString("name");
                String department = rs.getString("department");

                System.out.println("Employee name: " + name);
                System.out.println("Employee department: " + department);
                System.out.println();
            }
        }
        catch (Exception e) {
            System.err.println(e.getClass().getName() + " : " + e.getMessage());
            System.exit(0);
        }
        finally {
            SqlRunner.closeConnection();
        }
    }

    public static void deleteAll(){
        String sql = "DELETE FROM employees;";
        SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }

}