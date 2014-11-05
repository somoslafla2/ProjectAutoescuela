/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.factoriaAlumnos.alumno;

import modelo.excepciones.AlumnoMalFormado;
import java.util.Calendar;

/**
 *
 * @author Formacion
 */
public class AlumnoPresencial extends Alumno {
    private static final long serialVersionUID = 2973562552464212054L;

    public AlumnoPresencial(String nombre, String apellido1, String apellido2, String dni, String telefono, Calendar fechaNacimiento) throws AlumnoMalFormado {
        super(nombre, apellido1, apellido2, dni, telefono, fechaNacimiento);
        
    }
    
}
