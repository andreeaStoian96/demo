import java.util.List;

public interface Filters {
    List<Employee> getFirstTenEmployeesWithSeniority(List<Employee> employeeList);
 List<Employee> getFirstFiveEmployeeWithTheBestSalary(List<Employee> employeeList);
    List<Employee> getEmployeesWhoResign(List<Employee> employeeList);
    void getListOfEmployeesInTheLastXMonths();
    void getEmployeeWithMaximumSalary();
    void getEmployeeWithMinimumSalary();

}
