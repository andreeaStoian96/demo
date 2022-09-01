import org.omg.CosNaming.NamingContextPackage.NotFound;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class Application extends BasicEmployeeSettingsImp {

    private static List<Employee> employeeList = new ArrayList<>();

    private static BasicEmployeeSettingsImp basicEmployeeSettingsImp = new BasicEmployeeSettingsImp();


    public static void main(String[] args) throws ParseException, NotFound {
//        final AtomicInteger count = new AtomicInteger(1);
//        int id = count.incrementAndGet();
//       private String firstName;
//        String lastName;
//        int age;
//        String email;
//        Date employmentDate;
//        Date employeeResignDate = null;
//        String function;
//        boolean isManager;
//        String managerName;
//        double salary;


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
                            oldEmp.setManager(input.next().equalsIgnoreCase("y") ? true : false);
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
                            System.out.println("Enter employee resign date using yhe following pattern: dd/mm/yyyy");
                            oldEmp.setEmployeeResignDate(new SimpleDateFormat("dd/MM/yyyy").parse(input.next()));
                            break;
                        default:
                            System.out.println("Enter a correct choice from the list!");
                            break;

                    }
                    basicEmployeeSettingsImp.alterEmployee(employeeList, newEmployee);
                    break;
                case 5:
                    do {
                        int filter = 0;
                        System.out.println("Choose from the filter:\n"
                                + "1.First 10 employees in terms of seniority in the company\n"
                                + "2.First 10 employees with the biggest salary\n"
                                + "3.the employees that have resign in certain year and month\n"
                                + "4.List of employees in the last (enter the numbers of months)");
                        filter = input.nextInt();
                        switch (filter) {
                            case 1:
                                employeeList.sort(Comparator.comparing(Employee::getEmploymentDate));
                                abstract class YearsOfWorkComparator implements Comparator {
                                    public int compare(Employee e1, Employee e2) {
                                        return e1.getEmploymentDate().compareTo(e2.getEmploymentDate());
                                    }

                                }
                                for (Employee emp2 : employeeList) {
                                    System.out.println(emp2);
                                }
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
        System.out.println("Enter employment date of employee using the following pattern: dd/MM/yyyy");
        employee.setEmploymentDate(new SimpleDateFormat("dd/MM/yyyy").parse(input.next()));
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


//    private static String modifyEmployee() throws ParseException {
//
//        int j = 0;
//        for (Employee e : employeeList) {
//            if (e.getEmail().equals(verEmail) {
//                j++;
//                do {
//                    int change = 0;
//                    System.out.println("Modify employee details:\n"
//                            + "1.First name\n"
//                            + "2.Last name\n"
//                            + "3.Age\n"
//                            + "4.Email\n"
//                            + "5.Function\n"
//                            + "6.Is employee manager?\n"
//                            + "7.Manager name\n"
//                            + "8.Salary\n"
//                            + "9.resign date"
//                            + "10.Go back\n");
//
//                    System.out.println("Enter your choice:");
//                    change = input.nextInt();
//                    switch (change) {
//                        case 1:
//                            System.out.println("Enter new first name for the employee:");
//                            e.setFirstName(input.next());
//                            System.out.println(e + "\n");
//                            break;
//                        case 2:
//                            System.out.println("Enter new last name for employee:");
//                            e.setLastName(input.next());
//                            System.out.println(e + "\n");
//                            break;
//                        case 3:
//                            System.out.println("Enter the age of the employee:");
//                            e.setAge(input.nextInt());
//                            System.out.println(e + "\n");
//                            break;
//                        case 4:
//                            System.out.println("Enter the new email address for the employee:");
//                            e.setEmail(input.next());
//                            System.out.println(e + "\n");
//                            break;
//                        case 5:
//                            System.out.println("Enter the new function of the employee:");
//                            e.setFunction(input.next());
//                            System.out.println(e + "\n");
//                            break;
//                        case 6:
//                            System.out.println("Has the employee became a manager? y/n ");
//                            e.setManager(input.next().equalsIgnoreCase("y") ? true : false);
//                            System.out.println(e + "\n");
//                            break;
//                        case 7:
//                            System.out.println("Enter new manager name:");
//                            e.setManagerName(input.next());
//                            System.out.println(e + "\n");
//                            break;
//                        case 8:
//                            System.out.println("Enter the new salary for employee:");
//                            e.setSalary(input.nextDouble());
//                            System.out.println(e + "\n");
//                            break;
//                        case 9:
//                            System.out.println("Enter employee resign date using yhe following pattern: dd/mm/yyyy");
//                            e.setEmployeeResignDate(new SimpleDateFormat("dd/MM/yyyy").parse(input.next()));
//                            System.out.println(e + "\n");
//                            break;
//                        case 10:
//                            j++;
//                            break;
//                        default:
//                            System.out.println("Enter a correct choice from the list!");
//                            break;
//
//                    }
//
//                } while (j == 1);
//            }
//        }
//        if (j == 0) {
//            System.out.println("Employees details are not available!");
//        }
//        return modifyEmployee();
//    }
}

