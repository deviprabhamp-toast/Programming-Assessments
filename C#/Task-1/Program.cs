using System;
using System.Collections;
using System.Collections.Generic;
using System.Text.RegularExpressions;

namespace EmployeeClassDemo
{
    
class Employee
{
    int EmpId;
    string Name;
    string Department;
    string Designation;
    double Salary;
    static int idCount = 1001;
    
    public Employee()
    {
        this.EmpId = Employee.idCount++;
    }
    public Employee(string Name, string Department, string Designation, double Salary)
    {
        this.EmpId = Employee.idCount++;
        this.Name = Name;
        this.Department = Department;
        this.Designation = Designation;
        this.Salary = Salary;
    }

    public int Id
    {
        get { return EmpId;}
        set { EmpId = value;}

    }
    public string EmpName
    {
        get { return Name;}
        set { Name = value;}
    }
    public string EmpDepartment
    {
        get { return Department;}
        set { 
            string[] departments = {"Research & Development", "IT", "Admin", "HR", "Accounts"};
            Regex rgx = new Regex("[1-5]");
            while (!(rgx.IsMatch(value)))
             {
                 Console.WriteLine("Select department number:\n \t1 - Research & Development\n \t2 - IT\n \t3 - Admin\n \t4 - HR\n \t5 - Accounts");
                 Console.WriteLine("Please select one from the above options:");
                 value = Console.ReadLine();
             }
            int deptNumber = Convert.ToInt32(value);
            Department = departments[deptNumber - 1];
        }
    }
    public string EmpDesignation
    {
        get { return Designation;}
        set { 
            string[] designations = {"Accountant", "Manager", "QA Engineer", "Network Admin", "Software developer"};
            Regex rgx = new Regex("[1-5]");
        while (!(rgx.IsMatch(value)))
        {
            Console.WriteLine("Select designation:\n \t1 - Accountant\n \t2 - Manager\n \t3 - QA Engineer\n \t4 - Network Admin\n \t5 - Software developer");
            Console.WriteLine("Please select one from the above options:");
            value = Console.ReadLine();
        }
        int desgNumber = Convert.ToInt32(value);
        Designation = designations[desgNumber - 1];
        }
    }
    public double EmpSalary
    {
        get { return Salary;}
        set { 
            string inputSalary;
            while(value < 500)
            {
                Console.WriteLine("Salary should be Rs. 500 or above...Enter again ");
                inputSalary = Console.ReadLine();
            
            while (true)
            {
            try
               {
                value = Convert.ToDouble(inputSalary);
                break;
               } 
            catch (Exception exception){
                Console.WriteLine("Invalid salary....Enter again");
                inputSalary = Console.ReadLine();
            }
            }
        }
        Salary = value;
    }
    }

    public string ToString()
    {
        return "| ID: " + this.EmpId.ToString() + " |  Name: " + this.Name + " |  Department: " + this.Department + " |  Designation: " + this.Designation + " |  Salary: Rs. " + this.Salary.ToString() + "  |";
    }
   
   public void SetAllowance()
    {
        double salaryBeforeAllowance = Salary;
        if (Designation.Equals("Manager"))
        {
            Salary += (20 * Salary / 100);
        }
        else 
        {
            Salary += (10 * Salary / 100);
        }
        Console.WriteLine("Salary after allowance: Rs. " + Salary.ToString());
        Console.WriteLine("Difference in salary before and after allowance: Rs. " + String.Format("{0:F2}",Salary - salaryBeforeAllowance));
    }
}

public class Program{
    static void Main(string[] args){
        string name, designationNum, departmentNum, salary;
        int noOfEmployees;
        string choice = "y";
        double inputSalary;
        List<Employee> employeeList = new List<Employee>();
        while(choice.Equals("y"))
        {
            Employee employee = new Employee();
            Console.WriteLine("Enter employee details:");
            Console.WriteLine();
            Console.WriteLine("Enter employee name:");
            name = Console.ReadLine();
            employee.EmpName = name;
            Console.WriteLine("Select department number:\n \t1 - Research & Development\n \t2 - IT\n \t3 - Admin\n \t4 - HR\n \t5 - Accounts");
            departmentNum = Console.ReadLine();
            employee.EmpDepartment = departmentNum;
            Console.WriteLine("Select designation:\n \t1 - Accountant\n \t2 - Manager\n \t3 - QA Engineer\n \t4 - Network Admin\n \t5 - Software developer");
            designationNum = Console.ReadLine();
            employee.EmpDesignation = designationNum;
            Console.WriteLine("Enter the salary (in Rs):");
            salary = Console.ReadLine();
            while (true)
            {
            try
               {
                inputSalary = Convert.ToDouble(salary);
                break;
               } 
            catch (Exception exception){
                Console.WriteLine("Invalid salary....Enter again");
                salary = Console.ReadLine();
            }
        }
            employee.EmpSalary = inputSalary;
            employeeList.Add(employee);
            Console.WriteLine("Want to add more employees? \n\tPress y (yes) to add\n\tPress n (no) to stop");
            choice = Console.ReadLine();
            while(!(choice.Equals("y")) && !(choice.Equals("n")))
            {
                Console.WriteLine("Please press a valid one:\n\t y - Add employee\n\t n - Stop");
                choice = Console.ReadLine();
            }
        }
        noOfEmployees = employeeList.Count;
        for(int i = 0; i < employeeList.Count; i++){
            Console.WriteLine(employeeList[i].ToString());
            employeeList[i].SetAllowance();
            Console.WriteLine("***********************************************************************************************");
        }
    }
}
}
