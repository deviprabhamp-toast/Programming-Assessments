import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Set;

public class AttendanceMaster{
    private LinkedHashMap<Employee,Integer> employeeAttendance = new LinkedHashMap<>();
    Scanner sin= new Scanner(System.in);
    public int  checkValidDays(String noOfWorkingDays)
    {
        int days;
        while(true)
        {
            try{
                days = Integer.parseInt(noOfWorkingDays);
                if(days < 0)
                {
                    System.out.println("Enter valid no. of working days..");
                    noOfWorkingDays = sin.nextLine();
                }
                else
                {
                    break;
                }
            }
            catch(Exception e)
            {
                System.out.println("Invalid days....Enter again");
                noOfWorkingDays = sin.nextLine();
            }
        }
        return days;
    }
    public  void enterAttendance(ArrayList<Employee> employees){
        String noOfWorkingDays;
        int days;
        int noOfEmployees = employees.size();
        int attendanceCount = employeeAttendance.size();
        if(noOfEmployees == attendanceCount)
        {
            System.out.println("Already entered attendance for all employees..");
        }
        else
        {
            System.out.println("Enter the employee attendance details:");
            for (int i=0; i<noOfEmployees; i++) {
                if(!employeeAttendance.containsKey(employees.get(i)))
                {
                    System.out.println("Employee Details:");
                    System.out.println(employees.get(i).toString());
                    System.out.println("Enter the number of working days for the employee:");
                    noOfWorkingDays = sin.nextLine();
                    days = checkValidDays(noOfWorkingDays);
                    employeeAttendance.put(employees.get(i), days);
                }
            }
        }
    }
    public void updateAttendanceById(ArrayList<Employee> employees)
    {
        int updId;
        String noOfWorkingDays;
        int days;
        System.out.println("Enter employee Id to update attendance");
        String updateId;
        while(true)
        {
            updateId = sin.nextLine();
            try{
                updId = Integer.parseInt(updateId);
                break;
            }
            catch(Exception e)
            {
                System.out.println("Invalid Employee Id....Enter again");
            }
        }
        if(updId<1001 || updId>=Employee.idCount)
        {
            System.out.println("Employee with ID "+updateId+" is not found!!");
        }
        else
        {
                System.out.println("Enter the number of working days for the employee:");
                noOfWorkingDays = sin.nextLine();
                days = checkValidDays(noOfWorkingDays);
                employeeAttendance.put(employees.get(updId - 1001),days);
                System.out.println("Attendance updated successfully!!");
        }
    }
    public void showEligibleList()
    {
        if(employeeAttendance.isEmpty())
        {
            System.out.println("Attendance not entered for any employee..");
        }
        else {
            System.out.println("Eligible employees list for salary based on attendance:");
            Set<Employee> employeeSet = employeeAttendance.keySet();
            for (Employee employee : employeeSet) {
                if (employeeAttendance.get(employee) >= 10) {
                    System.out.println(employee.toString());
                    System.out.println("Number of days worked:" + employeeAttendance.get(employee));
                    System.out.println("--------------------------------------------------------------------------------------------------------------");
                }
            }
        }
    }
}
