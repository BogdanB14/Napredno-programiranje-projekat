/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import domen.Administrator;
import forme.LoginForma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;
import kordinator.Kordinator;

/**
 *
 * @author Bogdan Blagojevic
 */
public class LoginController {
    private final LoginForma lf;

    public LoginController(LoginForma lf) {
        this.lf = lf;
        addActionListener();
    }

    private void addActionListener() {
        lf.loginAddActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                login(e);
            }

            private void login(ActionEvent e) {
                String korisnickoIme = lf.getjTextFieldKorisnickoIme().getText().trim();
                String lozinka = String.valueOf(lf.getjPasswordFieldLozinka().getPassword());
                
                Komunikacija.getInstanca().konekcija();
                Administrator a = Komunikacija.getInstanca().prijava(korisnickoIme, lozinka);
                
                if(a == null){
                    JOptionPane.showMessageDialog(lf, "Neuspesna prijava, molimo Vas pokusajte ponovo", "Greska prilikom prijave", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                JOptionPane.showMessageDialog(lf, "Uspesno ste se prijavli na sistem", "Uspesna prijava", JOptionPane.INFORMATION_MESSAGE);
                Kordinator.getInstanca().setUlogovani(a);
                Kordinator.getInstanca().otvoriGlavnuFormu();
                lf.dispose();
            }
            
        });
    }

    public void otvoriFormu() {
        lf.setVisible(true);
    }
    
    
}
