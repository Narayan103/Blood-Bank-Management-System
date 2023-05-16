import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class createtable  {
    createtable() throws SQLException {
        try {
            //Registering the Driver
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            //Getting the connection
            String mysqlUrl = "jdbc:mysql://localhost/bloodbank";
            Connection con = DriverManager.getConnection(mysqlUrl, "root", "students");
            System.out.println("Connection established......");
            //Creating the Statement
            Statement stmt = con.createStatement();
            //Query to create a table
            String query = "CREATE TABLE bloodbank("
                    + "name varchar(20), "
                    + "Blood_Group VARCHAR (5), "
                    + "age varchar(3), "
                    + "phone_no varchar(10), "
                    + "gender varchar(10), "
                    + "Username varchar(10), "
                    + "Password varchar(10), "
                    + "PRIMARY KEY (Username,phone_no))";
            String query1 = "CREATE TABLE location("
                    + "Username varchar(20), "
                    + "location VARCHAR (20), "
                    + "bloodtype varchar(4), "
                    + "phone_no varchar(14), "
                    + "PRIMARY KEY (Username,phone_no))";
            String query2 = "CREATE TABLE acceptor("
                    + "Username varchar(20), "
                    + "location VARCHAR (20), "
                    + "bloodtype varchar(4), "

                    + "PRIMARY KEY (Username))";
            String query3 = "CREATE TABLE login("
                    + "User_name varchar(10), "
                    + "Password VARCHAR (10), "
                    + "PRIMARY KEY (User_name))";
            String a = "admin123";
            String b = "admin987";
            String q = "INSERT INTO login ( User_name, Password) values('" + a + "','" + b + "')";

            stmt.execute(query);
            stmt.execute(query1);
            stmt.execute(query2);
            stmt.execute(query3);
            stmt.execute(q);
            System.out.println("Table Created......");
        } catch (Exception ae) {
            ae.printStackTrace();
        }
    }
    public static void main(String args[]) throws SQLException {
        new createtable();
    }
}
