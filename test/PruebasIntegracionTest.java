/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.Core.Equipo;
import com.Core.Jugador;
import com.Core.Partido;
import com.GUI.Marcador;
import java.util.ArrayList;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class PruebasIntegracionTest extends TestCase {
    
    
    ArrayList<Jugador> jugadoresE1 = new ArrayList<Jugador>();
    ArrayList<Jugador> jugadoresE2 = new ArrayList<Jugador>();
    
    public PruebasIntegracionTest() {
        
    }
    
    public void test1(){
        
        Jugador j1 = new Jugador("juan", "perez", 1, "medio campo");
        Jugador j2 = new Jugador("jose", "Baez", 2, "ataque");
        jugadoresE1.add(j1);
        jugadoresE1.add(j2);
        
        Jugador j3 = new Jugador("Eduardo", "perez", 1, "defensa");
        Jugador j4 = new Jugador("Carlos", "Marte", 2, "medio campo");
        jugadoresE2.add(j3);
        jugadoresE2.add(j4);
        
        Equipo e1 = new Equipo("los leones", "Cuba", jugadoresE1);
        Equipo e2 = new Equipo("Sol rojo", "Argentina", jugadoresE2);
        
        Partido p = new Partido("25/5/2015", "Estadio", e1, e2);
        p.setNumeroJugadores(2);
        
        Marcador m = new Marcador(p);
        
        assertEquals(false,p.getPartidoiniciado());
        
        m.iniciarPartido();
        assertEquals(true,p.getPartidoiniciado());
        assertEquals(true,p.getPartidoiniciado());
        assertEquals(true,p.getPartidoiniciado());
        m.pausarPartido();
        assertEquals(true,p.getPartidoiniciado());
        assertEquals(true,p.getPartidoiniciado());
        m.pausarPartido();
        assertEquals(true,p.getPartidoiniciado());
        
    }
    
    public void test2(){
        
        Jugador j1 = new Jugador("juan", "perez", 1, "medio campo");
        Jugador j2 = new Jugador("jose", "Baez", 2, "ataque");
        jugadoresE1.add(j1);
        jugadoresE1.add(j2);
        
        Jugador j3 = new Jugador("Eduardo", "perez", 1, "defensa");
        Jugador j4 = new Jugador("Carlos", "Marte", 2, "medio campo");
        jugadoresE2.add(j3);
        jugadoresE2.add(j4);
        
        Equipo e1 = new Equipo("los leones", "Cuba", jugadoresE1);
        Equipo e2 = new Equipo("Sol rojo", "Argentina", jugadoresE2);
        
        Partido p = new Partido("25/5/2015", "Estadio", e1, e2);
        p.setNumeroJugadores(2);
        
        Marcador m = new Marcador(p);
        
        m.iniciarPartido();
        
        m.
       
        
    }
    

    @Test
    public void test3(){  // PRUEBA DEL METODO GETNOMBREAPELL DE LA CLASE JUGADOR
        
        Jugador j1 = new Jugador("juan", "perez", 1, "medio campo");
        Jugador j2 = new Jugador("jose", "Baez", 2, "ataque");
        jugadoresE1.add(j1);
        jugadoresE1.add(j2);

        Jugador j3 = new Jugador("Eduardo", "perez", 1, "defensa");
        Jugador j4 = new Jugador("Carlos", "Marte", 2, "medio campo");
        jugadoresE2.add(j3);
        jugadoresE2.add(j4);

        Equipo e1 = new Equipo("los leones", "Cuba", jugadoresE1);
        Equipo e2 = new Equipo("Sol rojo", "Argentina", jugadoresE2);
        
        assertEquals("jose Baez", e1.getNombreApellJugador(2));
        assertEquals("juan perez", e1.getNombreApellJugador(1));
        assertEquals(null, e1.getNombreApellJugador(3));
        assertEquals(null, e1.getNombreApellJugador(0));
        assertEquals(null, e1.getNombreApellJugador(0));
        assertEquals(null, e1.getNombreApellJugador(4));
        
         Jugador j5 = new Jugador("Jose", "Eduardo", 3, "defensa");
        Jugador j6 = new Jugador("Juan", "Pablo", 4, "medio campo");
        
        jugadoresE2.add(j5);
        jugadoresE2.add(j6);
        
        assertEquals("Jose Eduardo", e2.getNombreApellJugador(3));
        assertEquals("Juan Pablo", e2.getNombreApellJugador(4));
        assertEquals("Jose Eduardo", e2.getNombreApellJugador(3));
        assertEquals(null, e2.getNombreApellJugador(10000));
        assertEquals("Carlos Marte", e2.getNombreApellJugador(2));
    }
    
     public void test4(){
        
         Jugador j1 = new Jugador("juan", "perez", 1, "medio campo");
        Jugador j2 = new Jugador("jose", "Baez", 2, "ataque");
        jugadoresE1.add(j1);
        jugadoresE1.add(j2);

        Jugador j3 = new Jugador("Eduardo", "perez", 1, "defensa");
        Jugador j4 = new Jugador("Carlos", "Marte", 2, "medio campo");
        jugadoresE2.add(j3);
        jugadoresE2.add(j4);

        Equipo e1 = new Equipo("los leones", "Cuba", jugadoresE1);
        Equipo e2 = new Equipo("Sol rojo", "Argentina", jugadoresE2);
        Partido p = new Partido("25/8/1995","N",e1,e2);
        Marcador m = new Marcador(p);
        
        assertEquals("//Jugada ANOTACION",m.tipoJugada(2) );
        assertEquals("//Jugada OFENSIVA", m.tipoJugada(4));
        assertEquals(null, m.tipoJugada(15));
         assertEquals("//Jugada ANOTACION",m.tipoJugada(2) );
        assertEquals("//Jugada OFENSIVA", m.tipoJugada(5));
        assertEquals("//Jugada OFENSIVA", m.tipoJugada(14));
         assertEquals("//Jugada ANOTACION",m.tipoJugada(2) );
        assertEquals("//Jugada OFENSIVA", m.tipoJugada(7));
        assertEquals(null, m.tipoJugada(15));
         assertEquals("//Jugada ANOTACION",m.tipoJugada(2) );
        assertEquals("//Jugada OFENSIVA", m.tipoJugada(8));
        assertEquals("//Jugada OFENSIVA", m.tipoJugada(16));
      
    }
    
    
    
}
