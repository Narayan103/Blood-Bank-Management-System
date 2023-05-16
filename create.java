import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class create {
    create() throws SQLException {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            //Getting the connection
            String mysqlUrl = "jdbc:mysql://localhost/";
            Connection con = DriverManager.getConnection(mysqlUrl, "root", "students");
            System.out.println("Connection established......");
            //Creating the Statement
            Statement stmt = con.createStatement();
            {
                String sql = "CREATE DATABASE bloodbank";
                stmt.executeUpdate(sql);
                System.out.println("Database created successfully...");
                int r = 0;
                if (r == 0) {
                    new createtable();
                }
            }
        } catch (Exception ae) {
            ae.printStackTrace();

        }
    }
        public static void main (String[]args) throws SQLException {
            new create();
        }

    }
