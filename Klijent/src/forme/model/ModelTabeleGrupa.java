/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.model;

import domen.Grupa;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Bogdan Blagojevic
 */
public class ModelTabeleGrupa extends AbstractTableModel{
    private List<Grupa> lista;
    private String[] kolone = {"ID Grupe", "Naziv grupe", "Broj clanova", "Kategorija", "Administrator", "Trener"};
    public ModelTabeleGrupa(List<Grupa> lista){
        this.lista = lista;
    }
    
    public ModelTabeleGrupa(){
        this.lista = new ArrayList<>();
    }
    
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Grupa grupa = lista.get(rowIndex);
        switch (columnIndex) {
            case 0: return grupa.getGrupaID();
            case 1: return grupa.getNazivGrupe();
            case 2: return grupa.getBrClanova();
            case 3: return grupa.getKategorija().getNazivKategorije();
            case 4: return grupa.getAdministrator().getKorisnickoIme();
            case 5: return grupa.getTrener();
            default:
                throw new AssertionError();
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    
    public void nadjiGrupu(String kategorija, String naziv, String trener){
        List<Grupa> filtriranaLista = lista.stream().filter(g -> (kategorija == null || g.getKategorija().getNazivKategorije().toUpperCase().contains(kategorija.toUpperCase())))
                .filter(g -> (naziv == null || g.getNazivGrupe().toLowerCase().contains(naziv.toLowerCase())))
                .filter(g -> (trener == null || g.getTrener().toString().toLowerCase().contains(trener.toLowerCase())))
                .collect(Collectors.toList());
        this.lista = filtriranaLista;
        fireTableDataChanged();
    }

    public List<Grupa> getLista() {
        return lista;
    }

    public void setLista(List<Grupa> lista) {
        this.lista = lista;
    }

    public String[] getKolone() {
        return kolone;
    }

    public void setKolone(String[] kolone) {
        this.kolone = kolone;
    }
    
    
}
