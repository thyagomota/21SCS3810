/*
 * CS3810 - Principles of Database Systems - Spring 2021
 * Instructor: Thyago Mota
 * Description: Activity 01 - EmployeeFMSDriver
 */

import java.util.Scanner;

public class EmployeeFMSDriver {

    static void menu() {
        System.out.println("1. Create");
        System.out.println("2. Read");
        System.out.println("3. Update");
        System.out.println("4. Delete");
        System.out.println("5. Quit");
    }

    public static void main(String[] args) {
        EmployeeFMS fms = new EmployeeFMS();
        Scanner sc = new Scanner(System.in);
        int option = 0;
        int id;
        String name, department;
        Employee employee;
        while (option != 5) {
            menu();
            System.out.print("? ");
            option = Integer.parseInt(sc.nextLine());
            switch (option) {
                case 1:
                    System.out.print("id? ");
                    id = Integer.parseInt(sc.nextLine());
                    System.out.print("name? ");
                    name = sc.nextLine();
                    System.out.print("department? ");
                    department = sc.nextLine();
                    employee = new Employee(id, name, department);
                    fms.create(employee);
                    break;
                case 2:
                    System.out.print("id? ");
                    id = Integer.parseInt(sc.nextLine());
                    employee = fms.read(id);
                    if (employee != null)
                        System.out.println(employee);
                    else
                        System.out.println("Not found!");
                    break;
                case 3:
                    System.out.print("(old) id? ");
                    int oldId = Integer.parseInt(sc.nextLine());
                    System.out.print("(new) id? ");
                    id = Integer.parseInt(sc.nextLine());
                    System.out.print("(new) name? ");
                    name = sc.nextLine();
                    System.out.print("(new) department? ");
                    department = sc.nextLine();
                    employee = new Employee(id, name, department);
                    fms.update(oldId, employee);
                    break;
                case 4:
                    System.out.print("id? ");
                    id = Integer.parseInt(sc.nextLine());
                    fms.delete(id);
                    break;
            }
        }
    }
}
