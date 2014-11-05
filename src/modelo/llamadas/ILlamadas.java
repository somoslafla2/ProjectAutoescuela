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
public interface ILlamadas {
    static String CONSULTARDNI = "{?=call OBTENERIDALUMNO(?)}";
    static String INSERTAR_NUEVO = "{call INSERTARNUEVO(?,?,?,?,?,?,?,?,?)}";
    static String INSERTAR_NUEVO2 = "{?=call INSERTARNUEVO2(?,?,?,?,?,?,?,?,?)}";
    static String BORRAR_ALUMNO = "{call BORRARALUMNO(?)}";
    static String OBTENERIDALUMNO = "{? = call OBTENERIDALUMNO(?)}";
    static String CONSULTAR_TODO = "SELECT NOMBRE, APELLIDO1, APELLIDO2, DNI, TELEFONO FROM ALUMNO";
    static String SACAR_ALUMNO_DNI = "{?=call SACARALUMNOPORDNI(?,?,?,?,?,?,?)}";
    static String SACAR_ALUMNO_ID = "{?=call SACAR(?,?,?,?,?,?,?)}";
    static String MODIFICAR_ALUMNO = "{call MODIFICARALUMNO(?,?,?,?,?,?,?,?)}";
}
