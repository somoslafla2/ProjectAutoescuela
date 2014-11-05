/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.carnet;

/**
 *
 * @author Oscar
 */
public enum TipoCarnet {
    A(250.00F),B(500.00F),C(750.00F);
    
    private Float precio;

    private TipoCarnet(Float precio) {
        this.precio = precio;
    }

    public Float getPrecio() {
        return precio;
    }
}
