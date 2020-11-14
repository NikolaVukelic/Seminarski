/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form.igraci;

import controler.Controler;
import domain.Igrac;
import domain.Sudija;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Nikola
 */
public class ModelTabeleIgraca extends AbstractTableModel {

    ArrayList<Igrac> lista;

    public ModelTabeleIgraca() {
        lista = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Igrac i = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return i.getUserID();
            case 1:
                return i.getIme();
            case 2:
                return i.getPrezime();

            default:
                return "nista";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "Ime";
            case 2:
                return "Prezime";

            default:
                return "nista";
        }
    }

    public ArrayList<Igrac> getLista() {
        return lista;
    }

    public void dodajUTabelu(Igrac i) {
        lista.add(i);
        fireTableDataChanged();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return false;
        }
        return true;
    }

    public void obrisiRed(int tID, ArrayList<Sudija> listaSudija, int row) {
        lista.remove(row);
        fireTableDataChanged();
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Igrac i = lista.get(rowIndex);

        switch (columnIndex) {
            case 1:
                String st = aValue.toString();
                i.setIme(st);
                break;

            case 2:
                String pre = aValue.toString();
                i.setPrezime(pre);
                break;

        }
        try {
            if (i.getIme().isEmpty() || i.getPrezime().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Igrac nije izmenjen.");
            } else {
                Controler.getInstance().stornirajIgraca(i);
                JOptionPane.showMessageDialog(null, "Igrac storniran.");
            }
        } catch (IOException ex) {
            Logger.getLogger(ModelTabeleIgraca.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ModelTabeleIgraca.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
