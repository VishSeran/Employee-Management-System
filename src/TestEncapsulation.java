
public class TestEncapsulation {

    public static String comparisonSalaries(Employee emp1, Employee emp2) {
        if (emp1.getSalary() > emp2.getSalary()) {
            return emp1.getName() + "has highest salaries";
        } else if (emp2.getSalary() > emp1.getSalary()) {
            return emp2.getName() + " has a higher salary";
        } else {
            return "Equal salaries";
        }
    }

    public static void main(String[] args) {

        //parameterized constrctor
        System.out.println("Creating first employee using constructor...");
        Employee employee1 = new Employee("John Doe", 30, 5000.0);
        System.out.println("Employee1: ");
        employee1.display();

        //default constructor
        System.out.println("\nCreating first employee using constructor...");
        Employee employee2 = new Employee();
        employee2.setName("Jane Smith");
        employee2.setAge(25);
        employee2.setSalary(5500);
        System.out.println("Employee2: ");
        employee2.display();

        System.out.println("Testing validation with invalid values:");
        employee1.setName("");  // Invalid: empty name
        employee1.setAge(70);   // Invalid: age outside range
        employee2.setSalary(-100); // Invalid: negative salary

        System.out.println("\nEmployee Details After Invalid Values:");
        employee1.display();
        employee2.display();

        // Step 4: Give both employees a 10% raise
        System.out.println("Giving both employees a 10% raise:");
        employee1.giveRaise(10);
        employee2.giveRaise(10);

        System.out.println("\nEmployee Details After Raise:");
        employee1.display();
        employee2.display();

        // Step 5: Clone the first employee
        System.out.println("\nCloning the first employee...");

        try {
            Employee cloneEmployee1 = (Employee) (employee1.clone());
            System.out.println("\ncloneEmployee1 Details: ");
            cloneEmployee1.display();

            // Step 14: Modify the original employee to show clones are separate objects
            System.out.println("Modifying the original employee's salary...");
            employee1.setSalary(6000.0);

            System.out.println("\nOriginal Employee After Modification:");
            employee1.display();

            System.out.println("Cloned Employee After Original was Modified:");
            cloneEmployee1.display();

        } catch (CloneNotSupportedException e) {
            System.out.println("Cloning not supported: " + e.getMessage());
        }

        String result = comparisonSalaries(employee1, employee2);
        System.out.println("Salary comparison result: " + result);


    }
}
