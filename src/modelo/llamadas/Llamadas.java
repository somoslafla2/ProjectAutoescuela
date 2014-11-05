/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.llamadas;

/**
 *
 * @author Oscar
 */
public class Llamadas {
    public static final String CONSULTARDNI = "{?=call OBTENERIDALUMNO(?)}";
    public static final String INSERTAR_NUEVO = "{call INSERTARNUEVO(?,?,?,?,?,?,?,?,?)}";
    public static final String INSERTAR_NUEVO2 = "{?=call INSERTARNUEVO2(?,?,?,?,?,?,?,?,?)}";
    public static final String BORRAR_ALUMNO = "{call BORRARALUMNO(?)}";
    public static final String OBTENERIDALUMNO = "{? = call OBTENERIDALUMNO(?)}";
    public static final String CONSULTAR_TODO = "SELECT NOMBRE, APELLIDO1, APELLIDO2, DNI, TELEFONO FROM ALUMNO";
    public static final String SACAR_ALUMNO_DNI = "{?=call SACARALUMNOPORDNI(?,?,?,?,?,?,?)}";
    public static final String SACAR_ALUMNO_ID = "{?=call SACAR(?,?,?,?,?,?,?)}";
    public static final String MODIFICAR_ALUMNO = "{call MODIFICARALUMNO(?,?,?,?,?,?,?,?)}";

}
