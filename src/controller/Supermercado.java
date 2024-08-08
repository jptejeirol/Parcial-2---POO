package controller;

import java.io.FileNotFoundException;
import views.Catalogo;
import model.Firebase;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author Juan Pablo Tejeiro Londoño
 */
public class Supermercado {

    public static void main(String[] args) throws FileNotFoundException {

        Firebase firebase = new Firebase();
        
        java.awt.EventQueue.invokeLater(() -> {
            new Catalogo().setVisible(true);
        });        
        
    }
    
}
