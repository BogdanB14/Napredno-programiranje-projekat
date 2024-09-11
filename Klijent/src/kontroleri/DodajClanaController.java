/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import domen.Clan;
import domen.Mesto;
import domen.Pol;
import forme.DodajClanaForma;
import forme.ModFormeClan;
import static forme.ModFormeClan.DODAJ;
import static forme.ModFormeClan.IZMENI;
import forme.model.ModelTabeleClan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;
import komunikacija.Odgovor;
import kordinator.Kordinator;

/**
 *
 * @author Bogdan Blagojevic
 */
public class DodajClanaController {
    private final DodajClanaForma dodajClanaForma;

    public DodajClanaController(DodajClanaForma dodajClanaForma) {
        this.dodajClanaForma = dodajClanaForma;
        addActionListener();
    }

    private void addActionListener() {
        dodajClanaForma.dodajAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dodaj(e);
            }

            private void dodaj(ActionEvent e) {
                try {
                    String jmbg = dodajClanaForma.getjTextFieldJMBG().getText().trim();
                    if(jmbg == null || jmbg.isBlank() || jmbg.isEmpty() || !jmbg.matches("[0-9]{13}") || jmbg.length() != 13){
                        JOptionPane.showMessageDialog(dodajClanaForma, "Podaci o novom clanu nisu upamceni", "GRESKA", JOptionPane.ERROR_MESSAGE);
                        return;                        
                    }
                    String ime = dodajClanaForma.getjTextFieldIme().getText().trim();
                    if(ime == null || ime.isBlank() || ime.isEmpty() || !ime.matches("[a-zA-Z]+")){
                        JOptionPane.showMessageDialog(dodajClanaForma, "Podaci o novom clanu nisu upamceni", "VALIDACIJA", JOptionPane.ERROR_MESSAGE);
                        return;                        
                    }                    
                    String prezime = dodajClanaForma.getjTextFieldPrezime().getText().trim();
                    if(prezime == null || prezime.isBlank() || prezime.isEmpty() || !prezime.matches("[a-zA-Z]+")){
                        JOptionPane.showMessageDialog(dodajClanaForma, "Podaci o novom clanu nisu upamceni", "VALIDACIJA", JOptionPane.ERROR_MESSAGE);
                        return;                        
                    }                                
                    String telefon = dodajClanaForma.getjTextFieldTelefon().getText().trim();

                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String datum = dodajClanaForma.getjTextFieldDatumRodjenja().getText().trim();
                    Pol pol = (Pol) dodajClanaForma.getjComboBoxPol().getSelectedItem();
                    Mesto mesto = (Mesto) dodajClanaForma.getjComboBoxMesto().getSelectedItem();
                    if(datum == null || datum.isBlank() || datum.isEmpty() || !datum.matches("[0-9]{4}-[0-1][0-9]-[0-3][0-9]")){
                        JOptionPane.showMessageDialog(dodajClanaForma, "Podaci o novom clanu nisu upamceni", "VALIDACIJA", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    Date datumRodjenja = sdf.parse(datum);
                    Clan clan = new Clan(jmbg,ime,prezime,datumRodjenja,pol,telefon, mesto);
                        Odgovor odgovor = Komunikacija.getInstanca().kreirajClana(clan);
                        
                        if(odgovor.getOdgovor() == null){
                        JOptionPane.showMessageDialog(dodajClanaForma, "Novi clan je uspesno kreiran", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                        dodajClanaForma.dispose();
                        return;
                        }
                        JOptionPane.showMessageDialog(dodajClanaForma, "Podaci o novom clanu nisu upamceni", "GRESKA", JOptionPane.ERROR_MESSAGE);
                        dodajClanaForma.dispose();
                } catch (ParseException ex) {
                    Logger.getLogger(DodajClanaController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        dodajClanaForma.izmeniAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                izmeni(e);
            }

            private void izmeni(ActionEvent e) {
                try {
                    String jmbg = dodajClanaForma.getjTextFieldJMBG().getText().trim();

                    String ime = dodajClanaForma.getjTextFieldIme().getText().trim();
                    if(ime == null || ime.isBlank() || ime.isEmpty() || !ime.matches("[a-zA-Z]+")){
                        JOptionPane.showMessageDialog(dodajClanaForma, "Podaci o novom clanu nisu upamceni", "GRESKA", JOptionPane.ERROR_MESSAGE);
                        return;                        
                    }                    
                    String prezime = dodajClanaForma.getjTextFieldPrezime().getText().trim();
                    if(prezime == null || prezime.isBlank() || prezime.isEmpty() || !prezime.matches("[a-zA-Z]+")){
                        JOptionPane.showMessageDialog(dodajClanaForma, "Podaci o novom clanu nisu upamceni", "GRESKA", JOptionPane.ERROR_MESSAGE);
                        return;                        
                    }                                
                    String telefon = dodajClanaForma.getjTextFieldTelefon().getText().trim();
  
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String datum = dodajClanaForma.getjTextFieldDatumRodjenja().getText().trim();
                    Pol pol = (Pol) dodajClanaForma.getjComboBoxPol().getSelectedItem();
                    Mesto mesto = (Mesto) dodajClanaForma.getjComboBoxMesto().getSelectedItem();
                    if(datum == null || datum.isBlank() || datum.isEmpty() || !datum.matches("[0-9]{4}-[0-1][0-9]-[0-3][0-9]")){
                        JOptionPane.showMessageDialog(dodajClanaForma, "Podaci o novom clanu nisu upamceni", "GRESKA", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    Date datumRodjenja = sdf.parse(datum);
                    if(pol == null || mesto == null){
                        JOptionPane.showMessageDialog(dodajClanaForma, "Podaci o novom clanu nisu upamceni");
                        return;
                    }
                    Clan clan = new Clan(jmbg,ime,prezime,datumRodjenja,pol,telefon, mesto);
                    System.out.println("CLAN KADA SI POZVAO AZURIRAJ CLANA: " + clan);
                    Odgovor odgovor = Komunikacija.getInstanca().izmeniClana(clan);
                    boolean update = (boolean) odgovor.getOdgovor();
                        if(update){
                        JOptionPane.showMessageDialog(dodajClanaForma, "Sistem je izmenio clana", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                        dodajClanaForma.dispose();
                        return;
                        }else{
                        JOptionPane.showMessageDialog(dodajClanaForma, "Sistem ne moze da izmeni clana", "GRESKA", JOptionPane.ERROR_MESSAGE);
                        dodajClanaForma.dispose();
                        }
                } catch (ParseException ex) {
                    Logger.getLogger(DodajClanaController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        dodajClanaForma.addGlavniMeniActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dodajClanaForma.dispose();
            }
        });
    }

    public void otvoriFormu(ModFormeClan mod){
        pripremiFormu(mod);
        dodajClanaForma.setVisible(true);
    }
    
      public void pripremiFormu(ModFormeClan mod) {
          dodajClanaForma.getjComboBoxMesto().setSelectedItem(null);
          dodajClanaForma.getjComboBoxPol().setSelectedItem(null);
          List<Mesto> lista = Komunikacija.getInstanca().ucitajListuMesta();
          if(lista == null){
              JOptionPane.showMessageDialog(dodajClanaForma, "Sistem ne moze da nadje mesta po zadatoj vrednosti", "GRESKA", JOptionPane.ERROR_MESSAGE);
              return;
                }
          for(Mesto m : lista){
              dodajClanaForma.getjComboBoxMesto().addItem(m);
          }
          switch(mod){
            case DODAJ:
                dodajClanaForma.getjComboBoxPol().setSelectedItem(null);
                dodajClanaForma.getjComboBoxMesto().setSelectedItem(null);
                dodajClanaForma.getjButtonAzuriraj().setVisible(false);
                dodajClanaForma.getjButtonDodaj().setVisible(true);
                dodajClanaForma.getjButtonDodaj().setEnabled(true);
                break;
                
            case IZMENI:
                
                dodajClanaForma.getjButtonAzuriraj().setVisible(true);
                dodajClanaForma.getjButtonDodaj().setVisible(false);
                dodajClanaForma.getjButtonAzuriraj().setEnabled(true);
                Clan clan = (Clan) Kordinator.getInstanca().vratiParam("clan");
                dodajClanaForma.getjComboBoxPol().setSelectedItem(clan.getPol());
                dodajClanaForma.getjComboBoxMesto().setSelectedItem(clan.getMesto());
                dodajClanaForma.getjTextFieldIme().setText(clan.getImeClana());
                dodajClanaForma.getjTextFieldPrezime().setText(clan.getPrezimeClana());
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String datum = sdf.format(clan.getDatumRodjenja());
                dodajClanaForma.getjTextFieldDatumRodjenja().setText(datum);
                dodajClanaForma.getjTextFieldJMBG().setText(clan.getJmbg());
                dodajClanaForma.getjTextFieldJMBG().setEnabled(false);
                dodajClanaForma.getjTextFieldTelefon().setText(clan.getTelefon());
                break;
        }

    }
    
}
