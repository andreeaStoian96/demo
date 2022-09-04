
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;


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
        for (Employee oldEmp : employeeList) {
            if (oldEmp.getId() == (newEmployee.getId())) {
                oldEmp = newEmployee;
                int index = employeeList.indexOf(oldEmp);
                employeeList.set(index, newEmployee);
                break;
            }
        }
        System.out.println(newEmployee);
        // oldEmp = cauta in emlList angajatul care are id-ul = newEmployee.getId()
        // oldEmp = newEmp
        // vezi cum salvezi newEmp in locul lui oldEmp

    }

    static Employee getEmployeeByEmail(List<Employee> employeeList, String verEmail) {
        Optional<Employee> employee = Optional.ofNullable(employeeList.stream().filter(employee1 -> employee1.getEmail().equalsIgnoreCase(verEmail)).collect(Collectors.toList()).get(0));
        if(employee.isPresent()) {
            return employee.get();
        }
        throw new RuntimeException(String.format("No employee found for email: %s", verEmail));
        // fa logica
//        Employee searchedEmployee = null;
//        for (Employee employee : employeeList) {
//            if (employee.getEmail().equals(verEmail)) {
//                searchedEmployee = employee;
//                break;
//            }
//        }
//        if(searchedEmployee == null){
//         throw new RuntimeException(String.format("No employee found for email: %s", verEmail));
//        }
//        return searchedEmployee;
    }
}

// in aplicatie:
// ai metoda getEmpByEmail
// oldEmp = getEmpByEmail
// ai swithc case ca sa afli ce vrei sa modifici
//ex: email: oldEmp.setEmail(newEmail)
//ex2: firstName: oldEmp.setFirstName(new firstName) ...
// dupa ce termini de modificat atributele angajatului, apelezi alterEmployee(empList, newEmp)

