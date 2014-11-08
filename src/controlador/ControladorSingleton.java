/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import excepciones.AlumnoNoEncontrado;
import java.sql.CallableStatement;
import java.sql.SQLException;
import modelo.carnet.TipoCarnet;
import modelo.excepciones.AlumnoMalFormado;
import modelo.factoriaAlumnos.alumno.Alumno;
import modelo.factoriaAlumnos.factoria.CreadorAlumnoDistancia;
import modelo.factoriaAlumnos.factoria.CreadorAlumnoPresencial;
import modelo.factoriaAlumnos.factoria.FactoriaAlumnado;
import java.util.Calendar;
import java.util.GregorianCalendar;
import modelo.AlumnoDAO;
import modelo.MatriculaAlumno;
import modelo.factoriaAlumnos.alumno.AlumnoPresencial;
import modelo.lambdas.CreateLambda;
import modelo.lambdas.DeleteLambda;
import modelo.lambdas.ResultLambda;
import modelo.lambdas.UpdateLambda;
import vista.InterfazVista;

/**
 *
 * @author Oscar
 */
public class ControladorSingleton {
    private InterfazVista vista;
    private AlumnoDAO dao;

    public void setVista(InterfazVista vista) {
        this.vista = vista;
    }
        
    public void crear(){
        boolean pres = vista.getPresencial();
        
        Alumno a = null; 
        try {
            a = crearAlumno(pres,vista.getNombre(), vista.getAp1(), vista.getAp2(), vista.getDNI(), vista.getTlfn(), 
                    new GregorianCalendar(vista.getAnio(), vista.getMes()-1, vista.getDia()));
            
            TipoCarnet c = vista.getCarnet();
        
            MatriculaAlumno mA = new MatriculaAlumno(a, c);      

            // Create lanza excepción si no se puede añadir el alumno en la base de datos
            int id = dao.create(new CreateLambda().getCrear(),mA);
            
            if (id != -1){
                vista.setId(id);
                vista.mostarMensaje("Alumno creado correctamente");
            }
            else
                vista.mostarMensaje("Imposible insertar el alumno");
            
        } catch (AlumnoMalFormado ex) {
            vista.mostarMensaje(ex.getMessage());
        }
               
    }
    
    public boolean borrar(){
        String mensaje = null;
        try {
            if(dao.delete(new DeleteLambda().getBorrar(),vista.getDNI())){
                mensaje = "Alumno borrado correctamente";
            } else {
                mensaje = "Imposible borrar el alumno";
            }
        } catch (AlumnoNoEncontrado ex) {
            mensaje = ex.getMessage();
        } finally {
            vista.mostarMensaje(mensaje);
        }
        return true;
    }
    
    public void consultar(){
        String resultado = dao.resultTodo(new ResultLambda().getConsultarTodo());
        vista.show(resultado);
    }
    
    public MatriculaAlumno consultar(String dni){
        if (dni==null)
            dni = vista.getDNI();
        
        MatriculaAlumno ma = null;
        try {
            ma = dao.resultAlumno(new ResultLambda().getConsultarAlumno(), dni);
        } catch (AlumnoNoEncontrado ex) {
            vista.mostarMensaje(ex.getMessage());
        }
        return ma;
    }
    
    public Alumno crearAlumno(boolean presencial,String nombre, String apellido1, String apellido2, 
        String dni, String telefono, Calendar fechaNacimiento) throws AlumnoMalFormado{
        FactoriaAlumnado factoria;
        if (presencial){
            factoria = new CreadorAlumnoPresencial();
        }else {
            factoria = new CreadorAlumnoDistancia();
        }
        
        return factoria.crearAlumno(nombre, apellido1, apellido2, dni, telefono, fechaNacimiento);
    }
    
    public void actualizar(){
        Alumno nuevo = null;
        try {
            nuevo = crearAlumno(vista.getPresencial(), vista.getNombre(), vista.getAp1(),
                    vista.getAp2(), dao.getMa().getAlumno().getDni(),vista.getTlfn(),
                    dao.getMa().getAlumno().getFechaNacimiento());
            dao.update(new UpdateLambda().getModificarAlumno(),nuevo);
            vista.mostarMensaje("Alumno actualizado correctamente");
        } catch (AlumnoMalFormado ex) {
            vista.mostarMensaje(ex.getMessage());
        }
    }
    
    public boolean show(MatriculaAlumno ma){
        if (ma != null){
            vista.show(ma);
            return true;
        }
        return false;
    }
    
    public void prepararLlamada(CallableStatement llamada, 
            Alumno alumno, TipoCarnet carnet) throws SQLException{
        llamada.setString(2, alumno.getNombre());
        llamada.setString(3, alumno.getApellido1());
        llamada.setString(4, alumno.getApellido2());
        llamada.setString(5, alumno.getDni());
        llamada.setString(6, alumno.getTelefono());
        llamada.setString(7, (alumno instanceof AlumnoPresencial ? "PRESENCIAL" : "A DISTANCIA"));
        llamada.setString(8, alumno.fechaToString());
        if (carnet != null){
            llamada.setString(9, carnet.name());
            llamada.setFloat(10, carnet.getPrecio());
        }
    }
    
    private ControladorSingleton() { 
        dao = new AlumnoDAO();
    }
    
    public static ControladorSingleton getInstance() {
        return ControladorSingletonHolder.INSTANCE;
    }
    
    private static class ControladorSingletonHolder {
        private static final ControladorSingleton INSTANCE = new ControladorSingleton();
    }
}
