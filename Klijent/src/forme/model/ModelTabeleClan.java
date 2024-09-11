/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.model;

import domen.Clan;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Bogdan Blagojevic
 */
public class ModelTabeleClan extends AbstractTableModel{
    private List<Clan> lista;
    private String[] kolone = {"JMBG", "Ime", "Prezime", "Datum rodjenja", "Pol", "Telefon", "Mesto"};
    
    public ModelTabeleClan(List<Clan> lista){
        this.lista = lista;
    }
    
    public ModelTabeleClan(){
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
        Clan clan = lista.get(rowIndex);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String datumRodjenja = sdf.format(clan.getDatumRodjenja());
        switch (columnIndex) {
            case 0: return clan.getJmbg();
            case 1: return clan.getImeClana();
            case 2: return clan.getPrezimeClana();
            case 3: return datumRodjenja;
            case 4: return clan.getPol();
            case 5: return clan.getTelefon();
            case 6: return clan.getMesto();
            default:
                return "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    
    
    public List<Clan> getLista() {
        return lista;
    }

    public void setLista(List<Clan> lista) {
        this.lista = lista;
    }

    public void nadjiClana(String ime, String prezime) {
        List<Clan> filtriranaLista = lista.stream().filter(c -> (ime == null || ime.isEmpty() || c.getImeClana().toLowerCase().contains(ime.toLowerCase())))
                .filter(c -> (prezime == null || prezime.isEmpty() || c.getPrezimeClana().toLowerCase().contains(prezime.toLowerCase())))
                .collect(Collectors.toList());
        this.lista = filtriranaLista;
        fireTableDataChanged();
    }
    
}
