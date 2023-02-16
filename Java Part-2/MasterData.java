import java.util.ArrayList;

public class MasterData {
    private ArrayList<Employee> employees = new ArrayList<>();
    public MasterData(ArrayList<Employee> employeeList)
    {
        for(Employee employee: employeeList)
        {
            employees.add(employee);
        }
    }
    public void displayEmployees()
    {
        for(Employee employee: employees)
        {
            System.out.println(employee.toString());
            employee.setAllowance();
            System.out.println("***********************************************************************************************");

        }
    }
}
