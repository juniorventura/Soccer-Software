/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.GUI;

import java.awt.Color;
import java.applet.AudioClip;

/**
 *
 * @author Junior C
 */
public class Inicio extends javax.swing.JFrame {

    /**
     * Creates new form Inicio
     */
    
    AudioClip seleccion;
    
    public Inicio() {
        
        initComponents();
         this.getContentPane().setBackground(Color.BLUE);
        setLocationRelativeTo(null); 
        descripcioncrear.setVisible(false);
       
        descripcionguardar.setVisible(false);
        descripcionsobre.setVisible(false);
        seleccion = java.applet.Applet.newAudioClip(getClass().getResource("/com/Sonidos/Selection.wav"));
    
        
        
      
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descripcioncrear = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        cargarPartido = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        crearPartido = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        descripcionguardar = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        descripcionsobre = new javax.swing.JTextArea();
        sobrelaApp = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Soccer Software");
        setBackground(new java.awt.Color(0, 0, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        descripcioncrear.setEditable(false);
        descripcioncrear.setBackground(new java.awt.Color(51, 51, 255));
        descripcioncrear.setColumns(20);
        descripcioncrear.setForeground(new java.awt.Color(255, 255, 255));
        descripcioncrear.setRows(5);
        descripcioncrear.setText("Permite crear un partido\nconfigurando\nlos datos basicos \nnecesarios de los equipos");
        descripcioncrear.setBorder(null);
        jScrollPane1.setViewportView(descripcioncrear);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, 260, 100));

        jLabel1.setFont(new java.awt.Font("Tele-Marines", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Soccer Software");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 62, -1, -1));

        jPanel1.setBackground(new java.awt.Color(0, 0, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(468, 100, 110, 10));

        jPanel2.setBackground(new java.awt.Color(0, 0, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 47, 110, -1));

        cargarPartido.setFont(new java.awt.Font("RussellSquare", 0, 36)); // NOI18N
        cargarPartido.setText("Cargar Partido");
        cargarPartido.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                cargarPartidoMouseMoved(evt);
            }
        });
        cargarPartido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cargarPartidoMouseExited(evt);
            }
        });
        getContentPane().add(cargarPartido, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        jPanel3.setLayout(null);

        crearPartido.setFont(new java.awt.Font("RussellSquare", 0, 24)); // NOI18N
        crearPartido.setText("Crear Partido");
        crearPartido.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                crearPartidoMouseMoved(evt);
            }
        });
        crearPartido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                crearPartidoMouseExited(evt);
            }
        });
        jPanel3.add(crearPartido);
        crearPartido.setBounds(230, 200, 147, 22);

        descripcionguardar.setEditable(false);
        descripcionguardar.setBackground(new java.awt.Color(0, 153, 153));
        descripcionguardar.setColumns(20);
        descripcionguardar.setForeground(new java.awt.Color(255, 255, 255));
        descripcionguardar.setRows(5);
        descripcionguardar.setText("Permite cargar los\npartidos guardados\npara su visualizacion\nen la aplicacion");
        descripcionguardar.setBorder(null);
        descripcionguardar.setCaretColor(new java.awt.Color(255, 255, 255));
        descripcionguardar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setViewportView(descripcionguardar);

        jPanel3.add(jScrollPane2);
        jScrollPane2.setBounds(20, 180, 250, 130);

        descripcionsobre.setEditable(false);
        descripcionsobre.setBackground(new java.awt.Color(102, 102, 255));
        descripcionsobre.setColumns(20);
        descripcionsobre.setForeground(new java.awt.Color(255, 255, 255));
        descripcionsobre.setRows(5);
        descripcionsobre.setText("Version actuaal 2.2\nJava 8\n@Autores: Junior Ventura\n          Nelson Colon\n          Victor Suero");
        descripcionsobre.setBorder(null);
        jScrollPane3.setViewportView(descripcionsobre);

        jPanel3.add(jScrollPane3);
        jScrollPane3.setBounds(230, 270, 330, 100);

        sobrelaApp.setFont(new java.awt.Font("RussellSquare", 0, 18)); // NOI18N
        sobrelaApp.setText("Sobre la aplicacion");
        sobrelaApp.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                sobrelaAppMouseMoved(evt);
            }
        });
        sobrelaApp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sobrelaAppMouseExited(evt);
            }
        });
        jPanel3.add(sobrelaApp);
        sobrelaApp.setBounds(370, 250, 160, 17);

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/Imagenes/fondoHome.jpg"))); // NOI18N
        jPanel3.add(fondo);
        fondo.setBounds(0, 0, 530, 430);

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 430));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/Imagenes/soccer-player.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, 110, 70));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cargarPartidoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cargarPartidoMouseMoved
        seleccion.play();
        cargarPartido.setForeground(Color.BLUE);
        descripcionguardar.setVisible(true);
        
    }//GEN-LAST:event_cargarPartidoMouseMoved

    private void cargarPartidoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cargarPartidoMouseExited
         seleccion.stop();
        cargarPartido.setForeground(Color.BLACK);
        descripcionguardar.setVisible(false);
    }//GEN-LAST:event_cargarPartidoMouseExited

    private void crearPartidoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crearPartidoMouseMoved
        seleccion.play();
        crearPartido.setForeground(Color.BLUE);
        descripcioncrear.setVisible(true);
    }//GEN-LAST:event_crearPartidoMouseMoved

    private void crearPartidoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crearPartidoMouseExited
        seleccion.stop();
        crearPartido.setForeground(Color.BLACK);
        descripcioncrear.setVisible(false);
    }//GEN-LAST:event_crearPartidoMouseExited

    private void sobrelaAppMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sobrelaAppMouseMoved
      seleccion.play();
        sobrelaApp.setForeground(Color.BLUE);
        descripcionsobre.setVisible(true);
    }//GEN-LAST:event_sobrelaAppMouseMoved

    private void sobrelaAppMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sobrelaAppMouseExited
         seleccion.stop(); 
        sobrelaApp.setForeground(Color.BLACK);
        descripcionsobre.setVisible(false);
    }//GEN-LAST:event_sobrelaAppMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cargarPartido;
    private javax.swing.JLabel crearPartido;
    private javax.swing.JTextArea descripcioncrear;
    private javax.swing.JTextArea descripcionguardar;
    private javax.swing.JTextArea descripcionsobre;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel sobrelaApp;
    // End of variables declaration//GEN-END:variables
}
