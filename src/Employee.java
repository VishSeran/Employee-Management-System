


public class Employee implements Cloneable {

    private String name;
    private int age;
    private double  salary;

    //Default constructor
    public Employee() {
        this.name = "Unknown";
        this.age = 18;
        this.salary = 0.0;
    }

    //parameterized constructor
    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    //getter methods
    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public double getSalary() {
        return this.salary;
    }

    //setter methods
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Name cannot be null");
            this.name = "Unknown";
        }
    }

    public void setAge(int age) {
        if (age >= 18 && age <= 65) {
            this.age = age;
        } else {
            System.out.println("Age cannot be less than 18 or greater than 65");
        }
    }

    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        }else {
            System.out.println("Salary cannot be negative");
        }
    }

    public double annualSalary(){
        double salaryAnnual = this.salary*12;
        return salaryAnnual;
    }

    public void giveRaise(double percentage){
        if(percentage > 0 ){
            double raiseAmount = this.salary*percentage; 
            this.salary += raiseAmount;
            System.out.println("You have raused by: " + raiseAmount);
            System.out.println("Your new salary: " + this.getSalary());
        }else{
            System.out.println("Raise cannot be null or negative");
        }
    }

    
}
