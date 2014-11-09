/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista.consola.main;

import controlador.ControladorSingleton;
import modelo.conexion.ConexionAutoescuela;
import vista.consola.menu.Menu;
import vista.consola.menu.assets.AssetMenu;


/**
 *
 * @author Oscar
 */
public class Main {
    public static void main(String[] args) {        
        ConexionAutoescuela.getInstance();
        ControladorSingleton.getInstance();
        Menu m = AssetMenu.createMenu();
        ControladorSingleton.getInstance().setVista(m);
        while (true){
            m.showMenu();
            m = m.executeOption();
        }
    }
}
