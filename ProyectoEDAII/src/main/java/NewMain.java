
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joshu
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        NuevoArchivo archivo = new NuevoArchivo();
        archivo.GenerarNuevoArchivo();
        Polifase p = new Polifase();
        
           p.Particion("claves.txt","W1.txt","W2.txt");
           p.Combinacion("W1.txt","W2.txt","claves.txt");
           
           for(int i = 0; i<1000; i++){
               p.Particion("claves.txt","W1.txt","W2.txt");
               p.Combinacion("W1.txt","W2.txt","claves.txt");
           }
           
        System.out.println("Done");
    }
    
}
