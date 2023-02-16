import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Set;

public class AttendanceMaster{
    private Hashtable<Employee, Integer> employeeAttendance = new Hashtable<>();
    Scanner sin= new Scanner(System.in);
    public  void enterAttendance(ArrayList<Employee> employees){
        String noOfWorkingDays;
        int days=0;
        System.out.println("Enter the employee attendance details:");
        for (Employee employee : employees) {
            System.out.println("Employee Details:");
            System.out.println(employee.toString());
            System.out.println("Enter the number of working days for the employee:");
            boolean validDays = false;
            while(!validDays)
            {
                noOfWorkingDays = sin.nextLine();
                try{
                    days = Integer.parseInt(noOfWorkingDays);
                    validDays = true;
                    if(days < 0)
                    {
                        validDays = false;
                        System.out.println("Enter valid no. of working days..");
                    }
                }
                catch(Exception e)
                {
                    validDays = false;
                    System.out.println("Invalid salary....Enter again");
                }
            }
            employeeAttendance.put(employee, days);
        }
    }
    public void showEligibleList()
    {
        System.out.println("Eligible employees list for salary based on attendance:");
        Set<Employee> employeeSet = employeeAttendance.keySet();
        for (Employee employee : employeeSet) {
            if (employeeAttendance.get(employee) >= 10) {
                System.out.println(employee.toString());
                System.out.println("Number of days worked:"+employeeAttendance.get(employee));
                System.out.println("--------------------------------------------------------------------------------------------------------------");
            }
        }
    }
}
