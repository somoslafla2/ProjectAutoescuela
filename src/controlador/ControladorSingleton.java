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
        
    /**
     * Se crea un alumno con los datos introducidos por el usuario y se inserta
     * en la base de datos junto con la matriculación de un tipo de carnet.
     */
    public void crear(){
        boolean pres = vista.getPresencial();
        
        Alumno a = null; 
        try {
            //Se crea el alumno con los datos introducidos
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
            // Si al alumno le faltan datos se muestra un mensaje indicándolo
            vista.mostarMensaje(ex.getMessage());
        }
               
    }
    
    /**
     * Borra un alumno con un DNI concreto de la base de datos si lo encuentra.
     * @return Retorna true si se ha podido eliminar un alumno de la base de datos
     * y false en caso contrario.
     */
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
    
    /**
     * Consulta todos los alumnos registrados en la autoescuela y los muestra por
     * pantalla.
     */
    public void consultar(){
        String resultado = dao.resultTodo(new ResultLambda().getConsultarTodo());
        vista.show(resultado);
    }
    
    /**
     * Consulta un alumno concreto por su DNI y lo muestra por pantalla
     * @param dni Parámetro de búsqueda en la base de datos.
     * @return Retorna un tipo MatriculaAlumno que contiene toda la información del
     * alumno y el tipo de carnet matriculado.
     */
    public MatriculaAlumno consultar(String dni){
        if (dni==null)
            dni = vista.getDNI();
        
        MatriculaAlumno ma = null;
        try {
            ma = dao.resultAlumno(new ResultLambda().getConsultarAlumno(), dni);
        } catch (AlumnoNoEncontrado ex) {
            // En el caso de que no se encuentre el alumno con el DNI recogido de
            // la vista se muestra un mensaje por pantalla.
            vista.mostarMensaje(ex.getMessage());
        }
        return ma;
    }
    
    /**
     * Método para crear un alumno concreto
     * @param presencial Indica el tipo de alumno que es, Presencial o A distancia
     * @param nombre Nombre del alumno
     * @param apellido1 Primer apellido del alumno
     * @param apellido2 Segundo apellido del alumno
     * @param dni DNI del alumno
     * @param telefono Teléfono de contacto del alumno
     * @param fechaNacimiento Fecha de nacimiento del alumno
     * @return Retorna un objeto Alumno con los datos introducidos
     * @throws AlumnoMalFormado Si faltan datos para registrar el alumno retorna una excepción.
     */
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
    
    /**
     * Actualiza los datos concretos de un alumno
     */
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
    
    /**
     * Muestra todos los datos de un alumno así como el carnet matriculado.
     * @param ma
     * @return Retorna true si ha podido mostrar correctamente los datos.
     */
    public boolean show(MatriculaAlumno ma){
        if (ma != null){
            vista.show(ma);
            return true;
        }
        return false;
    }
    
    /**
     * Prepara la llamada a la base de datos.
     * @param llamada 
     * @param alumno
     * @param carnet
     * @throws SQLException 
     */
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
