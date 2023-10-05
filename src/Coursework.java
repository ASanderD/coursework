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
            sum = sum + (employees[id].getSalary());
        }
        return sum;
    }

    public static void printSumSalary() {
        System.out.println("Сумма затрат на зарплаты в месяц: " + calculateSumSalary(employees));
    }

    public static void printMinSalary(Employee[] employees) {
        double minSalary = employees[0].getSalary();
        int tempId = 0; //переменная для записи порядкого номера работника с минимальной зарплатой
        for (id = 0; id < employees.length; id++) {
            if (employees[id] == null) {
                break;
            }
            if (minSalary>employees[id].getSalary()) {
                minSalary = employees[id].getSalary();
                tempId = id;
            }
        }
        System.out.println("Сотрудник с минимальной зарплатой: " + employees[tempId]);
    }

    public static void printMaxSalary(Employee[] employees) {
        double maxSalary = employees[0].getSalary();
        int tempId = 0; //переменная для записи порядкого номера работника с максимальной зарплатой
        for (id = 0; id < employees.length; id++) {
            if (employees[id] == null) {
                break;
            }
            if (maxSalary<employees[id].getSalary()) {
                maxSalary = employees[id].getSalary();
                tempId = id;
            }
        }
        System.out.println("Сотрудник с максимальной зарплатой: " + employees[tempId]);
    }

    public static void printMiddleSalary(Employee[] employees) {
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
            System.out.println(employees[id].getEmployee());
        }
    }

    public static void main(String[] args) {

        employees[0] = new Employee("Иванов Иван Иванович", "1", 165987.45);
        employees[1] = new Employee("Петров Петр Петрович", "2", 73490.99);
        employees[2] = new Employee("Сидоров Сидор Сидорович", "3", 32521.15);
        employees[3] = new Employee("Абрамов Абрам Абрамович", "2", 19823.99);
        employees[4] = new Employee("Александров Александр Александрович", "2", 99999.99);
        /*employees[5] = new Employee("Петров Петр Петрович", "2", 99999.99);
        employees[6] = new Employee("Петров Петр Петрович", "2", 99999.99);
        employees[7] = new Employee("Петров Петр Петрович", "2", 99999.99);
        employees[8] = new Employee("Петров Петр Петрович", "2", 99999.99);
        employees[9] = new Employee("Петров Петр Петрович", "2", 99999.99);*/
        printInfoAboutEmployees(employees);
        printSumSalary();
        printMinSalary(employees);
        printMaxSalary(employees);
        printMiddleSalary(employees);
        printEmployees(employees);
    }
}