/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import domen.Clan;
import forme.PrikazClanaForma;
import forme.model.ModelTabeleClan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import komunikacija.Komunikacija;
import komunikacija.Odgovor;
import kordinator.Kordinator;

/**
 *
 * @author Bogdan Blagojevic
 */
public class PrikazClanaController {
    private final PrikazClanaForma prikazClanaForma;

    public PrikazClanaController(PrikazClanaForma prikazClanaForma) {
        this.prikazClanaForma = prikazClanaForma;
        addActionListener();
    }

    public void otvoriFormu() {
        pripremiFormu();
        prikazClanaForma.setVisible(true);
        
    }

    public void pripremiFormu() {
        List<Clan> lista = Komunikacija.getInstanca().ucitajListuClanova();
        if(lista == null){
            JOptionPane.showMessageDialog(prikazClanaForma, "Sistem ne moze da nadje clanove po zadatoj vrednosti", "GRESKA", JOptionPane.ERROR_MESSAGE);
            return;
        }
        ModelTabeleClan mtc = new ModelTabeleClan(lista);
        prikazClanaForma.getjTableClanovi().setModel(mtc);
    }

    private void addActionListener() {
        prikazClanaForma.addBtnObrisiActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selektovaniRed = prikazClanaForma.getjTableClanovi().getSelectedRow();
                if(selektovaniRed == -1){
                    JOptionPane.showMessageDialog(prikazClanaForma, "Sistem ne moze da ucita clana", "GRESKA", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                ModelTabeleClan mtc = (ModelTabeleClan) prikazClanaForma.getjTableClanovi().getModel();
                Clan clan = mtc.getLista().get(selektovaniRed);
                int brElemenata = mtc.getLista().size();
                try{
                Odgovor odgovor = Komunikacija.getInstanca().obrisiClana(clan);
                System.out.println("ODGOVOR KOJI SI PRIMIO OD KOMUNIKACIJE U PRIKAZ CLANA KONTROLER: " + odgovor);
                boolean uspeh = (boolean) odgovor.getOdgovor();
                if(uspeh){
                    JOptionPane.showMessageDialog(prikazClanaForma, "Sistem je obrisao clana", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                    pripremiFormu();
                    return;
                } else{
                    JOptionPane.showMessageDialog(prikazClanaForma, "Sistem ne moze da obrise clana", "GRESKA", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                }catch(Exception exc){
                    JOptionPane.showMessageDialog(prikazClanaForma, "Sistem ne moze da obrise clana", "GRESKA", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
        });
       
        prikazClanaForma.addBbtnIzmeniActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selektovaniRed = prikazClanaForma.getjTableClanovi().getSelectedRow();
                if(selektovaniRed == -1){
                    JOptionPane.showMessageDialog(prikazClanaForma, "Sistem ne moze da ucita clana", "GRESKA", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try{
                    ModelTabeleClan mtc = (ModelTabeleClan) prikazClanaForma.getjTableClanovi().getModel();
                    Clan clan = mtc.getLista().get(selektovaniRed);                    
                    Kordinator.getInstanca().dodajParam("clan", clan);
                    Kordinator.getInstanca().otvoriIzmeniClanaFormu();
                } catch(Exception exc){
                    JOptionPane.showMessageDialog(prikazClanaForma, "Sistem ne moze da izmeni clana", "GRESKA", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
         prikazClanaForma.addBbtnPretraziActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             String ime = prikazClanaForma.getjTextFieldImePretraga().getText().trim();
             String prezime = prikazClanaForma.getjTextFieldPrezimePretraga().getText().trim();
             
             ModelTabeleClan mtc = (ModelTabeleClan) prikazClanaForma.getjTableClanovi().getModel();
             mtc.nadjiClana(ime, prezime);
             ModelTabeleClan m = (ModelTabeleClan) prikazClanaForma.getjTableClanovi().getModel();
             
                List<Clan> filtriranaLista = m.getLista();
                if(filtriranaLista.size() > 1){
                    JOptionPane.showMessageDialog(prikazClanaForma, "Sistem je nasao clanove po zadatoj vrednosti", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
                }
                if(filtriranaLista.size() == 0){
                    JOptionPane.showMessageDialog(prikazClanaForma, "Sistem ne moze da nadje clanove po zadatoj vrednosti", "Greska", JOptionPane.ERROR_MESSAGE);
                }
                if(filtriranaLista.size() == 1){
                    JOptionPane.showMessageDialog(prikazClanaForma, "Sistem je ucitao clana", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
         
          prikazClanaForma.addBbtnResetujActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             
            pripremiFormu();
             
            }
        });
          
          prikazClanaForma.addGlavniMeniActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prikazClanaForma.dispose();
            }
        });
    }
    
    
}
