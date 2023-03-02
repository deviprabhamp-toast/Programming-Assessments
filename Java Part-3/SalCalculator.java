import java.util.LinkedHashMap;
import java.util.Set;
public class SalCalculator {
    public void calculateSalary(LinkedHashMap<Employee, Integer> employeeAttendance)
    {
        double pf, gross;
        Set<Employee> employeeSet = employeeAttendance.keySet();
        System.out.println(String.format("| %-10s | %-20s | %-30s | %-20s | %-15s | %-15s | %-15s | %-10s | %-15s | %-15s |","ID","NAME","DEPARTMENT","DESIGNATION","SALARY","ALLOWANCE","GROSS SALARY","PF","NET SALARY","DAYS WORKED"));
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (Employee employee : employeeSet) {
                pf = (10 * employee.getSalaryBeforeAllowance())/100;
                gross = employee.getSalary();
                System.out.print(employee.toString());
                System.out.println(String.format(" %-15s | %-10s | %-15s | %-15s |",String.format("%.2f",gross),String.format("%.2f",pf),String.format("%.2f",gross-pf),employeeAttendance.get(employee)));
        }
    }
}
