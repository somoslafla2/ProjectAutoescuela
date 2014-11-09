/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.llamadas;

/**
 * Interfaz con las llamadas a las funciones almacenadas de la base de datos, así
 * como consultas a la misma.
 * @author Oscar, Ester,Christian y Gonzalo
 */
public interface ILlamadas {
    //static String INSERTAR_NUEVO = "{call INSERTARNUEVO(?,?,?,?,?,?,?,?,?)}";
    static String INSERTAR_NUEVO2 = "{?=call INSERTARNUEVO2(?,?,?,?,?,?,?,?,?)}";
    static String BORRAR_ALUMNO = "{call BORRARALUMNO(?)}";
    static String OBTENERIDALUMNO = "{? = call OBTENERIDALUMNO(?)}";
    static String CONSULTAR_TODO = "SELECT NOMBRE, APELLIDO1, APELLIDO2, DNI, TELEFONO FROM ALUMNO";
    static String SACAR_ALUMNO_DNI = "{?=call SACARALUMNOPORDNI(?,?,?,?,?,?,?)}";
    static String SACAR_ALUMNO_ID = "{?=call SACAR(?,?,?,?,?,?,?)}";
    static String MODIFICAR_ALUMNO = "{call MODIFICARALUMNO(?,?,?,?,?,?,?,?)}";
    static String CONSULTAR_CARNET = "SELECT TIPOCARNET, FECHAALTA FROM MATRICULALUMNO WHERE IDALUMNO=?";
}
