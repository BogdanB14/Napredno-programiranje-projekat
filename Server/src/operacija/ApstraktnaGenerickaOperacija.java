/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija;

import repository.Repository;
import repository.db.DBRepository;
import repository.db.impl.DBRepositoryGeneric;

/**
 *
 * @author Bogdan Blagojevic
 */
public abstract class ApstraktnaGenerickaOperacija {
    protected final Repository broker;

    public ApstraktnaGenerickaOperacija() {
        this.broker = new DBRepositoryGeneric();
    }
    
    public final void izvrsi(Object objekat, String kljuc) throws Exception{
        try{
            preduslovi(objekat);
            zapocniTransakciju();
            izvrsiOperaciju(objekat, kljuc);
            potvrdiTransakciju();
        } catch(Exception e){
            ponistiTransakciju();
            throw e;
        }
//        } finally{ //Ovaj ovde deo ne dozvoljava da se 2 puta izvrsi neka operacija, ne razumem zasto ?!
//            ugasiKonekciju();
//        }
        
    }
    
    protected abstract void preduslovi(Object param) throws Exception;
    
    protected abstract void izvrsiOperaciju(Object param, String kljuc) throws Exception;
    
    private void zapocniTransakciju() throws Exception{
        ((DBRepository) broker).connect();
    }
    
    private void potvrdiTransakciju() throws Exception{
        ((DBRepository) broker).commit();
    }
    
    
    private void ponistiTransakciju() throws Exception{
        ((DBRepository) broker).rollback();
    }
    
    private void ugasiKonekciju() throws Exception{
        ((DBRepository) broker).disconnect();
    }
}
