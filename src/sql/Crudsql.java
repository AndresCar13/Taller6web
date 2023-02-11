/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sql;
import getset.Variables;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

/**
 *
 * @author afcz1
 */
public class Crudsql extends Conexionsql{
    java.sql.Statement st;
    ResultSet rs;
    Variables var = new Variables();
    
    public void insertar(String id, String nombre, String descripcion) {
        try {
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "insert into tipodocumento(id,nombre,descripcion) values('"+id+"','"+nombre+"','"+descripcion+"');";
            st.execute(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "El registo se guardó correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en el registro\n\n"+e, "Warning", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void mostrar(String id) {
        try {
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "select * from tipodocumento where id = '"+id+"';";
            rs = st.executeQuery(sql);
            if(rs.next()) {
                var.setId(rs.getString("id"));
                var.setNombre(rs.getString("nombre"));
                var.setDescripcion(rs.getString("descripcion"));
            } else {
                var.setId(rs.getString(""));
                var.setNombre(rs.getString(""));
                var.setDescripcion(rs.getString(""));
                JOptionPane.showMessageDialog(null, "No se encontró registro", "Sin registro", JOptionPane.INFORMATION_MESSAGE);
                
            }
            st.close();
            conexion.close();
            
        } catch (Exception e) {            
            JOptionPane.showMessageDialog(null, "Error en el sistema de búsqueda\n\n"+e, "Warning", JOptionPane.ERROR_MESSAGE);            
        }
    }
    
    public void actualizar(String id, String nombre, String descripcion) {
        try {
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "update tipodocumento set id = '"+id+"', nombre = '"+nombre+"', descripcion = '"+descripcion+"' where id = '"+id+"' ";
            st.executeUpdate(sql);
            
            st.close();
            conexion.close();
            
            JOptionPane.showMessageDialog(null, "El registro se actualizó correctamente", "Felicidades", JOptionPane.INFORMATION_MESSAGE);
                       
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar", "Warning", JOptionPane.ERROR_MESSAGE);
            
        }
    }
    
    public void eliminar(String id) {
        try {
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "delete from tipodocumento where id = '"+id+"'; ";
            st.executeUpdate(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "El registro se borró correctamente", "Felicidades", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al Borrar", "Warning", JOptionPane.ERROR_MESSAGE);
        }
    }    
    
}
