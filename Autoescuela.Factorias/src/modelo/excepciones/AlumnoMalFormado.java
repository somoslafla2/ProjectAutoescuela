/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.excepciones;

/**
 *
 * @author Formacion
 */
public class AlumnoMalFormado extends Exception {

    /**
     * Creates a new instance of <code>AlumnoMalFormado</code> without detail
     * message.
     */
    public AlumnoMalFormado() {
    }

    /**
     * Constructs an instance of <code>AlumnoMalFormado</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public AlumnoMalFormado(String msg) {
        super(msg);
    }
}
