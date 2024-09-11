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
public class UcitajTreningeOperacija extends ApstraktnaGenerickaOperacija{
    private List<Trening> lista;
    @Override 
    protected void preduslovi(Object param) throws Exception {
        if(param != null &&!(param instanceof Trening))
            throw new Exception("Sistem ne moze da ucita treninge");
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        lista = broker.getAll(new Trening(), " JOIN sala sala ON trening.`sala`= sala.`salaID` JOIN mesto mesto ON sala.`mesto`= mesto.`mestoID` JOIN trener trener ON trening.`trener`= trener.`trenerID` JOIN mesto mesto2 ON trener.`mesto`= mesto2.`mestoID` JOIN grupa grupa ON trening.`grupa`= grupa.`grupaID`");
    }

    public List<Trening> getLista() {
        return lista;
    }

    public void setLista(List<Trening> lista) {
        this.lista = lista;
    }
    
    
    
}
