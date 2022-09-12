import java.time.Month;
import java.time.Year;
import java.util.Date;
import java.util.List;

public interface Filters {
    List<Employee> getFirstTenEmployeesWithSeniority(List<Employee> employeeList);
 List<Employee> getFirstFiveEmployeeWithTheBestSalary(List<Employee> employeeList);
    List<Employee> getEmployeesWhoResignByMonthAndYear(List<Employee> employeeList, Integer month, Integer year);
    List<Employee> getListOfEmployeesInTheLastXMonths(List<Employee> employeeList, Integer months);
    void getEmployeeWithMaximumSalary();
    void getEmployeeWithMinimumSalary();

}
