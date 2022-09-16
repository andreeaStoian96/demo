import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class FiltersImp implements Filters {
    @Override
    public List<Employee> getFirstTenEmployeesWithSeniority(List<Employee> employeeList) {
        return employeeList.stream()
                .limit(10)
                .sorted((e1, e2) -> e1.getEmploymentDate().compareTo(e2.getEmploymentDate()))
                .collect(Collectors.toList());
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
        return employeesWithResignDate.stream().filter(employee ->
                        (employee.getEmployeeResignDate().getYear() == year && employee.getEmployeeResignDate().getMonthValue() == month))
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> getListOfEmployeesInTheLastXMonths(List<Employee> employeeList, Integer months) {
        return employeeList.stream()
                .filter(employee -> employee.getEmploymentDate().isAfter(LocalDate.now().minusMonths(months)))
                .collect(Collectors.toList());

    }

    @Override
    public Optional<Employee> getEmployeeWithMaximumSalary(List<Employee> employeeList) {
        return employeeList.stream()
                .max(Comparator.comparing(Employee::getSalary));

    }

    @Override
    public Optional<Employee> getEmployeeWithMinimumSalary(List<Employee> employeeList) {
        return employeeList.stream()
                .min(Comparator.comparing(Employee::getSalary));
    }

    @Override
    public Set<String> getManagers(List<Employee> employeeList) {
         return employeeList.stream()
                 .map(value -> value.getManagerName())
                 .collect(Collectors.toSet());
    }

    @Override
    public List<Employee> getManagersAndEmployees(List<Employee> employeeList) {
        return null;
    }
}
