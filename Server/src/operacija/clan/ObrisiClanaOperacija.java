/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.clan;

import domen.Clan;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author Bogdan Blagojevic
 */
public class ObrisiClanaOperacija extends ApstraktnaGenerickaOperacija{
    public static boolean delete = false;
    @Override
    protected void preduslovi(Object param) throws Exception {
        if(!(param instanceof Clan))
            throw new Exception("Sistem ne moze da obrise clana");
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        delete = broker.delete((Clan) param);
    }
    
}
