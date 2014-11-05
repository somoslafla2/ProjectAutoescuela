/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.interfaces;

import java.sql.Connection;

/**
 *
 * @author Oscar
 */
public abstract interface CRUD<T,R> {
    abstract R accion(Connection con, T elem);
}
