public class Coursework {

    static Employee[] employees = new Employee[10];
    static int id = Employee.id();


    public static void printInfoAboutEmployees(Employee[] employees) {
        for (id = 0; id < employees.length; id++) {
            if (employees[id] == null) {
                break;
            }
            System.out.println(employees[id]);
        }
    }

    public static double calculateSumSalary(Employee[] employees) {
        double sum = 0;
        for (id = 0; id < employees.length; id++) {
            if (employees[id] == null) {
                break;
            }
            sum = sum + employees[id].getSalary();
        }
        return sum;
    }

    public static void printSumSalary() {
        System.out.println("Сумма затрат на зарплаты в месяц: " + calculateSumSalary(employees));
    }

    public static void calculateAndPrintMinSalary(Employee[] employees) {
        double minSalary = employees[0].getSalary();
        int tempId = 0; //переменная для записи порядкого номера работника с минимальной зарплатой
        for (id = 0; id < employees.length; id++) {
            if (employees[id] == null) {
                break;
            }
            if (minSalary > employees[id].getSalary()) {
                minSalary = employees[id].getSalary();
                tempId = id;
            }
        }
        System.out.println("Сотрудник с минимальной зарплатой: " + employees[tempId]);
    }

    public static void calculateAndPrintMaxSalary(Employee[] employees) {
        double maxSalary = employees[0].getSalary();
        int tempId = 0; //переменная для записи порядкого номера работника с максимальной зарплатой
        for (id = 0; id < employees.length; id++) {
            if (employees[id] == null) {
                break;
            }
            if (maxSalary < employees[id].getSalary()) {
                maxSalary = employees[id].getSalary();
                tempId = id;
            }
        }
        System.out.println("Сотрудник с максимальной зарплатой: " + employees[tempId]);
    }

    public static void calculateAndPrintMiddleSalary(Employee[] employees) {
        double sum = calculateSumSalary(employees); // переменная для передачи значения sum из метода calculateSumSalary
        double midSalary = 0;
        for (id = 0; id < employees.length; id++) {
            if (employees[id] == null) {
                break;
            }
            midSalary = sum / (id + 1);
        }
        System.out.printf("Среднее значение зарплаты: %.2f\n", midSalary);
    }

    public static void printEmployees(Employee[] employees) {
        for (id = 0; id < employees.length; id++) {
            if (employees[id] == null) {
                break;
            }
            System.out.printf("%s, ", employees[id].getEmployee());
        }
        System.out.println();
    }

    public static void indexingOfSalaries(double percent) {
        for (id = 0; id < employees.length; id++) {
            if (employees[id] == null) {
                break;
            }
            double indexingSalaries = employees[id].getSalary();
            indexingSalaries += employees[id].getSalary() * percent / 100;
            employees[id].setSalary(indexingSalaries);
            System.out.printf("Проиндексированная зарплата id: %s - %.2f\n", id, employees[id].getSalary());
        }

    }

    public static void calculateAndPrintMinSalaryAtDepartment(String department) {
        double minSalaryAtDepartment = employees[0].getSalary();
        int tempId = 0; //переменная для записи порядкого номера работника с минимальной зарплатой
        for (id = 0; id < employees.length; id++) {
            if (employees[id] == null) {
                break;
            }
            if (employees[id].getDepartment().equals(department)) {
                if (minSalaryAtDepartment > employees[id].getSalary()) {
                    minSalaryAtDepartment = employees[id].getSalary();
                    tempId = id;
                }
            }
        }
        System.out.println("Сотрудник с минимальной зарплатой по отделу " + department + ": " + employees[tempId]);
    }

    public static void calculateAndPrintMaxSalaryAtDepartment(String department) {
        double maxSalaryAtDepartment = 0;
        int tempId = 0; //переменная для записи порядкого номера работника с максимальной зарплатой
        for (id = 0; id < employees.length; id++) {
            if (employees[id] == null) {
                break;
            }
            if (employees[id].getDepartment().equals(department)) {
                if (maxSalaryAtDepartment < employees[id].getSalary()) {
                    maxSalaryAtDepartment = employees[id].getSalary();
                    tempId = id;
                }
            }
        }
        System.out.printf("Сотрудник с максимальной зарплатой по отделу " + department + ": " + employees[tempId] + "\n");
    }

    public static void calculateAndPrintSumSalaryAtDepartment(String department) {
        double sum = 0;
        for (id = 0; id < employees.length; id++) {
            if (employees[id] == null) {
                break;
            }
            if (employees[id].getDepartment().equals(department)) {
                sum += employees[id].getSalary();
            }
        }
        System.out.printf("Сумма затрат на зарплату по отделу № %s: %.2f\n", department, sum);
    }

    public static void calculateAndPrintMiddleSalaryAtDepartment(String department) {
        double middleSalary;
        double sum = 0;
        int employeesAtDepartment = 0; //переменная для учета количества сотрудников в отделе
        for (id = 0; id < employees.length; id++) {
            if (employees[id] == null) {
                break;
            }
            if (employees[id].getDepartment().equals(department)) {
                employeesAtDepartment++;
                sum += employees[id].getSalary();
            }
        }
        middleSalary = sum / employeesAtDepartment;
        System.out.printf("Средняя зарплату по отделу № %s: %.2f\n", department, middleSalary);
    }

    public static void printEmployeesAtDepartment(String department) {
        for (id = 0; id < employees.length; id++) {
            if (employees[id] == null) {
                break;
            }
            if (employees[id].getDepartment().equals(department)) {
                System.out.println(employees[id].getId() + " " + employees[id].getEmployee() + " " + employees[id].getSalary());
            }
        }
    }

    public static void findAndPrintSalaryEmployeeLessThan(double salary) {
        for (id = 0; id < employees.length; id++) {
            if (employees[id] == null) {
               break;
            }
            if (employees[id].getSalary() < salary) {
                System.out.println("Сотрудники с зарплатой меньше числа " + salary + ": " + employees[id].getId() + ", " + employees[id].getEmployee() + ", " + employees[id].getSalary());
            }
        }
    }

    public static void findAndPrintSalaryEmployeeMoreThan(double salary) {
        for (id = 0; id < employees.length; id++) {
            if (employees[id] == null) {
                break;
            }
            if (employees[id].getSalary() > salary) {
                System.out.println("Сотрудники с зарплатой больше числа " + salary + ": " + employees[id].getId() + ", " + employees[id].getEmployee() + ", " + employees[id].getSalary());
            }
        }
    }

    public static void main(String[] args) {

        employees[0] = new Employee("Иванов Иван Иванович", "1", 165987.45);
        employees[1] = new Employee("Петров Петр Петрович", "2", 73490.99);
        employees[2] = new Employee("Сидоров Сидор Сидорович", "3", 32521.15);
        employees[3] = new Employee("Абрамов Абрам Абрамович", "4", 19823.99);
        employees[4] = new Employee("Александров Александр Александрович", "5", 99999.99);
        employees[5] = new Employee("Артемов Артем Артемович", "5", 77569.99);
        employees[6] = new Employee("Трусов Балбес Бывалович", "5", 115369.27);
        employees[7] = new Employee("Андреев Андрей Андреевич", "1", 47853.15);
        employees[8] = new Employee("Михеев Михей Михеевич", "2", 66324.81);
        //employees[9] = new Employee("Петров Петр Петрович", "2", 99999.99);
        printInfoAboutEmployees(employees);
        printSumSalary();
        calculateAndPrintMinSalary(employees);
        calculateAndPrintMaxSalary(employees);
        calculateAndPrintMiddleSalary(employees);
        printEmployees(employees);
        indexingOfSalaries(4.0);
        calculateAndPrintMinSalaryAtDepartment("1");
        calculateAndPrintMaxSalaryAtDepartment("1");
        calculateAndPrintSumSalaryAtDepartment("1");
        calculateAndPrintMiddleSalaryAtDepartment("5");
        printEmployeesAtDepartment("5");
        findAndPrintSalaryEmployeeLessThan(100000.00);
        findAndPrintSalaryEmployeeMoreThan(100000.00);
    }
}