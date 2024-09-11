/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Bogdan Blagojevic
 */
public class Trener implements ApstraktniDomenskiObjekat{
    private Long trenerID;
    private String imeTrener;
    private String prezimeTrener;
    private Mesto mesto;

    public Trener() {
    }

    public Trener(Long trenerID, String imeTrener, String prezimeTrener, Mesto mesto) {
        this.trenerID = trenerID;
        this.imeTrener = imeTrener;
        this.prezimeTrener = prezimeTrener;
        this.mesto = mesto;
    }

    public Long getTrenerID() {
        return trenerID;
    }

    public void setTrenerID(Long trenerID) {
        this.trenerID = trenerID;
    }

    public String getImeTrener() {
        return imeTrener;
    }

    public void setImeTrener(String imeTrener) {
        this.imeTrener = imeTrener;
    }

    public String getPrezimeTrener() {
        return prezimeTrener;
    }

    public void setPrezimeTrener(String prezimeTrener) {
        this.prezimeTrener = prezimeTrener;
    }

    public Mesto getMesto() {
        return mesto;
    }

    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }

    
    
    @Override
    public String toString() {
        return imeTrener + " " + prezimeTrener;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Trener other = (Trener) obj;
        if (!Objects.equals(this.imeTrener, other.imeTrener)) {
            return false;
        }
        if (!Objects.equals(this.prezimeTrener, other.prezimeTrener)) {
            return false;
        }
        return Objects.equals(this.trenerID, other.trenerID);
    }

    @Override
    public String vratiNazivTabele() {
        return "trener";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {

        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while(rs.next()){
            Long id = (long) rs.getInt("trener.trenerID");
            String ime = rs.getString("trener.imeTrener");
            String prezime =rs.getString("trener.prezimeTrener");
            Long mestoID = (long) rs.getInt("mesto.mestoID");
            Long ptt = (long) rs.getInt("mesto.postanskiBroj");
            String naziv = rs.getString("mesto.naziv");
            Mesto m = new Mesto(mestoID, ptt, naziv);
            
            Trener t = new Trener(id, ime, prezime, m);
            lista.add(t);
        }
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "imeTrener,prezimeTrener,mesto";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'"+imeTrener+"','"+prezimeTrener+"',"+mesto.getMestoID();
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "trener.trenerID="+trenerID;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        //"imeTrener,prezimeTrener,mesto";
        return "imeTrener='"+imeTrener+"', prezimeTrener='"+prezimeTrener+"', mesto="+mesto.getMestoID();
    }
    
    
}
