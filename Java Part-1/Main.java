import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sin = new Scanner(System.in);
        String name, desgNum, deptNum;
        int noOfEmployees,valid = 0;
        double salary=1000;
        String choice = "y";
        String departments[] = {"Research & Development", "IT", "Admin", "HR", "Accounts"};
        String designations[] = {"Accountant", "Manager", "QA Engineer", "Network Admin", "Software developer"};
        ArrayList<Employee> employee_list = new ArrayList<Employee>();

        while(choice.equals("y"))
        {
            System.out.println("Enter employee details:");
            System.out.println();
            System.out.println("Enter employee name:");
            name = sin.nextLine();
            while(!(name.matches("[a-zA-Z][a-zA-Z .]*[a-zA-Z]+")) || (name.length()<=3))
            {
                System.out.println("Please re-enter the name correctly:");
                name = sin.nextLine();
            }
            System.out.println("Select department number:\n \t1 - Research & Development\n \t2 - IT\n \t3 - Admin\n \t4 - HR\n \t5 - Accounts");
            deptNum = sin.nextLine();
            while(!(deptNum.matches("[1-5]")))
            {
                System.out.println("Select department number:\n \t1 - Research & Development\n \t2 - IT\n \t3 - Admin\n \t4 - HR\n \t5 - Accounts");
                System.out.println("Please select one from the above options:");
                deptNum = sin.nextLine();
            }
            System.out.println("Select designation:\n \t1 - Accountant\n \t2 - Manager\n \t3 - QA Engineer\n \t4 - Network Admin\n \t 5 - Software developer");
            desgNum = sin.nextLine();
            while(!(desgNum.matches("[1-5]")))
            {
                System.out.println("Select designation:\n \t1 - Accountant\n \t2 - Manager\n \t3 - QA Engineer\n \t4 - Network Admin\n \t 5 - Software developer");
                System.out.println("Please select one from the above options:");
                desgNum = sin.nextLine();
            }
            System.out.println("Enter the salary (in Rs):");
            while(valid == 0 || salary < 500)
            {
                String sal = sin.nextLine();
                try{
                    salary = Double.parseDouble(sal);
                    valid = 1;
                    if(salary < 500)
                    {
                        System.out.println("Salary should be above 500...Enter again ");
                    }
                }
                catch(Exception e)
                {
                    valid = 0;
                    System.out.println("Invalid salary....Enter again");
                }
            }
            valid = 0;
            int deptNumber = Integer.parseInt(deptNum);
            int desgNumber = Integer.parseInt(desgNum);
            //employee_arr[i] = new Employee(name, departments[deptNumber-1], designations[desgNumber-1], salary);
            employee_list.add(new Employee(name, departments[deptNumber-1], designations[desgNumber-1], salary));
            System.out.println("Want to add more employees? \n\tPress 'y' (yes) to add\n\tPress 'n' (no) to stop");
            choice = sin.nextLine();
            while(!(choice.equals("y")) && !(choice.equals("n")))
            {
                System.out.println("Please press a valid one:\n\t'y' - Add employee\n\t'n' - Stop");
                choice = sin.nextLine();
            }
        }
        noOfEmployees = employee_list.size();
        for(int i=0; i<noOfEmployees; i++){
            System.out.println(employee_list.get(i).ToString());
            employee_list.get(i).SetAllowance();
            System.out.println("***********************************************************************************************");
        }
    }
}
