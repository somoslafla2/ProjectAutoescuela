/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.lambdas;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.conexion.ConexionAutoescuela;
import modelo.interfaces.Delete;
import modelo.llamadas.ILlamadas;

/**
 * Clase que contiene una expresión lambda del tipo Delete<Integer, Boolean>
 * @author Oscar, Ester,Christian y Gonzalo
 */
public class DeleteLambda {
    /**
     * Expresión lambda que realiza el borrado de un alumno concreto de la base de
     * datos por medio de su indentificador.
     */
    private final Delete<Integer, Boolean> borrar = (Integer id)->{
        boolean exito = false;
        Connection con = ConexionAutoescuela.getInstance().getConexion();
        try (CallableStatement llamada = con.prepareCall(ILlamadas.BORRAR_ALUMNO,
                    ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE)){
            // Se da valor a los argumentos de la llamada
            llamada.setInt(1, id); // Se asigna el identidificador del alumno a borrar

            int filas_afectadas = llamada.executeUpdate();
            if (filas_afectadas != 0)  // Se ha conseguido borrar el alumno
                exito = true;
            
            //Se cierra la llamada
            llamada.close();
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error", "Ha ocurrido un error\nen la conexión", JOptionPane.ERROR_MESSAGE);
        }
        return exito;
    };

    public Delete<Integer, Boolean> getBorrar() {
        return borrar;
    }
    
}
