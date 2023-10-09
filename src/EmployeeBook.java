import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;


public class EmployeeBook {
    private final Employee[] employees;

    private static int size;

    public EmployeeBook() {
        this.employees = new Employee[10];
    }

    public void addEmployee(String employeeEmployee, String employeeDepartment, double salary) { // Добавить нового сотрудника
        if (size >= employees.length) {
            System.out.println("В хранилище сотрудников закончилось место!");
        }

        if (employees[size] == null) {
            Employee newEmployee = new Employee(employeeEmployee, employeeDepartment, salary);
            employees[size++] = newEmployee;
        }
    }

    public void removeEmployee(String employee) { //Удалить сотрудника (находим сотрудника по Ф. И. О. и/или id, обнуляем его ячейку в массиве)
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                break;
            }
            if (employees[i].getEmployee().equals(employee)) {
                System.out.println(employees[i].getEmployee() + " удален");
                System.arraycopy(employees, i + 1, employees, i, size - i - 1);
                employees[size - 1] = null;
                size--;
                return;
            }
        }
    }

    public void changeSalaryEmployee(String employee, double changeSalary) { //Изменить сотрудника (получить сотрудника по Ф. И. О., модернизировать его запись) - изменить зарплату
        for (Employee value : employees) {
            if (value == null) {
                break;
            }
            if (value.getEmployee().equals(employee)) {
                value.setSalary(changeSalary);
                System.out.println(value);
            }
        }
    }

    public void changeSalaryDepartment(String employee, String changeDepartment) { //Изменить сотрудника (получить сотрудника по Ф. И. О., модернизировать его запись) - изменить отдел
        for (Employee value : employees) {
            if (value == null) {
                break;
            }
            if (value.getEmployee().equals(employee)) {
                value.setDepartment(changeDepartment);
                System.out.println(value);
            }
        }
    }

    public void printInfoAboutEmployeeOfDepartments() { //Получить Ф. И. О. всех сотрудников по отделам (напечатать список отделов и их сотрудников)

        ArrayList<Employee> employee = new ArrayList<>();
        for (Employee value : employees) {
            if (value == null) {
                break;
            }
            employee.add(new Employee(value.getEmployee(), value.getDepartment(), value.getSalary()));
        }
        Comparator<Employee> compareByDepartment = Comparator
                .comparing(Employee::getDepartment);

        ArrayList<Employee> sortedEmployee = employee.stream()
                .sorted(compareByDepartment)
                .collect(Collectors.toCollection(ArrayList::new));
        for (Employee e : sortedEmployee) {
            System.out.println("Отдел № " + e.getDepartment() + ", Ф.И.О.: " + e.getEmployee() + ", ");
        }
    }

    public void printInfoAboutEmployees() { // Получить список всех сотрудников со всеми имеющимися по ним данными
        for (Employee employee : employees) {
            if (employee == null) {
                break;
            }
            System.out.println(employee);
        }
    }

    public double calculateSumSalary() { // Посчитать сумму затрат на зарплаты в месяц.
        double sum = 0;
        for (Employee employee : employees) {
            if (employee == null) {
                break;
            }
            sum = sum + employee.getSalary();
        }
        return sum;
    }

    public void printSumSalary() {
        System.out.println("Сумма затрат на зарплаты в месяц: " + calculateSumSalary()); // Вывод суммы затрат на зарплаты в месяц
    }

    public void calculateAndPrintMinSalary() { //Найти сотрудника с минимальной зарплатой
        double minSalary = employees[0].getSalary();
        int tempId = 0; //переменная для записи порядкого номера работника с минимальной зарплатой
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                break;
            }
            if (minSalary > employees[i].getSalary()) {
                minSalary = employees[i].getSalary();
                tempId = i;
            }
        }
        System.out.println("Сотрудник с минимальной зарплатой: " + employees[tempId]);
    }

    public void calculateAndPrintMaxSalary() { //Найти сотрудника с максимальной зарплатой
        double maxSalary = employees[0].getSalary();
        int tempId = 0; //переменная для записи порядкого номера работника с максимальной зарплатой
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                break;
            }
            if (maxSalary < employees[i].getSalary()) {
                maxSalary = employees[i].getSalary();
                tempId = i;
            }
        }
        System.out.println("Сотрудник с максимальной зарплатой: " + employees[tempId]);
    }

    public void calculateAndPrintMiddleSalary() { //Подсчитать среднее значение зарплат
        double sum = calculateSumSalary(); // переменная для передачи значения sum из метода calculateSumSalary
        double midSalary = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                break;
            }
            midSalary = sum / (i + 1);
        }
        System.out.printf("Среднее значение зарплаты: %.2f\n", midSalary);
    }

    public void printEmployees() { //Получить Ф. И. О. всех сотрудников (вывести в консоль)
        for (Employee employee : employees) {
            if (employee == null) {
                break;
            }
            System.out.printf("%s, ", employee.getEmployee());
        }
    }

    public void indexingOfSalaries(double percent) { //Проиндексировать зарплату (вызвать изменение зарплат у всех сотрудников на величину аргумента в %)
        for (Employee employee : employees) {
            if (employee == null) {
                break;
            }
            double indexingSalaries = employee.getSalary();
            indexingSalaries += employee.getSalary() * percent / 100;
            employee.setSalary(indexingSalaries);
            System.out.printf("Проиндексированная зарплата id: %s - %.2f\n", employee.getId(), employee.getSalary());
        }

    }

    public void calculateAndPrintMinSalaryAtDepartment(String department) { // Получить в качестве параметра номер отдела (1–5) и найти сотрудника с минимальной зарплатой
        double minSalaryAtDepartment = employees[0].getSalary();
        int tempId = 0; //переменная для записи порядкого номера работника с минимальной зарплатой
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                break;
            }
            if (employees[i].getDepartment().equals(department)) {
                if (minSalaryAtDepartment > employees[i].getSalary()) {
                    minSalaryAtDepartment = employees[i].getSalary();
                    tempId = i;
                }
            }
        }
        System.out.println("Сотрудник с минимальной зарплатой по отделу " + department + ": " + employees[tempId]);
    }

    public void calculateAndPrintMaxSalaryAtDepartment(String department) { //Получить в качестве параметра номер отдела (1–5) и найти сотрудника с максимальной зарплатой
        double maxSalaryAtDepartment = 0;
        int tempId = 0; //переменная для записи порядкого номера работника с максимальной зарплатой
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                break;
            }
            if (employees[i].getDepartment().equals(department)) {
                if (maxSalaryAtDepartment < employees[i].getSalary()) {
                    maxSalaryAtDepartment = employees[i].getSalary();
                    tempId = i;
                }
            }
        }
        System.out.printf("Сотрудник с максимальной зарплатой по отделу " + department + ": " + employees[tempId] + "\n");
    }

    public void calculateAndPrintSumSalaryAtDepartment(String department) { //Получить в качестве параметра номер отдела (1–5) и найти сумму затрат на зарплату по отделу
        double sum = 0;
        for (Employee employee : employees) {
            if (employee == null) {
                break;
            }
            if (employee.getDepartment().equals(department)) {
                sum += employee.getSalary();
            }
        }
        System.out.printf("Сумма затрат на зарплату по отделу № %s: %.2f\n", department, sum);
    }

    public void calculateAndPrintMiddleSalaryAtDepartment(String department) { // cреднюю зарплату по отделу
        double middleSalary;
        double sum = 0;
        int employeesAtDepartment = 0; //переменная для учета количества сотрудников в отделе
        for (Employee employee : employees) {
            if (employee == null) {
                break;
            }
            if (employee.getDepartment().equals(department)) {
                employeesAtDepartment++;
                sum += employee.getSalary();
            }
        }
        middleSalary = sum / employeesAtDepartment;
        System.out.printf("Средняя зарплату по отделу № %s: %.2f\n", department, middleSalary);
    }

    public void indexingOfSalariesAtDepartment(String depatment, double percent) { //Проиндексировать зарплату всех сотрудников отдела на процент, который приходит в качестве параметра
        for (Employee employee : employees) {
            if (employee == null) {
                break;
            }
            if (employee.getDepartment().equals(depatment)) {
                double indexingSalaries = employee.getSalary();
                indexingSalaries += employee.getSalary() * percent / 100;
                employee.setSalary(indexingSalaries);
                System.out.printf("Проиндексированная зарплата всех сотрудников отдела № %s id: %s - %.2f\n", employee.getDepartment(), employee.getId(), employee.getSalary());
            }
        }
    }

    public void printEmployeesAtDepartment(String department) { //Напечатать всех сотрудников отдела (все данные, кроме отдела)
        for (Employee employee : employees) {
            if (employee == null) {
                break;
            }
            if (employee.getDepartment().equals(department)) {
                System.out.println(employee.getId() + " " + employee.getEmployee() + " " + employee.getSalary());
            }
        }
    }

    public void findAndPrintSalaryEmployeeLessThan(double salary) { // Всех сотрудников с зарплатой меньше числа (вывести id, Ф. И. О. и зарплатой в консоль)
        for (Employee employee : employees) {
            if (employee == null) {
                break;
            }
            if (employee.getSalary() < salary) {
                System.out.println("Сотрудники с зарплатой меньше числа " + salary + ": " + employee.getId() + ", " + employee.getEmployee() + ", " + employee.getSalary());
            }
        }
    }

    public void findAndPrintSalaryEmployeeMoreThan(double salary) { // Всех сотрудников с зарплатой больше (или равно) числа (вывести id, Ф. И. О. и зарплатой в консоль)
        for (Employee employee : employees) {
            if (employee == null) {
                break;
            }
            if (employee.getSalary() > salary) {
                System.out.println("Сотрудники с зарплатой больше числа " + salary + ": " + employee.getId() + ", " + employee.getEmployee() + ", " + employee.getSalary());
            }
        }
    }
}

