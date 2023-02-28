import java.util.Scanner;
public class Employee {
    private int empId;
    private String name;
    private String department;
    private String designation;
    private double salary;
    static int idCount = 1001;
    Scanner sin = new Scanner(System.in);

    public Employee(String name, String department, String designation, double salary)
    {
        this.empId = idCount++;
        this.name = name;
        this.department = department;
        this.designation = designation;
        this.salary = salary;
    }
    public Employee(){
        empId = idCount++;
    }

    public int getId()
    {
        return empId;
    }
    public void setId(int id)
    {
        empId = id;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String employeeName)
    {
        while(!(employeeName.matches("[a-zA-Z][a-zA-Z .]*[a-zA-Z]+")) || (employeeName.length()<3))
        {
            System.out.println("Please re-enter the name correctly:");
            employeeName = sin.nextLine();
        }
        name = employeeName;
    }
    public String getDepartment()
    {
        return department;
    }
    public void setDepartment(String departmentNum)
    {
        String departments[] = {"Research & Development", "IT", "Admin", "HR", "Accounts"};
        Scanner sin = new Scanner(System.in);
        while(!(departmentNum.matches("[1-5]")))
        {
            System.out.println("Select department number:\n \t1 - Research & Development\n \t2 - IT\n \t3 - Admin\n \t4 - HR\n \t5 - Accounts");
            System.out.println("Please select one from the above options:");
            departmentNum = sin.nextLine();
        }
        int deptNumber = Integer.parseInt(departmentNum);
        department = departments[deptNumber-1];
    }
    public String getDesignation()
    {
        return designation;
    }
    public void setDesignation(String desgNum)
    {
        String designations[] = {"Accountant", "Manager", "QA Engineer", "Network Admin", "Software developer"};
        Scanner sin = new Scanner(System.in);
        while(!(desgNum.matches("[1-5]")))
        {
            System.out.println("Select designation:\n \t1 - Accountant\n \t2 - Manager\n \t3 - QA Engineer\n \t4 - Network Admin\n \t5 - Software developer");
            System.out.println("Please select one from the above options:");
            desgNum = sin.nextLine();
        }
        int desgNumber = Integer.parseInt(desgNum);
        designation = designations[desgNumber-1];
    }

    public double getSalary()
    {
        return salary;
    }
    public void setSalary(String inputSalary)
    {
        boolean validSalary = false;
        while(!validSalary)
        {
            try{
                salary = Double.parseDouble(inputSalary);
                validSalary = true;
                if(salary < 500)
                {
                    validSalary = false;
                    System.out.println("Salary should be Rs. 500 or above...Enter again ");
                    inputSalary = sin.nextLine();
                }
            }
            catch(Exception e)
            {
                validSalary = false;
                System.out.println("Invalid salary....Enter again");
                inputSalary = sin.nextLine();
            }
        }
    }
    public String toString()
    {
        return "| ID: "+empId+" |  Name: "+name+" |  Department: "+department+" |  Designation: "+designation+" |  Salary: Rs. "+salary+"  |";
    }
    public void setAllowance()
    {
        double salaryAfterAllowance;
        if(designation.compareTo("Manager") == 0)
        {
            salaryAfterAllowance = salary + (20 * salary / 100);
        }
        else {
            salaryAfterAllowance = salary + (10 * salary / 100);
        }
        System.out.println("Allowance: Rs. "+String.format("%.2f",salaryAfterAllowance-salary));
        System.out.println("Salary after allowance: Rs. "+salaryAfterAllowance);
    }
}
