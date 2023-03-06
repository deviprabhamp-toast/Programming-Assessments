import java.util.ArrayList;
import java.util.Scanner;
public class TestEmployee {
    static  AttendanceMaster attendance = new AttendanceMaster();
    public static void main(String[] args) {
        Scanner sin = new Scanner(System.in);
        boolean filter = false;
        int empAddCount=0,attCount=0;
        String name, designationNum, departmentNum, salary;
        String menuChoice;
        ArrayList<Employee> employeeList = new ArrayList<>();
        System.out.println("\t\t\t***********************************************************");
        System.out.println("\t\t\t\t\t\tPAYROLL MANAGEMENT SYSTEM");
        System.out.println("\t\t\t***********************************************************");
        System.out.println("\t\t\t1 - Add Employee\n\t\t\t2 - Enter attendance\n\t\t\t3 - Update Attendance by Employee ID\n\t\t\t4 - Show employees eligible for salary\n\t\t\t5 - Sort employee list\n\t\t\t6 - Display employee details\n\t\t\t7 - Filter employees\n\t\t\t8 - Calculate salary for eligible employees\n\t\t\t\tPress any other key to EXIT\n\nEnter your choice:");
        menuChoice = sin.nextLine();
        while(menuChoice.matches("[1-8]"))
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
                    employee.setAllowance();
                    employeeList.add(employee);
                    empAddCount++;
                    break;
                }
                case "2": {
                    if(!employeeList.isEmpty()) {
                        attendance.enterAttendance(employeeList);
                        filter = false;
                        empAddCount = 0;
                        attCount = 0;
                    }
                    else
                        System.out.println("No employee details found to make attendance entry!!");
                    break;
                }
                case "3": {
                    if(!employeeList.isEmpty()){
                        attCount+=attendance.updateAttendanceById(employeeList);
                        if(attCount == empAddCount){
                            empAddCount = 0;
                            attCount = 0;
                        }
                        filter = false;
                    }
                    else
                        System.out.println("No employee found in list to update attendance!!");
                    break;
                }
                case "4": {
                    if(!employeeList.isEmpty())
                        attendance.showEligibleList();
                    else
                        System.out.println("No employee found in list!!");
                    break;
                }
                case "5":{
                    if(!employeeList.isEmpty()) {
                        String sortChoice1, sortChoice2;
                        System.out.println("\t\t1. Sort by Id\n\t\t2. Sort by name\n\t\t3. Sort by salary \n\t\tSelect a sort:");
                        sortChoice1 = sin.nextLine();
                        while (!sortChoice1.matches("[1-3]")) {
                            System.out.println("\t\t1. Sort by Id\n\t\t2. Sort by name\n\t\t3. Sort by salary \n\t\tPlease select a sort from the above options:");
                            sortChoice1 = sin.nextLine();
                        }
                        System.out.println("\t\t1. Ascending sort\n\t\t2. Descending sort\n\t\tSelect a sort type:");
                        sortChoice2 = sin.nextLine();
                        while (!sortChoice2.matches("[1-2]")) {
                            System.out.println("\t\t1. Ascending sort\n\t\t2. Descending sort\n\t\tPlease select a sort type from above options:");
                            sortChoice2 = sin.nextLine();
                        }
                        MasterData employeeData1 = new MasterData(employeeList);
                        employeeData1.sortEmployees(sortChoice1, sortChoice2);
                        employeeData1.displayEmployees();
                    }
                    else
                        System.out.println("No employee details found to sort!!");
                    break;
                }
                case "6": {
                    if(!employeeList.isEmpty()) {
                        MasterData employeeData2 = new MasterData(employeeList);
                        employeeData2.displayEmployees();
                    }
                    else
                        System.out.println("No employee details found!!");
                    break;
                }
                case "7": {
                    if(employeeList.isEmpty())
                        System.out.println("No employee details found!!");
                    else if(attendance.isAttendanceEmpty())
                        System.out.println("Attendance dictionary is empty!! Cannot filter employees");
                    else {
                        attendance.filterEmployeeList();
                        filter = true;
                    }
                    break;
                }
                case "8": {
                    if(employeeList.isEmpty())
                        System.out.println("No employee details found!!");
                    else {
                        if(!filter)
                            System.out.println("Filter employees not eligible for salary before salary calculation");
                        else {
                            if(attendance.isAttendanceEmpty())
                                System.out.println("Attendance dictionary is empty!! No employee found to calculate salary..");
                            if(empAddCount == attCount){
                                SalCalculator calculator = new SalCalculator();
                                calculator.calculateSalary(attendance.getAttendance());
                            }
                            else {
                                System.out.println("Enter attendance for new added employees before salary calculation!!");
                            }
                        }
                    }
                    break;
                }
            }
            System.out.println();
            System.out.println("\t\t\t***********************************************************");
            System.out.println("\t\t\t\t\t\tPAYROLL MANAGEMENT SYSTEM");
            System.out.println("\t\t\t***********************************************************");
            System.out.println("\t\t\t\t1 - Add Employee\n\t\t\t\t2 - Enter attendance\n\t\t\t\t3 - Update Attendance by Employee ID\n\t\t\t\t4 - Show employees eligible for salary\n\t\t\t\t5 - Sort employee list\n\t\t\t\t6 - Display employee details\n\t\t\t\t7 - Filter employees\n\t\t\t\t8 - Calculate salary for eligible employees\n\t\t\t\tPress any other key to EXIT\n\nEnter your choice:");
            menuChoice = sin.nextLine();
        }
    }
}
