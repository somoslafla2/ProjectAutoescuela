/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista.consola.entradaconsola;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Formacion
 */
public class EntradaConsola {
    
    public static int leerInt(String msg){
        System.out.print(msg);
        int opcion = -1;
        try{
            opcion = new Scanner(System.in).nextInt();
        } catch (InputMismatchException ex){
            System.out.println("La opción no es un numero");
            opcion = leerInt(msg);
        }
        return opcion;
    }
    
    public static String leerLinea(String msg){
        System.out.print(msg);
        return new Scanner(System.in).nextLine();
    }
    
}
