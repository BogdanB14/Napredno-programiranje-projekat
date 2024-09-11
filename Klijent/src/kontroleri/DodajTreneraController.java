/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import domen.Mesto;
import domen.Trener;
import forme.DodajTreneraForma;
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
public class DodajTreneraController {
    private final DodajTreneraForma dodajTreneraForma;

    public DodajTreneraController(DodajTreneraForma dodajTreneraForma) {
        this.dodajTreneraForma = dodajTreneraForma;
        addActionListener();
    }

    private void addActionListener() {
        dodajTreneraForma.dodajTreneraAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dodaj(e);
            }

            private void dodaj(ActionEvent e) {
                String ime = dodajTreneraForma.getjTextFieldImeTrenera().getText().trim();
                String prezime = dodajTreneraForma.getjTextFieldPrezimeTrenera().getText().trim();
                if(ime == null || prezime == null || ime.isEmpty() || prezime.isEmpty() || !ime.matches("[A-Z-a-z]+") || !prezime.matches("[A-Z-a-z]+")){
                    JOptionPane.showMessageDialog(dodajTreneraForma, "Podaci o novom treneru nisu upamceni", "GRESKA", JOptionPane.ERROR_MESSAGE);
                    return;
            }
                Mesto mesto = (Mesto) dodajTreneraForma.getjComboBoxMesto().getSelectedItem();
                if(mesto == null){
                    JOptionPane.showMessageDialog(dodajTreneraForma, "Podaci o novom treneru nisu upamceni", "GRESKA", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Trener trener = new Trener(0L, ime, prezime, mesto);
                Odgovor odgovor = Komunikacija.getInstanca().kreirajTrenera(trener);
                
                if(odgovor.getOdgovor() == null){
                    JOptionPane.showMessageDialog(dodajTreneraForma, "Novi trener je uspesno kreiran", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                    dodajTreneraForma.dispose();
                    return;
                }
                JOptionPane.showMessageDialog(dodajTreneraForma, "Podaci o novom treneru nisu upamceni", "GRESKA", JOptionPane.INFORMATION_MESSAGE);
                dodajTreneraForma.dispose();
            }
        });
        
        dodajTreneraForma.addGlavniMeniActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dodajTreneraForma.dispose();
            }
        });
        
    }

    public void otvoriFormu() {
        System.out.println("USAO U OTVORI FORMU");
        pripremiFormu();
        dodajTreneraForma.setVisible(true);
    }

    private void pripremiFormu() {
        dodajTreneraForma.getjComboBoxMesto().setSelectedItem(null);
        System.out.println("USAO U PRIPREMI FORMU");
       List<Mesto> lista = Komunikacija.getInstanca().ucitajListuMesta();
       for(Mesto m : lista){
           dodajTreneraForma.getjComboBoxMesto().addItem(m);
       }
    }
}
