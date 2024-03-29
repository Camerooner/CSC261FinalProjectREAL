/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.csc261pokedexfinalproject;

import com.formdev.flatlaf.FlatLightLaf;
import com.github.oscar0812.pokeapi.models.pokemon.Pokemon;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;

/**
 *
 * @author Cam
 */

public class PokedexIntro extends javax.swing.JFrame {
    
    private AudioPlayer audioPlayer;

    /**
     * Creates new form PokedexIntro
     */
    
    public PokedexIntro() {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(217, 76, 56)); // Set the background color of the content pane
        setTitle("Pokédex Application");
        setResizable(false); // Non-resizable window
        setLocationRelativeTo(null); // Center window
        audioPlayer = new AudioPlayer();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pokedexEnterButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pokedexEnterButton.setFont(new java.awt.Font("Pokemon Solid", 0, 24)); // NOI18N
        pokedexEnterButton.setText("Enter Pokédex");
        pokedexEnterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pokedexEnterButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Pokemon Solid", 0, 24)); // NOI18N
        jLabel1.setText(" Cam's Pokédex & Pokémon Quiz!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(pokedexEnterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                .addComponent(pokedexEnterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pokedexEnterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pokedexEnterButtonActionPerformed
        audioPlayer.playButtonSound("A Button BW.wav");

        // Main tabbed pane
        JTabbedPane tabbedPane = new JTabbedPane();

        // Instances of the panels
        PokedexGUI pokedexPanel = new PokedexGUI();
        PokemonQuiz quizPanel = new PokemonQuiz();
        
        // Adds the panels to the tabbed pane
        tabbedPane.addTab("Pokédex", pokedexPanel);
        tabbedPane.addTab("Quiz", quizPanel);

        getContentPane().removeAll();
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(tabbedPane, BorderLayout.CENTER);
        revalidate();
        repaint();
    }//GEN-LAST:event_pokedexEnterButtonActionPerformed

    
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
            java.util.logging.Logger.getLogger(PokedexIntro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PokedexIntro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PokedexIntro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PokedexIntro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FlatLightLaf.setup();
                new PokedexIntro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton pokedexEnterButton;
    // End of variables declaration//GEN-END:variables
}
