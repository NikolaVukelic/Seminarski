/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form.sudije;

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
public class ModelTabeleSudije extends AbstractTableModel {

    ArrayList<Sudija> lista;

    public ModelTabeleSudije() {
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
        Sudija s = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return s.getUserID();
            case 1:
                return s.getIme();
            case 2:
                return s.getPrezime();

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

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return false;
        }
        return true;
    }

    public ArrayList<Sudija> getLista() {
        return lista;
    }

    public void dodajUTabelu(Sudija s) {
        lista.add(s);
        fireTableDataChanged();

    }

    public void obrisiRed(int tID, ArrayList<Igrac> listaIgraca, int row) {
        lista.remove(row);
        fireTableDataChanged();
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Sudija s = lista.get(rowIndex);

        switch (columnIndex) {
            case 1:
                String st = aValue.toString();
                s.setIme(st);
                break;

            case 2:
                String pre = aValue.toString();
                s.setPrezime(pre);
                break;

        }
        try {
            if (s.getIme().isEmpty() || s.getPrezime().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Sudija nije izmenjen.");
            } else {
                Controler.getInstance().stornirajSudiju(s);
                JOptionPane.showMessageDialog(null, "Sudija storniran.");
            }
        } catch (IOException ex) {
            Logger.getLogger(ModelTabeleSudije.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ModelTabeleSudije.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
