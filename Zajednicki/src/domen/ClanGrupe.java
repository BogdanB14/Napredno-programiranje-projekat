/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Bogdan Blagojevic
 */
public class ClanGrupe implements ApstraktniDomenskiObjekat{
    private int rbClana;
    private Grupa grupa;
    private String pozicija;
    private String status;
    private Clan clan;

    
    public ClanGrupe() {
    }

    public ClanGrupe(int rbClana, String pozicija, String status, Clan clan, Grupa grupa) {
        this.rbClana = rbClana;
        this.pozicija = pozicija;
        this.status = status;
        this.clan = clan;
        this.grupa = grupa;
    }

    public int getRbClana() {
        return rbClana;
    }

    public void setRbClana(int rbClana) {
        this.rbClana = rbClana;
    }

    public String getPozicija() {
        return pozicija;
    }

    public void setPozicija(String pozicija) {
        this.pozicija = pozicija;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }
    
    @Override
    public String toString() {
        return "ClanGrupe{" + "rbClana=" + rbClana + ", pozicija=" + pozicija + ", status=" + status + '}';
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
        final ClanGrupe other = (ClanGrupe) obj;
        if (this.rbClana != other.rbClana) {
            return false;
        }
        if (!Objects.equals(this.pozicija, other.pozicija)) {
            return false;
        }
        return Objects.equals(this.status, other.status);
    }

    @Override
    public String vratiNazivTabele() {
        return "clangrupe";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "grupa,pozicija,status,clan";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return ""+grupa.getGrupaID()+",'"+pozicija+"','"+status+"',"+clan.getJmbg();
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "clangrupe.rbClana="+rbClana + " AND clangrupe.grupa="+grupa.getGrupaID();
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        //"grupa,pozicija,status,clan";
        return "grupa="+grupa.getGrupaID()+", pozicija='"+pozicija+"', status='"+status+"', clan="+clan.getJmbg();
    }
    
    
}
