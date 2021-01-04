/*
 * CS3810 - Principles of Database Systems - Spring 2021
 * Instructor: Thyago Mota
 * Description: Activity 01 - EmployeeFMS
 */

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class EmployeeFMS implements CRUD<Integer, Employee> {

    private static final String DATA_FILE = "employee.csv";

    @Override
    public void create(Employee employee) {
        try {
            PrintStream out = new PrintStream(new FileOutputStream(DATA_FILE, true));
            out.println(employee);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Employee read(Integer id) {
        try {
            Scanner sc = new Scanner(new FileInputStream(DATA_FILE));
            Employee emp = null;
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String data[] = line.split(",");
                int current = Integer.parseInt(data[0]);
                if (current == id) {
                    String name = data[1];
                    String dep = data[2];
                    emp = new Employee(id, name, dep);
                    break;
                }
            }
            sc.close();
            return emp;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    // TODO: implement the update operation
    @Override
    public void update(Integer id, Employee employee) {

    }

    // TODO: implement the delete operation
    @Override
    public void delete(Integer id) {

    }
}
