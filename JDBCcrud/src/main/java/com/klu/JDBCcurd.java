package com.klu;
import java.sql.*;
public class JDBCcurd {

	public static void main(String[] args){
		
		String url="jdbc:mysql://localhost:3306/fsads3";
		String usr="root";
		String pwd="@Vijay9955";
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,usr,pwd);
				System.out.println("Database Connection Established");
		Statement st=con.createStatement();
		String createDept="create table if not exists Dept("+"dept_id int primary key auto_increment,"+"dept_name varchar(20)"+")";
		st.execute(createDept);
		System.out.println("Department table created");
		st.execute(
			      "CREATE TABLE IF NOT EXISTS Emp (" +
			      "emp_id INT PRIMARY KEY AUTO_INCREMENT, " +
			      "emp_name VARCHAR(15), " +
			      "sal DOUBLE, " +
			      "dept_id INT, " +
			      "FOREIGN KEY (dept_id) REFERENCES dept(dept_id)" +
			      ")"
			    );
        System.out.println("Employee table created"); 
	}
	catch(Exception e){
		e.printStackTrace();
	}
  }
}