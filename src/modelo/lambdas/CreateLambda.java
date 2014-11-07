/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.lambdas;

import controlador.ControladorSingleton;
import modelo.carnet.TipoCarnet;
import modelo.factoriaAlumnos.alumno.AlumnoPresencial;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import modelo.MatriculaAlumno;
import modelo.conexion.ConexionAutoescuela;
import modelo.interfaces.Create;
import modelo.llamadas.Llamadas;

/**
 *
 * @author Oscar
 */
public class CreateLambda {
    private final Create<MatriculaAlumno, Integer> crear = (MatriculaAlumno mA)->{
        // Crear el alumno en la base de datos con el carnet correspondiente
        Integer id = -1;
        Connection con = ConexionAutoescuela.getInstance().getConexion();
        try (CallableStatement llamada = con.prepareCall(Llamadas.INSERTAR_NUEVO2,
                ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE)) {
            //Damos valor a los argumentos
            llamada.registerOutParameter(1, Types.INTEGER);
            ControladorSingleton.getInstance().prepararLlamada(llamada, mA.getAlumno(), mA.getCarnet());

            int filas_afectadas = llamada.executeUpdate();
            //System.out.println("las filas afectadas son: " + filas_afectadas);
            id = llamada.getInt(1);

            llamada.close();
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return id;
    };

    public Create<MatriculaAlumno, Integer> getCrear() {
        return crear;
    }

}
