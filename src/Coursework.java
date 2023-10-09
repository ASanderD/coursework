
public class Coursework {


    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();

        //добавление новых сотрудников

        employeeBook.addEmployee("Иванов Иван Иванович", "1", 40.0);
        employeeBook.addEmployee("Петров Петр Петрович", "2", 69.0);
        employeeBook.addEmployee("Сидоров Сидор Сидорович", "3", 35.0);
        employeeBook.addEmployee("Абрамов Абрам Абрамович", "4", 19.0);
        employeeBook.addEmployee("Александров Александр Александрович", "5", 1000.0);
        employeeBook.addEmployee("Артемов Артем Артемович", "5", 18.0);
        employeeBook.addEmployee("Трусов Балбес Бывалович", "5", 13.0);
        employeeBook.addEmployee("Андреев Андрей Андреевич", "1", 100.0);
        employeeBook.addEmployee("Михеев Михей Михеевич", "2", 15.0);
        employeeBook.addEmployee("Васильев Василий Васильевич", "2", 10.0);

        //вызов методов по заданию

        employeeBook.printInfoAboutEmployees();

        employeeBook.printSumSalary();

        employeeBook.calculateAndPrintMinSalary();

        employeeBook.calculateAndPrintMaxSalary();

        employeeBook.calculateAndPrintMiddleSalary();

        employeeBook.printEmployees();
        System.out.println();
        employeeBook.indexingOfSalaries(4.0);

        employeeBook.calculateAndPrintMinSalaryAtDepartment("5");

        employeeBook.calculateAndPrintMaxSalaryAtDepartment("1");

        employeeBook.calculateAndPrintSumSalaryAtDepartment("1");

        employeeBook.calculateAndPrintMiddleSalaryAtDepartment("5");

        employeeBook.indexingOfSalariesAtDepartment("3", 10);

        employeeBook.printEmployeesAtDepartment("5");

        employeeBook.findAndPrintSalaryEmployeeLessThan(50.00);

        employeeBook.findAndPrintSalaryEmployeeMoreThan(50.00);

        employeeBook.removeEmployee("Александров Александр Александрович");

        employeeBook.changeSalaryEmployee("Иванов Иван Иванович", 100000);

        employeeBook.changeSalaryDepartment("Иванов Иван Иванович", "4");

        System.out.println();

        employeeBook.printInfoAboutEmployeeOfDepartments();
    }
}