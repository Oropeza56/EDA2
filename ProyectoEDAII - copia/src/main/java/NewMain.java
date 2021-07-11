
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
        long TInicio, TFin, tiempo;           //Para determinar el tiempo
        int x,y,z;
        
          TInicio = System.currentTimeMillis(); //de ejecución
          p.Particion("claves.txt","W1.txt","W2.txt");
          p.Combinacion("W1.txt","W2.txt","claves.txt");

          /*
        for (int i = 0; i< 200; i++){
            p.Combinacion("W1.txt","W2.txt","claves.txt");
            System.out.println(nroRegistros("claves.txt"));
            System.out.println(nroRegistros("W1.txt"));
            System.out.println(nroRegistros("W2.txt"));
            System.out.println();
        }
          */
          
          
           //p.Combinacion("W1.txt","claves.txt","W2.txt");
           //p.Combinacion("claves.txt","W2.txt","W1.txt");
           /*
           int i = 0;
           
           
           
           while( p.index < p.getClaves("claves.txt")){
               p.Particion("claves.txt","W1.txt","W2.txt");
               p.Combinacion("W1.txt","W2.txt","claves.txt");
               //p.CombinacionMenor("W1.txt","W2.txt","claves.txt");
               i++;
               //System.out.println(p.index);
           }*/
           
           do{
           p.Combinacion("W1.txt","W2.txt","claves.txt");
           System.out.println(x=(int) nroRegistros("claves.txt"));
           System.out.println(y=(int) nroRegistros("W1.txt"));
           System.out.println(z=(int) nroRegistros("W2.txt"));           
           System.out.println();

           //w=(int) nroRegistros("W1.txt");
           //z=(int) nroRegistros("W2.txt");
        }while(x != 496 || y != 496 );
           
            
           
            TFin = System.currentTimeMillis();
            tiempo = TFin - TInicio;
            System.out.println("Tiempo de ejecución en milisegundos: " + tiempo);
           //System.out.println(p.end);
        //System.out.println("Done");
    }
    
    public static long nroRegistros(String ruta) throws IOException{
            long count=0;
            FileReader fr = new FileReader(ruta);
            BufferedReader bf = new BufferedReader(fr);
            String text1 = bf.readLine();
            String[] claves = text1.split(",");
        
            for(int i = 0; i<claves.length; i++){
                //valor = Integer.valueOf(claves[i]);
                count++;
            }
            fr.close();
            bf.close();
            return count; 
    }   
}
