/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Singleton de la conexión
 * @author Oscar, Ester,Christian y Gonzalo
 */
public class ConexionAutoescuela {
    
    private Connection conexion;

    /**
     * 
     * @return Retorna la conexión y en el caso de que esté cerrada, la vuelve a abrir
     */
    public Connection getConexion() {
        try {
            if (conexion.isClosed())
                conexion = DriverManager.getConnection(
                        "jdbc:oracle:thin:@localhost:1521:XE", "autoescuela", "autoescuela");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Imposible realizar la conexión", 
                    "Error de conexión", JOptionPane.ERROR_MESSAGE);
        }
        return conexion;
    }
    
    /**
     * Cierre de conexión. Si la conexión ya está cerrada no es necesario volverla a cerrar 
     */
    public void closeConnection() {
        try {
            if (!conexion.isClosed())
                conexion.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error", "Error al cerrar la conexión", JOptionPane.ERROR_MESSAGE);
        }
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
