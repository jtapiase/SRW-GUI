package dataLayer;

import java.sql.*;
import java.util.Properties;

public class DB_user {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://52.167.225.0:3307/SDRW";

    static final String USER = "userd2r";
    static final String PASSWORD = "D2R/user*";

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

            sql = "SELECT * FROM usuarios WHERE username='"+ sUserName +"' AND password='"+ sUserPassword+"'";


            System.out.println(sql);

            ResultSet rs = stmt.executeQuery(sql);

            if(rs.next()) {
                isValidUser = true;
                System.out.println(rs);
            }

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

    public void register(String sUserName, String sUserPassword){

        Connection conn = null;
        Statement stmt = null;
        String sql = "";

        try{
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("connecting bd...");

            Properties properties = new Properties();
            properties.setProperty("user", USER);
            properties.setProperty("password", PASSWORD);
            properties.setProperty("useSSL", "true");
            properties.setProperty("verifyServerCertificate", "true");
            properties.setProperty("requireSSL", "false");
            conn = DriverManager.getConnection(DB_URL,properties);

            System.out.println("Creating statement");
            stmt = conn.createStatement();

            sql = "INSERT INTO usuarios VALUES (NULL,'"+sUserName+"','"+sUserPassword+"')";


            System.out.println(sql);

            stmt.executeUpdate(sql);

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

    }

    public void calificar(int calificacion, String id){

        Connection conn = null;
        Statement stmt = null;
        String sql = "";
        System.out.println(id);
        try{
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("connecting bd...");

            Properties properties = new Properties();
            properties.setProperty("user", USER);
            properties.setProperty("password", PASSWORD);
            properties.setProperty("useSSL", "true");
            properties.setProperty("verifyServerCertificate", "true");
            properties.setProperty("requireSSL", "false");
            conn = DriverManager.getConnection(DB_URL,properties);

            System.out.println("Creating statement");
            stmt = conn.createStatement();
            System.out.println(id);
            sql = "UPDATE medicamentos_users SET calificacion = "+calificacion+";";


            System.out.println(sql);

            stmt.executeUpdate(sql);

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

    }
}
