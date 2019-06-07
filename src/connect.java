import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;

public class connect {

    static final String DB_URL ="jdbc:sqlite:sqliteDemo.db";
    public static void main(String[] args) {
         Connection con = null;
         Statement st = null;
        try {
             Class.forName("org.sqlite.JDBC");
            System.out.println("Connecting to a selected database...");
            con = DriverManager.getConnection(DB_URL);
            System.out.println("Connected database successfully...");
            System.out.println("Inserting records into the table...");
            st = con.createStatement();

            st.executeUpdate("drop table if exists User");
            }catch (Exception ex){

            ex.printStackTrace();
            System.out.println("connection failed");

            }finally {
            if (con != null){
                try {
                    con.close();
                }catch (SQLException e){ }
            }
        }
    }
}
