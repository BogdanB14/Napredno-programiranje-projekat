/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.grupa;

import domen.Grupa;
import java.util.List;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author Bogdan Blagojevic
 */
public class UcitajGrupeOperacija extends ApstraktnaGenerickaOperacija{
    private List<Grupa> lista;
    @Override
    protected void preduslovi(Object param) throws Exception {
        if(param != null && !(param instanceof Grupa))
            throw new Exception("Sistem ne moze da ucita grupe");
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        lista = broker.getAll(new Grupa(), " JOIN kategorija kategorija ON grupa.`kategorija`=kategorija.`kategorijaID` JOIN administrator administrator ON grupa.`administrator`=administrator.`administratorID` JOIN trener trener ON grupa.`trener`=trener.`trenerID` JOIN mesto mesto ON trener.`mesto`=mesto.`mestoID` ORDER BY grupa.grupaID");
    }

    public List<Grupa> getLista() {
        return lista;
    }

    public void setLista(List<Grupa> lista) {
        this.lista = lista;
    }
    
    
    
}
