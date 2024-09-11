/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.grupa;

import domen.Grupa;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author Bogdan Blagojevic
 */
public class DodajGrupuOperacija extends ApstraktnaGenerickaOperacija{

    @Override
    protected void preduslovi(Object param) throws Exception {
        if(!(param instanceof Grupa))
            throw new Exception("Podaci o novoj grupi nisu upamceni");
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        broker.add((Grupa) param);
    }
    
}
