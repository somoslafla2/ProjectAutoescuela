/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista.consola.menu;

import controlador.Controlador;
import java.util.List;
import vista.InterfazVista;
import vista.consola.entradaconsola.EntradaConsola;
import vista.consola.exceptions.OptionNotValid;

/**
 *
 * @author Oscar
 */
public class Menu implements InterfazVista{
    
    private Controlador controlador;
    
    private final String title;
    private Menu next;
    private Menu prev;
    private final List<Option> options;

    public Menu(String title, Menu next, Menu prev, List<Option> options, Controlador controlador) {
        this.title = title;
        this.next = next;
        this.prev = prev;
        this.options = options;
        this.controlador = controlador;
    }

    public Menu(String title, List<Option> options, Controlador controlador){
      this(title,null,null,options,controlador);  
    }  
    
    // Getters & Setters -------------------------------------------------------
    
    public String getTitle() {
        return title;
    }

    public Menu getNext() {
        return next;
    }

    public void setNext(Menu next) {
        this.next = next;
    }

    public Menu getPrev() {
        return prev;
    }

    public void setPrev(Menu prev) {
        this.prev = prev;
    }
    
    // Add option to menu ------------------------------------------------------
    
    public boolean createOption(String sign, Action action){
        return options.add(new Option(sign, action));
    }
    
    // Show menu's options -------------------------------------------------------
    
    public void showMenu(){
        System.out.println(title);
        options.stream()
               .map(Option::getSign) // Obtener las opciones por nombre
               .forEach(System.out::println); // imprimir
    }
    
    // Execute option -------------------------------------------------------------
    
    public Menu executeOption() {
        Menu m = null;
        int op = EntradaConsola.leerInt("Selecciona opción: ");
        try{
            if (compruebaNumOpcion(op)){
               m = options.get(op).execute();
            }
        } catch (OptionNotValid ex){
            System.out.println(ex.getMessage());
            m = executeOption();
        }
        return m;  
    }
    
    private boolean compruebaNumOpcion(int op) throws OptionNotValid{
        if (op >= 0 && op < options.size()){
            return true;
        } else {
            throw new OptionNotValid("Opción no válida");
        }
    }

    @Override
    public void setControlador(Controlador c) {
        this.controlador = c;
    }
    
    // Inner class Option ------------------------------------------------------
    
    private class Option{
        private String sign;
        private Action action;

        public Option(String sign){
            this.sign = sign;
        }
        
        public Option(String sign, Action action) {
            this.sign = sign;
            this.action = action;
        }

        public String getSign() {
            return sign;
        }  
        
        // Execute action ------------------------------------------------------
        public Menu execute(){
            return action.execute();
        }
    }
    
}
