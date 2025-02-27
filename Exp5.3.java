/* Hard Level:
Create a menu-based Java application with the following options. 1.Add an Employee 2. Display All 3. Exit If option 1 is selected, the application should gather details of the employee like employee name, employee id, designation and salary and store it in a file. If option 2 is selected, the application should display all the employee details. If option 3 is selected the application should exit
*/
import java.io.*;
import java.util.*;

class Employee {
    private String name;
    private int id;
    private String designation;
    private double salary;

    public Employee(String name, int id, String designation, double salary) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        this.salary = salary;
    }

    public String toString() {
        return id + ", " + name + ", " + designation + ", " + salary;
    }
}

public class EmployeeManagement {
    private static final String FILE_NAME = "employees.txt";
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add an Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    addEmployee(scanner);
                    break;
                case 2:
                    displayEmployees();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option! Try again.");
            }
        }
    }

    private static void addEmployee(Scanner scanner) {
        try (FileWriter fw = new FileWriter(FILE_NAME, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter pw = new PrintWriter(bw)) {
            
            System.out.print("Enter Employee ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            
            System.out.print("Enter Employee Name: ");
            String name = scanner.nextLine();
            
            System.out.print("Enter Designation: ");
            String designation = scanner.nextLine();
            
            System.out.print("Enter Salary: ");
            double salary = scanner.nextDouble();
            
            Employee emp = new Employee(name, id, designation, salary);
            pw.println(emp);
            
            System.out.println("Employee added successfully!");
        } catch (IOException e) {
            System.out.println("Error saving employee data.");
        }
    }

    private static void displayEmployees() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("\nEmployee Details:");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("No employees found or error reading file.");
        }
    }
}
