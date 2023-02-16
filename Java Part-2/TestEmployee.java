import java.util.ArrayList;
import java.util.Scanner;
public class TestEmployee {
    public static ArrayList<Employee> employeeList = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sin = new Scanner(System.in);
        String name, designationNum, departmentNum, salary;
        int noOfEmployees;
        String choice = "y";

        while(choice.equals("y"))
        {
            Employee employee = new Employee();
            System.out.println("Enter employee details:");
            System.out.println();
            System.out.println("Enter employee name:");
            name = sin.nextLine();
            employee.setName(name);
            System.out.println("Select department number:\n \t1 - Research & Development\n \t2 - IT\n \t3 - Admin\n \t4 - HR\n \t5 - Accounts");
            departmentNum = sin.nextLine();
            employee.setDepartment(departmentNum);
            System.out.println("Select designation:\n \t1 - Accountant\n \t2 - Manager\n \t3 - QA Engineer\n \t4 - Network Admin\n \t5 - Software developer");
            designationNum = sin.nextLine();
            employee.setDesignation(designationNum);
            System.out.println("Enter the salary (in Rs):");
            salary = sin.nextLine();
            employee.setSalary(salary);
            employeeList.add(employee);
            System.out.println("Want to add more employees? \n\tPress 'y' (yes) to add\n\tPress 'n' (no) to stop");
            choice = sin.nextLine();
            while(!(choice.equals("y")) && !(choice.equals("n")))
            {
                System.out.println("Please press a valid one:\n\t'y' - Add employee\n\t'n' - Stop");
                choice = sin.nextLine();
            }
        }
        noOfEmployees = employeeList.size();
        for(int i=0; i<noOfEmployees; i++){
            System.out.println(employeeList.get(i).toString());
            employeeList.get(i).setAllowance();
            System.out.println("***********************************************************************************************");
        }
    }
}
