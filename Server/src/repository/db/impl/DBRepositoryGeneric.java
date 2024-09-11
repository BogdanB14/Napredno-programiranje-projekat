/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.db.impl;

import domen.ApstraktniDomenskiObjekat;
import java.util.ArrayList;
import java.util.List;
import repository.db.DBConnectionFactory;
import repository.db.DBRepository;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author Bogdan Blagojevic
 */
public class DBRepositoryGeneric implements DBRepository<ApstraktniDomenskiObjekat> {

    @Override
    public List<ApstraktniDomenskiObjekat> getAll(ApstraktniDomenskiObjekat param, String uslov) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        
        String upit = "SELECT * FROM " + param.vratiNazivTabele();
        if(uslov != null){
            upit += uslov;
        }
        System.out.println(upit);
        
        Statement st = DBConnectionFactory.getInstance().getConnection().createStatement();
        ResultSet rs = st.executeQuery(upit);
        lista = param.vratiListu(rs);
        
        rs.close();
        st.close();
        
        return lista;
    }

    @Override
    public void add(ApstraktniDomenskiObjekat param) throws Exception {
        String upit = "INSERT INTO " + param.vratiNazivTabele() + " (" + param.vratiKoloneZaUbacivanje() + ") VALUES (" + param.vratiVrednostiZaUbacivanje() + ")";
        System.out.println(upit);
        Statement st = DBConnectionFactory.getInstance().getConnection().createStatement();
        st.executeUpdate(upit);
        System.out.println(upit);
        st.close();
    }

    @Override
    public boolean edit(ApstraktniDomenskiObjekat param) throws Exception {
        System.out.println("Usao u edit!");
        String upit = "UPDATE " + param.vratiNazivTabele() + " SET " + param.vratiVrednostiZaIzmenu();
        System.out.println(upit);
        Statement st = DBConnectionFactory.getInstance().getConnection().createStatement();
        int affectedRows = st.executeUpdate(upit);
        commit();
        st.close();
        return affectedRows > 0;
    }

    @Override
    public boolean delete(ApstraktniDomenskiObjekat param) throws Exception {
        String upit = "DELETE FROM " + param.vratiNazivTabele() + " WHERE " + param.vratiPrimarniKljuc();
        System.out.println(upit);
        Statement st = DBConnectionFactory.getInstance().getConnection().createStatement();
        int a = st.executeUpdate(upit);
        
        st.close();        
        return a > 0;
    }

    @Override
    public List<ApstraktniDomenskiObjekat> getAll() {
        return null; //TODO
    }
    
    
}
