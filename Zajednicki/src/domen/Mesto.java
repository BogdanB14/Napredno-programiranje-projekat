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
public class Mesto implements ApstraktniDomenskiObjekat{
    private Long mestoID;
    private Long postanskiBroj;
    private String naziv;

    public Mesto() {
    }

    public Mesto(Long mestoID, Long postanskiBroj, String naziv) {
        this.mestoID = mestoID;
        this.postanskiBroj = postanskiBroj;
        this.naziv = naziv;
    }

    public Long getMestoID() {
        return mestoID;
    }

    public void setMestoID(Long mestoID) {
        this.mestoID = mestoID;
    }

    public Long getPostanskiBroj() {
        return postanskiBroj;
    }

    public void setPostanskiBroj(Long postanskiBroj) {
        this.postanskiBroj = postanskiBroj;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
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
        final Mesto other = (Mesto) obj;
        if (!Objects.equals(this.naziv, other.naziv)) {
            return false;
        }
        if (!Objects.equals(this.mestoID, other.mestoID)) {
            return false;
        }
        return Objects.equals(this.postanskiBroj, other.postanskiBroj);
    }

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public String vratiNazivTabele() {
        return "mesto";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while(rs.next()){
            Long id = (long) rs.getInt("mesto.mestoID");
            Long ptt = (long) rs.getInt("mesto.postanskiBroj");
            String n = rs.getString("mesto.naziv");
            Mesto m = new Mesto(id, ptt, n);
            lista.add(m);
        }
        return lista;
     }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "postanskiBroj,naziv";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return""+postanskiBroj+",'"+naziv+"'";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "mesto.mestoID="+mestoID;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        //"postanskiBroj,naziv";
        return "postanskiBroj="+postanskiBroj+", naziv='"+naziv+"'";
    }
    
    
}
