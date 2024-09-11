/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kordinator;

import domen.Administrator;
import forme.DodajClanaForma;
import forme.DodajGrupuForma;
import forme.DodajTreneraForma;
import forme.DodajTreningForma;
import forme.GlavnaForma;
import forme.LoginForma;
import forme.ModFormeClan;
import forme.PrikazClanaForma;
import forme.PrikazGrupaForma;
import forme.PrikazTreningForma;
import java.util.HashMap;
import java.util.Map;
import kontroleri.DodajClanaController;
import kontroleri.DodajGrupuController;
import kontroleri.DodajTreneraController;
import kontroleri.DodajTreningController;
import kontroleri.GlavnaFormaController;
import kontroleri.LoginController;
import kontroleri.PrikazClanaController;
import kontroleri.PrikazGrupaController;
import kontroleri.PrikazTreningaController;

/**
 *
 * @author Bogdan Blagojevic
 */
public class Kordinator {
    private static Kordinator instanca;
    private Administrator ulogovani;
    private LoginController loginController;
    private GlavnaFormaController glavnaFormaController;
    private PrikazClanaController prikazClanaController;
    private DodajClanaController dodajClanaController;
    private PrikazGrupaController prikazGrupaController;
    private PrikazTreningaController prikazTreningaController;
    private DodajTreneraController dodajTreneraController;
    private DodajGrupuController dodajGrupuController;
    private DodajTreningController dodajTreningController;
    private Map<String, Object> parametri;
    
    
    public static Kordinator getInstanca(){
        if(instanca == null)
            instanca = new Kordinator();
        return instanca;
    }
    
    private Kordinator(){
        parametri = new HashMap<>();
    }

    public void otvoriLoginFormu() {
        loginController = new LoginController(new LoginForma());
        loginController.otvoriFormu();
        
    }

    public void otvoriGlavnuFormu() {
        glavnaFormaController = new GlavnaFormaController(new GlavnaForma());
        glavnaFormaController.otvoriFormu();
        
    }


    public void otvoriPrikazClanaFormu() {
        prikazClanaController = new PrikazClanaController(new PrikazClanaForma());
        prikazClanaController.otvoriFormu();
    }
    
    public Administrator getUlogovani() {
        return ulogovani;
    }

    public void setUlogovani(Administrator ulogovani) {
        this.ulogovani = ulogovani;
    }

    public void otvoriDodajClanaFormu() {
        dodajClanaController = new DodajClanaController(new DodajClanaForma());
        dodajClanaController.otvoriFormu(ModFormeClan.DODAJ);
        dodajClanaController.pripremiFormu(ModFormeClan.DODAJ);
        
    }


    public void otvoriDodajTreneraFormu() {
        System.out.println("USAO U OTVORI DODAJ TRENERA FORMU");
        dodajTreneraController = new DodajTreneraController(new DodajTreneraForma());
        dodajTreneraController.otvoriFormu();

    }
    
    
    public void osveziTabeluClanova() {
        prikazClanaController.pripremiFormu();
    }
    
    public void dodajParam(String s, Object o){
        parametri.put(s, o);
    }
    
    public Object vratiParam(String s){
        return parametri.get(s);
    }

    public void otvoriIzmeniClanaFormu() {
        dodajClanaController = new DodajClanaController(new DodajClanaForma());
        dodajClanaController.otvoriFormu(ModFormeClan.IZMENI);
    }

    public void osveziGlavnuFormu() {
        prikazClanaController.pripremiFormu();
    }
    
    
    public void otvoriPrikazGrupaFormu(){
        prikazGrupaController = new PrikazGrupaController(new PrikazGrupaForma());
        prikazGrupaController.otvoriFormu();
    }
    
    public void otvoriPrikazTreningaFormu(){
        prikazTreningaController = new PrikazTreningaController(new PrikazTreningForma());
        prikazTreningaController.otvoriFormu();
    }

    public void otvoriDodajGrupuForma() {
        dodajGrupuController = new DodajGrupuController(new DodajGrupuForma());
        dodajGrupuController.otvoriFormu();
    }

    public void otvoriDodajTreningFormu() {
        System.out.println("USAO U OTVORI DODAJ TRENING FORMU U KORDINATORU");
        dodajTreningController = new DodajTreningController(new DodajTreningForma());
        dodajTreningController.otvoriFormu();
    }

}
