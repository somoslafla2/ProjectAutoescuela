/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import modelo.carnet.TipoCarnet;
import modelo.factoriaAlumnos.alumno.Alumno;
import modelo.factoriaAlumnos.alumno.AlumnoPresencial;
import java.util.Calendar;

/**
 * Clase que contendrá la información necesaria de la base de datos.
 * En nuestro caso, el identificador del alumno, el alumno, el tipo de carnet
 * matriculado y la fecha de alta de matriculación.
 * @author Oscar, Ester,Christian y Gonzalo
 */
public class MatriculaAlumno {
    private Integer idAlumno;
    private Alumno alumno;
    private TipoCarnet carnet;
    private Calendar fechaAlta;

    /**
     * Constructor con un alumno y un carnet
     * @param alumno
     * @param carnet 
     */
    public MatriculaAlumno(Alumno alumno, TipoCarnet carnet) {
        this.alumno = alumno;
        this.carnet = carnet;
    }    

    /**
     * Constructor que incluye el identificador del alumno
     * @param idAlumno
     * @param alumno
     * @param carnet 
     */
    public MatriculaAlumno(Integer idAlumno, Alumno alumno, TipoCarnet carnet) {
        this (alumno, carnet);
        this.idAlumno = idAlumno;
    }

    /**
     * Getter del identificador del alumno actual
     * @return Retorna el identificador del alumno actual que corresponde con el 
     * de la base de datos.
     */
    public Integer getIdAlumno() {
        return idAlumno;
    }

    /**
     * Setter del identificador del alumno en la base de datos
     * @param idAlumno 
     */
    public void setIdAlumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }
    
    /**
     * Getter del alumno actual
     * @return Retorna el alumno actual con el que se está trabajando
     */  
    public Alumno getAlumno() {
        return alumno;
    }

    /**
     * Setter del alumno actual con el que se está trabajando
     * @param alumno 
     */
    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    /**
     * 
     * @return Retorna el tipo de carnet del que se ha matriculado el alumno
     */
    public TipoCarnet getCarnet() {
        return carnet;
    }

    /**
     * 
     * @param carnet 
     */
    public void setCarnets(TipoCarnet carnet) {
        this.carnet = carnet;
    }

    /**
     * 
     * @return Retorna la fecha de alta en la que se matriculó el alumno de un carnet
     */
    public Calendar getFechaAlta() {
        return fechaAlta;
    }

    /**
     * 
     * @param fechaAlta 
     */
    public void setFechaAlta(Calendar fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
    
    /**
     * 
     * @return Retorna un String con todos los datos del alumno actual
     */
    @Override
    public String toString() {
        String fecha = (fechaAlta.get(Calendar.MONTH)+1)+"/"
                + (fechaAlta.get(Calendar.DAY_OF_MONTH)) + "/"
                + (fechaAlta.get(Calendar.YEAR));
        
        return "--------------------------------------------------\n"
                + "Id Alumno: " + idAlumno + '\n'
                + "Nombre: " + alumno.getNombre() + '\n' 
                + "Apellidos: "+ alumno.getApellido1() + ' ' + alumno.getApellido2() + '\n'
                + "DNI: " + alumno.getDni() + '\n' 
                + "Fecha Nacimiento: " + alumno.fechaToString()+ '\n'
                + "Telefono: " + alumno.getTelefono() + '\n'
                + "Tipo: " + (alumno instanceof AlumnoPresencial ? "PRESENCIAL" : "A DISTANCIA")
                + "\nMATRICULAS --------------------------------------\n"
                + "- " + carnet.name() + " Fecha Alta: " + fecha + " Precio: " + carnet.getPrecio();
    }
    
    
}
