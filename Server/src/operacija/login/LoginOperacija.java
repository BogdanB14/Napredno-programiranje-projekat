/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.login;

import domen.Administrator;

import java.util.List;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author Bogdan Blagojevic
 */
public class LoginOperacija extends ApstraktnaGenerickaOperacija {
    private Administrator administrator;
    @Override
    protected void preduslovi(Object param) throws Exception {
            if(param == null || !(param instanceof Administrator))
                throw new Exception("Sistem ne moze da pronadje administratora na osnovu unetih podataka");
            
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        List<Administrator> listaAdministratora = broker.getAll((Administrator) param, null);
        System.out.println("LOGIN OPERACIJA ADMINISTRATORA, SVI ADMINISTRATORI: " + listaAdministratora);
        
        for(Administrator a : listaAdministratora){
            if(a.equals((Administrator) param)){
                administrator = a;
                return;
            }
        }
        administrator = null;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    
}
