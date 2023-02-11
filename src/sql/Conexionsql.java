/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sql;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author afcz1
 */
public class Conexionsql {
    Connection conn = null;
    String url = "jdbc:postgresql://localhost:5432/crud_JAVA";
    String usuario = "postgres";
    String clave = "1005484061";
    
    public Connection conectar() {
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, usuario, clave);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la conección\n\n"+e, "Warning", JOptionPane.ERROR_MESSAGE);
        }
        return conn;
    }
}
