/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.consola.menu.assets;

import controlador.ControladorSingleton;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.conexion.ConexionAutoescuela;
import vista.consola.menu.Action;
import vista.consola.menu.Menu;

/**
 *
 * @author Oscar
 */
public class AssetMenu {
    
    public static Menu createMenu(){
        Menu principal = createMenuPrincipal();
        Menu consultas = crearMenuConsultar();
        principal.setNext(consultas);
        consultas.setPrev(principal);
        return principal;
    }
    
    private static Menu createMenuPrincipal(){
        
        Menu m = new Menu("\nGESTIÓN ALUMNOS AutoescuelaGOCE -----", new ArrayList());  
        
        Action action = () -> {
            System.out.println("\nINTRODUCIR DATOS DEL NUEVO ALUMNO -------");
            ControladorSingleton.getInstance().crear();
            return m;
        };
        m.createOption("0. Alta alumno", action);
        
        action = () -> {
            System.out.println("\nDAR DE BAJA UN ALUMNO -----");
            ControladorSingleton.getInstance().borrar();
            return m;
        };
        m.createOption("1. Baja Alumno", action);
        
        action = () -> { 
            System.out.println("\nACTUALIZAR DATOS ALUMNO ----------");
            if (ControladorSingleton.getInstance().show(ControladorSingleton.getInstance().consultar(null)))
                ControladorSingleton.getInstance().actualizar();
            return m;
        };
        m.createOption("2. Actualizar Alumno", action);
        
        action = () -> {
            return m.getNext();
        };
        m.createOption("3. Consultar por...", action);
        
        action = () -> {
                ConexionAutoescuela.getInstance().closeConnection();
            
            System.exit(0);
            return null;
        };
        m.createOption("4. Salir", action);
        
        return m;
    }
    
    private static Menu crearMenuConsultar(){
        Menu m = new Menu("\nMenu Consultas -----", new ArrayList());
        
        Action action = () -> {
            System.out.println("\nALUMNOS REGISTRADOS --------");
            ControladorSingleton.getInstance().consultar();
            return m;
        };
        m.createOption("0. Consultar todo", action);
        
        action = () -> {
            System.out.println("\nDATOS DE UN ALUMNO ---------------------------");
            ControladorSingleton.getInstance().show(ControladorSingleton.getInstance().consultar(null));
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
 