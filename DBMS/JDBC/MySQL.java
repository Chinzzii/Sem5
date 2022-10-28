package JDBC;

import java.sql.*;
import java.util.Scanner;

/*
	1. import package
	2. load and register the driver
	3. create a connection
	4. create a statement
	5. execute the query
	6. process the result
	7. close
*/

public class MySQL {

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		String url = "jdbc:mysql://localhost:3306/class";
		String userName = "root";
		String pass = "chinmay";
		
		String query = "";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, userName, pass);		
		Statement st = con.createStatement();
		
		String data = "";
		String tableName = "";
		String field;
		String value;
		
		int ch=0;
		while(ch!=7) {
			System.out.println("\nChoose Operation: ");
			System.out.println("1. Create Table \n2. Drop Table \n3. Insert \n4. Update \n5. Delete \n6. Select All Records \n7. Exit");
			ch = sc.nextInt();
			
			switch(ch) {
				case 1:
					System.out.println("Enter Table Name: ");
					sc.next();
					tableName = sc.nextLine();
					System.out.println("Enter field and type in form (field1 type2, field2 type2)");
					field=sc.nextLine();
					query = "create table " + tableName + field;
					st.executeUpdate(query);
					System.out.println("Table " + tableName + " created!");
					break;
					
				case 2:
					System.out.println("Enter Table Name to be Dropped: ");
					tableName = sc.nextLine();
					query = "drop table " + tableName;
					st.executeUpdate(query);
					System.out.println("Table " + tableName + " deleted!");
					break;
					

				case 3:
					System.out.println("Enter Table Name to be Inserted: ");
					sc.next();
					tableName = sc.nextLine();
					System.out.println("Enter Values in form (value1, value2,...): ");
					value = sc.nextLine();
					query = "insert into " + tableName + " values " + value;
					st.executeUpdate(query);
					break;
					
				case 4:
					System.out.println("Enter Table Name to be Updated: ");
					sc.next();
					tableName = sc.nextLine();
					System.out.println("Enter field to be updated: ");
					field = sc.nextLine();
					System.out.println("Enter new name of field: ");
					value = sc.nextLine();
					query = "update " + tableName + " set " + field + "='" + value + "\'";
					st.executeUpdate(query);
					break;
					
				case 5:
					System.out.println("Enter Table Name to be Deleted: ");
					tableName = sc.nextLine();
					query = "delete from " + tableName;
					st.executeUpdate(query);
					break;
				
				case 6:
					query = "select * from student";
					ResultSet rs = st.executeQuery(query);
					while(rs.next()) {
						data = rs.getInt(1) + " : " + rs.getString(2) + "\t" + rs.getInt(3);
						System.out.println(data);
					}
					break;
				
				case 7:
					System.out.println("Exited");
					break;
				
				default:
					break;
			
			}
		}
		st.close();
		con.close();
	}

}
