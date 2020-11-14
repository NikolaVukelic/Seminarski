/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form.takmicenje;

import domain.Takmicenje;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Nikola
 */
public class ModelTabeleTakmicenje extends AbstractTableModel {

    ArrayList<Takmicenje> lista;

    public ModelTabeleTakmicenje() {
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
        Takmicenje t = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return t.getTakmicenjeID();
            case 1:
                return t.getDatum();
            case 2:
                return t.getDodatniOpis();

            default:
                return "nista";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID takmicenja";
            case 1:
                return "Datum";
            case 2:
                return "Opis";
            default:
                return "nista";
        }
    }

    public ArrayList<Takmicenje> getLista() {
        return lista;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public void dodajUTabelu(Takmicenje t) {
        lista.add(t);
        fireTableDataChanged();
    }

    public int vratiIDTakmicenja(int red) {
        Takmicenje t = lista.get(red);
        return t.getTakmicenjeID();
    }

}
