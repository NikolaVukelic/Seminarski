/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form.takmicenje;

import controler.Controler;
import domain.Igrac;
import domain.Sudija;
import domain.Takmicenje;
import domain.Ucesce;
import form.igraci.DodajIgracaForm;
import form.sudije.DodajSudijuForm;
import form.igraci.ModelTabeleIgraca;
import form.sudije.ModelTabeleSudije;
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
public class TakmicenjeForm extends javax.swing.JFrame {

    int ucesceID;
    int tID;
    ArrayList<Igrac> listaIgraca = new ArrayList<>();
    ArrayList<Sudija> listaSudija = new ArrayList<>();

    /**
     * Creates new form TakmicenjeForm
     */
    public TakmicenjeForm(int takmicenjeID, ArrayList<Igrac> listaIgraca, ArrayList<Sudija> listaSudija) {
        tID = takmicenjeID;
        this.listaIgraca = listaIgraca;
        this.listaSudija = listaSudija;

        initComponents();
        srediFormu();
    }

    public TakmicenjeForm(int takmicenjeID, ArrayList<Igrac> listaIgraca, ArrayList<Sudija> listaSudija, int ucesce) {
        tID = takmicenjeID;
        this.listaIgraca = listaIgraca;
        this.listaSudija = listaSudija;
        this.ucesceID = ucesce;
        initComponents();
        srediFormu();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnDodajSudiju = new javax.swing.JButton();
        btnObrisiSudiju = new javax.swing.JButton();
        btnSacuvaj = new javax.swing.JButton();
        labelaTakmicenje = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaSudije = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaIgraci = new javax.swing.JTable();
        btnDodajIgraca = new javax.swing.JButton();
        btnObrisiIgraca = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Unos takmicenja");

        btnDodajSudiju.setText("Dodaj sudiju");
        btnDodajSudiju.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajSudijuActionPerformed(evt);
            }
        });

        btnObrisiSudiju.setText("Obrisi sudiju");
        btnObrisiSudiju.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiSudijuActionPerformed(evt);
            }
        });

        btnSacuvaj.setText("Sacuvaj");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        labelaTakmicenje.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tabelaSudije.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabelaSudije);

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
        jScrollPane2.setViewportView(tabelaIgraci);

        btnDodajIgraca.setText("Dodaj igraca");
        btnDodajIgraca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajIgracaActionPerformed(evt);
            }
        });

        btnObrisiIgraca.setText("Obrisi igraca");
        btnObrisiIgraca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiIgracaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelaTakmicenje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnObrisiIgraca)
                            .addComponent(btnDodajIgraca)
                            .addComponent(btnDodajSudiju)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnSacuvaj)
                                .addComponent(btnObrisiSudiju)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(labelaTakmicenje, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDodajIgraca)
                        .addGap(18, 18, 18)
                        .addComponent(btnObrisiIgraca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDodajSudiju)
                        .addGap(18, 18, 18)
                        .addComponent(btnObrisiSudiju)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addComponent(btnSacuvaj)
                        .addGap(67, 67, 67))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDodajSudijuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajSudijuActionPerformed
        DodajSudijuForm dsf = new DodajSudijuForm(listaSudija, listaIgraca, tID, ucesceID);
        dsf.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnDodajSudijuActionPerformed

    private void btnDodajIgracaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajIgracaActionPerformed
        DodajIgracaForm dif = new DodajIgracaForm(listaIgraca, listaSudija, tID, ucesceID);
        dif.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnDodajIgracaActionPerformed

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed
        try {
            List<Ucesce> ucesca = Controler.getInstance().vratiUcescaZaIzabranoTakmicenje(tID);
            int maxID = vratiMaxID(ucesca);
            if (maxID > ucesceID) {
                ucesceID = maxID;
            }
            if (validno()) {
                ArrayList<Ucesce> listaUcesca = new ArrayList<>();
                for (Igrac i : listaIgraca) {
                    for (Sudija s : listaSudija) {
                        Ucesce u = new Ucesce(ucesceID, tID, i.getUserID(), s.getUserID());
                        if (neSadrzi(ucesca, u)) {
                            ucesceID++;
                            u.setUcesceID(ucesceID);
                            listaUcesca.add(u);
                        }
                    }
                }
                try {
                    Controler.getInstance().sacuvajUcesca(listaUcesca);
                    JOptionPane.showMessageDialog(null, "Takmicenje je uneseno.");
                } catch (SQLException ex) {
                    Logger.getLogger(TakmicenjeForm.class.getName()).log(Level.SEVERE, null, ex);
                }                

                IzaberiTakmicenjeForm itf = new IzaberiTakmicenjeForm(ucesceID);
                itf.setVisible(true);
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Bar 1 igrac i bar 1 sudija mora da se izabere.");
            }
        } catch (IOException ex) {
            Logger.getLogger(TakmicenjeForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TakmicenjeForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnSacuvajActionPerformed

    private void btnObrisiIgracaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiIgracaActionPerformed
        int row = tabelaIgraci.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Izaberi ucesce");
        } else {
            ModelTabeleIgraca mti = (ModelTabeleIgraca) tabelaIgraci.getModel();
            mti.obrisiRed(tID, listaSudija, row);
            Igrac zaBrisanje = listaIgraca.get(row);
            listaIgraca.remove(row);

            try {
                List<Ucesce> ucesca = Controler.getInstance().vratiUcescaZaIzabranoTakmicenje(tID);
                for (Ucesce u : ucesca) {
                    try {
                        if (u.getIgracID() == zaBrisanje.getUserID()) {
                            Controler.getInstance().obrisiUcesce(u.getUcesceID());
                            JOptionPane.showMessageDialog(null, "Ucesce obrisano.");
                        }

                    } catch (Exception ex) {
                        Logger.getLogger(TakmicenjeForm.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(TakmicenjeForm.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_btnObrisiIgracaActionPerformed

    private void btnObrisiSudijuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiSudijuActionPerformed
        int row = tabelaSudije.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Izaberi ucesce");
        } else {
            ModelTabeleSudije mts = (ModelTabeleSudije) tabelaSudije.getModel();
            mts.obrisiRed(tID, listaIgraca, row);
            Sudija zaBrisanje = listaSudija.get(row);
            listaSudija.remove(row);

            try {
                List<Ucesce> ucesca = Controler.getInstance().vratiUcescaZaIzabranoTakmicenje(tID);
                for (Ucesce u : ucesca) {
                    try {
                        if (u.getSudijaID() == zaBrisanje.getUserID()) {
                            Controler.getInstance().obrisiUcesce(u.getUcesceID());
                            JOptionPane.showMessageDialog(null, "Ucesce obrisano.");
                        }

                    } catch (Exception ex) {
                        Logger.getLogger(TakmicenjeForm.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            } catch (IOException ex) {
                Logger.getLogger(TakmicenjeForm.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(TakmicenjeForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnObrisiSudijuActionPerformed

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
            java.util.logging.Logger.getLogger(TakmicenjeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TakmicenjeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TakmicenjeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TakmicenjeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TakmicenjeForm(-1, new ArrayList<>(), new ArrayList<>()).setVisible(true);
            }
        });
    }

    private void srediFormu() {
        try {
            List<Takmicenje> listaTakmicenja;
            try {
                listaTakmicenja = Controler.getInstance().vratiTakmicenja();
                for (Takmicenje t : listaTakmicenja) {
                    if (t.getTakmicenjeID() == tID) {
                        labelaTakmicenje.setText("Takmicenje br. " + t.getTakmicenjeID() + " odrzava se datuma: " + t.getDatum() + " " + t.getDodatniOpis());
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(TakmicenjeForm.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(TakmicenjeForm.class.getName()).log(Level.SEVERE, null, ex);
            }

            ModelTabeleIgraca mti = new ModelTabeleIgraca();
            tabelaIgraci.setModel(mti);

            List<Ucesce> ucesca = Controler.getInstance().vratiUcescaZaIzabranoTakmicenje(tID);

            int[] igraciID = new int[10];
            int brojacIgraci = 0;
            int[] sudijeID = new int[10];
            int brojacSudije = 0;
            for (Ucesce u : ucesca) {
                if (nemaUNizu(u.getIgracID(), igraciID)) {
                    igraciID[brojacIgraci] = u.getIgracID();
                    brojacIgraci++;
                }
                if (nemaUNizu(u.getSudijaID(), sudijeID)) {
                    sudijeID[brojacSudije] = u.getSudijaID();
                    brojacSudije++;
                }
            }

            List<Igrac> igraciUBaziZaIzabranoTakmicenje = new ArrayList<>();
            List<Sudija> sudijeUBaziZaIzabranoTakmicenje = new ArrayList<>();
            List<Igrac> tempIgraci;
            List<Sudija> tempSudije;

            for (int igracID : igraciID) {
                try {
                    tempIgraci = Controler.getInstance().vratiIgracaZaIzabranoTakmicenje(igracID);
                    igraciUBaziZaIzabranoTakmicenje.addAll(tempIgraci);
                } catch (IOException ex) {
                    Logger.getLogger(TakmicenjeForm.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(TakmicenjeForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            for (int sudijaID : sudijeID) {
                try {
                    tempSudije = Controler.getInstance().vratiSudijuZaIzabranoTakmicenje(sudijaID);
                    sudijeUBaziZaIzabranoTakmicenje.addAll(tempSudije);
                } catch (IOException ex) {
                    Logger.getLogger(TakmicenjeForm.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(TakmicenjeForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            ModelTabeleSudije mts = new ModelTabeleSudije();
            tabelaSudije.setModel(mts);

            for (Igrac i : igraciUBaziZaIzabranoTakmicenje) {
                if (nijeDuplikat(i)) {
                    listaIgraca.add(i);
                }
            }

            for (Sudija s : sudijeUBaziZaIzabranoTakmicenje) {
                if (nijeDuplikat(s)) {
                    listaSudija.add(s);
                }
            }

            dodajListuIgracaUTabelu(listaIgraca);
            dodajListuSudijaUTabelu(listaSudija);
        } catch (IOException ex) {
            Logger.getLogger(TakmicenjeForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TakmicenjeForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodajIgraca;
    private javax.swing.JButton btnDodajSudiju;
    private javax.swing.JButton btnObrisiIgraca;
    private javax.swing.JButton btnObrisiSudiju;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelaTakmicenje;
    private javax.swing.JTable tabelaIgraci;
    private javax.swing.JTable tabelaSudije;
    // End of variables declaration//GEN-END:variables

    void dodajListuIgracaUTabelu(ArrayList<Igrac> lista) {
        ModelTabeleIgraca mti = (ModelTabeleIgraca) tabelaIgraci.getModel();
        for (Igrac i : lista) {
            if (!listaIgraca.contains(i)) {
                listaIgraca.add(i);
            }
        }
        for (Igrac i : listaIgraca) {
            mti.dodajUTabelu(i);
        }
    }

    void dodajListuSudijaUTabelu(ArrayList<Sudija> lista) {
        ModelTabeleSudije mts = (ModelTabeleSudije) tabelaSudije.getModel();
        for (Sudija s : lista) {
            if (!listaSudija.contains(s)) {
                listaSudija.add(s);
            }
        }

        for (Sudija s : listaSudija) {
            mts.dodajUTabelu(s);
        }
    }

    public ArrayList<Igrac> getListaIgraca() {
        return listaIgraca;
    }

    public ArrayList<Sudija> getListaSudija() {
        return listaSudija;
    }

    public void setListaIgraca(ArrayList<Igrac> listaIgraca) {
        this.listaIgraca = listaIgraca;
    }

    public void setListaSudija(ArrayList<Sudija> listaSudija) {
        this.listaSudija = listaSudija;
    }

    private boolean nijeDuplikat(Igrac i) {
        for (Igrac ig : listaIgraca) {
            if (ig.getUserID() == i.getUserID()) {
                return false;
            }
        }
        return true;
    }

    private boolean nijeDuplikat(Sudija s) {
        for (Sudija ss : listaSudija) {
            if (ss.getUserID() == s.getUserID()) {
                return false;
            }
        }
        return true;
    }

    private boolean validno() {
        if (listaIgraca.isEmpty() || listaSudija.isEmpty()) {
            return false;
        }
        return true;
    }

    private boolean nemaUNizu(int igracID, int[] igraciID) {
        for (int broj : igraciID) {
            if (broj == igracID) {
                return false;
            }
        }
        return true;
    }

    private boolean neSadrzi(List<Ucesce> ucesca, Ucesce u) {
        for (Ucesce uc : ucesca) {
            if (uc.getIgracID() == u.getIgracID() && uc.getSudijaID() == u.getSudijaID()) {
                return false;
            }
        }
        return true;
    }

    private int vratiMaxID(List<Ucesce> ucesca) {
        if (ucesca.isEmpty()) {
            return 0;
        }

        int x = ucesca.get(0).getUcesceID();
        for (Ucesce u : ucesca) {
            if (u.getUcesceID() > x) {
                x = u.getUcesceID();
            }
        }
        return x;
    }

}
