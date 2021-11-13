/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iu;

import logica.Juego;
import logica.Participante;

/**
 *
 * @author Gabriel
 */
public class PartidaPoker extends javax.swing.JDialog {

    /**
     * Creates new form PartidaPoker
     */
    private Participante participante;
    private Juego juego;
    public PartidaPoker(java.awt.Frame parent, boolean modal,Juego juego,Participante participante) {
        super(parent, modal);
        initComponents();
        this.participante=participante;
        this.juego=juego;
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMensaje = new javax.swing.JLabel();
        jCarta1 = new javax.swing.JButton();
        jCarta2 = new javax.swing.JButton();
        jCarta3 = new javax.swing.JButton();
        jCarta4 = new javax.swing.JButton();
        jCarta5 = new javax.swing.JButton();
        jBtnApostar = new javax.swing.JButton();
        jBtnPasar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jMensaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMensaje.setText("ESPERANDO PARA EMPEZAR");

        jCarta1.setIcon(new javax.swing.ImageIcon("C:\\Users\\elmef\\Desktop\\Clon obligatorio\\cartas\\cartas\\Invertida.gif")); // NOI18N
        jCarta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCarta1ActionPerformed(evt);
            }
        });

        jCarta2.setIcon(new javax.swing.ImageIcon("C:\\Users\\elmef\\Desktop\\Clon obligatorio\\cartas\\cartas\\Invertida.gif")); // NOI18N
        jCarta2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCarta2ActionPerformed(evt);
            }
        });

        jCarta3.setIcon(new javax.swing.ImageIcon("C:\\Users\\elmef\\Desktop\\Clon obligatorio\\cartas\\cartas\\Invertida.gif")); // NOI18N

        jCarta4.setIcon(new javax.swing.ImageIcon("C:\\Users\\elmef\\Desktop\\Clon obligatorio\\cartas\\cartas\\Invertida.gif")); // NOI18N

        jCarta5.setIcon(new javax.swing.ImageIcon("C:\\Users\\elmef\\Desktop\\Clon obligatorio\\cartas\\cartas\\Invertida.gif")); // NOI18N

        jBtnApostar.setText("APOSTAR");
        jBtnApostar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnApostarActionPerformed(evt);
            }
        });

        jBtnPasar.setText("PASAR");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jCarta1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jCarta2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jCarta3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jCarta4, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jCarta5, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(286, 286, 286)
                        .addComponent(jBtnApostar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jBtnPasar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(117, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jCarta1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCarta2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCarta3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCarta4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCarta5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(52, 52, 52)
                .addComponent(jMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBtnApostar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtnPasar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCarta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCarta1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCarta1ActionPerformed

    private void jCarta2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCarta2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCarta2ActionPerformed

    private void jBtnApostarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnApostarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnApostarActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnApostar;
    private javax.swing.JButton jBtnPasar;
    private javax.swing.JButton jCarta1;
    private javax.swing.JButton jCarta2;
    private javax.swing.JButton jCarta3;
    private javax.swing.JButton jCarta4;
    private javax.swing.JButton jCarta5;
    private javax.swing.JLabel jMensaje;
    // End of variables declaration//GEN-END:variables
}
