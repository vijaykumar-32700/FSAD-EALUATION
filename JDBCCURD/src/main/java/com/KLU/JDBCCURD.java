package com.KLU;
import java.sql.*;
import java.util.Scanner;

public class JDBCCURD {

	static String url = "jdbc:mysql://localhost:3306/fsad3";
    static String user = "root";
    static String password = "@Vijay9955";

    public static void main(String[] args) {

        createTables();   // Create tables first

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n------ MENU ------");
            System.out.println("1. Insert Department");
            System.out.println("2. Insert Employee");
            System.out.println("3. View Employees");
            System.out.println("4. Update Employee Salary");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    insertDept();
                    break;
                case 2:
                    insertEmployee();
                    break;
                case 3:
                    viewEmployees();
                    break;
                case 4:
                    updateEmployee();
                    break;
                case 5:
                    deleteEmployee();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 6);
    }

    // ================= TABLE CREATION =================
    static void createTables() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            Statement st = con.createStatement();

            String deptTable =
                    "CREATE TABLE IF NOT EXISTS dept (" +
                    "dept_id INT PRIMARY KEY AUTO_INCREMENT, " +
                    "dept_name VARCHAR(50))";

            String empTable =
                    "CREATE TABLE IF NOT EXISTS employee (" +
                    "emp_id INT PRIMARY KEY AUTO_INCREMENT, " +
                    "emp_name VARCHAR(50), " +
                    "salary DOUBLE, " +
                    "dept_id INT, " +
                    "FOREIGN KEY (dept_id) REFERENCES dept(dept_id))";

            st.execute(deptTable);
            st.execute(empTable);

            System.out.println("Tables created or already exist.");

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ================= INSERT DEPARTMENT =================
    static void insertDept() {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            String sql = "INSERT INTO dept(dept_name) VALUES (?)";
            PreparedStatement ps = con.prepareStatement(sql);

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Dept Name: ");
            ps.setString(1, sc.next());

            ps.executeUpdate();
            System.out.println("Department inserted successfully.");

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ================= INSERT EMPLOYEE =================
    static void insertEmployee() {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            String sql = "INSERT INTO employee(emp_name, salary, dept_id) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Employee Name: ");
            ps.setString(1, sc.next());

            System.out.print("Enter Salary: ");
            ps.setDouble(2, sc.nextDouble());

            System.out.print("Enter Dept ID: ");
            ps.setInt(3, sc.nextInt());

            ps.executeUpdate();
            System.out.println("Employee inserted successfully.");

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ================= VIEW EMPLOYEES =================
    static void viewEmployees() {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            String sql =
                    "SELECT e.emp_id, e.emp_name, e.salary, d.dept_name " +
                    "FROM employee e JOIN dept d ON e.dept_id = d.dept_id";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            System.out.println("\nID | Name | Salary | Department");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("emp_id") + " | " +
                        rs.getString("emp_name") + " | " +
                        rs.getDouble("salary") + " | " +
                        rs.getString("dept_name"));
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ================= UPDATE EMPLOYEE =================
    static void updateEmployee() {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            String sql = "UPDATE employee SET salary=? WHERE emp_id=?";
            PreparedStatement ps = con.prepareStatement(sql);

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();

            System.out.print("Enter New Salary: ");
            double sal = sc.nextDouble();

            ps.setDouble(1, sal);
            ps.setInt(2, id);

            ps.executeUpdate();
            System.out.println("Employee salary updated.");

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ================= DELETE EMPLOYEE =================
    static void deleteEmployee() {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            String sql = "DELETE FROM employee WHERE emp_id=?";
            PreparedStatement ps = con.prepareStatement(sql);

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Employee ID to delete: ");
            ps.setInt(1, sc.nextInt());

            ps.executeUpdate();
            System.out.println("Employee deleted.");

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}