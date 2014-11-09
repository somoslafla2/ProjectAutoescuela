/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.lambdas;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import javax.swing.JOptionPane;
import modelo.conexion.ConexionAutoescuela;
import modelo.interfaces.Result;
import modelo.llamadas.ILlamadas;

/**
 * Clase que contiene una expresión lambda del tipo Result<String, Integer>
 * @author Oscar, Ester,Christian y Gonzalo
 */
public class ObtenerIDLambda {
    /**
     * Expresión lambda que devuelve un Integer que se corresponde con el identificador
     * del alumno con DNI = dni en la base de datos, en caso de no encontralo devuelve -1.
     */
    private final Result<String,Integer> consultarID = (String dni)->{
        Integer id = -1;
        Connection con = ConexionAutoescuela.getInstance().getConexion();
        try (CallableStatement llamada = con.prepareCall(ILlamadas.OBTENERIDALUMNO)) {
            //Damos valor a los argumentos
            llamada.registerOutParameter(1, Types.INTEGER); // Tipo de salida de la función
            llamada.setString(2, dni); // Se asocia el dni al playholder correspondiente en la llamada.

            int filas_afectadas = llamada.executeUpdate();

            // Se recoge el IDALUMNO de la tabla
            id = llamada.getInt(1);

            llamada.close();
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error", "Ha ocurrido un error\nen la conexión", JOptionPane.ERROR_MESSAGE);        
        }

        return id;
    };

    public Result<String, Integer> getConsultarID() {
        return consultarID;
    }
}
