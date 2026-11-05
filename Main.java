import java.util.ArrayList;

abstract class Employee
{
    private int id;
    private String name;
    public Employee(String name,int id)
    {
        this.id=id;
        this.name=name;
    }
    public String getName()
    {
        return name;
    }
    public int getId()
    {
        return id;
    }
    public abstract double calculateSalary();
    @Override
    public String toString()
    {
        return "Employee [name="+name+" , id="+id+" , salary="+calculateSalary()+"]";
    }
}

class FullTimeEmployee extends Employee
{
    private double monthySalary;
    public FullTimeEmployee(String name,int id,double monthySalary)
    {
        super(name,id);
        this.monthySalary=monthySalary;
    }
    @Override
    public double calculateSalary()
    {
        return monthySalary;
    }
}

class PartTimeEmployee extends Employee
{
    private int hoursWorked;
    private double hourlyRate;
    public PartTimeEmployee(String name,int id,int hoursWorked,double hourlyRate)
    {
        super(name,id);
        this.hoursWorked=hoursWorked;
        this.hourlyRate=hourlyRate;
    }
    @Override
    public double calculateSalary()
    {
        return hoursWorked*hourlyRate;
    }
}

@SuppressWarnings("unused")
class PayrollSystem
{
    private ArrayList<Employee> employeeList;
    public PayrollSystem()
    {
        employeeList =new ArrayList<>();
    }
    public void addEmployee(Employee employee)
    {
        employeeList.add(employee);
    }
    public void removeEmployee(int id)
    {
        Employee employeeToRemove=null;
        for(Employee employee:employeeList)
        {
            if(employee.getId()==id)
            {
                employeeToRemove=employee;
                break;
            }
        }
        if(employeeToRemove!=null)
        {
            employeeList.remove(employeeToRemove);
        }
    }
    public void displayEmployees()
    {
        for(Employee employee:employeeList)
        {
            System.out.println(employee);
        }
    }
}

public class Main
{
    public static void main(String args[])
    {
        PayrollSystem payrollSystem=new PayrollSystem();
        FullTimeEmployee emp1=new FullTimeEmployee("Vikas", 1, 28000);
        PartTimeEmployee emp2=new PartTimeEmployee("Raju", 2, 48, 550);
        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);
        System.out.println("Initial Employee Details: ");
        payrollSystem.displayEmployees();
        System.out.println("Removing Empl oyees");
        payrollSystem.removeEmployee(2);
        System.out.println("Remaining Employees");
        payrollSystem.displayEmployees();    
        PartTimeEmployee emp3=new PartTimeEmployee("Ramu",3,90,560);
        payrollSystem.addEmployee(emp3);
        System.out.println("Remaining Employees");
        payrollSystem.displayEmployees();
    }
}