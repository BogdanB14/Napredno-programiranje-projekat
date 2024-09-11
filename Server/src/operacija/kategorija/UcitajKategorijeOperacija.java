/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.kategorija;

import domen.Kategorija;
import java.util.List;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author Bogdan Blagojevic
 */
public class UcitajKategorijeOperacija extends ApstraktnaGenerickaOperacija{
    List<Kategorija> lista;
    @Override
    protected void preduslovi(Object param) throws Exception {
        if(param != null && !(param instanceof Kategorija))
            throw new Exception("Sistem ne moze da ucita kategorije");
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        lista = broker.getAll(new Kategorija(), "");
    }

    public void setLista(List<Kategorija> lista) {
        this.lista = lista;
    }

    public List<Kategorija> getLista() {
        return lista;
    }
    
    
    
}
