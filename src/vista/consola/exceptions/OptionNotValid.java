/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista.consola.exceptions;

/**
 *
 * @author Formacion
 */
public class OptionNotValid extends Exception {
    private static final long serialVersionUID = -1100705434319189458L;

    /**
     * Creates a new instance of <code>OptionNotValid</code> without detail
     * message.
     */
    public OptionNotValid() {
    }

    /**
     * Constructs an instance of <code>OptionNotValid</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public OptionNotValid(String msg) {
        super(msg);
    }
}
