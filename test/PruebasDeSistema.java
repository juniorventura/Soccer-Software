/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.Core.Equipo;
import com.Core.Jugador;
import com.Core.Partido;
import com.GUI.Consultas;
import com.GUI.DescripcionEvento;
import com.GUI.Marcador;
import static com.GUI.Marcador.getTiempoPartido;

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
 * 
 */
public class PruebasDeSistema extends TestCase {
    
   
    ArrayList<Jugador> jugadoresE1 = new ArrayList<Jugador>();
    ArrayList<Jugador> jugadoresE2 = new ArrayList<Jugador>();
    
    public void testSISTEMA() {

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
        p.setNumeroJugadores(4);

        Marcador m = new Marcador(p);

        m.iniciarPartido();
        m.selectorFaltaE2.setSelectedIndex(2);

        String respuesta;
        respuesta = ("** " + p.getEquipo2().getNombreApellJugador(2) + " Equipo " + p.getEquipo2().getNombre() + " "
                + m.selectorFaltaE2.getSelectedItem().toString());
        String esperado;
        esperado = "** Carlos Marte Equipo Sol rojo zancadilla a un adversario";
        assertEquals(esperado, respuesta);

        m.selectorFaltaE2.setSelectedIndex(5);

        respuesta = ("** " + p.getEquipo1().getNombreApellJugador(1) + " Equipo " + p.getEquipo1().getNombre() + " "
                + m.selectorFaltaE2.getSelectedItem().toString());

        esperado = "** juan perez Equipo los leones golpear a un adversario";
        assertEquals(esperado, respuesta);

        m.selectorJugadaE1.setSelectedIndex(5);

        respuesta = ("** " + p.getEquipo1().getNombreApellJugador(1) + " Equipo " + p.getEquipo1().getNombre() + " " + m.tipoJugada(5) + " "
                + m.selectorJugadaE1.getSelectedItem().toString());

        esperado = "** juan perez Equipo los leones //Jugada OFENSIVA Saques de banda";
        assertEquals(esperado, respuesta);

        m.pausarPartido();
        assertEquals(2, m.flagPausa);
        m.pausarPartido();
        assertEquals(3, m.flagPausa);

        m.selectorJugadaE1.setSelectedIndex(2);

        respuesta = ("** " + p.getEquipo1().getNombreApellJugador(1) + " Equipo " + p.getEquipo1().getNombre() + " " + m.tipoJugada(2) + " "
                + m.selectorJugadaE1.getSelectedItem().toString());

        esperado = "** juan perez Equipo los leones //Jugada ANOTACION GOAL!!!!!!";

        m.se1++;

        assertEquals(esperado, respuesta);
        assertEquals(1, m.se1);

        respuesta = Marcador.modelo.getElementAt(3).toString();
        esperado = "-----------------------------EVENTOS:";

        assertEquals(esperado, respuesta);

        m.lista.setSelectedIndex(3);
        m.eliminarEvento();

        assertEquals(3, Marcador.modelo.getSize());

        DescripcionEvento d = new DescripcionEvento();
        d.descripcion.setText("CAIDA DE JUGADOR NO.2 EQUIPO...");
        Marcador.modelo.addElement(d.descripcion.getText());

        assertEquals("CAIDA DE JUGADOR NO.2 EQUIPO...", Marcador.modelo.getElementAt(3).toString());

        m.crearArchivo();

        Consultas c = new Consultas();
        respuesta = c.modelo2.getElementAt(0).toString();

        assertEquals(true, respuesta.contains("Partido los leones VS Sol rojo"));

    }

    public void testSISTEMA2() {

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
        p.setNumeroJugadores(4);

        Marcador m = new Marcador(p);

        m.iniciarPartido();

        assertEquals(true, m.timer.isRunning());

        m.pausarPartido();

        assertEquals(false, m.timer.isRunning());

        m.pausarPartido();

        assertEquals(true, m.timer.isRunning());
        
        assertEquals("los leones",m.equipo1.getText());
        
        assertEquals("Sol rojo",m.equipo2.getText());
    }
    
    public void testSISTEMA3(){
        
        
        
        
        
    }

    


}
