/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.factoriaAlumnos.alumno;

import modelo.excepciones.AlumnoMalFormado;
import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;

/**
 *
 * @author Formacion
 */
public abstract class Alumno implements Serializable{
    private static final long serialVersionUID = -682259716875927732L;
    
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String dni;
    private String telefono;
    private Calendar fechaNacimiento;

    public Alumno() {
    }

    public Alumno(String nombre, String apellido1, String apellido2, String dni, 
            String telefono, Calendar fechaNacimiento) throws AlumnoMalFormado {
        String cadena=null;
        boolean fallo = false;
        if (nombre.equals("") | nombre == null | apellido1.equals("") | apellido1 == null | 
            apellido2.equals("") | apellido2 == null | dni.equals("") |dni == null
            | telefono.equals("") | telefono == null){
            cadena = "Faltan datos o son erróneos";
            fallo = true;
        }
        else {
            GregorianCalendar hoy = new GregorianCalendar();
            int annios = hoy.get(Calendar.YEAR) - fechaNacimiento.get(Calendar.YEAR);
            if (annios < 18){
                cadena = "Eres menor de edad, pringaooooo";
                fallo = true;
            }
        }
        
        if (fallo){
            throw new AlumnoMalFormado(cadena);
        }
            
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.dni = dni;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public String fechaToString(){
        // mm/dd/yyyy
        String fecha = (fechaNacimiento.get(Calendar.MONTH)+1)+"/"
                + (fechaNacimiento.get(Calendar.DAY_OF_MONTH)) + "/"
                + (fechaNacimiento.get(Calendar.YEAR));
        return fecha;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.nombre);
        hash = 47 * hash + Objects.hashCode(this.apellido1);
        hash = 47 * hash + Objects.hashCode(this.apellido2);
        hash = 47 * hash + Objects.hashCode(this.dni);
        hash = 47 * hash + Objects.hashCode(this.telefono);
        hash = 47 * hash + Objects.hashCode(this.fechaNacimiento);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Alumno other = (Alumno) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellido1, other.apellido1)) {
            return false;
        }
        if (!Objects.equals(this.apellido2, other.apellido2)) {
            return false;
        }
        if (!Objects.equals(this.dni, other.dni)) {
            return false;
        }
        if (!Objects.equals(this.telefono, other.telefono)) {
            return false;
        }
        if (!Objects.equals(this.fechaNacimiento, other.fechaNacimiento)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
