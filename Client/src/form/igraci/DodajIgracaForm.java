/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form.igraci;

import controler.Controler;
import domain.Igrac;
import domain.Sudija;
import domain.User;
import form.takmicenje.TakmicenjeForm;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Nikola
 */
public class DodajIgracaForm extends javax.swing.JFrame {
    int ucesceID;
    public static int tID;
    ArrayList<Igrac> listaIgraca = new ArrayList<>();
    ArrayList<Sudija> listaSudija = new ArrayList<>();

    /**
     * Creates new form DodajIgracaForm
     */
    public DodajIgracaForm(ArrayList<Igrac> listaIgraca, ArrayList<Sudija> listaSudija, int tID,int ucesceID) {
        initComponents();
        ModelTabeleIgraca mti = new ModelTabeleIgraca();
        tabelaIgraci.setModel(mti);
        this.tID = tID;
        this.listaSudija = listaSudija;
        this.listaIgraca = listaIgraca;
        this.ucesceID=ucesceID;
        for (Igrac i : listaIgraca) {
            mti.dodajUTabelu(i);
        }
        napuniCB();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaIgraci = new javax.swing.JTable();
        btnNapraviIgraca = new javax.swing.JButton();
        btnPotvrdi = new javax.swing.JButton();
        cmbIgraci = new javax.swing.JComboBox();
        btnDodaj = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dodavanje igraca");

        tabelaIgraci.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabelaIgraci);

        btnNapraviIgraca.setText("Napravi igraca");
        btnNapraviIgraca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNapraviIgracaActionPerformed(evt);
            }
        });

        btnPotvrdi.setText("Potvrdi");
        btnPotvrdi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPotvrdiActionPerformed(evt);
            }
        });

        cmbIgraci.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnDodaj.setText("Dodaj");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmbIgraci, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(btnDodaj)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnPotvrdi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNapraviIgraca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(btnNapraviIgraca))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbIgraci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDodaj))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(55, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPotvrdi)
                        .addGap(62, 62, 62))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNapraviIgracaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNapraviIgracaActionPerformed
        NapraviIgracaDialog nid = new NapraviIgracaDialog(this, true);
        nid.setVisible(true);
    }//GEN-LAST:event_btnNapraviIgracaActionPerformed

    private void btnPotvrdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPotvrdiActionPerformed
        TakmicenjeForm tf = new TakmicenjeForm(tID, listaIgraca, listaSudija,ucesceID);
        tf.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnPotvrdiActionPerformed

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
        int br = cmbIgraci.getItemCount();
        if (br == 0) {
            JOptionPane.showMessageDialog(null, "greska");
        } else {
            Igrac i = (Igrac) cmbIgraci.getSelectedItem();
            ModelTabeleIgraca mti = (ModelTabeleIgraca) tabelaIgraci.getModel();
            mti.dodajUTabelu(i);
            listaIgraca.add(i);
            cmbIgraci.removeItem(i);
        }
    }//GEN-LAST:event_btnDodajActionPerformed

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
            java.util.logging.Logger.getLogger(DodajIgracaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DodajIgracaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DodajIgracaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DodajIgracaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DodajIgracaForm(new ArrayList<>(), new ArrayList<>(), tID,-1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnNapraviIgraca;
    private javax.swing.JButton btnPotvrdi;
    private javax.swing.JComboBox cmbIgraci;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaIgraci;
    // End of variables declaration//GEN-END:variables

    void dodajIgraca(Igrac i) {
        List<Igrac> listaIgr;
        List<Sudija> listaSud;
        int userID = 0;
        try {
            listaIgr = Controler.getInstance().vratiIgrace();
            listaSud = Controler.getInstance().vratiSudije();
            userID = vratiMaxUserID(listaIgr, listaSud);
            i.setUserID(userID);
            
            User u = new User(userID, i.getUsername(), i.getPassword(), i.getEmail());
            Controler.getInstance().dodajUsera(u);
            Controler.getInstance().dodajIgraca(i);
            JOptionPane.showMessageDialog(null, "Igrac unesen.");
        } catch (SQLException ex) {
            Logger.getLogger(DodajIgracaForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DodajIgracaForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DodajIgracaForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        napuniCB();
    }

    private void napuniCB() {
        cmbIgraci.removeAllItems();
        List<Igrac> lista;
        try {
            lista = Controler.getInstance().vratiIgrace();
            for (Igrac i : lista) {
                if (nijeDuplikat(i)) {
                    cmbIgraci.addItem(i);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(DodajIgracaForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DodajIgracaForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private boolean nijeDuplikat(Igrac i) {
        for (Igrac ig : listaIgraca) {
            if (ig.getUserID() == i.getUserID()) {
                return false;
            }
        }
        return true;
    }

    private int vratiMaxUserID(List<Igrac> listaIgr, List<Sudija> listaSud) {
        int max = 0;
        for (Igrac i : listaIgr) {
            for (Sudija s : listaSud) {
                if (i.getUserID() >= s.getUserID()) {
                    max = i.getUserID();
                } else {
                    max = s.getUserID();
                }

            }
        }
        return max + 1;
    }

}
