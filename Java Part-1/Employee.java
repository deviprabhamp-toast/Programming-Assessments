class Employee {
    private int empID;
    private String name;
    private String department;
    private String designation;
    private double salary;
    static int idCount = 1001;

    // Employee class parameterized constructor
    Employee(String name, String department, String designation, double salary)
    {
        this.empID = idCount++;
        this.name = name;
        this.department = department;
        this.designation = designation;
        this.salary = salary;
    }
    public int GetEmpId()
    {
        return empID;
    }
    public void SetEmpId(int id)
    {
        empID = id;
    }
    public String GetEmpName()
    {
        return name;
    }
    public void SetEmpName(String ename)
    {
        name = ename;
    }
    public String GetDepartment()
    {
        return department;
    }
    public void SetDepartment(String dept)
    {
        department = dept;
    }
    public String GetDesignation()
    {
        return designation;
    }
    public void SetDesignation(String desg)
    {
        designation = desg;
    }
    public double GetSalary()
    {
        return salary;
    }
    public void SetSalary(double sal)
    {
        salary = sal;
    }


    public String ToString()
    {
        return "| ID: "+empID+" |  Name: "+name+" |  Department: "+department+" |  Designation: "+designation+" |  Salary: Rs. "+salary+"  |";
    }

    public void SetAllowance()
    {
        double salaryBeforeAllowance = salary;
        if(designation.compareTo("Manager") == 0)
        {
            salary += (20 * salary / 100);
        }
        else {
            salary += (10 * salary / 100);
        }
        System.out.println("Salary after allowance: Rs. "+salary);
        System.out.println("Difference in salary before and after allowance: Rs. "+String.format("%.2f",salary - salaryBeforeAllowance));
    }
}

