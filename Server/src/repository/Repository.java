/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import java.util.List;

/**
 *
 * @author Bogdan Blagojevic
 */
public interface Repository<T> {
    List<T> getAll(T param, String uslov) throws Exception; //Претрага
    void add(T param) throws Exception; //Radi insert operaciju
    boolean edit(T param) throws Exception; //Radi update operaciju nad parametrom T
    boolean delete(T param) throws Exception; //Radi se delete operacija nad parametrom T koji moze biti bilo koji objekat iz modela
    List<T> getAll(); //Vraca sve objekte iz liste
    
    
}
