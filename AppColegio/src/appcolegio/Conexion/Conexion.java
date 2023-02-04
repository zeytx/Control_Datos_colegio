package appcolegio.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;



    public class Conexion {

    public static Connection getConnection() throws ClassNotFoundException{
        Connection con = null;
        try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String conexionUrl = "jdbc:sqlserver://ZEYTX\\SQLEXPRESS:1433;databaseName=BDCOLEGIO;user=sa;password=130502;";
                con = DriverManager.getConnection(conexionUrl);
            } catch (SQLException e){
                JOptionPane.showMessageDialog(null, "CONEXION ERRONEA " + e.toString());  
            }
        return con;
    }    
}
