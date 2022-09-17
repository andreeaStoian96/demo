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
    public List<Employee> getManagers(List<Employee> employeeList) {
        return employeeList.stream()
                .filter(employee -> employee.isManager())
                .collect(Collectors.toList());
//        return  employeeList.stream()
//                .map(Employee::getManagerName)
//                .distinct()
//                .collect(Collectors.toList());
    }

    @Override
    public void getManagersAndEmployees(List<Employee> employeeList) {
        Map<String, List<Employee>> employeeListByManagers = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getManagerName));

        Set<Map.Entry<String, List<Employee>>> entrySet = employeeListByManagers.entrySet();
        for (Map.Entry<String, List<Employee>> entry : entrySet) {
            System.out.println("Manager is: \n" + " " + entry.getKey() + "   \n" + "  Employees are: ");
            List<Employee> list = entry.getValue();
            for (Employee e : list) {
                System.out.println("   " + e.getFirstName() + " " + e.getLastName());
            }
            System.out.println();
        }

    }
}
