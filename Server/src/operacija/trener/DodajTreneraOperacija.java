/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.trener;

import domen.Trener;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author Bogdan Blagojevic
 */
public class DodajTreneraOperacija extends ApstraktnaGenerickaOperacija{

    @Override
    protected void preduslovi(Object param) throws Exception {
                if(!(param instanceof Trener))
            throw new Exception("Podaci o novom treneru nisu upamceni");

        
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        broker.add((Trener) param);
    }
    
}
