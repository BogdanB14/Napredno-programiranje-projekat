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
public class AzurirajClanaOperacija extends ApstraktnaGenerickaOperacija{
    public static boolean update = false;
    @Override
    protected void preduslovi(Object param) throws Exception {
        if(param == null || !(param instanceof Clan))
            throw new Exception("Sistem ne moze da ucita clana");
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        System.out.println("Usao u izvrsi oeraciju u AzurirajClanaOperacija");
        System.out.println("BOOLEAN UPDATE PRE broker.edit = " + update);
        update = broker.edit((Clan) param);
        System.out.println("BOOLEAN UPDATE POSLE broker.edit = " + update);
    }
    
}
