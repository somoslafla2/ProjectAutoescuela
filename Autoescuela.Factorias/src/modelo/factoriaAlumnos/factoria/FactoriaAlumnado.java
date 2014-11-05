/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.factoriaAlumnos.factoria;

import modelo.excepciones.AlumnoMalFormado;
import modelo.factoriaAlumnos.alumno.Alumno;
import java.util.Calendar;

/**
 *
 * @author Formacion
 */
public abstract class FactoriaAlumnado {
    public abstract Alumno crearAlumno(String nombre, String apellido1, String apellido2, 
        String dni, String telefono, Calendar fechaNacimiento)  throws AlumnoMalFormado;
}
