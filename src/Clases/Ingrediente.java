/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author alumno
 */
public class Ingrediente {
    public String nombre;
    public int cantidad;
    public String unidad;
    
    /**
     * Constructor basico
     * @param nombre
     * @param cantidad
     * @param unidad 
     */
    public Ingrediente(String nombre, int cantidad, String unidad){
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.unidad = unidad;
    }
    
    /**
     * Un Override al toString
     * @return 
     */
    @Override
    public String toString(){
        return ("Ingrediente: " + this.nombre + " Cantidad: " + this.cantidad +" "+ this.unidad);
    }
}
