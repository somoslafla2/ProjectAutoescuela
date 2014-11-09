/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.lambdas;

import controlador.ControladorSingleton;
import modelo.factoriaAlumnos.alumno.Alumno;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import javax.swing.JOptionPane;
import modelo.conexion.ConexionAutoescuela;
import modelo.interfaces.Update;
import modelo.llamadas.ILlamadas;

/**
 * Clase que contiene una expresión lambda del tipo Update
 * @author Oscar, Ester,Christian y Gonzalo
 */
public class UpdateLambda {
    /**
     * Expresión lambda que retorna true si se ha conseguido actualizar un alumno
     * y false en caso contrario.
     */
    private final Update<Alumno,Boolean> modificarAlumno = (Alumno alumno)->{
        //Damos valor a los argumentos
        boolean exito = false;
        Connection con = ConexionAutoescuela.getInstance().getConexion();
        CallableStatement llamada;
        try {
            // Se prepara la llamada
            llamada = con.prepareCall(ILlamadas.OBTENERIDALUMNO);
            //Damos valor a los argumentos
            llamada.registerOutParameter(1, Types.INTEGER); // Tipo de salida
            llamada.setString(2, alumno.getDni());
            // Se ejecuta la llamada.
            int filas = llamada.executeUpdate();
            Integer id = new Integer(-1);
            // Si la llamada ha tenido éxito
            if (filas != 0){
                id = llamada.getInt(1); // Se recoge el identificador
            } 
            // Se cierra la llamada.
            llamada.close();
            // Se comprueba que el identificador sea distinto de -1, lo que quiere 
            // decir que hemos encontrado el alumno.
            if (id != -1){
                // Se realiza la actualización de los datos de dicho alumno
                llamada = con.prepareCall(ILlamadas.MODIFICAR_ALUMNO);
                llamada.setInt(1, id);
                ControladorSingleton.getInstance().prepararLlamada(llamada, alumno, null);

                int filas_afectadas = llamada.executeUpdate();
                
                exito = true;
            }
            llamada.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error", "Ha ocurrido un error\nen la conexión", JOptionPane.ERROR_MESSAGE);
        }
        return exito;
    };

    public Update<Alumno, Boolean> getModificarAlumno() {
        return modificarAlumno;
    }
}
