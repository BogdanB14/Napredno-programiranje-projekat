/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import domen.Grupa;
import forme.PrikazGrupaForma;
import forme.model.ModelTabeleGrupa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;

/**
 *
 * @author Bogdan Blagojevic
 */
public class PrikazGrupaController {
    private final PrikazGrupaForma prikazGrupaForma;

    public PrikazGrupaController(PrikazGrupaForma prikazGrupaForma) {
        this.prikazGrupaForma = prikazGrupaForma;
        addActionListener();
    }
    
    public void otvoriFormu(){
        pripremiFormu();
        prikazGrupaForma.setVisible(true);
    }

    private void pripremiFormu() {
        List<Grupa> grupe = Komunikacija.getInstanca().ucitajListuGrupa();
        ModelTabeleGrupa mtg = new ModelTabeleGrupa(grupe);
        prikazGrupaForma.getjTableGrupa().setModel(mtg);
    }

    private void addActionListener() {
    
        prikazGrupaForma.addBtnPretraziActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String kategorija;
                String naziv;
                String trener;
                   kategorija = prikazGrupaForma.getjTextFieldIDGrupe().getText();
                   naziv = prikazGrupaForma.getjTextFieldNazivGrupe().getText();
                   trener = prikazGrupaForma.getjTextFieldTrener().getText();
                   ModelTabeleGrupa mtg = (ModelTabeleGrupa) prikazGrupaForma.getjTableGrupa().getModel();
                   mtg.nadjiGrupu(kategorija, naziv, trener);
                   ModelTabeleGrupa m = (ModelTabeleGrupa) prikazGrupaForma.getjTableGrupa().getModel();
                   List<Grupa> filtriranaLista = m.getLista();
                   
                   if(filtriranaLista.size() > 1){
                    JOptionPane.showMessageDialog(prikazGrupaForma, "Sistem je nasao grupe po zadatoj vrednosti", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
                }
                if(filtriranaLista.size() == 0){
                    JOptionPane.showMessageDialog(prikazGrupaForma, "Sistem ne moze da ucita grupu", "Greska", JOptionPane.ERROR_MESSAGE);
                }
                if(filtriranaLista.size() == 1){
                    JOptionPane.showMessageDialog(prikazGrupaForma, "Sistem je ucitao grupu", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        
        prikazGrupaForma.addBtnResetujActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 pripremiFormu();
            }
        });
        
        prikazGrupaForma.addGlavniMeniActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prikazGrupaForma.dispose();
            }
        });
    }
}
