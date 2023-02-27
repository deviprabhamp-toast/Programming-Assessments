import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class TestEmployee {
    static  AttendanceMaster attendance = new AttendanceMaster();
    public static void main(String[] args) {
        Scanner sin = new Scanner(System.in);
        String name, designationNum, departmentNum, salary;
        String menuChoice;
        String menuOptions[] = {"1", "2", "3", "4", "5"};
        ArrayList<Employee> employeeList = new ArrayList<>();
        System.out.println("\t\t ******PAYROLL MANAGEMENT SYSTEM********");
        System.out.println("\t1 - Add Employee\n\t2 - Enter attendance\n\t3 - Update Attendance by Employee ID\n\t4 - Show eligibility list for salary\n\t5 - Display employee details\n\tPress any other key to EXIT\n\n\tEnter your choice:");
        menuChoice = sin.nextLine();

        while(Arrays.asList(menuOptions).contains(menuChoice))
        {
            switch(menuChoice)
            {
                case "1": {

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

                    break;
                }
                case "2": {
                    if(employeeList.size() == 0)
                    {
                        System.out.println("No employee details found to make attendance entry!!");
                    }
                    else
                    {
                        attendance.enterAttendance(employeeList);
                    }
                    break;
                }

                case "3": {
                    attendance.updateAttendanceById(employeeList);
                    break;
                }

                case "4": {
                        attendance.showEligibleList();
                       break;
                }

                case "5": {
                    MasterData employeeData = new MasterData(employeeList);
                    employeeData.displayEmployees();
                    break;
                }

            }

            System.out.println("\t\t ******PAYROLL MANAGEMENT SYSTEM********");
            System.out.println("\t1 - Add Employee\n\t2 - Enter attendance\n\t3 - Update Attendance by Employee ID\n\t4 - Show eligibility list for salary\n\t5 - Display employee details\n\tPress any other key to EXIT\n\n\tEnter your choice:");
            menuChoice = sin.nextLine();
        }

    }
}
