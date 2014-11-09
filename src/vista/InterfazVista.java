/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista;

import modelo.carnet.TipoCarnet;
import modelo.MatriculaAlumno;
import vista.consola.entradaconsola.EntradaConsola;

/**
 * Interfaz con métodos por defecto para recuperar y mostrar datos por consola
 * @author Formacion
 */
public interface InterfazVista {
    public static String CREATE = "CREATE";
        
    default void setId(int id){
        System.out.println("Usuario creado, Identificador: "+id);
    }
    
    default String getNombre(){
        return EntradaConsola.leerLinea("Introducir nombre: ");
    }
    
    default String getAp1(){
        return EntradaConsola.leerLinea("Introducir primer apellido: ");
    }
    
    default String getAp2(){
        return EntradaConsola.leerLinea("Introducir segundo apellido: ");
    }
    
    default String getDNI(){
        return EntradaConsola.leerLinea("Introducir DNI: ");
    }
    
    default String getDNI2(){
        return EntradaConsola.leerLinea("Introducir DNI: ");
    }
    
    default String getTlfn(){
        return EntradaConsola.leerLinea("Introducir teléfono: ");
    }
    
    default int getAnio(){
        return EntradaConsola.leerInt("Introducir año nacimiento: ");
    }
    
    default int getMes(){
        return EntradaConsola.leerInt("Introducir mes nacimiento: ");
    }
    
    default int getDia(){
        return EntradaConsola.leerInt("Introducir dia nacimiento: ");
    }
    
    default boolean getPresencial(){
        String respuesta = EntradaConsola.leerLinea("¿Modalidad presencial? (s/n): ");
        return respuesta.equals("s");
    }
    
    default TipoCarnet getCarnet(){
       // FactoriaCarnet f = null;
        for (TipoCarnet carnet : TipoCarnet.values()) {
            System.out.println("- "+carnet.name());
        }
        String respuesta = EntradaConsola.leerLinea("Elige un tipo de carnet: ");
        return TipoCarnet.valueOf(respuesta);
    }
    
    default void show(String cadena){
        System.out.println(cadena);
    }
    
    default void show(MatriculaAlumno ma){
        System.out.println(ma.toString());
    }

    default void mostarMensaje(String message){
        System.out.println(message);
    }
}
