/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.interfaces;

import java.util.function.Function;

/**
 *
 * @author Oscar
 * @param <T> Tipo de entrada en el método apply de Function
 * @param <R> Tipo de retorno en el método apply de Function
 */
public interface Create<T,R> extends Function<T,R> {
    
}
