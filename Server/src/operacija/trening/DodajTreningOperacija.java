/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.trening;

import domen.Trening;
import java.util.List;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author Bogdan Blagojevic
 */
public class DodajTreningOperacija extends ApstraktnaGenerickaOperacija{   
    List<Trening> lista;
    @Override
    protected void preduslovi(Object param) throws Exception {
        if(param == null || !(param instanceof Trening))
            throw new Exception("Sistem ne moze da doda trening");
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        broker.add((Trening) param);
    }

    public List<Trening> getLista() {
        return lista;
    }

    public void setLista(List<Trening> lista) {
        this.lista = lista;
    }
    
    
}
