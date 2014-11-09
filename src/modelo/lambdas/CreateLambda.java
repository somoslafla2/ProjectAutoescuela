/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.lambdas;

import controlador.ControladorSingleton;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import javax.swing.JOptionPane;
import modelo.MatriculaAlumno;
import modelo.conexion.ConexionAutoescuela;
import modelo.interfaces.Create;
import modelo.llamadas.ILlamadas;

/**
 * Clase que contiene una expresión lambda del tipo Create<Matricula, Integer>
 * @author Oscar, Ester,Christian y Gonzalo
 */
public class CreateLambda {
    /**
     * Expresión lambda que se comunica con la base de datos para introducir un nuevo
     * registro.
     */
    private final Create<MatriculaAlumno, Integer> crear = (MatriculaAlumno mA)->{
        // Crear el alumno en la base de datos con el carnet correspondiente
        Integer id = -1;
        Connection con = ConexionAutoescuela.getInstance().getConexion();
        try (CallableStatement llamada = con.prepareCall(ILlamadas.INSERTAR_NUEVO2,
                ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE)) {
            //Damos valor a los argumentos
            llamada.registerOutParameter(1, Types.INTEGER);
            // El controlador prepara la llamada a la base de datos.
            ControladorSingleton.getInstance().prepararLlamada(llamada, mA.getAlumno(), mA.getCarnet());

            int filas_afectadas = llamada.executeUpdate();
            // Se recoge el identificador asignado al nuevo alumno
            id = llamada.getInt(1);

            llamada.close();
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error", "Ha ocurrido un error en la conexión", JOptionPane.ERROR_MESSAGE);
        }
        return id;
    };

    public Create<MatriculaAlumno, Integer> getCrear() {
        return crear;
    }

}
