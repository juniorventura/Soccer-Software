/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.Core.*;
import com.GUI.Marcador;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Junior C
 */
public class MarcadorTest extends TestCase{
    
   

    ArrayList<Jugador> jugadoresE1 = new ArrayList<Jugador>();
    ArrayList<Jugador> jugadoresE2 = new ArrayList<Jugador>();
    
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

    
    
}
