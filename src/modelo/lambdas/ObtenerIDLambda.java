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
import modelo.llamadas.Llamadas;

/**
 *
 * @author Oscar, Ester,Christian y Gonzalo
 */
public class ObtenerIDLambda {
    private final Result<String,Integer> consultarID = (String dni)->{
        Integer id = -1;
        Connection con = ConexionAutoescuela.getInstance().getConexion();
        try (CallableStatement llamada = con.prepareCall(Llamadas.OBTENERIDALUMNO)) {
            //Damos valor a los argumentos
            llamada.registerOutParameter(1, Types.INTEGER);
            llamada.setString(2, dni);

            int filas_afectadas = llamada.executeUpdate();
            //System.out.println("las filas afectadas son: " + filas_afectadas);
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
