/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komunikacija;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bogdan Blagojevic
 */
public class Posiljalac {
    //Kod posiljalaca se koristi za outpustStream, a kod primaoca inputStream
    private Socket socket; 

    public Posiljalac(Socket socket) {
        this.socket = socket;
    }
    
    public void posalji(Object obj){ try {
        //Salje ili zahtev ili odgovor
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(obj);
        oos.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
    
    
}
