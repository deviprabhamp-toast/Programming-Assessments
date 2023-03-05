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
        System.out.printf("| %-10s | %-20s | %-30s | %-20s | %-15s | %-15s |","ID","NAME","DEPARTMENT","DESIGNATION","SALARY","ALLOWANCE");
        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
        for(Employee employee: employees)
        {
            System.out.println(employee.toString());
           // System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
        }
    }

    public void sortEmployees(String sortChoice1, String sortChoice2)
    {
        if(sortChoice1.equals("1")){
            if(sortChoice2.equals("1"))
                employees.sort((e1, e2) -> e1.getId() - e2.getId());
            else
                employees.sort((e1, e2) -> e2.getId() - e1.getId());
        }

        else if(sortChoice1.equals("2")){
            if(sortChoice2.equals("1"))
                employees.sort((e1, e2) -> e1.getName().compareTo(e2.getName()));
            else
                employees.sort((e1, e2) -> e2.getName().compareTo(e1.getName()));
        }
        else{
            if(sortChoice2.equals("1"))
                employees.sort((e1,e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
            else
                employees.sort((e1,e2) -> Double.compare(e2.getSalary(), e1.getSalary()));
        }
    }
}
