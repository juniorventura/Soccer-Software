/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.Core.*;
import com.GUI.ArchivoACrear;
import com.GUI.Consultas;
import com.GUI.DescripcionEvento;
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
public class PruebasUnitariasTest extends TestCase{
    
    public void test1(){ // Probando los retornos la clase Jugador
        
        Jugador j1 = new Jugador("Eduardo", "perez", 1, "defensa");
        Jugador j2 = new Jugador("Carlos", "Marte", 2, "medio campo");
        Jugador j3 = new Jugador("Eduardo", "perez", 3, "defensa");
        Jugador j4 = new Jugador("Carlos", "Marte", 4, "medio campo");
        Jugador j5 = new Jugador("Eduardo", "perez", 5, "defensa");
        Jugador j6 = new Jugador("Carlos", "Marte", 6, "medio campo");
        Jugador j7 = new Jugador("Eduardo", "perez", 7, "defensa");
        Jugador j8 = new Jugador("Carlos", "Marte", 8, "medio campo");
        
        assertEquals("Eduardo", j1.getNombre());
        assertEquals("Eduardo defensa", j1.getNombre()+" "+j1.getPosicion());
        assertEquals("Marte", j2.getApellido());
        assertEquals(3, j3.getNumero());
        assertEquals(4, j4.getNumero());
        assertEquals("defensa", j5.getPosicion());
        assertEquals("medio campo", j6.getPosicion());
        assertEquals("perez", j7.getApellido());
           
    }
    
    public void test2(){       //prueba metodo descripcion evento
        
        DescripcionEvento d = new DescripcionEvento();
        
        d.descripcion.setText("8Falta");
        assertEquals(false, d.verificar());
        d.descripcion.setText("Falta");
        assertEquals(true, d.verificar());
        d.descripcion.setText("ñFalta");
        assertEquals(true, d.verificar());
        d.descripcion.setText(".Falta");
        assertEquals(true, d.verificar());
        d.descripcion.setText("20Falta");
        assertEquals(false, d.verificar());
        
    }
    
    
    
   
    
}
