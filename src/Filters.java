import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface Filters {
    List<Employee> getFirstTenEmployeesWithSeniority(List<Employee> employeeList);

    List<Employee> getFirstFiveEmployeeWithTheBestSalary(List<Employee> employeeList);

    List<Employee> getEmployeesWhoResignByMonthAndYear(List<Employee> employeeList, Integer month, Integer year);

    List<Employee> getListOfEmployeesInTheLastXMonths(List<Employee> employeeList, Integer months);

    Optional<Employee> getEmployeeWithMaximumSalary(List<Employee> employeeList);

    Optional<Employee> getEmployeeWithMinimumSalary(List<Employee> employeeList);

    Set<String> getManagers(List<Employee> employeeList);

    List<Employee> getManagersAndEmployees(List<Employee> employeeList);

}
