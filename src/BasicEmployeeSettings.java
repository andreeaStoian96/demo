import org.omg.CosNaming.NamingContextPackage.NotFound;

import java.util.List;

public interface BasicEmployeeSettings {public void addEmployee(List<Employee> employeeList, Employee employee);
    public void viewEmployee(List<Employee> employeeList, String email) throws NotFound;
    public void deleteEmployee(List<Employee> employeeList, String email);
    public void alterEmployee(List<Employee> employeeList, Employee newEmployee);


}
