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
public class Trening implements ApstraktniDomenskiObjekat{
    private int rbTreninga;
    private Date datumTreninga;
    private TipTreninga tipTreninga;
    private Sala sala;
    private Trener trener;
    private Grupa grupa;

    public Trening() {
    }

    public Trening(int rbTreninga, Date datumTreninga, TipTreninga tipTreninga, Sala sala, Trener trener, Grupa grupa) {
        this.rbTreninga = rbTreninga;
        this.datumTreninga = datumTreninga;
        this.tipTreninga = tipTreninga;
        this.sala = sala;
        this.trener = trener;
        this.grupa = grupa;
    }

    public int getRbTreninga() {
        return rbTreninga;
    }

    public void setRbTreninga(int rbTreninga) {
        this.rbTreninga = rbTreninga;
    }

    public Date getDatumTreninga() {
        return datumTreninga;
    }

    public void setDatumTreninga(Date datumTreninga) {
        this.datumTreninga = datumTreninga;
    }

    public TipTreninga getTipTreninga() {
        return tipTreninga;
    }

    public void setTipTreninga(TipTreninga tipTreninga) {
        this.tipTreninga = tipTreninga;
    }

    
    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Trener getTrener() {
        return trener;
    }

    public void setTrener(Trener trener) {
        this.trener = trener;
    }

    public Grupa getGrupa() {
        return grupa;
    }

    public void setGrupa(Grupa grupa) {
        this.grupa = grupa;
    }

    @Override
    public String toString() {
        return "Trening{" + "rbTreninga=" + rbTreninga + ", datumTreninga=" + datumTreninga + ", tipTreninga=" + tipTreninga + ", sala=" + sala + ", trener=" + trener + ", grupa=" + grupa + '}';
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
        final Trening other = (Trening) obj;
        if (this.rbTreninga != other.rbTreninga) {
            return false;
        }
        if (!Objects.equals(this.datumTreninga, other.datumTreninga)) {
            return false;
        }
        return this.tipTreninga == other.tipTreninga;
    }
    
    

    @Override
    public String vratiNazivTabele() {
        return "trening";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        /*    private int rbTreninga;
    private Date datumTreninga;
    private TipTreninga tipTreninga;
    private Sala sala;
    private Trener trener;
    private Grupa grupa;
*/      List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while(rs.next()){
            int rb = rs.getInt("trening.rbTreninga");
            java.util.Date datum = new java.util.Date(rs.getDate("trening.datumTreninga").getTime());
            TipTreninga tip = TipTreninga.valueOf(rs.getString("trening.tipTreninga"));
            
            Long salaID = (long) rs.getInt("sala.salaID");
            String nazivSale = rs.getString("sala.nazivSale");
            int kapacitet = rs.getInt("sala.kapacitet");
            Long mestoID = (long) rs.getInt("sala.mesto");
            Long postanskiBroj = (long) rs.getInt("mesto.postanskiBroj");
            String nazivMesta = rs.getString("mesto.naziv");
            Mesto m = new Mesto(mestoID, postanskiBroj, nazivMesta);
            Sala s = new Sala(salaID, nazivSale, kapacitet, m);
            
            Long trenerID = (long) rs.getInt("trener.trenerID");
            String imeTrener = rs.getString("trener.imeTrener");
            String prezimeTrener = rs.getString("trener.prezimeTrener");
            Long mestoIDTrener = (long) rs.getInt("trener.mesto");
            String nazivMestaTrener = rs.getString("mesto2.naziv");
            Long ptt = (long) rs.getInt("mesto2.postanskiBroj");
            Mesto m1 = new Mesto(mestoIDTrener, ptt, nazivMestaTrener);
            Trener t = new Trener(trenerID, imeTrener, prezimeTrener, m1);
            
            Long grupaID = (long) rs.getInt("trening.grupa");
            String naziv = rs.getString("grupa.nazivGrupe");
            int brClanova = rs.getInt("grupa.brClanova");
            Grupa g = new Grupa(grupaID, naziv, brClanova, null, null, null);
            
            Trening trening = new Trening(rb, datum, tip, s, t, g);
            lista.add(trening);
        }
        System.out.println("LISTA TRENINGA JE: " + lista);
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "datumTreninga,tipTreninga,sala,trener,grupa";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        java.sql.Date datum = new java.sql.Date(datumTreninga.getTime());
        return "'"+datum+"','"+tipTreninga+"',"+sala.getSalaID()+","+trener.getTrenerID()+","+grupa.getGrupaID();
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "trening.rbTreninga="+rbTreninga;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        //"datumTreninga,tipTreninga,sala,trener,grupa";
        return "datumTreninga='"+datumTreninga+"', tipTreninga='"+tipTreninga+"', sala="+sala.getSalaID()+", trener="+trener.getTrenerID()+", grupa="+grupa.getGrupaID();
    }
    
    
}
