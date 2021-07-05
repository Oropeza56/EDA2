/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
     
/**
 *
 * @author joshu
 */
public class NuevoArchivo {
    
    public void NuevoArchivo(){
        
    }
    
    public void GenerarNuevoArchivo() throws IOException{
        FileWriter claves = new FileWriter("claves.txt");
        int valor;
        for(int i = 0; i<500; i++){
            String clave = String.valueOf((int)Math.floor(Math.random()*5000+1));
            claves.write(clave);
            if(i!=499){
                claves.write(",");
            }
        }
        claves.close();
    }
}
