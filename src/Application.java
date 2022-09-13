import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class Application extends BasicEmployeeSettingsImp {
    private static List<Employee> employeeList = new ArrayList<>();
    private static BasicEmployeeSettingsImp basicEmployeeSettingsImp = new BasicEmployeeSettingsImp();
    private static FiltersImp filtersImp = new FiltersImp();

    public static void main(String[] args) throws ParseException {

        addInitialEmployees();
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("Press: \n"
                    + "1 for add employee"
                    + "\n2 for view employee "
                    + "\n3 for delete employee "
                    + "\n4 for alter employee"
                    + "\n5 for filters"
                    + "\n6 for exiting the program ");
            int inp = input.nextInt();
            switch (inp) {
                case 1:
                    basicEmployeeSettingsImp.addEmployee(employeeList, createEmployee());
                    break;
                case 2:
                    System.out.println("Enter the email for the person you want to search:");
                    String verEmail = input.next();
                    basicEmployeeSettingsImp.viewEmployee(employeeList, verEmail);
                    break;
                case 3:
                    System.out.println("Enter the email of the person you want to delete!");
                    verEmail = input.next();
                    basicEmployeeSettingsImp.deleteEmployee(employeeList, verEmail);
                    break;
                case 4:
                    System.out.println("Enter the employee email you want to modify:");
                    verEmail = input.next();
                    Employee oldEmp = getEmployeeByEmail(employeeList, verEmail);
                    Employee newEmployee = oldEmp;
                    System.out.println("Modify employee details:\n"
                            + "1.First name\n"
                            + "2.Last name\n"
                            + "3.Age\n"
                            + "4.Email\n"
                            + "5.Function\n"
                            + "6.Is employee manager?\n"
                            + "7.Manager name\n"
                            + "8.Salary\n"
                            + "9.resign date");

                    System.out.println("Enter your choice:");
                    int change = input.nextInt();
                    switch (change) {
                        case 1:
                            System.out.println("Enter new first name for the employee:");
                            oldEmp.setFirstName(input.next());
                            break;
                        case 2:
                            System.out.println("Enter new last name for employee:");
                            oldEmp.setLastName(input.next());
                            break;
                        case 3:
                            System.out.println("Enter the age of the employee:");
                            oldEmp.setAge(input.nextInt());
                            break;
                        case 4:
                            System.out.println("Enter the new email address for the employee:");
                            oldEmp.setEmail(input.next());
                            break;
                        case 5:
                            System.out.println("Enter the new function of the employee:");
                            oldEmp.setFunction(input.next());
                            break;
                        case 6:
                            System.out.println("Has the employee became a manager? y/n ");
                            oldEmp.setManager(input.next().equalsIgnoreCase("y"));
                            break;
                        case 7:
                            System.out.println("Enter new manager name:");
                            oldEmp.setManagerName(input.next());
                            break;
                        case 8:
                            System.out.println("Enter the new salary for employee:");
                            oldEmp.setSalary(input.nextDouble());
                            break;
                        case 9:
                            System.out.println("Enter employee resign date using the following pattern: yyyy-mm-dd");
                            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-mm-dd");
                            oldEmp.setEmployeeResignDate(LocalDate.parse(input.next()));
                            break;
                        default:
                            System.out.println("Enter a correct choice from the list!");
                            break;
                    }
                    basicEmployeeSettingsImp.alterEmployee(employeeList, newEmployee);
                    break;
                case 5:
                    do {
                        System.out.println("Choose from the filter:\n"
                                + "1.First 10 employees in terms of seniority in the company\n"
                                + "2.First 5 employees with the biggest salary\n"
                                + "3.The employees that have resign in certain year and month\n"
                                + "4.List of employees in the last (enter the numbers of months)\n"
                                + "5.Employee with the maximum salary\n"
                                + "6.Employee with the minimum salary\n");
                        int filter = input.nextInt();
                        switch (filter) {
                            case 1:
                                List<Employee> employees = filtersImp.getFirstTenEmployeesWithSeniority(employeeList);
                                employees.forEach(employee -> System.out.println(employee));
                                break;
                            case 2:
                                List<Employee> employeesTwo = filtersImp.getFirstFiveEmployeeWithTheBestSalary(employeeList);
                                employeesTwo.forEach(employee -> System.out.println(employee));
                                break;
                            case 3:
                                System.out.println("Enter month as integer(0-january.....11-december)!");
                                int month = input.nextInt();
                                System.out.println("Enter year as integer!");
                                int year = input.nextInt();
                                List<Employee> employeesThree = filtersImp.getEmployeesWhoResignByMonthAndYear(employeeList, month, year);

                                employeesThree.forEach(employee -> System.out.println(employee));
                                break;
                            case 4:
                                System.out.println("Enter how many months!");
                                int months = input.nextInt();
                                List<Employee> filteredEmployees = filtersImp.getListOfEmployeesInTheLastXMonths(employeeList, months);
                                filteredEmployees.forEach(employee -> System.out.println(employee));
                            case 5:
                                Optional<Employee> filterFive = filtersImp.getEmployeeWithMaximumSalary(employeeList);
                                System.out.println(filterFive);
                            case 6:
                                Optional<Employee> filterSix = filtersImp.getEmployeeWithMinimumSalary(employeeList);
                                System.out.println(filterSix);
                        }
                    } while (input.nextInt() != 5);
                case 6:
                    System.out.println("You have choose to exit!");
                    break;
            }
        } while (input.nextInt() != 6);
    }

    private static Employee createEmployee() throws ParseException {
        Employee employee = new Employee();
        Scanner input = new Scanner(System.in);

        System.out.println("Enter employee first name: ");
        employee.setFirstName(input.next());
        System.out.println("Enter employee last name: ");
        employee.setLastName(input.next());
        System.out.println("Enter employee age: ");
        employee.setAge(input.nextInt());
        System.out.println("Enter employee email:");
        employee.setEmail(input.next());
        System.out.println("Enter employment date of employee using the following pattern: yyyy-mm-dd");
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-mm-dd");
        employee.setEmploymentDate(LocalDate.parse(input.next()));
        System.out.println("Enter employee function:");
        employee.setFunction(input.next());
        System.out.println("Is the employee manager? y/n");
        employee.setManager(input.next().equalsIgnoreCase("y") ? true : false);
        System.out.println(employee.isManager());
        System.out.println("Enter manager name:");
        employee.setManagerName(input.next());
        System.out.println("Enter employee salary:");
        employee.setSalary(input.nextDouble());
        return employee;
    }

    private static void addInitialEmployees() {
        Employee emp1 = new Employee(1, "Maria", "Ion", 29, "mariaion@yahoo.com", LocalDate.of(2009, 12, 11), null, "developer", true, "Ion", 5999.0);
        Employee emp2 = new Employee(2, "Mioara", "Ian", 39, "mioaraian@gmail.com",
                LocalDate.parse("2009-12-23"), LocalDate.parse("2010-02-12"), "HR", false, "Andreea", 2599.0);
        Employee emp3 = new Employee(3, "Alex", "Maghe", 40, "alexmaghe@gmail.com",
                LocalDate.parse("2010-11-13"), null, "developer", false, "Ion", 3999.0);
        Employee emp4 = new Employee(4, "Alina", "Vagner", 30, "alinavagner@yahoo.com",
                LocalDate.parse("2017-12-12"), null, "developer", false, "Ion", 2299.0);
        Employee emp5 = new Employee(5, "Marian", "Stenea", 59, "marianstenea@yahoo.com",
                LocalDate.parse("2010-12-11"), null, "developer", true, "Stenea", 5999.0);
        Employee emp6 = new Employee(6, "Ionut", "Alunu", 29, "ionutalunu@yahoo.com",
                LocalDate.parse("2020-10-15"), null, "developer", false, "Stenea", 3999.0);
        Employee emp7 = new Employee(7, "Alin", "Aba", 49, "alinaba@yahoo.com",
                LocalDate.parse("2016-10-16"), null, "developer", false, "Stenea", 3999.0);
        Employee emp8 = new Employee(8, "Adina", "Simo", 25, "adinasimo@yahoo.com",
                LocalDate.parse("2020-11-24"), null, "developer", false, "Ion", 2000.0);
        Employee emp9 = new Employee(9, "Andrei", "Mihai", 43, "andreimihai@yahoo.com",
                LocalDate.parse("2020-12-29"), null, "developer", false, "Ion", 2533.0);
        Employee emp10 = new Employee(10, "Diana", "Posa", 34, "dianaposa@yahoo.com",
                LocalDate.parse("2022-09-02"), null, "developer", false, "Ion", 3525.0);
        Employee emp11 = new Employee(11, "Vlad", "Vasile", 32, "vladvasile@yahoo.com",
                LocalDate.parse("2016-06-03"), null, "developer", false, "Stenea", 3423.0);
        employeeList.addAll(Arrays.asList(emp1, emp2, emp3, emp4, emp5, emp6, emp7, emp8, emp9, emp10, emp11));
    }


}

