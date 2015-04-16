package com.Core;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Junior C
 */
public class Jugador {
    
    private String nombre, apellido, posicion;
    private int  numero;
    private int demo;
    
    public Jugador(String nombre, String apellido, int numero, String posicion)
    {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numero = numero;
        this.posicion = posicion;
    }
    
    public String getNombre()
    {
        return this.nombre;
    }
    
    public String getApellido()
    {
        return this.apellido;
    }
    
    public void setNombre(String n)
    {
        this.nombre = n;
    }
    
    public void setApellido(String a)
    {
        this.apellido = a;
    }
    
    public int getNumero()
    {
        return this.numero;
    }
    
    @Override
    public String toString()
    {
        return (this.nombre + " " + this.apellido + " " + this.posicion + " " + this.numero);
    }
    
    
    
    public String getPosicion()
    {
        return this.posicion;
    }
    
    
}
