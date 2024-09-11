/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.model;

import domen.TipTreninga;
import domen.Trening;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Bogdan Blagojevic
 */
public class ModelTabeleTrening extends AbstractTableModel{
    private List<Trening> lista;
    private String[] kolone = {"Redni broj", "Datum", "Tip treninga", "Sala", "Trener", "Grupa"};
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    public ModelTabeleTrening(List<Trening> lista){
        this.lista = lista;
    }
    
    public ModelTabeleTrening(){
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
        Trening trening = lista.get(rowIndex);

        String datum = sdf.format(trening.getDatumTreninga());
        switch (columnIndex) {
            case 0: return trening.getRbTreninga();
            case 1: return datum;
            case 2: return trening.getTipTreninga();
            case 3: return trening.getSala().getNazivSale();
            case 4: return trening.getTrener();
            case 5: return trening.getGrupa().getNazivGrupe();
            default:
                throw new AssertionError();
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    public void nadjiTrening(String tip, String datum) {
        List<Trening> filtriranaLista = lista.stream()
            .filter(t -> (tip == null || tip.isEmpty() || tip.isBlank() || t.getTipTreninga().name().toUpperCase().contains(tip.toUpperCase())))
            .filter(t -> (datum == null || datum.equals("format: yyyy-MM-dd") || sdf.format(t.getDatumTreninga()).contains(datum)))
            .collect(Collectors.toList());
        this.lista = filtriranaLista;
        fireTableDataChanged();
    }

    public List<Trening> getLista() {
        return lista;
    }

    public void setLista(List<Trening> lista) {
        this.lista = lista;
    }

    public String[] getKolone() {
        return kolone;
    }

    public void setKolone(String[] kolone) {
        this.kolone = kolone;
    }
    
    
}
