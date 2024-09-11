/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.administrator;

import domen.Administrator;
import java.util.List;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author Bogdan Blagojevic
 */
public class UcitajAdministratoreOperacija extends ApstraktnaGenerickaOperacija{
    List<Administrator> lista;
    @Override
    protected void preduslovi(Object param) throws Exception {
        if(param != null && !(param instanceof Administrator))
            throw new Exception("");
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        lista = broker.getAll(new Administrator(), "");
    }

    public List<Administrator> getLista() {
        return lista;
    }

    public void setLista(List<Administrator> lista) {
        this.lista = lista;
    }
    
    
}
