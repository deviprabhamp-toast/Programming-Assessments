import java.util.Hashtable;
import java.util.Scanner;

public class AttendanceMaster{
    private Hashtable<Employee, Integer> employeeAttendance = new Hashtable<>();
    Scanner sin= new Scanner(System.in);
    public  AttendanceMaster(){
        int noOfWorkingDays;
        System.out.println("Enter the employee attendance details:");
        for (Employee employee : TestEmployee.employeeList) {
            System.out.println("Employee Details:");
            System.out.println("Employee ID: "+employee.getId());
            System.out.println("Employee Name: "+employee.getName());
            System.out.println("Enter the number of working days for the employee:");
            noOfWorkingDays = sin.nextInt();
            employeeAttendance.put(employee, noOfWorkingDays);
        }
    }
}
