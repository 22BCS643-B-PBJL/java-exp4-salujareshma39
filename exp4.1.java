/* Easy Level:
Write a Java program to implement an ArrayList that stores employee details (ID, Name, and Salary). Allow users to add, update, remove, and search employees.
*/
import java.util.ArrayList;
import java.util.Scanner;

class Emp {
    int id;
    String name;
    double salary;

    Emp(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Salary: " + salary;
    }
}

public class EmpManagement {
    static ArrayList<Emp> employees = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Add Employee\n2. Update Employee\n3. Remove Employee\n4. Search Employee\n5. Display All\n6. Exit");
            System.out.print("Enter option: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1: addEmp(); break;
                case 2: updateEmp(); break;
                case 3: removeEmp(); break;
                case 4: searchEmp(); break;
                case 5: displayAll(); break;
                case 6: return;
                default: System.out.println("Invalid Option!");
            }
        }
    }

    static void addEmp() {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Salary: ");
        double salary = scanner.nextDouble();
        employees.add(new Emp(id, name, salary));
        System.out.println("Employee Added!");
    }

    static void updateEmp() {
        System.out.print("Enter ID to update: ");
        int id = scanner.nextInt();
        for (Emp e : employees) {
            if (e.id == id) {
                scanner.nextLine();
                System.out.print("Enter New Name: ");
                e.name = scanner.nextLine();
                System.out.print("Enter New Salary: ");
                e.salary = scanner.nextDouble();
                System.out.println("Employee Updated!");
                return;
            }
        }
        System.out.println("Employee Not Found!");
    }

    static void removeEmp() {
        System.out.print("Enter ID to remove: ");
        int id = scanner.nextInt();
        employees.removeIf(e -> e.id == id);
        System.out.println("Employee Removed!");
    }

    static void searchEmp() {
        System.out.print("Enter ID to search: ");
        int id = scanner.nextInt();
        for (Emp e : employees) {
            if (e.id == id) {
                System.out.println(e);
                return;
            }
        }
        System.out.println("Employee Not Found!");
    }

    static void displayAll() {
        if (employees.isEmpty()) {
            System.out.println("No Employees Found!");
        } else {
            employees.forEach(System.out::println);
        }
    }
}
