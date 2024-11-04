package DataBase;

import java.sql.*;

public class DBHelper{
    Connection c = null;
    private String usr = "Database";
    private String psw = "Password";
    private String url = "jdbc:mysql://mysqlserver.com:3306/Database?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public Connection getConnection() throws SQLException{
        try{
            c = DriverManager.getConnection(url, usr, psw);
        }catch(SQLException e){System.out.println("DBH: " + e.getLocalizedMessage());}
        return c;
    }
}
