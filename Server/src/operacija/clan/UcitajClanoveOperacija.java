/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.clan;

import domen.Clan;
import java.util.List;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author Bogdan Blagojevic
 */
public class UcitajClanoveOperacija extends ApstraktnaGenerickaOperacija {

    List<Clan> lista;
    
    @Override
    protected void preduslovi(Object param) throws Exception {
        if(param != null && !(param instanceof Clan))
            throw new Exception("Sistem ne moze da ucita clanove");
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        lista = broker.getAll(new Clan(), " JOIN mesto mesto ON clan.mesto=mesto.mestoID");
    }

    public List<Clan> getLista() {
        return lista;
    }

    public void setLista(List<Clan> lista) {
        this.lista = lista;
    }

    
    
    
    
}
