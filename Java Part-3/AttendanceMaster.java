import java.util.*;

public class AttendanceMaster{
    private LinkedHashMap<Employee,Integer> employeeAttendance = new LinkedHashMap<>();
    private ArrayList<Integer> filteredEmployees = new ArrayList<>();
    Scanner sin= new Scanner(System.in);
    public LinkedHashMap<Employee,Integer> getAttendance()
    {
        return employeeAttendance;
    }
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
                else {
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
                Employee employee1 = employees.get(i);

                if(!employeeAttendance.containsKey(employee1))
                {
                    if(!filteredEmployees.contains(employee1.getId())) {
                        System.out.println();
                        System.out.printf("| %-10s | %-20s | %-30s | %-20s | %-15s | %-15s |", "ID", "NAME", "DEPARTMENT", "DESIGNATION", "SALARY", "ALLOWANCE");
                        System.out.println();
                        System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
                        System.out.println(employee1.toString());
                        System.out.println("Enter the number of working days for the employee:");
                        noOfWorkingDays = sin.nextLine();
                        days = checkValidDays(noOfWorkingDays);
                        employeeAttendance.put(employee1, days);
                    }
                }
            }
        }
    }
    public int updateAttendanceById(ArrayList<Employee> employees)
    {
        int count=0;
        int updId;
        String noOfWorkingDays;
        int days;
        int initialSize;
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
            initialSize = employeeAttendance.size();
            System.out.println("Enter the number of working days for the employee:");
            noOfWorkingDays = sin.nextLine();
            days = checkValidDays(noOfWorkingDays);
            for (Employee employee : employees) {
                if (employee.getId() == updId) {
                    employeeAttendance.put(employee, days);
                    count = employeeAttendance.size()-initialSize;
                    if(filteredEmployees.contains(updId)) {
                        filteredEmployees.remove(Integer.valueOf(updId));
                        count=0;
                    }
                    System.out.println("Attendance updated successfully!!");
                    break;
                }
            }
        }
        return count;
    }
    public void showEligibleList()
    {
        if(employeeAttendance.isEmpty())
        {
            System.out.println("Attendance not found for any employee..");
        }
        else {
            System.out.println("Eligible employees list for salary based on attendance:");
            System.out.printf("| %-10s | %-20s | %-30s | %-20s | %-15s | %-15s | %-15s |","ID","NAME","DEPARTMENT","DESIGNATION","SALARY","ALLOWANCE","DAYS WORKED");
            System.out.println();
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
            Set<Employee> employeeSet = employeeAttendance.keySet();
            for (Employee employee : employeeSet) {
                if (employeeAttendance.get(employee) >= 10) {
                    System.out.print(employee.toString());
                    System.out.println(String.format(" %-15s |",employeeAttendance.get(employee)));
                    //System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
                }
            }
        }
    }
    public boolean isAttendanceEmpty()
    {
        if(employeeAttendance.isEmpty())
            return true;
        return false;
    }
    public void filterEmployeeList()
    {
        Iterator<Employee> iterator1 = employeeAttendance.keySet().iterator();
        while (iterator1.hasNext()) {
            Employee employee = iterator1.next();
            if (employeeAttendance.get(employee) < 10) {
                iterator1.remove();
                filteredEmployees.add(employee.getId());
                employeeAttendance.remove(employee);
            }
        }
        if(!employeeAttendance.isEmpty())
            showEligibleList();
        else
            System.out.println("Filtered employees!! No more employees details available in attendance.");
    }
}
