
public class Employee {

    private final String employee;
    private String department;
    private double salary;
    private int id;

    private static int counter;

    public static int id() { //метод-счетчик
        return counter++;
    }

    public Employee(String employee, String department, double salary) { //конструктор
        id = id();
        this.employee = employee;
        this.department = department;
        this.salary = salary;
    }

    public String getEmployee() {
        return employee;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "id: " + getId() + ", Ф.И.О.: " + employee + ", Отдел № " + department + ", Зарплата: " + salary;
    }
}
