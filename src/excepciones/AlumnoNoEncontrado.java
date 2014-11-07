/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package excepciones;

/**
 *
 * @author Oscar
 */
public class AlumnoNoEncontrado extends Exception {

    /**
     * Creates a new instance of <code>AlumnoNoEncontrado</code> without detail
     * message.
     */
    public AlumnoNoEncontrado() {
    }

    /**
     * Constructs an instance of <code>AlumnoNoEncontrado</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public AlumnoNoEncontrado(String msg) {
        super(msg);
    }
}
