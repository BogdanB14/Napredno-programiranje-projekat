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
public class Kategorija implements ApstraktniDomenskiObjekat{
    private Long kategorijaID;
    private String nazivKategorije;
    private String opisKategorije;
    private Pol pol;

    public Kategorija() {
    }

    public Kategorija(Long kategorijaID, String nazivKategorije, String opisKategorije, Pol pol) {
        this.kategorijaID = kategorijaID;
        this.nazivKategorije = nazivKategorije;
        this.opisKategorije = opisKategorije;
        this.pol = pol;
    }

    public Long getKategorijaID() {
        return kategorijaID;
    }

    public void setKategorijaID(Long kategorijaID) {
        this.kategorijaID = kategorijaID;
    }

    public String getNazivKategorije() {
        return nazivKategorije;
    }

    public void setNazivKategorije(String nazivKategorije) {
        this.nazivKategorije = nazivKategorije;
    }

    public String getOpisKategorije() {
        return opisKategorije;
    }

    public void setOpisKategorije(String opisKategorije) {
        this.opisKategorije = opisKategorije;
    }

    public Pol getPol() {
        return pol;
    }

    public void setPol(Pol pol) {
        this.pol = pol;
    }

    @Override
    public String toString() {
        return nazivKategorije;
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
        final Kategorija other = (Kategorija) obj;
        if (!Objects.equals(this.nazivKategorije, other.nazivKategorije)) {
            return false;
        }
        if (!Objects.equals(this.opisKategorije, other.opisKategorije)) {
            return false;
        }
        if (!Objects.equals(this.kategorijaID, other.kategorijaID)) {
            return false;
        }
        return this.pol == other.pol;
    }

    @Override
    public String vratiNazivTabele() {
        return "kategorija";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while(rs.next()){
            Long id = (long) rs.getInt("kategorija.kategorijaID");
            String naziv = rs.getString("kategorija.nazivKategorije");
            String opis = rs.getString("kategorija.opisKategorije");
            Pol p = Pol.valueOf(rs.getString("kategorija.pol"));
            Kategorija k = new Kategorija(id, naziv, opis, p);
            lista.add(k);
        }
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "nazivKategorije,opisKategorije,pol";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'"+nazivKategorije+"','"+opisKategorije+"','"+pol+"'";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "kategorija.kategorijaID="+kategorijaID;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        //"nazivKategorije,opisKategorije,pol";
        return "nazivKategorije='"+nazivKategorije+"', opisKategorije='"+opisKategorije+"', pol='"+pol+"'";
    }
    
    
}
