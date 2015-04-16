package com.Core;


import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Junior C
 */
public class Equipo {
    
    private String nombre, pais;
    private int Score;
    private ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
    
    public Equipo(String nombre, String pais,ArrayList<Jugador> j)
    {
      this.nombre = nombre;
      this.pais = pais;
      Score = 0;
      jugadores = j;
    }
  
    public String getNombre()
    {
        return this.nombre;
    }
    
       public String getPais()
    {
        return this.pais;
    }
    
    public ArrayList<Jugador> getJugadores()
    {
        return jugadores;
    }
    
    public void setNombre(String n)
    {
        this.nombre = n;
    }
    
     public void setPais(String p)
    {
        this.pais = p;
    }
     
      public void setScore(int n)
    {
        this.Score = n;
    }
      
    public void setJugador(Jugador j)
    {
        jugadores.add(j);
    }
    
    public String getNombreApellJugador(int n) // Retorna el nombre y apellido del jugador a buscar 
    {
        if(n > jugadores.size() || n < jugadores.size()) return null;
        else
        {
             for(Jugador j : jugadores)
             {
                if(j.getNumero() == n) return (j.getNombre()+" "+j.getApellido());
             }  
        }
        
       return null;
    }
    
   
}
