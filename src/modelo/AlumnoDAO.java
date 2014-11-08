/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import excepciones.AlumnoNoEncontrado;
import modelo.factoriaAlumnos.alumno.Alumno;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.lambdas.ObtenerIDLambda;

/**
 * Clase que se comunica con la base de datos y nuestro programa para crear, borrar
 * y actualizar datos, así como obtener consultas.
 * @author Oscar, Ester,Christian y Gonzalo
 */
public class AlumnoDAO {
    
    private MatriculaAlumno ma;

    public MatriculaAlumno getMa() {
        return ma;
    }
    
    /**
     * Crear un alumno nuevo y su matriculación en la base de datos.
     * @param crud 
     * @param ma 
     * @return Retorna el IDALUMNO de la base de datos si se ha insertado correctamente,
     * en caso contrario retorna -1.
     */
    public int create(Function<MatriculaAlumno,Integer> crud, MatriculaAlumno ma) {
        Integer i = crud.apply(ma);
        return i;
    }
    
    /**
     * Consulta todos los alumno ingresados en la base de datos.
     * @param crud 
     * @return Retorna la cadena con los datos de los alumnos.
     */
    public String resultTodo(Function<ResultSet,ResultSet> crud) {
        String cadena = "NOMBRE\tAPELLIDO1\tAPELLIDO2\tDNI\tTELEFONO\n"
                      + "------\t---------\t---------\t---\t--------\n";
        ResultSet rs = null;
        rs = crud.apply(rs);
        try {
            while (rs.next()){
                cadena += rs.getString("NOMBRE")+"\t" + rs.getString("APELLIDO1") + "\t"
                        + rs.getString("APELLIDO2") + "\t" + rs.getString("DNI") + "\t" 
                        + rs.getString("TELEFONO") + "\n";
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cadena;
    }
    
    /**
     * Consulta un alumno concreto en la base de datos a través del CRUD.
     * @param crud 
     * @param dni
     * @return Retorna una MatriculaAlumno si el alumno con dni está en la base de datos,
     * en caso contrario, retorna null.
     * @throws AlumnoNoEncontrado
     */
    public MatriculaAlumno resultAlumno(Function<Integer,MatriculaAlumno> crud, String dni) throws AlumnoNoEncontrado{
        Integer id = obtenerID(new ObtenerIDLambda().getConsultarID(), dni);
        ma = crud.apply(id);
        return ma;
    }
    
    /**
     * Actualiza un alumno de la base de datos a través del CRUD
     * @param crud 
     * @param alumno
     * @return Retorna true si se ha realizado la actualización correctamente, y false
     * en caso contrario.
     */
    public boolean update(Function<Alumno, Boolean> crud, Alumno alumno){
        return crud.apply(alumno);
    }
    
    /**
     * Borra un alumno de la base de datos.
     * @param crud 
     * @param dni
     * @return Retorna true si se borra correctamente y false en caso contrario.
     * @throws AlumnoNoEncontrado
     */
    public boolean delete (Function<Integer,Boolean> crud, String dni) throws AlumnoNoEncontrado{
        Integer id = obtenerID(new ObtenerIDLambda().getConsultarID(),dni);
        return crud.apply(id);

    }
    
    /**
     * Obtiene el IDALUMNO de la base de datos a través del CRUD.
     * @param crud Se fijan los tipos de entrada y retorno a String e Integer.
     * @param dni 
     * @return Retorna el IDALUMNO si encuentra un alumno con el dni, y -1 en caso contrario.
     * @throws excepciones.AlumnoNoEncontrado
     */
    public Integer obtenerID(Function<String,Integer> crud, String dni) throws AlumnoNoEncontrado{        
        Integer id = crud.apply(dni);
        if (id == -1)
            throw new AlumnoNoEncontrado("Alumno no encotrado");
        return id;
    }
    
}
