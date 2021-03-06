/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import form.igraci.PrikaziIgraceDialog;
import form.sudije.PrikaziSudijeDialog;
import form.takmicenje.IzaberiTakmicenjeForm;

/**
 *
 * @author Nikola
 */
public class FrmMain extends javax.swing.JFrame {

    /**
     * Creates new form FrmMain
     */
    public FrmMain() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        menuItemPrikaziTakmicenja = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        menuItemPrikaziIgrace = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        menuItemPrikaziSudije = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jMenu2.setText("File");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Edit");
        jMenuBar1.add(jMenu3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu4.setText("Takmicenja");

        menuItemPrikaziTakmicenja.setText("Prikazi");
        menuItemPrikaziTakmicenja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemPrikaziTakmicenjaActionPerformed(evt);
            }
        });
        jMenu4.add(menuItemPrikaziTakmicenja);

        jMenuBar2.add(jMenu4);

        jMenu5.setText("Igraci");

        menuItemPrikaziIgrace.setText("Prikazi");
        menuItemPrikaziIgrace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemPrikaziIgraceActionPerformed(evt);
            }
        });
        jMenu5.add(menuItemPrikaziIgrace);

        jMenuBar2.add(jMenu5);

        jMenu6.setText("Sudije");

        menuItemPrikaziSudije.setText("Prikazi");
        menuItemPrikaziSudije.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemPrikaziSudijeActionPerformed(evt);
            }
        });
        jMenu6.add(menuItemPrikaziSudije);

        jMenuBar2.add(jMenu6);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemPrikaziIgraceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemPrikaziIgraceActionPerformed
        PrikaziIgraceDialog pig = new PrikaziIgraceDialog(this, true);
        pig.setVisible(true);
    }//GEN-LAST:event_menuItemPrikaziIgraceActionPerformed

    private void menuItemPrikaziSudijeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemPrikaziSudijeActionPerformed
        PrikaziSudijeDialog psd = new PrikaziSudijeDialog(this, true);
        psd.setVisible(true);
    }//GEN-LAST:event_menuItemPrikaziSudijeActionPerformed

    private void menuItemPrikaziTakmicenjaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemPrikaziTakmicenjaActionPerformed
        IzaberiTakmicenjeForm itf = new IzaberiTakmicenjeForm();
        this.setVisible(false);
        itf.setVisible(true);
    }//GEN-LAST:event_menuItemPrikaziTakmicenjaActionPerformed

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
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem menuItemPrikaziIgrace;
    private javax.swing.JMenuItem menuItemPrikaziSudije;
    private javax.swing.JMenuItem menuItemPrikaziTakmicenja;
    // End of variables declaration//GEN-END:variables
}
