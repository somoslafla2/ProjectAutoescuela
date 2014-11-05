/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Formacion
 */
public class ConexionAutoescuela {
    
    private Connection conexion;

    public Connection getConexion() {
        Connection c = null;
        try {
            if (conexion.isClosed())
                c = conexion;
            else
                c = DriverManager.getConnection(
                        "jdbc:oracle:thin:@localhost:1521:XE", "autoescuela", "autoescuela");
        } catch (SQLException ex) {
            System.out.println("Vamos mal...");
        }
        return c;
    }
    
    private ConexionAutoescuela() {
        try {
            conexion = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:XE", "autoescuela", "autoescuela");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Imposible realizar la conexión", 
                    "Error de conexión", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static ConexionAutoescuela getInstance() {
        return ConexionHolder.INSTANCE;
    }
    
    private static class ConexionHolder {

        private static final ConexionAutoescuela INSTANCE = new ConexionAutoescuela();
    }
}
