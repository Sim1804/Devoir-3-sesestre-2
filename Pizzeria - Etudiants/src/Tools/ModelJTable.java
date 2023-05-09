package Tools;

import Entities.Pizza;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ModelJTable extends AbstractTableModel {
    private String[] colonnes;
    private Object[][] lignes;

    @Override
    public String getColumnName(int column) {
        return colonnes[column];
    }

    @Override
    public int getRowCount() {
        return lignes.length;
    }

    @Override
    public int getColumnCount() {
        return colonnes.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return lignes[rowIndex][columnIndex];
    }

    @Override
    public void setValueAt(Object value, int row, int column) {
        lignes[row][column] = value;
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return column == 4 ;
    }


    public void loadDatasPizzas(ArrayList<Pizza> lesPizzas)
    {
        // A vous de jouer
        colonnes = new String[]{"Numéro","Nom","Nombre de personne","Prix","Quantité"};
        lignes = new Object[lesPizzas.size()][5];
        int i = 0;
        for (Pizza pizza : lesPizzas){
            lignes [i][0] = pizza.getNumeroPizza();
            lignes [i][1] = pizza.getNomPizza();
            lignes [i][2] = pizza.getNbPersonne();
            lignes [i][3] = pizza.getPrixPizza();
            lignes [i][4] = pizza.getQuantite();
            i++;
        }
        fireTableChanged(null);
    }
}
