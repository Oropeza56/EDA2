
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joshu
 */
public class Polifase {
    public void Polifase(){
        
    }
    public void Particion(String nombre) throws FileNotFoundException, IOException{
        FileReader r = new FileReader(nombre);
        BufferedReader b = new BufferedReader(r);
        FileWriter w1 = new FileWriter("W1.txt");
        FileWriter w2 = new FileWriter("W2.txt");
        List<Integer> lista = new LinkedList<>();
        
        String text = b.readLine();
        String[] claves = text.split(",");
        //int[] valor = new int[claves.length];
        
        for(int i = 0; i<claves.length; i++){
            //valor = Integer.valueOf(claves[i]);
            lista.add(Integer.parseInt(claves[i]));
        }
        
        while(lista.isEmpty() == false){
            int[] aux = new int[4];
           if( lista.size() >= 4  ){
               aux[0] = lista.remove(0);
               aux[1] = lista.remove(0);
               aux[2] = lista.remove(0);
               aux[3] = lista.remove(0);
               Arrays.sort(aux);
               for(int i = 0; i<4; i++){
                   if(i == 0){
                       w1.write(Integer.toString(aux[i]));
                   }          
                   else
                   {
                       w1.write(",");
                       w1.write(Integer.toString(aux[i]));
                   }
               }
               w1.write(",");
           }
           else if(lista.size() == 3){
               aux[0] = lista.remove(0);
               aux[1] = lista.remove(0);
               aux[2] = lista.remove(0);
               Arrays.sort(aux);
               for(int i = 0; i<3; i++){
                   if(i == 0){
                       w1.write(Integer.toString(aux[i]));
                   }          
                   else
                   {
                       w1.write(",");
                       w1.write(Integer.toString(aux[i]));
                   }
               }
               w1.write(",");
           }
           else if( lista.size() == 2 ){
               aux[0] = lista.remove(0);
               aux[1] = lista.remove(0);
               for(int i = 0; i<2; i++){
                   if(i == 0){
                       w1.write(Integer.toString(aux[i]));
                   }          
                   else
                   {
                       w1.write(",");
                       w1.write(Integer.toString(aux[i]));
                   }
               }
               w1.write(",");
           }
           else{
               aux[0] = lista.remove(0);
               for(int i = 0; i<1; i++){
                   if(i == 0){
                       w1.write(Integer.toString(aux[i]));
                   }          
                   else
                   {
                       w1.write(",");
                       w1.write(Integer.toString(aux[i]));
                   }
               }
               w1.write(",");
           }
           
           aux = new int[4];
           if( (lista.isEmpty() == false) && lista.size() >= 4  ){
               aux[0] = lista.remove(0);
               aux[1] = lista.remove(0);
               aux[2] = lista.remove(0);
               aux[3] = lista.remove(0);
               Arrays.sort(aux);
               for(int i = 0; i<4; i++){
                   if(i == 0){
                       w2.write(Integer.toString(aux[i]));
                   }          
                   else
                   {
                       w2.write(",");
                       w2.write(Integer.toString(aux[i]));
                   }
               }
               w2.write(",");
           }
           else if((lista.isEmpty() == false) && lista.size() == 3){
               aux[0] = lista.remove(0);
               aux[1] = lista.remove(0);
               aux[2] = lista.remove(0);
               Arrays.sort(aux);
               for(int i = 0; i<3; i++){
                   if(i == 0){
                       w2.write(Integer.toString(aux[i]));
                   }          
                   else
                   {
                       w2.write(",");
                       w2.write(Integer.toString(aux[i]));
                   }
               }
               w2.write(",");
           }
           else if((lista.isEmpty() == false) && lista.size() == 2){
               aux[0] = lista.remove(0);
               aux[1] = lista.remove(0);
               Arrays.sort(aux);
               for(int i = 0; i<2; i++){
                   if(i == 0){
                       w2.write(Integer.toString(aux[i]));
                   }          
                   else
                   {
                       w2.write(",");
                       w2.write(Integer.toString(aux[i]));
                   }
               }
               w2.write(",");
           }
           else if(lista.isEmpty() == false){
               aux[0] = lista.remove(0);
               Arrays.sort(aux);
               for(int i = 0; i<1; i++){
                   if(i == 0){
                       w2.write(Integer.toString(aux[i]));
                   }          
                   else
                   {
                       w2.write(",");
                       w2.write(Integer.toString(aux[i]));
                   }
               }
               w2.write(",");
           }
           
        }
        //tengo que intercalar las claves a un documento, ahí ordenarlas en sublistas y trabajar las sublistas cuando al menos un documento esté vacio
        // Considerando a los archivos como a , b ,c 
        // Sí a está vacio entonces mezclar elementos en b-c hasta que alguno de los dos esé vacio ( a = null || b = null)
        // Evaluar cual de los archivos fue el nulo y mezclar ahí los elementos
        r.close();
        b.close();
        w1.close();
        w2.close();
        
        System.out.println("Estado Documento de Particion 1:");
        ImprimirDocumento("W1.txt");
        
        System.out.println();
        
        System.out.println("Estado Documento de Particion 2:");
        ImprimirDocumento("W2.txt");
    }
    
    public void ImprimirDocumento(String F1) throws FileNotFoundException, IOException{
        FileReader r1 = new FileReader(F1);
        BufferedReader b1 = new BufferedReader(r1);
        
        String text = b1.readLine();
        String[] claves = text.split(",");
        ImprimirArreglo(claves);
        
        r1.close();
        b1.close();
    }
    
    public void ImprimirArreglo(String[] valor){
        for(int i = 0; i<valor.length;i++){
            System.out.print(valor[i]+", ");
        }
    }
}
