/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import domen.Administrator;
import forme.GlavnaForma;
import kordinator.Kordinator;

/**
 *
 * @author Bogdan Blagojevic
 */
public class GlavnaFormaController {
    private final GlavnaForma glavnaForma;

    public GlavnaFormaController(GlavnaForma glavnaForma) {
        this.glavnaForma = glavnaForma;
        addActionListeners();
    }

    private void addActionListeners() {
        
    }

    public void otvoriFormu() {
        Administrator a = Kordinator.getInstanca().getUlogovani();
        glavnaForma.setVisible(true);

        glavnaForma.getjLabelKorisnickoIme().setText(a.getImeAdmin() + " " + a.getPrezimeAdmin());
    }

    
}
