/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.sala;

import domen.Sala;
import java.util.List;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author Bogdan Blagojevic
 */
public class UcitajSaleOperacija extends ApstraktnaGenerickaOperacija{
    List<Sala> lista;
    @Override
    protected void preduslovi(Object param) throws Exception {
        if(param != null && !(param instanceof Sala))
            throw new Exception("Sistem ne moze da ucita sale");
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        lista = broker.getAll(new Sala(), " JOIN mesto mesto ON sala.mesto=mesto.mestoID");
    }

    public List<Sala> getLista() {
        return lista;
    }

    public void setLista(List<Sala> lista) {
        this.lista = lista;
    }
    
    
}
