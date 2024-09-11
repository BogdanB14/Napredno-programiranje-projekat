/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import domen.Grupa;
import domen.Sala;
import domen.TipTreninga;
import domen.Trener;
import domen.Trening;
import forme.DodajTreningForma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;
import komunikacija.Odgovor;

/**
 *
 * @author Bogdan Blagojevic
 */
public class DodajTreningController {
    
    private final DodajTreningForma dodajTreningForma;

    public DodajTreningController(DodajTreningForma dodajTreningForma) {
        this.dodajTreningForma = dodajTreningForma;
        addActionListener();
    }

    private void addActionListener() {
        dodajTreningForma.addDodajTreningActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String datum = dodajTreningForma.getjTextFieldDatumTreninga().getText().trim();
                    if(datum == null || datum.isBlank() || datum.isEmpty() || !datum.matches("[0-9]{4}-[0-1][0-9]-[0-3][0-9]")){
                        JOptionPane.showMessageDialog(dodajTreningForma, "Greska, trening nije kreiran", "GRESKA", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    Date datumTreninga = new Date();
                    Date trenutniDatum = new Date();
                    
                try {
                  datumTreninga  = sdf.parse(datum);
                  if(datumTreninga.before(trenutniDatum)){
                        JOptionPane.showMessageDialog(dodajTreningForma, "Greska, trening nije kreiran", "GRESKA", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(DodajTreningController.class.getName()).log(Level.SEVERE, null, ex);
                }
                TipTreninga tip = (TipTreninga) dodajTreningForma.getjComboBoxTipTreninga().getSelectedItem();
                Sala sala = (Sala) dodajTreningForma.getjComboBoxSala().getSelectedItem();
                Trener trener = (Trener) dodajTreningForma.getjComboBoxTrener().getSelectedItem();
                Grupa grupa = (Grupa) dodajTreningForma.getjComboBoxGrupa().getSelectedItem();
                if(tip == null || sala == null || trener == null || grupa == null){
                    JOptionPane.showMessageDialog(dodajTreningForma, "Izaberite objekat iz padajuce liste");
                    return;
                }
                Trening trening = new Trening(0, datumTreninga, tip, sala, trener, grupa);
                Odgovor odgovor = Komunikacija.getInstanca().kreirajTrening(trening);
                
                if(odgovor.getOdgovor() == null){
                    JOptionPane.showMessageDialog(dodajTreningForma, "Novi trening je uspesno kreiran", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                    dodajTreningForma.dispose();
                    return;
                }
                JOptionPane.showMessageDialog(dodajTreningForma, "Podaci o novom treningu nisu upamceni", "GRESKA", JOptionPane.INFORMATION_MESSAGE);
                dodajTreningForma.dispose();
            }
        });
        
        
        dodajTreningForma.addGlavniMeniActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dodajTreningForma.dispose();
            }
        });
    }

    public void otvoriFormu() {
        System.out.println("USAO U OTVORI FORMU U DODAJ TRENING CONTROLLER-U");
        pripremiFormu();
        dodajTreningForma.setVisible(true);
    }

    private void pripremiFormu() {
        System.out.println("USAO U PRIPREMI FORMU");
        List<Sala> listaSala = Komunikacija.getInstanca().ucitajListuSala();
        for(Sala s : listaSala){
            dodajTreningForma.getjComboBoxSala().addItem(s);
        }
        
        List<Trener> listaTrenera = Komunikacija.getInstanca().ucitajListuTrenera();
        for(Trener t : listaTrenera){
            dodajTreningForma.getjComboBoxTrener().addItem(t);
        }
        
        List<Grupa> listaGrupa = Komunikacija.getInstanca().ucitajListuGrupa();
        for(Grupa g : listaGrupa){
            dodajTreningForma.getjComboBoxGrupa().addItem(g);
        }
       
    }
}
