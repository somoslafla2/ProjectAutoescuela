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
 *
 * @author Oscar
 */
public class MatriculaAlumno {
    private Integer idAlumno;
    private Alumno alumno;
    private TipoCarnet carnet;
    private Calendar fechaAlta;

    public MatriculaAlumno(Alumno alumno, TipoCarnet carnet) {
        this.alumno = alumno;
        this.carnet = carnet;
    }    

    public MatriculaAlumno(Integer idAlumno, Alumno alumno, TipoCarnet carnet) {
        this (alumno, carnet);
        this.idAlumno = idAlumno;
    }

    public Integer getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }
    
    
    
    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public TipoCarnet getCarnet() {
        return carnet;
    }

    public void setCarnets(TipoCarnet carnet) {
        this.carnet = carnet;
    }

    public Calendar getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Calendar fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
    
    

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
