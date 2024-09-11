/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domen.Administrator;
import domen.Clan;
import domen.Grupa;
import domen.Kategorija;
import domen.Mesto;
import domen.Sala;
import domen.Trener;
import domen.Trening;
import java.util.List;
import operacija.administrator.UcitajAdministratoreOperacija;
import operacija.clan.AzurirajClanaOperacija;
import operacija.clan.DodajClanaOperacija;
import operacija.clan.ObrisiClanaOperacija;
import operacija.clan.UcitajClanoveOperacija;
import operacija.grupa.DodajGrupuOperacija;
import operacija.grupa.UcitajGrupeOperacija;
import operacija.kategorija.UcitajKategorijeOperacija;
import operacija.login.LoginOperacija;
import operacija.mesto.UcitajMestaOperacija;
import operacija.sala.UcitajSaleOperacija;
import operacija.trener.DodajTreneraOperacija;
import operacija.trener.UcitajTrenereOperacija;
import operacija.trening.DodajTreningOperacija;
import operacija.trening.UcitajTreningeOperacija;

/**
 *
 * @author Bogdan Blagojevic
 */
public class Controller {
    private static Controller instance;
    
    public static Controller getInstance(){
        if(instance == null)
            instance = new Controller();
        return instance;
    }
    
    private Controller(){
        
    }

    public Administrator login(Administrator a) throws Exception{
        LoginOperacija lo = new LoginOperacija();
        lo.izvrsi(a, null);
        System.out.println("Administrator u login metodi u kontroleru: " + lo.getAdministrator());
        return lo.getAdministrator();
    }

    public List<Clan> ucitajClanove() throws Exception {
        UcitajClanoveOperacija operacija = new UcitajClanoveOperacija();
        operacija.izvrsi(null, null);
        System.out.println("KLASA CONTROLLER CLANOVI:" + operacija.getLista());
        return operacija.getLista(); 
    }

    public boolean obrisiClana(Clan clan) throws Exception {
        ObrisiClanaOperacija opo = new ObrisiClanaOperacija();
        opo.izvrsi(clan, null);
        return opo.delete;
    }

    public void dodajClana(Clan clan) throws Exception {
        DodajClanaOperacija dco = new DodajClanaOperacija();
        dco.izvrsi(clan, null);
    }

    public void dodajTrenera(Trener trener) throws Exception {
        DodajTreneraOperacija dto = new DodajTreneraOperacija();
        dto.izvrsi(trener, null);
    }
    
    public void dodajTrening(Trening trening) throws Exception {
        DodajTreningOperacija dto = new DodajTreningOperacija();
        dto.izvrsi(trening, null);
    }


    public void dodajGrupu(Grupa grupa) throws Exception {
        DodajGrupuOperacija dgo = new DodajGrupuOperacija();
        dgo.izvrsi(grupa, null);
    
    }
    
    public List<Mesto> ucitajMesta() throws Exception {
        UcitajMestaOperacija umo = new UcitajMestaOperacija();
        umo.izvrsi(null, null);
        System.out.println("KLASA CONTROLLER CLANOVI:" + umo.getLista());
        return umo.getLista();
    }

    public boolean azurirajClana(Clan clan) throws Exception {
        System.out.println("Usao u azuriraj clana u kontroleru");
        AzurirajClanaOperacija aco = new AzurirajClanaOperacija();
        aco.izvrsi(clan, null);
        return aco.update;
    }

    public List<Trening> ucitajTreninge() throws Exception {
        UcitajTreningeOperacija uto = new UcitajTreningeOperacija();
        uto.izvrsi(null, null);
        System.out.println("KLASA CONTROLLER TRENINZI: " + uto.getLista());
        return uto.getLista();
    }

    public List<Grupa> ucitajGrupe() throws Exception {
        UcitajGrupeOperacija ugo = new UcitajGrupeOperacija();
        ugo.izvrsi(null, null);
        System.out.println("KLASA CONTROLLER GRUPE: " + ugo.getLista());
        return ugo.getLista();
    }

    public List<Administrator> ucitajAdministratore() throws Exception {
        UcitajAdministratoreOperacija uao = new UcitajAdministratoreOperacija();
        uao.izvrsi(null, null);
        System.out.println("KLASA CONTROLLER ADMINISTRATORI: " + uao.getLista());
        return uao.getLista();
    }

    public List<Kategorija> ucitajKategorije() throws Exception {
        UcitajKategorijeOperacija uko = new UcitajKategorijeOperacija();
        uko.izvrsi(null, null);
        System.out.println("KLASA CONTROLLER KATEGORIJE: " + uko.getLista());
        return uko.getLista();
    }

    public List<Trener> ucitajTrenere() throws Exception {
        UcitajTrenereOperacija uto = new UcitajTrenereOperacija();
        uto.izvrsi(null, null);
        System.out.println("KLASA CONTROLLER TRENERI: " + uto.getLista());
        return uto.getLista();
    }

    public List<Sala> ucitajSale() throws Exception {
        UcitajSaleOperacija uso = new UcitajSaleOperacija();
        uso.izvrsi(null, null);
        System.out.println("KLASA CONTROLLER SALE: " + uso.getLista());
        return uso.getLista();
    }




}
