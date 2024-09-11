/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.mesto;

import domen.Mesto;
import java.util.List;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author Bogdan Blagojevic
 */
public class UcitajMestaOperacija extends ApstraktnaGenerickaOperacija{
    private List<Mesto> lista;
    
    @Override
    protected void preduslovi(Object param) throws Exception {
        if(param != null && !(param instanceof Mesto))
            throw new Exception("Sistem ne moze da ucita mesta");
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        lista = broker.getAll(new Mesto(), "");
    }

    public List<Mesto> getLista() {
        return lista;
    }

    public void setLista(List<Mesto> lista) {
        this.lista = lista;
    }
    
    
}
