/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.trener;

import domen.Trener;
import java.util.List;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author Bogdan Blagojevic
 */
public class UcitajTrenereOperacija extends ApstraktnaGenerickaOperacija{
    List<Trener> lista;
    @Override
    protected void preduslovi(Object param) throws Exception {
        if(param != null && !(param instanceof Trener))
            throw new Exception("Sistem ne moze da ucita trener");
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
       lista = broker.getAll(new Trener(), " JOIN mesto mesto ON trener.mesto=mesto.mestoID");
    }

    public List<Trener> getLista() {
        return lista;
    }

    public void setLista(List<Trener> lista) {
        this.lista = lista;
    }
    
    
}
