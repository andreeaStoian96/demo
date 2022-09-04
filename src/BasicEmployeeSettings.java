

import java.util.List;

public interface BasicEmployeeSettings {
     void addEmployee(List<Employee> employeeList, Employee employee);

    void viewEmployee(List<Employee> employeeList, String email);

    void deleteEmployee(List<Employee> employeeList, String email);

    void alterEmployee(List<Employee> employeeList, Employee newEmployee);
}
