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
    public int partition(int low, int high, String choice)
    {
        Employee pivot = employees.get(high);
        int i = low-1;
        for (int j=low; j<high; j++)
        {
            if(choice.equals("1"))
            {
                if (employees.get(j).getId() < pivot.getId())
                {
                    i++;
                    Employee employee1 = employees.get(i);
                    employees.set(i,employees.get(j));
                    employees.set(j,employee1);
                }
            }
            else if(choice.equals("2"))
            {
                if (employees.get(j).getName().compareTo(pivot.getName()) < 0)
                {
                    i++;
                    Employee employee1 = employees.get(i);
                    employees.set(i,employees.get(j));
                    employees.set(j,employee1);
                }
            }
            else
            {
                if (employees.get(j).getSalary() < pivot.getSalary())
                {
                    i++;
                    Employee employee1 = employees.get(i);
                    employees.set(i,employees.get(j));
                    employees.set(j,employee1);
                }
            }
        }

        Employee employee2 = employees.get(i+1);
        employees.set(i+1,employees.get(high));
        employees.set(high,employee2);
        return i+1;
    }
    public void sort_by_attribute(int low, int high, String choice)
    {
        if (low < high)
        {
            int partition_index = partition(low, high, choice);
            sort_by_attribute(low, partition_index-1, choice);
            sort_by_attribute(partition_index+1, high, choice);
        }
    }

}
