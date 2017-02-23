/**
 * Created by user on 22/02/2017.
 */

public class Runner {
    public static void main(String[] args){
        Employee.deleteAll();
        Department.deleteAll();

        Department department1 = new Department("HR");
        Department department2 = new Department("Marketing");

        department1.save();
        department2.save();

        Employee employee1 = new Employee("Suzie Smith", department1, 45000);
        Employee employee2 = new Employee("Jamie Jones", department2, 25000);

//        employee1.setName("Suzie Jones");
//        employee1.update();
//
//        department1.setTitle("Fun");
//        department1.update();

        employee1.save();
        employee2.save();
//
//        employee1.getEmployeeDetails();
//        employee2.getEmployeeDetails();

//        employee1.delete();
//        department1.delete();

        Employee.all();

    }
}
