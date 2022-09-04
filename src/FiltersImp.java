import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FiltersImp implements Filters {

    @Override
    public List<Employee> getFirstTenEmployeesWithSeniority(List<Employee> employeeList) {
        List<Employee> filterOne = employeeList.stream()
                .limit(10)
                .sorted((e1, e2) -> e1.getEmploymentDate().compareTo(e2.getEmploymentDate()))
                .collect(Collectors.toList());
        return filterOne;
    }
    @Override
    public List<Employee> getFirstFiveEmployeeWithTheBestSalary(List<Employee> employeeList) {
       List<Employee> filterTwo= employeeList.stream()
                .limit(5)
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .collect(Collectors.toList());
       return filterTwo;
    }
    @Override
    public List<Employee>  getEmployeesWhoResign(List<Employee> employeeList) {
return employeeList;
    }
    @Override
    public void getListOfEmployeesInTheLastXMonths() {

    }
    @Override
    public void getEmployeeWithMaximumSalary() {

    }
    @Override
    public void getEmployeeWithMinimumSalary() {

    }
}
