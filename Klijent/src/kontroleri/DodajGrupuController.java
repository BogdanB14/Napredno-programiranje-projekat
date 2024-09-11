/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import domen.Administrator;
import domen.Grupa;
import domen.Kategorija;
import domen.Trener;
import forme.DodajGrupuForma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;
import komunikacija.Odgovor;

/**
 *
 * @author Bogdan Blagojevic
 */
public class DodajGrupuController {
     private final DodajGrupuForma dodajGrupuForma;

    public DodajGrupuController(DodajGrupuForma dodajGrupuForma) {
        this.dodajGrupuForma = dodajGrupuForma;
        addActionListener();
    }

    private void addActionListener() {
        dodajGrupuForma.addDodajGrupuActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dodaj(e);
            }

            private void dodaj(ActionEvent e) {
                String naziv = dodajGrupuForma.getjTextFieldNazivGrupe().getText();
                int maxClanova = 0;
                try {
                    maxClanova = Integer.parseInt(dodajGrupuForma.getjTextFieldBrojClanova().getText());
                } catch (NumberFormatException numberFormatException) {
                    JOptionPane.showMessageDialog(dodajGrupuForma, "Грешка, група није креирана");
                    return;
                }
                Kategorija kategorija = (Kategorija) dodajGrupuForma.getjComboBoxKategorija().getSelectedItem();
                Administrator administrator = (Administrator) dodajGrupuForma.getjComboBoxAdministrator().getSelectedItem();
                Trener trener = (Trener) dodajGrupuForma.getjComboBoxTrener().getSelectedItem();
                
                if(kategorija == null || administrator == null || trener == null){
                    JOptionPane.showMessageDialog(dodajGrupuForma, "Грешка, група није креирана");
                    return;
                }
                
                
                Grupa grupa = new Grupa(1L, naziv, maxClanova, kategorija, administrator, trener);
                Odgovor odgovor = Komunikacija.getInstanca().kreirajGrupu(grupa);
                
                if(odgovor.getOdgovor() == null){
                    JOptionPane.showMessageDialog(dodajGrupuForma, "Nova grupa je uspesno kreirana", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                    dodajGrupuForma.dispose();
                    return;
                }
                JOptionPane.showMessageDialog(dodajGrupuForma, "Грешка, група није креирана", "GRESKA", JOptionPane.ERROR_MESSAGE);
                dodajGrupuForma.dispose();                
            }
        });
        
                dodajGrupuForma.addGlavniMeniActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dodajGrupuForma.dispose();
            }
        });
    }

    public void otvoriFormu() {
        pripremiFormu();
        dodajGrupuForma.setVisible(true);
    }

    private void pripremiFormu() {
        dodajGrupuForma.getjComboBoxAdministrator().setSelectedItem(null);
        dodajGrupuForma.getjComboBoxKategorija().setSelectedItem(null);
        dodajGrupuForma.getjComboBoxTrener().setSelectedItem(null);
        List<Kategorija> listaKategorija = Komunikacija.getInstanca().ucitajListuKategorija();
        List<Trener> listaTrenera = Komunikacija.getInstanca().ucitajListuTrenera();
        List<Administrator> listaAdministratora = Komunikacija.getInstanca().ucitajAdministratore();
        
        for(Kategorija k : listaKategorija){
            dodajGrupuForma.getjComboBoxKategorija().addItem(k);
        }
        
        for(Trener t : listaTrenera){
            dodajGrupuForma.getjComboBoxTrener().addItem(t);
        }
        
        for(Administrator a : listaAdministratora){
            dodajGrupuForma.getjComboBoxAdministrator().addItem(a);
        }
        
    }
     
     
}
