package dataLayer;

import java.sql.*;
import java.util.Properties;

public class DB_user {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://52.167.225.0:3307/SDRW";

    static final String USER = "jtapiase";
    static final String PASSWORD = "pass123";

    public boolean isValidUserLogin(String sUserName, String sUserPassword){

        boolean isValidUser = false;

        Connection conn = null;
        Statement stmt = null;
        String sql = "";

        try{
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("connecting bd");

            Properties properties = new Properties();
            properties.setProperty("user", USER);
            properties.setProperty("password", PASSWORD);
            properties.setProperty("useSSL", "true");
            properties.setProperty("verifyServerCertificate", "true");
            properties.setProperty("requireSSL", "false");
            conn = DriverManager.getConnection(DB_URL,properties);

            System.out.println("Creating statement");
            stmt = conn.createStatement();

            sql = "SELECT * FROM user";

            System.out.println(sql);

            ResultSet rs = stmt.executeQuery(sql);

            if(rs.next())
                isValidUser = true;

            rs.close();
            stmt.close();
            conn.close();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (stmt != null)
                    stmt.close();
            }catch (SQLException se2){se2.printStackTrace();}
            try {
                if (conn != null)
                    conn.close();
            }catch (SQLException se){se.printStackTrace();}
        }

        System.out.println("Closing db connection, bye");

        return isValidUser;
    }
}
