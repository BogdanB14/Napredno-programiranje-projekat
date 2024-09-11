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
public class Sala implements ApstraktniDomenskiObjekat{
    private Long salaID;
    private String nazivSale;
    private int kapacitet;
    private Mesto mesto;
    
    public Sala() {
    }

    public Sala(Long salaID, String nazivSale, int kapacitet, Mesto mesto) {
        this.salaID = salaID;
        this.nazivSale = nazivSale;
        this.kapacitet = kapacitet;
        this.mesto = mesto;
    }

    public Long getSalaID() {
        return salaID;
    }

    public void setSalaID(Long salaID) {
        this.salaID = salaID;
    }

    public String getNazivSale() {
        return nazivSale;
    }

    public void setNazivSale(String nazivSale) {
        this.nazivSale = nazivSale;
    }

    public int getKapacitet() {
        return kapacitet;
    }

    public void setKapacitet(int kapacitet) {
        this.kapacitet = kapacitet;
    }

    public Mesto getMesto() {
        return mesto;
    }

    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }
    
    @Override
    public String toString() {
        return nazivSale;
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
        final Sala other = (Sala) obj;
        if (!Objects.equals(this.nazivSale, other.nazivSale)) {
            return false;
        }
        return Objects.equals(this.salaID, other.salaID);
    }

    @Override
    public String vratiNazivTabele() {
        return "sala";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {

        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        
        while(rs.next()){
            Long id = (long) rs.getInt("sala.salaID");
            String nazivS = rs.getString("sala.nazivSale");
            int kap = rs.getInt("sala.kapacitet");
            Long mestoID = (long) rs.getInt("mesto.mestoID");
            Long ptt = (long) rs.getInt("mesto.postanskiBroj");
            String nazivmesta = rs.getString("mesto.naziv");
            Mesto m = new Mesto(mestoID, ptt, nazivmesta);
            Sala s = new Sala(id, nazivS, kap, m);
            
            lista.add(s);
            
        }
        
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "nazivSale,kapacitet,mesto";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'"+nazivSale+"',"+kapacitet+","+mesto.getMestoID();
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "sala.salaID="+salaID;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
       //"nazivSale,kapacitet,mesto";
       return "nazivSale='"+nazivSale+"', kapacitet="+kapacitet+", mesto="+mesto.getMestoID();
    }
    
    
}
