/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.consola.menu.assets;

import controlador.Controlador;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.conexion.ConexionAutoescuela;
import vista.consola.menu.Action;
import vista.consola.menu.Menu;

/**
 *
 * @author Oscar
 */
public class AssetMenu {
    
    public static Menu createMenu(Controlador controlador){
        Menu principal = createMenuPrincipal(controlador);
        Menu consultas = crearMenuConsultar(controlador);
        principal.setNext(consultas);
        consultas.setPrev(principal);
        return principal;
    }
    
    private static Menu createMenuPrincipal(Controlador controlador){
        
        Menu m = new Menu("Gestión Alumnos -----", new ArrayList(),controlador);  
        
        Action action = () -> {
            System.out.println("Recoger los datos del alumno");
            System.out.println("Dar de alta un alumno en la autoescuela\n");
            controlador.crear();
            return m;
        };
        m.createOption("0. Alta alumno", action);
        
        action = () -> {
            System.out.println("Seleccionar el alumno por algun criterio");
            System.out.println("Dar de baja un alumno en la autoescuela\n");
            controlador.borrar();
            return m;
        };
        m.createOption("1. Baja Alumno", action);
        
        action = () -> { 
            System.out.println("Actualizo los datos de un alumno de la autoescuela\n");
            controlador.show(controlador.consultar(null));
            controlador.actualizar();
            return m;
        };
        m.createOption("2. Actualizar Alumno", action);
        
        action = () -> {
            return m.getNext();
        };
        m.createOption("3. Consultar por...", action);
        
        action = () -> {
            try {
                ConexionAutoescuela.getInstance().getConexion().close();
            } catch (SQLException ex) {
                Logger.getLogger(AssetMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.exit(0);
            return null;
        };
        m.createOption("4. Salir", action);
        
        return m;
    }
    
    private static Menu crearMenuConsultar(Controlador controlador){
        Menu m = new Menu("Menu Consultas -----", new ArrayList(),controlador);
        
        Action action = () -> {
            System.out.println("Muestro todos los alumnos de la autoescuela con todos sus campos");
            controlador.consultar();
            return m;
        };
        m.createOption("0. Consultar todo", action);
        
        action = () -> {
            System.out.println("Consulto por algun criterio");
            controlador.show(controlador.consultar(null));
            return m;  
        };
        m.createOption("1. Consultar por DNI", action);
        
        action = () -> {
            return m.getPrev();
        };
        m.createOption("2. Volver", action);
        
        return m;
    }
    
}
 