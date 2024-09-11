/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import domen.Trening;
import forme.PrikazTreningForma;
import forme.model.ModelTabeleGrupa;
import forme.model.ModelTabeleTrening;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;

/**
 *
 * @author Bogdan Blagojevic
 */
public class PrikazTreningaController {
    private final PrikazTreningForma prikazTreningForma;

    public PrikazTreningaController(PrikazTreningForma prikazTreningForma) {
        this.prikazTreningForma = prikazTreningForma;
        addActionListener();
    }
    
    public void otvoriFormu(){
        pripremiFormu();
        prikazTreningForma.setVisible(true);
    }

    private void pripremiFormu() {
        List<Trening> treninzi = Komunikacija.getInstanca().ucitajListuTreninga();
        ModelTabeleTrening mtt = new ModelTabeleTrening(treninzi);
        prikazTreningForma.getjTableTrening().setModel(mtt);
    }

    private void addActionListener() {
    
        prikazTreningForma.addBtnPretraziActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tipTreninga = prikazTreningForma.getjTextFieldTipTreninga().getText();
                String datum = prikazTreningForma.getjTextFieldDatumTreninga().getText();
                ModelTabeleTrening mtt = (ModelTabeleTrening) prikazTreningForma.getjTableTrening().getModel();
                mtt.nadjiTrening(tipTreninga, datum);
                
                ModelTabeleTrening m = (ModelTabeleTrening) prikazTreningForma.getjTableTrening().getModel();
             
                List<Trening> filtriranaLista = m.getLista();
                if(filtriranaLista.size() > 1){
                    JOptionPane.showMessageDialog(prikazTreningForma, "Sistem je nasao treninge po zadatoj vrednosti", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
                }
                if(filtriranaLista.isEmpty()){
                    JOptionPane.showMessageDialog(prikazTreningForma, "Sistem ne moze da ucita trening", "Greska", JOptionPane.ERROR_MESSAGE);
                }
                if(filtriranaLista.size() == 1){
                    JOptionPane.showMessageDialog(prikazTreningForma, "Sistem je ucitao trening", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        
        prikazTreningForma.addBtnResetujActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 pripremiFormu();
            }
        });
        
        prikazTreningForma.addGlavniMeniActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prikazTreningForma.dispose();
            }
        });
    }
}
