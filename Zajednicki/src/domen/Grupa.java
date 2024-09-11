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
public class Grupa implements ApstraktniDomenskiObjekat{
    private Long grupaID;
    private String nazivGrupe;
    private int brClanova;
    private Kategorija kategorija;
    private Administrator administrator;
    private Trener trener;

    public Grupa() {
    }

    public Grupa(Long grupaID, String nazivGrupe, int brClanova, Kategorija kategorija, Administrator administrator, Trener trener) {
        this.grupaID = grupaID;
        this.nazivGrupe = nazivGrupe;
        this.brClanova = brClanova;
        this.kategorija = kategorija;
        this.administrator = administrator;
        this.trener = trener;
    }

    public Long getGrupaID() {
        return grupaID;
    }

    public void setGrupaID(Long grupaID) {
        this.grupaID = grupaID;
    }

    public String getNazivGrupe() {
        return nazivGrupe;
    }

    public void setNazivGrupe(String nazivGrupe) {
        this.nazivGrupe = nazivGrupe;
    }

    public int getBrClanova() {
        return brClanova;
    }

    public void setBrClanova(int rbClanova) {
        this.brClanova = brClanova;
    }

    public Kategorija getKategorija() {
        return kategorija;
    }

    public void setKategorija(Kategorija kategorija) {
        this.kategorija = kategorija;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    public Trener getTrener() {
        return trener;
    }

    public void setTrener(Trener trener) {
        this.trener = trener;
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
        final Grupa other = (Grupa) obj;
        if (!Objects.equals(this.nazivGrupe, other.nazivGrupe)) {
            return false;
        }
        return Objects.equals(this.grupaID, other.grupaID);
    }

    @Override
    public String toString() {
        return nazivGrupe;
    }

    
    
    @Override
    public String vratiNazivTabele() {
        return "grupa";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while(rs.next()){   
            /*    private Long grupaID;
    private String nazivGrupe;
    private int brClanova;
    private Kategorija kategorija;
    private Administrator administrator;
    private Trener trener;*/
            Long idGrupe = (long) rs.getInt("grupa.grupaID");
            String naziv = rs.getString("grupa.nazivGrupe");
            int br = rs.getInt("grupa.brClanova");
            
            Long kategorijaID = (long) rs.getInt("kategorija.kategorijaID");
            String nazivKategorije = rs.getString("kategorija.nazivKategorije");
            String opisKategorije = rs.getString("kategorija.opisKategorije");
            Pol pol = Pol.valueOf(rs.getString("kategorija.pol"));
            Kategorija k = new Kategorija(kategorijaID, nazivKategorije, opisKategorije, pol);
            
            Long administratorID = (long) rs.getInt("administrator.administratorID");
            String korisnickoIme = rs.getString("administrator.korisnickoIme");
            String sifra = rs.getString("administrator.sifra");
            String imeAdmin = rs.getString("administrator.imeAdmin");
            String prezimeAdmin = rs.getString("administrator.prezimeAdmin");
            Administrator a = new Administrator(administratorID, korisnickoIme, sifra, imeAdmin, prezimeAdmin);
            
            Long trenerId = (long) rs.getInt("trener.trenerID");
            String imeTrener = rs.getString("trener.imeTrener");
            String prezimeTrener = rs.getString("trener.prezimeTrener");
            Long mestoID = (long) rs.getInt("trener.mesto");
            Long postanskiBroj = (long) rs.getInt("mesto.postanskiBroj");
            String nazivMesta = rs.getString("mesto.naziv");
            Mesto m = new Mesto(mestoID, postanskiBroj, nazivMesta);
            Trener trener = new Trener(trenerId, imeTrener, prezimeTrener, m);
            
            Grupa grupa = new Grupa(idGrupe, naziv, br, k, a, trener);
            lista.add(grupa);
        }
        System.out.println("VRACENA GRUPA: " + lista);
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "nazivGrupe,brClanova,kategorija,administrator,trener";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'"+nazivGrupe+"',"+brClanova+","+kategorija.getKategorijaID()+","+administrator.getAdministratorID()+","+trener.getTrenerID();
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "grupa.grupaID="+grupaID;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        //"nazivGrupe,brClanova,kategorija,administrator,trener";
        return "nazivGrupe='"+nazivGrupe+"', brClanova="+brClanova+", kategorija="+ kategorija.getKategorijaID()+" ,administrator="+administrator.getAdministratorID()+", trener="+trener.getTrenerID();
    }
    
    
    
}
