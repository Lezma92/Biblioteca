package mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class conexion {

    private String bd = "biblioteca";
    private String url = "jdbc:mysql://localhost/" + bd;
    private String user = "root";
    private String pass = "";
    private Connection con = null;

    private void conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"No es posible conectarse con la base de datos \n"+e.getMessage());
        }
    }

    public Connection getConexion() {
        this.conectar();
        return con;
    }

}
