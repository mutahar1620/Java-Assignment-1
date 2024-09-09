import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManagementApp {

    // Employee class
    public static class Employee {
        private String name;
        private int id;
        private int salary;

        public Employee(String name, int id, int salary) {
            this.name = name;
            this.id = id;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public int getId() {
            return id;
        }

        public int getSalary() {
            return salary;
        }

        @Override
        public String toString() {
            return "Employee Name: " + name + ", ID: " + id + ", Salary: $" + salary;
        }
    }

    // EmployeeManager class to handle the operations
    public static class EmployeeManager {
        private ArrayList<Employee> employees = new ArrayList<>();

        public void addEmployee(String name, int id, int salary) {
            employees.add(new Employee(name, id, salary));
            System.out.println("Employee added.");
        }

        public void removeEmployee(int index) {
            if (index >= 0 && index < employees.size()) {
                employees.remove(index);
                System.out.println("Employee removed.");
            } else {
                System.out.println("Invalid index.");
            }
        }

        public void displayAllEmployees() {
            if (employees.isEmpty()) {
                System.out.println("No employees to display.");
            } else {
                System.out.println("Displaying all employees:");
                for (Employee employee : employees) {
                    System.out.println(employee);
                }
            }
        }
    }

    // Main class
    public static void main(String[] args) {
        EmployeeManager employeeManager = new EmployeeManager();
        Scanner input = new Scanner(System.in);
        int choice = 0;

        while (choice != 4) {
            System.out.println("\nEmployee management: ");
            System.out.println("1. Add employee ");
            System.out.println("2. Remove employee by index ");
            System.out.println("3. Display all employees ");
            System.out.println("4. Exit ");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine();  // Consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter employee name: ");
                    String name = input.nextLine();
                    System.out.print("Enter employee ID: ");
                    int id = input.nextInt();
                    System.out.print("Enter employee salary: ");
                    int salary = input.nextInt();
                    employeeManager.addEmployee(name, id, salary);
                    break;

                case 2:
                    System.out.print("Enter the index of the employee to remove: ");
                    int indexOfRemove = input.nextInt();
                    employeeManager.removeEmployee(indexOfRemove);
                    break;

                case 3:
                    employeeManager.displayAllEmployees();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        input.close();
    }
}
