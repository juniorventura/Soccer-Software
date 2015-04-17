/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.GUI;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;



public class Consultas extends javax.swing.JFrame {

   
      public Consultas() {
          
        initComponents();
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.WHITE);
        lista.setModel(modelo);
        lista2.setModel(modelo2);
        leerUltimosArchivosCreador();
        this.getContentPane().setBackground(Color.getHSBColor(0, 102, 153));
        
    }
    
    public DefaultListModel modelo = new DefaultListModel();
    public DefaultListModel modelo2 = new DefaultListModel();
    
    
  
   public void leerArchivo(){
        
        
        File f;
        FileReader fr;
        BufferedReader b;
        JFileChooser selArchivo = new JFileChooser();
        selArchivo.showOpenDialog(selArchivo);
        selArchivo.setCurrentDirectory(null);
       
        f = selArchivo.getSelectedFile();
        if(f == null)return;
        String line;
        
        try{
         
            fr = new FileReader(f);
            b = new BufferedReader(fr);
            while((line = b.readLine())!=null){
                modelo.addElement(line);
            }
        }
        catch(IOException e){
            JOptionPane.showConfirmDialog(rootPane, "NO SE Puede abrir el Archivo :(");
        }
   }
   
   public void leerArchivo(int i){ // OVERLOADING METODO LEER ARCHIVO PARA CUANDO SE HAGA DESDE ARCHIVOS RECIENTES
        
        
       String nombreArchivo;
       
       nombreArchivo = modelo2.getElementAt(lista2.getSelectedIndex()).toString();
       
        File f;
        FileReader fr;
        BufferedReader b;
       
       
        f = new File(nombreArchivo+".txt");
        
        String line;
        
       if (f.exists()) {
           try {

               fr = new FileReader(f);
               b = new BufferedReader(fr);
               while ((line = b.readLine()) != null) {
                   modelo.addElement(line);
               }
           } catch (IOException e) {
               JOptionPane.showConfirmDialog(rootPane, "NO SE Puede abrir el Archivo :(");
           }
       }
       else {
           JOptionPane.showMessageDialog(rootPane, "El archivo ya no existe o fue eliminado");
           for(int k = 0; k < modelo2.getSize(); k++){
               if(modelo2.getElementAt(k).equals(nombreArchivo)) modelo2.removeElementAt(k);
           }
       }
        
        
   }
   
   public void leerUltimosArchivosCreador(){
       
       File f;
       FileReader fr;
       BufferedReader br;
       String line;
       
       f = new File("METADATA1.txt");
       
       if(f.exists()){
           
           try{
               fr = new FileReader(f);
               br = new BufferedReader(fr);
               
               while((line = br.readLine()) != null){
                   modelo2.addElement(line);
               }
           }
           catch(IOException e){
               JOptionPane.showMessageDialog(rootPane, "No se ha podido leer el archivo :(");
           }  
       }
       else{
           JOptionPane.showConfirmDialog(rootPane, "Aun no existen archivos recientemente creados");
       }
       
       
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondopanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lista2 = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lista = new javax.swing.JList();
        jButton3 = new javax.swing.JButton();
        fondoImagen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 102, 153));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fondopanel.setLayout(null);

        lista2.setBackground(new java.awt.Color(0, 102, 102));
        lista2.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(lista2);

        fondopanel.add(jScrollPane2);
        jScrollPane2.setBounds(10, 110, 214, 460);

        jLabel1.setFont(new java.awt.Font("RussellSquare", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Archivos creados recientemente");
        fondopanel.add(jLabel1);
        jLabel1.setBounds(10, 60, 211, 13);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Seleccione un archivo");
        fondopanel.add(jLabel2);
        jLabel2.setBounds(60, 80, 130, 14);

        jButton1.setBackground(new java.awt.Color(0, 102, 255));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Abrir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        fondopanel.add(jButton1);
        jButton1.setBounds(10, 10, 55, 23);

        jButton2.setBackground(new java.awt.Color(0, 102, 255));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("buscar por directorio");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        fondopanel.add(jButton2);
        jButton2.setBounds(70, 10, 160, 23);

        jScrollPane1.setViewportView(lista);

        fondopanel.add(jScrollPane1);
        jScrollPane1.setBounds(230, 50, 700, 529);

        jButton3.setBackground(new java.awt.Color(0, 0, 255));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Inicio");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        fondopanel.add(jButton3);
        jButton3.setBounds(820, 10, 119, 23);

        fondoImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/Imagenes/Fondo-azul.png"))); // NOI18N
        fondopanel.add(fondoImagen);
        fondoImagen.setBounds(0, 0, 940, 610);

        getContentPane().add(fondopanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 640));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      if(modelo.getSize()!=0)limpiarLista();
        leerArchivo();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      if(!lista2.isSelectionEmpty()){
           if(modelo.getSize()!=0)limpiarLista();
          leerArchivo(1);
      }
      else{
          JOptionPane.showMessageDialog(rootPane, "Debe selecionar un elemento de la lista primero");
      }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        irAInicio();
    }//GEN-LAST:event_jButton3ActionPerformed

    public void limpiarLista(){
      
           modelo.clear();
       
    }
    
    public void irAInicio(){
        
        Inicio i = new Inicio();
        i.setVisible(true);
        dispose();
        
    }
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
            java.util.logging.Logger.getLogger(Consultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Consultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Consultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Consultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Consultas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fondoImagen;
    private javax.swing.JPanel fondopanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList lista;
    private javax.swing.JList lista2;
    // End of variables declaration//GEN-END:variables
}
