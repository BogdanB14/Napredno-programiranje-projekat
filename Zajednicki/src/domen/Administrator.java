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
public class Administrator implements ApstraktniDomenskiObjekat{
    private Long administratorID;
    private String korisnickoIme;
    private String sifra;
    private String imeAdmin;
    private String prezimeAdmin;

    public Administrator() {
    }

    public Administrator(Long administratorID, String korisnickoIme, String sifra, String imeAdmin, String prezimeAdmin) {
        this.administratorID = administratorID;
        this.korisnickoIme = korisnickoIme;
        this.sifra = sifra;
        this.imeAdmin = imeAdmin;
        this.prezimeAdmin = prezimeAdmin;
    }

    public Long getAdministratorID() {
        return administratorID;
    }

    public void setAdministratorID(Long administratorID) {
        this.administratorID = administratorID;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public String getImeAdmin() {
        return imeAdmin;
    }

    public void setImeAdmin(String imeAdmin) {
        this.imeAdmin = imeAdmin;
    }

    public String getPrezimeAdmin() {
        return prezimeAdmin;
    }

    public void setPrezimeAdmin(String prezimeAdmin) {
        this.prezimeAdmin = prezimeAdmin;
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
        final Administrator other = (Administrator) obj;
        if (!Objects.equals(this.korisnickoIme, other.korisnickoIme)) {
            return false;
        }
        return Objects.equals(this.sifra, other.sifra);
    }

    @Override
    public String toString() {
        return korisnickoIme;
    }

    @Override
    public String vratiNazivTabele() {
        return "administrator";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while(rs.next()){
            Long id = (long) rs.getInt("administrator.administratorID");
            String korisnicko = rs.getString("administrator.korisnickoIme");
            String lozinka = rs.getString("administrator.sifra");
            String ime = rs.getString("administrator.imeAdmin");
            String prezime = rs.getString("administrator.prezimeAdmin");
            Administrator a = new Administrator(id, korisnicko, lozinka, ime, prezime);
            lista.add(a);
        }
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "korisnickoIme,sifra,imeAdmin,prezimeAdmin";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'"+korisnickoIme+"','"+sifra+"','"+imeAdmin+"','"+prezimeAdmin+"'";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "administrator.administratorID="+administratorID;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "korisnickoIme='"+korisnickoIme+"', sifra='"+sifra+"', imeAdmin='"+imeAdmin+"', prezimeAdmin='"+prezimeAdmin;
    }
    
    
}
