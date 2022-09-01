
import java.util.List;
import java.util.function.Predicate;


public class BasicEmployeeSettingsImp implements BasicEmployeeSettings {
    @Override
    public void addEmployee(List<Employee> employeeList, Employee employee) {
        employeeList.add(employee);
    }

    @Override
    public void viewEmployee(List<Employee> employeeList, String verEmail) {
       Employee employee = getEmployeeByEmail(employeeList, verEmail);
        System.out.println(employee);

    }

    @Override
    public void deleteEmployee(List<Employee> employeeList, String verEmail) {
        Predicate<Employee> condition = employee -> (employee.getEmail().equals(verEmail));
        employeeList.removeIf(condition);
        System.out.println("Employee deleted!");
    }

    @Override
    public void alterEmployee(List<Employee> employeeList, Employee newEmployee) {
        for (Employee oldEmp: employeeList) {
            if(oldEmp.getId() == (newEmployee.getId())){
                oldEmp = newEmployee;
                int index =  employeeList.indexOf(oldEmp);
                employeeList.set(index, newEmployee);
            }
        }
        System.out.println(newEmployee);
        // oldEmp = cauta in emlList angajatul care are id-ul = newEmployee.getId()
        // oldEmp = newEmp
        // vezi cum salvezi newEmp in locul lui oldEmp

//        int j = 0;
//        for (Employee e : employeeList) {
//            if (e.getEmail().equals(verEmail)) {
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
    }

    static  Employee getEmployeeByEmail(List<Employee> employeeList, String verEmail)  {
        // fa logica
        Employee searchedEmployee = null;
        for (Employee employee : employeeList) {
            if (employee.getEmail().equals(verEmail)) {
                searchedEmployee = employee;
                break;
            }
        }
        if(searchedEmployee == null){
         throw new RuntimeException(String.format("No employee found for email: %s", verEmail));
        }
        return searchedEmployee;
    }
}

    // in aplicatie:
    // ai metoda getEmpByEmail
    // oldEmp = getEmpByEmail
    // ai swithc case ca sa afli ce vrei sa modifici
    //ex: email: oldEmp.setEmail(newEmail)
    //ex2: firstName: oldEmp.setFirstName(new firstName) ...
    // dupa ce termini de modificat atributele angajatului, apelezi alterEmployee(empList, newEmp)

