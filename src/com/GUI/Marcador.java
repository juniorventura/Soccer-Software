/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GUI;

import com.Core.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Junior C
 */
public class Marcador extends javax.swing.JFrame {

    private DefaultComboBoxModel modelocombo;
    public static DefaultListModel modelo; // MODELO QUE CONTENDRA LOS EVENTOS QUE SUCEDAN EN EL PARTIDO 
    public static int ss, mm, hh;  // SS HH Y MM REPRESENTAN LAS VARAIBLES APRA LOS SEGUNDOS MINTOS Y HORA DEL PARTIDO
    private Partido p;
    public static Calendar can = Calendar.getInstance();
    public static Calendar cann = new GregorianCalendar();
    public static int h, m, s; // Representan la hora, minuto y segundo del sistema actual
    private int flagPausa;
    private boolean faltaE1, jugadaE1, faltaE2, jugadaE2; // varaibles apra controlar las selecciones de los Jcombobox, para saber cual esta seleccionado
    private int se1, se2;

    public Marcador(Partido p) {

        initComponents();
        this.p = p; // ASIGNA LA VARIABLE P (PARTIDO) DE LA CLASE HOME A LA VARIABLE PARTIDO DE ESTA CLASE

        faltaE1 = false;
        jugadaE1 = false;
        faltaE2 = false;
        jugadaE2 = false;
        flagPausa = 1;
        h = 0;
        s = 0;
        m = 0;
        ss = 0;
        mm = 0;
        hh = 0;
        se1 = 0;
        se2 = 0;
        modelocombo = new DefaultComboBoxModel();

        NjugadoresE1.setModel(modelocombo);

        NjugadoresE2.setModel(modelocombo);
        
      
      
        switch (p.getNumeroJugadores()) // añade al combobox los numeros del 1 al (numero de jugadores seleccionado acteriormente)
        {
            case 2: {
                for (int i = 1; i <= 2; i++) {
                    modelocombo.addElement(i);
                }

            }
            break;
            case 7: {
                for (int i = 1; i <= 7; i++) {
                    modelocombo.addElement(i);
                }

            }
            break;
            case 8: {
                for (int i = 1; i <= 8; i++) {
                    modelocombo.addElement(i);
                }

            }
            break;
            case 9: {
                for (int i = 1; i <= 9; i++) {
                    modelocombo.addElement(i);
                }

            }
            break;
            case 10: {
                for (int i = 1; i <= 10; i++) {
                    modelocombo.addElement(i);
                }

            }
            break;
            case 11: {
                for (int i = 1; i <= 11; i++) {
                    modelocombo.addElement(i);
                }

            }
            break;

        }
        
        equipo1.setText(p.getEquipo1().getNombre()); // SE SETEAN LAS NOMBRE Y PAIS DE LOS EQUIPOS EN EL MARCADOR
        equipo2.setText(p.getEquipo2().getNombre());
        modelo = new DefaultListModel();
        lista.setModel(modelo); // SE LE ENVIA A LA LISTA ESOS EVENTOS APRA MORTARLOS
         
        this.getContentPane().setBackground(Color.white); // PONE EL COLOR DEL FORMULARIO EN BLANCO
        setLocationRelativeTo(null);

    }

    Timer timer = new Timer(1000, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            ss++;
            if (ss == 60) {
                mm++;
                ss = 0;
            }

            if (mm == 60) {
                hh++;
                mm = 0;
            }
            tiempo.setText(getTiempoPartido());
            if (hh == 1 && mm == 30 && ss == 0) { // CUANDO EL PARTIDO ALCANCE UNA HORA Y MEDIA, SE TERMINARA, SE EVALUARAN LAS PUNTUACIONES Y CREARA EL ARCHIVO
                timer.stop();
                if (p.getEquipo1().getScore() > p.getEquipo2().getScore()) {
                    modelo.addElement("El equipo " + p.getEquipo1().getNombre() + " gana el partido " + p.getEquipo1().getScore() + "/" + p.getEquipo2().getScore()
                            + " Contra el equipo " + p.getEquipo2().getNombre());
                } else if (p.getEquipo1().getScore() < p.getEquipo2().getScore()) {
                    modelo.addElement("El equipo " + p.getEquipo2().getNombre() + " gana el partido " + p.getEquipo2().getScore() + "/" + p.getEquipo1().getScore()
                            + " Contra el equipo " + p.getEquipo1().getNombre());
                } else {
                    modelo.addElement("El equipo " + p.getEquipo2().getNombre() + " Empata el partido " + p.getEquipo2().getScore() + "/" + p.getEquipo1().getScore()
                            + " Con  el equipo " + p.getEquipo1().getNombre());
                }
                JOptionPane.showMessageDialog(tiempoTexto, "El partido ha concluido");
                crearArchivo();
                JOptionPane.showMessageDialog(tiempoTexto, "El partido se ha guardado en la carpeta dist del programa");
                Inicio i = new Inicio();
                i.setVisible(true);
                dispose();
            }
        }

    });

    public static String getHoraActual() {

        h = cann.get(Calendar.HOUR_OF_DAY);
        m = cann.get(Calendar.MINUTE);
        s = cann.get(Calendar.SECOND);

        return (h + ":" + m + ":" + s);
    }

    public String generateRandom() // Funcion que genera un codigo aleatorio de 3 digitos que tendra el nombre dle archivo txt
    {
        StringBuffer ss = new StringBuffer();
        for (int i = 0; i < 3; i++) {
            ss.append(Math.round(Math.random() * 9));
        }

        return ss.toString();
    }

    public static String getTiempoPartido() {

        if (ss > 9 && mm > 9) {
            return ("0" + hh + ":" + mm + ":" + ss);
        } else if (ss < 10 && mm < 10) {
            return ("0" + hh + ":" + "0" + mm + ":" + "0" + ss);
        } else if (ss > 9 && mm < 10) {
            return ("0" + hh + ":" + "0" + mm + ":" + ss);
        } else {
            return ("0" + hh + ":" + mm + ":0" + ss);
        }
    }

    public String tipoJugada(int n) {
        if (n != 0 && n != 1 && n != 3 && n != 15) {
            if (n <= 3) {
                return "//Jugada ANOTACION";
            } else if (n >= 4 || n <= 14) {
                return "//Jugada OFENSIVA";
            } else {
                return "//Jugada DEFENSIVA";
            }

        }
        return null;
    }

    public String insertarFaltaJugadaE1() {

        int n = (NjugadoresE1.getSelectedIndex()+1);
        int k = selectorJugadaE1.getSelectedIndex();

        if (faltaE1 == true) {

            return ("** " + getTiempoPartido() + " " + p.getEquipo1().getNombreApellJugador(n) + " Equipo " + p.getEquipo1().getNombre() + " // Falta // "
                    + selectorFaltaE1.getSelectedItem().toString());
        } else {

            if (selectorJugadaE1.getSelectedIndex() == 2) {
                p.getEquipo1().setScore(++se1);
                scoreE1.setText(String.valueOf(se1));
            }
            if (p.getEquipo1().getScore() < 10) {
                scoreE1.setText("0" + String.valueOf(p.getEquipo1().getScore()));
            } else {
                scoreE1.setText(String.valueOf(p.getEquipo1().getScore()));
            }

            return ("** " + getTiempoPartido() + " " + p.getEquipo1().getNombreApellJugador(n) + " Equipo " + p.getEquipo1().getNombre() + " " + tipoJugada(k) + " "
                    + selectorJugadaE1.getSelectedItem().toString());
        }
    }

    public String insertarFaltaJugadaE2() {

        int n = (NjugadoresE2.getSelectedIndex()+1);
        int k = selectorJugadaE2.getSelectedIndex();
        if (faltaE2 == true) {

            return ("** " + getTiempoPartido() + " " + p.getEquipo2().getNombreApellJugador(n) + " Equipo " + p.getEquipo2().getNombre() + " // Falta // "
                    + selectorFaltaE2.getSelectedItem().toString());
        } else {

            if (selectorJugadaE2.getSelectedIndex() == 2) {
                p.getEquipo2().setScore(++se2);
                scoreE2.setText(String.valueOf(se2));
            }
            if (p.getEquipo2().getScore() < 10) {
                scoreE2.setText("0" + String.valueOf(p.getEquipo2().getScore()));
            } else {
                scoreE2.setText(String.valueOf(p.getEquipo2().getScore()));
            }

            return ("** " + getTiempoPartido() + " " + p.getEquipo2().getNombreApellJugador(n) + " Equipo " + p.getEquipo2().getNombre() + " " + tipoJugada(k) + " "
                    + selectorJugadaE2.getSelectedItem().toString());
        }
    }

    public void crearArchivo() {

        String nombre;
        nombre = generateRandom() + " Partido " + p.getEquipo1().getNombre() + " VS " + p.getEquipo2().getNombre();

        File fi = new File(nombre + ".txt");

        if (!fi.exists()) {

            try {
                fi.createNewFile();
                FileWriter f = new FileWriter(fi);

                for (int i = 0; i < lista.getModel().getSize(); i++) {

                    f.write((String) lista.getModel().getElementAt(i));
                    f.write("\r\n");
                }
                f.close();
                agregarAMetadadta(nombre);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(rootPane, "NO SE PUDO CREAR EL ARCHIVO");
            }

        } else {
            try {
                fi = new File(nombre + " " + generateRandom() + ".txt");
                fi.createNewFile();
                FileWriter f = new FileWriter(fi);

                for (int i = 0; i < lista.getModel().getSize(); i++) {

                    f.write((String) lista.getModel().getElementAt(i));
                    f.write("\r\n");
                }
                f.close();

            } catch (IOException e) {
                JOptionPane.showMessageDialog(rootPane, "NO SE PUDO CREAR EL ARCHIVO");
            }

        }

    }
    
    public void agregarAMetadadta(String nombreArchivo) {
        
        File f;
        String linea;
        FileReader lector = null;
        FileWriter escritor = null;
        BufferedReader lector2 = null;

        f = new File("METADATA1.txt");

        if (f.exists()) {

            try {
                escritor = new FileWriter(f);
                lector = new FileReader(f);
                lector2 = new BufferedReader(lector);
              while((linea = lector2.readLine())!=null);
              if(linea == null) escritor.write(nombreArchivo);
                
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(rootPane, "NO SE PUDO ESCRIBIR EN LA METADATA :(");
            }
            finally{
                try {
                    lector2.close();
                    lector.close();
                    escritor.close();
                } catch (IOException ex) {
                   JOptionPane.showMessageDialog(rootPane, "Hubo un error al cerrar el archivo :("); ;
                }

            }

        } else {

            try {
                f.createNewFile();
                escritor.close();
                
            } catch (IOException e) {
                JOptionPane.showMessageDialog(rootPane, "NO SE PUDO CREAR EL ARCHIVO :(");
            } finally {
                try {
                    escritor.close();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(tiempoTexto, "No se pudo cerrar el archivo");
                }
            }

        }


        
        
    }
    
    public void iniciarPartido(){
        
         timer.start();
            h = cann.get(Calendar.HOUR_OF_DAY);
            m = cann.get(Calendar.MINUTE);
            s = can.get(Calendar.SECOND);
            modelo.addElement("-----------------------------Partido " + p.getEquipo1().getNombre() + " vs " + p.getEquipo2().getNombre());
            modelo.addElement("-----------------------------Estadio: " + p.getEstadio());
            modelo.addElement("-----------------------------Hora de inicio: " + h + ":" + m + ":" + s);
            modelo.addElement("-----------------------------EVENTOS:");
            p.setPartidoiniciado(true);
    }
    
    public void pausarPartido(){
        
        
            if (flagPausa % 2 != 0) {
                timer.stop();
                pausar.setText("Seguir Partido");
            } else {
                timer.start();
                pausar.setText("Pausar Partido");
            }
            flagPausa++;
        
    }
    
    public void describirEvento(){
       DescripcionEvento d = new DescripcionEvento();
       d.setVisible(true);
    }
    
    public static void main (String[] args){
        
        Partido p = null;
        
        Marcador m = new Marcador(p);
        m.setVisible(true);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tiempoTexto = new javax.swing.JLabel();
        tiempo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        scoreE1 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        equipo1 = new javax.swing.JLabel();
        selectorFaltaE1 = new javax.swing.JComboBox();
        selectorJugadaE1 = new javax.swing.JComboBox();
        NjugadoresE1 = new javax.swing.JComboBox();
        insertar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        scoreE2 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        equipo2 = new javax.swing.JLabel();
        selectorFaltaE2 = new javax.swing.JComboBox();
        selectorJugadaE2 = new javax.swing.JComboBox();
        NjugadoresE2 = new javax.swing.JComboBox();
        insertar2 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        iniciar = new javax.swing.JButton();
        pausar = new javax.swing.JButton();
        eventoDescripcion = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        exportar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lista = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 255));
        jPanel1.setForeground(new java.awt.Color(0, 0, 255));

        tiempoTexto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tiempoTexto.setForeground(new java.awt.Color(255, 255, 255));
        tiempoTexto.setText("Tiempo:");

        tiempo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tiempo.setForeground(new java.awt.Color(255, 255, 255));
        tiempo.setText("00:00:00");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tiempoTexto)
                .addGap(18, 18, 18)
                .addComponent(tiempo)
                .addGap(29, 29, 29))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tiempoTexto)
                    .addComponent(tiempo))
                .addGap(0, 7, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Falta:");

        jLabel3.setText("Jugada:");

        jLabel4.setText("Por jugador #:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 255));
        jLabel5.setText("SCORE");

        scoreE1.setEditable(false);
        scoreE1.setBackground(new java.awt.Color(102, 0, 0));
        scoreE1.setFont(new java.awt.Font("RussellSquare", 1, 48)); // NOI18N
        scoreE1.setForeground(new java.awt.Color(255, 51, 51));
        scoreE1.setText("00");
        scoreE1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                scoreE1PropertyChange(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(0, 0, 255));

        equipo1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        equipo1.setForeground(new java.awt.Color(255, 255, 255));
        equipo1.setText("jLabel6");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(equipo1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(equipo1)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        selectorFaltaE1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione", "Patada a adversario", " zancadilla a un adversario", "salto sobre un adversario", "cargar contra un adversario", " golpear a un adversario", "empujar a un adversario", "sujetar a un adversario", "escupir a un adversario", "tocar el balón deliberadamente con las manos" }));
        selectorFaltaE1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                selectorFaltaE1ItemStateChanged(evt);
            }
        });
        selectorFaltaE1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectorFaltaE1ActionPerformed(evt);
            }
        });

        selectorJugadaE1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione", "Anotacion----------------", "GOAL!!!!!!", "Ofensivas----------------", "Despeje", "Saques de banda", "Saques de portería", "Saques de esquina", "Romper el fuera de juego", "Cambiar el juego", "Pase y movimiento", "Agujero defensive", "Triangulacion", "Intercambio de bandas", "Hombre clave", "Defensiva--------------------", "Posiciones adelantadas", "Tiros libres de corto alcance", "Saques de esquina y otros cruces", "Penaltis", "Juego defensivo hombre a hombre", " lanzamiento cruzado" }));
        selectorJugadaE1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                selectorJugadaE1ItemStateChanged(evt);
            }
        });

        NjugadoresE1.setBorder(null);

        insertar.setText("Insertar");
        insertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(selectorFaltaE1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(selectorJugadaE1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel5)
                        .addGap(31, 31, 31)
                        .addComponent(scoreE1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NjugadoresE1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(insertar)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(scoreE1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(selectorFaltaE1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(selectorJugadaE1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(NjugadoresE1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(insertar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("VS");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setText("Falta:");

        jLabel9.setText("Jugada:");

        jLabel10.setText("Por jugador #:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 255));
        jLabel11.setText("SCORE");

        scoreE2.setEditable(false);
        scoreE2.setBackground(new java.awt.Color(102, 0, 0));
        scoreE2.setFont(new java.awt.Font("RussellSquare", 1, 48)); // NOI18N
        scoreE2.setForeground(new java.awt.Color(255, 51, 51));
        scoreE2.setText("00");
        scoreE2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                scoreE2PropertyChange(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(0, 0, 255));

        equipo2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        equipo2.setForeground(new java.awt.Color(255, 255, 255));
        equipo2.setText("jLabel7");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(equipo2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(equipo2)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        selectorFaltaE2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione", "Patada a adversario", " zancadilla a un adversario", "salto sobre un adversario", "cargar contra un adversario", " golpear a un adversario", "empujar a un adversario", "sujetar a un adversario", "escupir a un adversario", "tocar el balón deliberadamente con las manos" }));
        selectorFaltaE2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                selectorFaltaE2ItemStateChanged(evt);
            }
        });

        selectorJugadaE2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione", "Anotacion----------------", "GOAL!!!!!!", "Ofensivas----------------", "Despeje", "Saques de banda", "Saques de portería", "Saques de esquina", "Romper el fuera de juego", "Cambiar el juego", "Pase y movimiento", "Agujero defensive", "Triangulacion", "Intercambio de bandas", "Hombre clave", "Defensiva--------------------", "Posiciones adelantadas", "Tiros libres de corto alcance", "Saques de esquina y otros cruces", "Penaltis", "Juego defensivo hombre a hombre", " lanzamiento cruzado" }));
        selectorJugadaE2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                selectorJugadaE2ItemStateChanged(evt);
            }
        });

        NjugadoresE2.setBorder(null);

        insertar2.setText("insertar");
        insertar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertar2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel11)
                        .addGap(31, 31, 31)
                        .addComponent(scoreE2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(selectorFaltaE2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(selectorJugadaE2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NjugadoresE2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(insertar2))
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(scoreE2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(selectorFaltaE2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(selectorJugadaE2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(NjugadoresE2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(insertar2))
                    .addComponent(jLabel10))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(0, 102, 102));

        iniciar.setBackground(new java.awt.Color(0, 102, 102));
        iniciar.setForeground(new java.awt.Color(255, 255, 255));
        iniciar.setText("Iniciar Partido");
        iniciar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        iniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarActionPerformed(evt);
            }
        });

        pausar.setBackground(new java.awt.Color(0, 102, 102));
        pausar.setForeground(new java.awt.Color(255, 255, 255));
        pausar.setText("Pausar Partido");
        pausar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pausar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pausarActionPerformed(evt);
            }
        });

        eventoDescripcion.setBackground(new java.awt.Color(0, 102, 102));
        eventoDescripcion.setForeground(new java.awt.Color(255, 255, 255));
        eventoDescripcion.setText("Evento por descripcion");
        eventoDescripcion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        eventoDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eventoDescripcionActionPerformed(evt);
            }
        });

        eliminar.setBackground(new java.awt.Color(0, 102, 102));
        eliminar.setForeground(new java.awt.Color(255, 255, 255));
        eliminar.setText("Eliminar evento");
        eliminar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        exportar.setBackground(new java.awt.Color(0, 102, 102));
        exportar.setForeground(new java.awt.Color(255, 255, 255));
        exportar.setText("Exportar");
        exportar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        exportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(iniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pausar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eventoDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exportar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(eventoDescripcion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(pausar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(iniciar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(eliminar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(exportar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jScrollPane1.setViewportView(lista);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void selectorFaltaE1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectorFaltaE1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectorFaltaE1ActionPerformed

    private void scoreE1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_scoreE1PropertyChange
        scoreE1.setHorizontalAlignment((int) CENTER_ALIGNMENT);
    }//GEN-LAST:event_scoreE1PropertyChange

    private void scoreE2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_scoreE2PropertyChange
        scoreE2.setHorizontalAlignment((int) CENTER_ALIGNMENT);
    }//GEN-LAST:event_scoreE2PropertyChange

    private void selectorFaltaE1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_selectorFaltaE1ItemStateChanged

        if (selectorFaltaE1.getSelectedIndex() != 0) {
            faltaE1 = true;
            jugadaE1 = false;

        }
    }//GEN-LAST:event_selectorFaltaE1ItemStateChanged

    private void selectorJugadaE1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_selectorJugadaE1ItemStateChanged
        if (selectorJugadaE1.getSelectedIndex() != 0) {
            faltaE1 = false;
            jugadaE1 = true;

        }

    }//GEN-LAST:event_selectorJugadaE1ItemStateChanged

    private void selectorFaltaE2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_selectorFaltaE2ItemStateChanged
        if (selectorFaltaE2.getSelectedIndex() != 0) {
            faltaE2 = true;
            jugadaE2 = false;

        }

    }//GEN-LAST:event_selectorFaltaE2ItemStateChanged

    private void selectorJugadaE2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_selectorJugadaE2ItemStateChanged
        if (selectorJugadaE2.getSelectedIndex() != 0) {
            faltaE2 = false;
            jugadaE2 = true;

        }
    }//GEN-LAST:event_selectorJugadaE2ItemStateChanged

    private void insertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertarActionPerformed
        if (p.getPartidoiniciado()) {
            if (selectorJugadaE1.getSelectedIndex() != 0 || selectorFaltaE1.getSelectedIndex() != 0
                    || selectorJugadaE1.getSelectedIndex() != 1 || selectorJugadaE1.getSelectedIndex() != 3
                    || selectorJugadaE1.getSelectedIndex() != 15) {
                modelo.addElement(insertarFaltaJugadaE1());
            }

        }

        selectorJugadaE1.setSelectedIndex(0);
        selectorFaltaE1.setSelectedIndex(0);
    }//GEN-LAST:event_insertarActionPerformed

    private void insertar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertar2ActionPerformed
        if (p.getPartidoiniciado()) {

            if (selectorJugadaE2.getSelectedIndex() != 0 || selectorFaltaE2.getSelectedIndex() != 0
                    || selectorJugadaE2.getSelectedIndex() != 1 || selectorJugadaE2.getSelectedIndex() != 3
                    || selectorJugadaE2.getSelectedIndex() != 15) {
                modelo.addElement(insertarFaltaJugadaE2());
            }

        }

        selectorJugadaE2.setSelectedIndex(0);
        selectorFaltaE2.setSelectedIndex(0);
    }//GEN-LAST:event_insertar2ActionPerformed

    private void iniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarActionPerformed
       
        if (!p.getPartidoiniciado()) {
           iniciarPartido();
        } else {
            JOptionPane.showMessageDialog(rootPane, "EL PARTIDO YA HA INICIADO");
        }
        
    }//GEN-LAST:event_iniciarActionPerformed

    private void pausarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pausarActionPerformed
      
        if (p.getPartidoiniciado()) {
            pausarPartido();
        } else {
            JOptionPane.showMessageDialog(tiempoTexto, "Aun no inicia el partido");
        }
        
        
    }//GEN-LAST:event_pausarActionPerformed

    private void eventoDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eventoDescripcionActionPerformed
        
         if(p.getPartidoiniciado()){
           describirEvento();
       }
       else JOptionPane.showMessageDialog(tiempoTexto, "Aun no inicia el partido");
        
        
    }//GEN-LAST:event_eventoDescripcionActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
         if(modelo.getSize() > 0) modelo.remove(lista.getSelectedIndex());
    }//GEN-LAST:event_eliminarActionPerformed

    private void exportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportarActionPerformed
       
         if(p.getPartidoiniciado()){
            crearArchivo();
            JOptionPane.showMessageDialog(tiempoTexto, "El partido se ha guardado en la carpeta dist del programa");
        }
        else JOptionPane.showMessageDialog(tiempoTexto, "El partido aun no inicia");
        
    }//GEN-LAST:event_exportarActionPerformed

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox NjugadoresE1;
    private javax.swing.JComboBox NjugadoresE2;
    private javax.swing.JButton eliminar;
    private javax.swing.JLabel equipo1;
    private javax.swing.JLabel equipo2;
    private javax.swing.JButton eventoDescripcion;
    private javax.swing.JButton exportar;
    private javax.swing.JButton iniciar;
    private javax.swing.JButton insertar;
    private javax.swing.JButton insertar2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList lista;
    private javax.swing.JButton pausar;
    private javax.swing.JTextField scoreE1;
    private javax.swing.JTextField scoreE2;
    private javax.swing.JComboBox selectorFaltaE1;
    private javax.swing.JComboBox selectorFaltaE2;
    private javax.swing.JComboBox selectorJugadaE1;
    private javax.swing.JComboBox selectorJugadaE2;
    private javax.swing.JLabel tiempo;
    private javax.swing.JLabel tiempoTexto;
    // End of variables declaration//GEN-END:variables
}
