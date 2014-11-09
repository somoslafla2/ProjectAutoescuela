/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.lambdas;

import controlador.ControladorSingleton;
import modelo.carnet.TipoCarnet;
import modelo.excepciones.AlumnoMalFormado;
import modelo.factoriaAlumnos.alumno.Alumno;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import modelo.MatriculaAlumno;
import modelo.conexion.ConexionAutoescuela;
import modelo.interfaces.Result;
import modelo.llamadas.ILlamadas;

/**
 * Clase que contiene una expresión lambda del tipo Result
 * @author Oscar, Ester,Christian y Gonzalo
 */
public class ResultLambda {
    /**
     * Retorna un ResultSet con todos los alumno en la base de datos.
     */
    private final Result<ResultSet,ResultSet> consultarTodo = (ResultSet rs)->{
        Connection con = ConexionAutoescuela.getInstance().getConexion();
        try {
            rs = con.createStatement().executeQuery(ILlamadas.CONSULTAR_TODO);
            
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error", "Ha ocurrido un error\nen la conexión", JOptionPane.ERROR_MESSAGE);
            rs = null;
        }
        
        return rs;
    };
    
    /**
     * Retorna un alumno con los carnets matrículados.
     */
    private final Result<Integer,MatriculaAlumno> consultarAlumno = (Integer id)->{
        MatriculaAlumno ma = null;
        Connection con = ConexionAutoescuela.getInstance().getConexion();
        CallableStatement llamada;        
        try{
            llamada = con.prepareCall(ILlamadas.SACAR_ALUMNO_ID, 
                    ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

            // Se registran los tipos de salida de los argumentos de la llamada.
            llamada.registerOutParameter(1, Types.VARCHAR);
            llamada.setInt(2, id);
            llamada.registerOutParameter(3, Types.VARCHAR);
            llamada.registerOutParameter(4, Types.VARCHAR);
            llamada.registerOutParameter(5, Types.VARCHAR);
            llamada.registerOutParameter(6, Types.VARCHAR);
            llamada.registerOutParameter(7, Types.VARCHAR);
            llamada.registerOutParameter(8, Types.DATE);

            int filas = llamada.executeUpdate();
            
            // Si la llamada ha tenido éxito.
            if (filas != 0){
                ma = recogerLlamada(llamada, id);
                ma = consultarCarnet(ma, id);                                    
            }
            
            // Se cierra la llamada.
            llamada.close();  
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error", "Ha ocurrido un error\nen la conexión", JOptionPane.ERROR_MESSAGE);
        }        
        return ma;
    };

    /**
     * Método privado en el que a partir de una llamada se recogen los datos de un alumno
     * @param llamada
     * @param id
     * @return Retorna un objeto MatriculaAlumno con los datos del alumno
     * @throws SQLException 
     */
    private MatriculaAlumno recogerLlamada(CallableStatement llamada,Integer id) throws SQLException{
        MatriculaAlumno ma = null;
        
        Calendar c = new GregorianCalendar();
        c.setTime(llamada.getDate(8));

        try{
            Alumno a = ControladorSingleton.getInstance().crearAlumno(
                llamada.getString(7).equals("PRESENCIAL"),
                llamada.getString(1), llamada.getString(3), 
                llamada.getString(4), llamada.getString(5), llamada.getString(6), c);
            ma = new MatriculaAlumno(id, a, TipoCarnet.A);
        } catch (AlumnoMalFormado ex){
        }
        return ma;
    }
    
    /**
     * Completa el objeto MatriculaAlumno con los datos del carnet matriculado
     * @param ma
     * @param id
     * @return Retorna el objeto MatriculaAlumno ma totalmente cualificado.
     * @throws SQLException 
     */
    private MatriculaAlumno consultarCarnet(MatriculaAlumno ma, Integer id) throws SQLException{
        // Se realiza una nueva consulta a la base de datos
        Connection con = ConexionAutoescuela.getInstance().getConexion();
        // Se prepara la llamada correspondiente
        CallableStatement llamada = con.prepareCall(ILlamadas.CONSULTAR_CARNET);
        // Se asigna el valor del playholder de la llamada.
        llamada.setInt(1, id);
        // Se recoge la consulta.
        ResultSet rs = llamada.executeQuery();
        // Se recuperan los datos de la consulta.
        while(rs.next()){
            ma.setCarnets(TipoCarnet.valueOf(rs.getString("TIPOCARNET")));
            Calendar c = new GregorianCalendar();
            c.setTime(rs.getDate("FECHAALTA"));
            ma.setFechaAlta(c);
        }
        // Se cierra el ResultSet.
        rs.close();
        // Se cierra la llamada.
        llamada.close();
        return ma;
    }
    
    public Result<ResultSet, ResultSet> getConsultarTodo() {
        return consultarTodo;
    }

    public Result<Integer, MatriculaAlumno> getConsultarAlumno() {
        return consultarAlumno;
    }
    
    
}
