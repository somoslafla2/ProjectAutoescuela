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
import modelo.MatriculaAlumno;
import modelo.conexion.ConexionAutoescuela;
import modelo.interfaces.Result;
import modelo.llamadas.Llamadas;

/**
 *
 * @author Oscar
 */
public class ResultLambda {
    /**
     * Retorna un ResultSet con todos los alumno en la base de datos.
     */
    private final Result<ResultSet,ResultSet> consultarTodo = (ResultSet rs)->{
        Connection con = ConexionAutoescuela.getInstance().getConexion();
        try {
            rs = con.createStatement().executeQuery(Llamadas.CONSULTAR_TODO);
            
        } catch (SQLException ex){
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
            llamada = con.prepareCall(Llamadas.SACAR_ALUMNO_ID, 
                    ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

            llamada.registerOutParameter(1, Types.VARCHAR);
            llamada.setInt(2, id);
            llamada.registerOutParameter(3, Types.VARCHAR);
            llamada.registerOutParameter(4, Types.VARCHAR);
            llamada.registerOutParameter(5, Types.VARCHAR);
            llamada.registerOutParameter(6, Types.VARCHAR);
            llamada.registerOutParameter(7, Types.VARCHAR);
            llamada.registerOutParameter(8, Types.DATE);

            int filas = llamada.executeUpdate();
            
            if (filas != 0){
                ma = recogerLlamada(llamada, id);
                ma = consultarCarnet(ma, id);                                    
            }
            llamada.close();  
        }catch(SQLException ex){
            ex.printStackTrace();
        }        
        return ma;
    };

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
    
    private MatriculaAlumno consultarCarnet(MatriculaAlumno ma, Integer id) throws SQLException{
        Connection con = ConexionAutoescuela.getInstance().getConexion();
        CallableStatement llamada = con.prepareCall("SELECT TIPOCARNET, FECHAALTA FROM MATRICULALUMNO WHERE IDALUMNO=?");
        llamada.setInt(1, id);
        ResultSet rs = llamada.executeQuery();
        while(rs.next()){
            ma.setCarnets(TipoCarnet.valueOf(rs.getString("TIPOCARNET")));
            Calendar c = new GregorianCalendar();
            c.setTime(rs.getDate("FECHAALTA"));
            ma.setFechaAlta(c);
        }
        rs.close();
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
