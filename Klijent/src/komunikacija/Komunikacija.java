/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komunikacija;

import domen.Administrator;
import domen.Clan;
import domen.Grupa;
import domen.Kategorija;
import domen.Mesto;
import domen.Sala;
import domen.Trener;
import domen.Trening;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import kordinator.Kordinator;

/**
 *
 * @author Bogdan Blagojevic
 */
public class Komunikacija {
    private Socket socket;
    private Posiljalac posiljalac;
    private Primalac primalac;
    private static Komunikacija instanca;
    
    public static Komunikacija getInstanca(){
        if(instanca == null)
            instanca = new Komunikacija();
        return instanca;
    }
    
    private Komunikacija(){
        
    }
    
    public void konekcija(){
        try {
            socket = new Socket("localhost",9000);
            posiljalac = new Posiljalac(socket);
            primalac = new Primalac(socket);
        } catch (IOException ex) {
            ex.printStackTrace();
            Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Administrator prijava(String korisnickoIme, String lozinka) {
        Administrator a = new Administrator();
        a.setKorisnickoIme(korisnickoIme);
        a.setSifra(lozinka);
        Zahtev zahtev = new Zahtev(Operacija.LOGIN, a);
        
        posiljalac.posalji(zahtev);
        Odgovor odg = (Odgovor) primalac.primi();
        Administrator administrator = (Administrator) odg.getOdgovor();
        return administrator;
    }

    public List<Clan> ucitajListuClanova() {
        Zahtev zahtev = new Zahtev(Operacija.UCITAJ_CLANOVE, null);
        List<Clan> lista;
        posiljalac.posalji(zahtev);
        
        Odgovor odgovor = (Odgovor) primalac.primi(); 
        
        lista = (List<Clan>) odgovor.getOdgovor();
        return lista;
    }
    
    public List<Mesto> ucitajListuMesta() {
        Zahtev zahtev = new Zahtev(Operacija.UCITAJ_MESTA, null);
        List<Mesto> lista;
        posiljalac.posalji(zahtev);
        
        Odgovor odgovor = (Odgovor) primalac.primi();
        
        lista = (List<Mesto>) odgovor.getOdgovor();
        return lista;
        
    }

    public Odgovor obrisiClana(Clan clan) {
        Zahtev zahtev = new Zahtev(Operacija.OBRISI_CLANA, clan);
        posiljalac.posalji(zahtev);
        Odgovor odgovor = (Odgovor) primalac.primi();
        System.out.println("ODGOVOR U OBRISI CLANA KOMUNIKACIJA:" + odgovor.getOdgovor());
        return odgovor;
        
    }

    public Odgovor kreirajClana(Clan clan) {
        Zahtev zahtev = new Zahtev(Operacija.DODAJ_CLANA, clan);
        System.out.println("ZAHTEEV U DODAJ CLANA U KOMUNIKACIJI: " + zahtev.getParametar());
        posiljalac.posalji(zahtev);
        
        Odgovor odgovor = (Odgovor) primalac.primi();
        System.out.println("ODGOVOR U DODAJ CLANA U KOMUNIKACIJI: " + odgovor.getOdgovor());
        return odgovor;
    }
    
    public Odgovor kreirajTrenera(Trener trener){
        Zahtev zahtev = new Zahtev(Operacija.DODAJ_TRENERA, trener);
        System.out.println("ZAHTEV U DODAJ TRENERA U KOMUNIKACIJI: " + zahtev.getParametar());
        posiljalac.posalji(zahtev);
        
        Odgovor odgovor = (Odgovor) primalac.primi();
        System.out.println("ODGOVOR U DODAJ TRENERA U KOMUNIKACIJI: " + odgovor.getOdgovor());
        return odgovor;
    }
    
    public Odgovor kreirajGrupu(Grupa grupa) {
        Zahtev zahtev = new Zahtev(Operacija.DODAJ_GRUPU, grupa);
        System.out.println("ZAHTEV U DODAJ GRUPU U KOMUNIKACIJI: " + zahtev.getParametar());
        posiljalac.posalji(zahtev);
        
        Odgovor odgovor = (Odgovor) primalac.primi();
        System.out.println("ODGOVOR U DODAJ GRUPU U KOMUNIKACIJI: " + odgovor.getOdgovor());
        return odgovor;
    }
    
    public Odgovor kreirajTrening(Trening trening) {
        Zahtev zahtev = new Zahtev(Operacija.DODAJ_TRENING, trening);
        System.out.println("ZAHTEV U DODAJ TRENING U KOMUNIKACIJI: " + zahtev.getParametar());
        posiljalac.posalji(zahtev);
        
        Odgovor odgovor = (Odgovor) primalac.primi();
        System.out.println("ODGOVOR U DODAJ TRENING U KOMUNIKACIJI: " + odgovor.getOdgovor());
        return odgovor;
    }

    public Odgovor izmeniClana(Clan clan) {
        Zahtev zahtev = new Zahtev(Operacija.AZURIRAJ_CLANA, clan);
        System.out.println("ZAHTEEV U AZURIRAJ CLANA U KOMUNIKACIJI: " + zahtev.getParametar());
        posiljalac.posalji(zahtev);
        
        Odgovor odgovor = (Odgovor) primalac.primi();
        Kordinator.getInstanca().osveziGlavnuFormu();
        return odgovor;
    }

    public List<Trening> ucitajListuTreninga() {
        Zahtev zahtev = new Zahtev(Operacija.UCITAJ_TRENINGE, null);
        List<Trening> treninzi = new ArrayList<>();
        
        posiljalac.posalji(zahtev);
        
        Odgovor odgovor = (Odgovor) primalac.primi();
        treninzi = (List<Trening>) odgovor.getOdgovor();
        
        return treninzi;
     }

    public List<Grupa> ucitajListuGrupa() {
        Zahtev zahtev = new Zahtev(Operacija.UCITAJ_GRUPE, null);
        List<Grupa> grupe = new ArrayList<>();
        
        posiljalac.posalji(zahtev);
        
        Odgovor odgovor = (Odgovor) primalac.primi();
        grupe = (List<Grupa>) odgovor.getOdgovor();
        
        return grupe;
    }
    public List<Sala> ucitajListuSala() {
        Zahtev zahtev = new Zahtev(Operacija.UCITAJ_SALE,  null);
        List<Sala> sale = new ArrayList<>();
        
        posiljalac.posalji(zahtev);
        
        Odgovor odgovor = (Odgovor) primalac.primi();
        sale = (List<Sala>) odgovor.getOdgovor();
        
        return sale;
    }
    

    public List<Kategorija> ucitajListuKategorija() {
        Zahtev zahtev = new Zahtev(Operacija.UCITAJ_KATEGORIJE, null);
        List<Kategorija> kategorije = new ArrayList<>();
        
        posiljalac.posalji(zahtev);
        
        Odgovor odgovor = (Odgovor) primalac.primi();
        kategorije = (List<Kategorija>) odgovor.getOdgovor();
        
        return kategorije;
    }

    public List<Trener> ucitajListuTrenera() {
        Zahtev zahtev = new Zahtev(Operacija.UCITAJ_TRENERE, null);
        List<Trener> treneri = new ArrayList<>();
        
        posiljalac.posalji(zahtev);
        
        Odgovor odgovor = (Odgovor) primalac.primi();
        treneri = (List<Trener>) odgovor.getOdgovor();
        
        return treneri;
    }

    public List<Administrator> ucitajAdministratore() {
        Zahtev zahtev = new Zahtev(Operacija.UCITAJ_ADMINISTRATORE, null);
        List<Administrator> administratori = new ArrayList<>();
        
        posiljalac.posalji(zahtev);
        
        Odgovor odgovor = (Odgovor) primalac.primi();
        administratori = (List<Administrator>) odgovor.getOdgovor();
        
        return administratori;
    }







}
