import java.util.ArrayList;
import java.util.Scanner;
public class TestEmployee {
    public static void main(String[] args) {
        Scanner sin = new Scanner(System.in);
        String name, designationNum, departmentNum, salary;
        String choice = "y";
        String attendanceChoice;
        ArrayList<Employee> employeeList = new ArrayList<>();

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

        System.out.println("MASTER DATA:");
        MasterData employeeData = new MasterData(employeeList);
        employeeData.displayEmployees();

        //Attendance
        System.out.println("Do you want to make attendance entry for employees? \n\tPress 'y' (yes) to add\n\tPress 'n' (no) to stop");
        attendanceChoice = sin.nextLine();
        while(!(attendanceChoice.equals("y")) && !(attendanceChoice.equals("n")))
        {
            System.out.println("Please press a valid one:\n\t'y' - Enter attendance\n\t'n' - Stop");
            attendanceChoice = sin.nextLine();
        }
        if(attendanceChoice.equals("y"))
        {
            AttendanceMaster attendance = new AttendanceMaster();
            attendance.enterAttendance(employeeList);
            attendance.showEligibleList();
        }
    }
}
