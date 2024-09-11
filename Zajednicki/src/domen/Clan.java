/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author Bogdan Blagojevic
 */
public class Clan implements ApstraktniDomenskiObjekat{
    private String jmbg;
    private String imeClana;
    private String prezimeClana;
    private Date datumRodjenja;
    private Pol pol;
    private String telefon;
    private Mesto mesto;
    
    public Clan() {
    }

    public Clan(String jmbg, String imeClana, String prezimeClana, Date datumRodjenja, Pol pol, String telefon, Mesto mesto) {
        this.jmbg = jmbg;
        this.imeClana = imeClana;
        this.prezimeClana = prezimeClana;
        this.datumRodjenja = datumRodjenja;
        this.pol = pol;
        this.telefon = telefon;
        this.mesto = mesto;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getImeClana() {
        return imeClana;
    }

    public void setImeClana(String imeClana) {
        this.imeClana = imeClana;
    }

    public String getPrezimeClana() {
        return prezimeClana;
    }

    public void setPrezimeClana(String prezimeClana) {
        this.prezimeClana = prezimeClana;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public Pol getPol() {
        return pol;
    }

    public void setPol(Pol pol) {
        this.pol = pol;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public Mesto getMesto() {
        return mesto;
    }

    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }

    @Override
    public String toString() {
        return "Clan{" + "jmbg=" + jmbg + ", imeClana=" + imeClana + ", prezimeClana=" + prezimeClana + ", datumRodjenja=" + datumRodjenja + ", pol=" + pol + ", telefon=" + telefon + ", mesto=" + mesto + '}';
    }
    
    


    @Override
    public int hashCode() {
        int hash = 5;
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
        final Clan other = (Clan) obj;
        return Objects.equals(this.jmbg, other.jmbg);
    }

    @Override
    public String vratiNazivTabele() {
        return "clan";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while(rs.next()){
            String j =  rs.getString("clan.jmbg");
            String ime = rs.getString("clan.imeClana");
            String prezime = rs.getString("clan.prezimeClana");
            java.util.Date dr = new java.util.Date(rs.getDate("clan.datumRodjenja").getTime());
            Pol p = Pol.valueOf(rs.getString("clan.pol"));
            String t = rs.getString("clan.telefon");
            Long idMesto = (long) rs.getInt("mesto.mestoID");
            String naziv = rs.getString("mesto.naziv");
            Long postanskiBroj = (long) rs.getInt("mesto.postanskiBroj");
            Mesto m = new Mesto(idMesto, postanskiBroj, naziv);
            Clan clan = new Clan(j, ime, prezime, dr, p, t, m);
            lista.add(clan);
        }
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "jmbg,imeClana,prezimeClana,datumRodjenja,pol,telefon,mesto";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        java.sql.Date datum = new java.sql.Date(datumRodjenja.getTime());
        return "'"+jmbg+"','"+imeClana+"','"+prezimeClana+"','"+datum+"','"+pol+"','"+telefon+"',"+mesto.getMestoID();
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "clan.jmbg='"+jmbg+"'";
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        //"jmbg,imeClana,prezimeClana,datumRodjenja,pol,telefon,mesto";
        java.sql.Date datum = new java.sql.Date(datumRodjenja.getTime());
        return "clan.jmbg='"+jmbg+"', clan.imeClana='"+imeClana+"', clan.prezimeClana='"+prezimeClana+"', clan.datumRodjenja='"+datum+"', clan.pol='"+pol+"', clan.telefon='"+telefon+"', clan.mesto="+mesto.getMestoID() + " WHERE " + vratiPrimarniKljuc();
    }
    
    
}
