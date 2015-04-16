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
public class Partido {
    
    private String estadio;
    private String fecha;
    private Equipo e1,e2;
    private int numeroJugadores;
    private boolean partidoiniciado;
    
    public Partido(String f, String es,Equipo e1, Equipo e2)
    {
        this.estadio = es;
        this.fecha = f;
        this.e1 = e1;
        this.e2 = e2;
    }
    
    public Equipo getEquipo1()
    {
        return e1;
    }
    
    public Equipo getEquipo2()
    {
        return e2;
    }
    
    
    public void setEquipo1(Equipo e)
    {
        e1 = e;
    }
    
    public String getFecha()
    {
        return this.fecha;
    }
    
    public String getEstadio()
    {
        return this.estadio;
    }
    
    
    public void setEquipo2(Equipo e)
    {
        e2 = e;
    }
    
    public int getNumeroJugadores()
    {
        return this.numeroJugadores;
    }
    
    public void setNumeroJugadores(int n)
    {
        this.numeroJugadores = n;
    }
    
    public boolean getPartidoiniciado(){
        return this.partidoiniciado;
    }
    
    public void setPartidoiniciado(boolean b)
    {
        this.partidoiniciado = b;
    }
    
    
}
