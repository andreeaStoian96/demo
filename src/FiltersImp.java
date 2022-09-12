import java.time.LocalDate;
import java.time.YearMonth;
import java.util.*;
import java.util.stream.Collectors;

public class FiltersImp implements Filters {
    @Override
    public List<Employee> getFirstTenEmployeesWithSeniority(List<Employee> employeeList) {
        List<Employee> tenEmployeeWithSeniority = employeeList.stream()
                .limit(10)
                .sorted((e1, e2) -> e1.getEmploymentDate().compareTo(e2.getEmploymentDate()))
                .collect(Collectors.toList());
        return tenEmployeeWithSeniority;
    }

    @Override
    public List<Employee> getFirstFiveEmployeeWithTheBestSalary(List<Employee> employeeList) {
        List<Employee> fiveEmployeesWithBestSalary = employeeList.stream()
                .limit(5)
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .collect(Collectors.toList());
        return fiveEmployeesWithBestSalary;
    }

    @Override
    public List<Employee> getEmployeesWhoResignByMonthAndYear(List<Employee> employeeList, Integer month, Integer year) {
        List<Employee> employeesWithResignDate = employeeList.stream()
                .filter(employee -> employee.getEmployeeResignDate() != null)
                .collect(Collectors.toList());
        employeesWithResignDate.stream().filter(employee -> employee.getEmployeeResignDate().getMonth().equals(month))
                .collect(Collectors.toList());
        employeesWithResignDate.stream().filter(employee -> employee.getEmployeeResignDate().getYear() == year)
                .collect(Collectors.toList());
        return employeesWithResignDate;

    }

    @Override
    public List<Employee> getListOfEmployeesInTheLastXMonths(List<Employee> employeeList, Integer months) {
        return employeeList.stream()
                .filter(employee -> employee.getEmploymentDate().isAfter(LocalDate.now().minusMonths(months)))
                .collect(Collectors.toList());

    }

    @Override
    public void getEmployeeWithMaximumSalary() {

    }

    @Override
    public void getEmployeeWithMinimumSalary() {

    }
}
