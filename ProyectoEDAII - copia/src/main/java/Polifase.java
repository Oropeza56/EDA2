
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
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
    boolean end = false; 
    public void Polifase(){
    }
    public static int prev = 0,aux = 0,index = 1;
    public void Particion(String F1, String F2, String destino) throws FileNotFoundException, IOException{
        FileReader r = new FileReader(F1);
        BufferedReader b = new BufferedReader(r);
        FileWriter w1 = new FileWriter(F2);
        FileWriter w2 = new FileWriter(destino);
        List<Integer> lista = new LinkedList<>();
        List<Integer> listaAux = new LinkedList<>();
        
        String text = b.readLine();
        String[] claves = text.split(",");
        //int[] valor = new int[claves.length];
        
        for(int i = 0; i<claves.length; i++){
            //valor = Integer.valueOf(claves[i]);
            lista.add(Integer.parseInt(claves[i]));
        }
        
        while(lista.isEmpty() == false ){
           int x = 4;
           if( lista.size() >= x  ){
               for(int i = 0; i<x; i++){
                   listaAux.add(lista.remove(0));
               }
               Collections.sort(listaAux);
               for(int i = 0; i<x; i++){
                   if(i == 0){
                       w1.write(Integer.toString(listaAux.remove(0)));
                   }          
                   else
                   {
                       w1.write(",");
                       w1.write(Integer.toString(listaAux.remove(0)));
                   }
               }
               w1.write(",");
           }
           else if (lista.size() > 0 ){
               x = lista.size();
               for(int i = 0; i<x; i++){
                   listaAux.add(lista.remove(0));
               }
               Collections.sort(listaAux);
               for(int i = 0; i<x; i++){
                   if(i == 0){
                       w1.write(Integer.toString(listaAux.remove(0)));
                   }          
                   else
                   {
                       w1.write(",");
                       w1.write(Integer.toString(listaAux.remove(0)));
                   }
               }
               w1.write(",");
           }
           /*
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
               Arrays.sort(aux);
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
           */
           //aux = new int[4];
           x = 4;
           if( !lista.isEmpty() && lista.size() >= x  ){
               for(int i = 0; i<x; i++){
                   listaAux.add(lista.remove(0));
               }
               Collections.sort(listaAux);
               for(int i = 0; i<x; i++){
                   if(i == 0){
                       w2.write(Integer.toString(listaAux.remove(0)));
                   }          
                   else
                   {
                       w2.write(",");
                       w2.write(Integer.toString(listaAux.remove(0)));
                   }
               }
               w2.write(",");
           }
           else if( !lista.isEmpty() && lista.size() > 0 ){
               x = lista.size();
               for(int i = 0; i<x; i++){
                   listaAux.add(lista.remove(0));
               }
               Collections.sort(listaAux);
               for(int i = 0; i<x; i++){
                   if(i == 0){
                       w2.write(Integer.toString(listaAux.remove(0)));
                   }          
                   else
                   {
                       w2.write(",");
                       w2.write(Integer.toString(listaAux.remove(0)));
                   }
               }
               w2.write(",");
           }
           /*
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
           */
           
        }
        //tengo que intercalar las claves a un documento, ahí ordenarlas en sublistas y trabajar las sublistas cuando al menos un documento esté vacio
        // Considerando a los archivos como a , b ,c 
        // Sí a está vacio entonces mezclar elementos en b-c hasta que alguno de los dos esé vacio ( a = null || b = null)
        // Evaluar cual de los archivos fue el nulo y mezclar ahí los elementos
        r.close();
        b.close();
        w1.close();
        w2.close();
        /*
        System.out.println();
        
        System.out.println("Estado Documento de Particion 1:");
        ImprimirDocumento("W1.txt");
        
        System.out.println();
        
        System.out.println("Estado Documento de Particion 2:");
        ImprimirDocumento("W2.txt");
        
        System.out.println();
        */
    }
    
    public void Combinacion(String F1, String F2, String destino) throws IOException{
        FileWriter w = new FileWriter(destino);
        FileReader r1 = new FileReader(F1);
        BufferedReader b1 = new BufferedReader(r1);
        FileReader r2 = new FileReader(F2);
        BufferedReader b2 = new BufferedReader(r2);
        List<Integer> lista1 = new LinkedList<>();
        List<Integer> lista2 = new LinkedList<>();
        List<Integer> listaAux = new LinkedList<>();
        List<Integer> listaAux2 = new LinkedList<>();
        
        String text1 = b1.readLine();
        String[] claves1 = text1.split(",");
        
        String text2 = b2.readLine();
        String[] claves2 = text2.split(",");
        
        for(int i = 0; i<claves1.length; i++){
            //valor = Integer.valueOf(claves[i]);
            lista1.add(Integer.parseInt(claves1[i]));
        }
        
        for(int i = 0; i<claves2.length; i++){
            //valor = Integer.valueOf(claves[i]);
            lista2.add(Integer.parseInt(claves2[i]));
        }
        
        int x=0;
        boolean first = true;
        
        //int[] aux = new int[4];
            // intercalacion de 2 bloques de 4 elementos
            while(( lista1.isEmpty() == false ) && ( lista2.isEmpty() == false )){
                if( !lista1.isEmpty() && !lista2.isEmpty() ){
                
                if(lista1.size() >= 4){
                    for(int i = 0; i < 4; i++){
                        listaAux.add(lista1.remove(0));
                    }                    
                }
                else{
                    x = lista1.size();
                    for(int i = 0; i < x; i++){
                        listaAux.add(lista1.remove(0));
                    }
                }
                if(lista2.size() >= 4){
                    for(int i = 0; i < 4; i++){
                        listaAux2.add(lista2.remove(0));
                    }
                }
                else{
                    x = lista2.size();
                    for(int i = 0; i < x; i++){
                        listaAux2.add(lista2.remove(0));
                    }
                }
            }
                
                // En este punto ya tenemos ambas listas auxiliares, procederemos a combinarlas por medio de una intercalacion
                
            Collections.sort(listaAux);
            Collections.sort(listaAux2);
            
            first = true;
            /*
            end = true;
            for(int i = 0; i < listaAux.size(); i++){
                for( int j = 0; j < listaAux2.size(); j++){
                    if( listaAux.get(i) > listaAux2.get(j) ){
                        System.out.println(listaAux.get(i) + ">" + listaAux2.get(j));
                    }
                    else{
                        System.out.println(listaAux.get(i) + " < " + listaAux2.get(j));
                        end = false;
                    }
                }
            }
            */
            while( listaAux.isEmpty() == false && listaAux2.isEmpty()== false ){
                if(listaAux.get(0) < listaAux2.get(0) ){
                    //listaAux.remove(0);
                    //System.out.println(i);
                    if(first == true){
                        w.write(Integer.toString(listaAux.remove(0)));
                        first = false;
                    }          
                    else
                    {
                        w.write(",");
                        w.write(Integer.toString(listaAux.remove(0)));
                    }
                }
                else{
                    if(first == true){
                        w.write(Integer.toString(listaAux2.remove(0)));
                        first = false;
                    }          
                    else
                    {
                        w.write(",");
                        w.write(Integer.toString(listaAux2.remove(0)));
                    }
                }
            }
            
            w.write(",");
            }
            
            //
            if(!listaAux.isEmpty()){
                int k = listaAux.size();
                for(int i = 0; i < k; i++ ){
                    if(i == 0){
                        w.write(Integer.toString(listaAux.remove(0)));
                    }          
                    else
                    {
                        w.write(",");
                        w.write(Integer.toString(listaAux.remove(0)));
                    }
                }  
                w.write(",");
            }
            
            if(!listaAux2.isEmpty()){
                    int k = listaAux2.size();
                    for(int i = 0; i < k; i++ ){
                        if(i == 0){
                            w.write(Integer.toString(listaAux2.remove(0)));
                        }          
                        else
                        {
                            w.write(",");
                            w.write(Integer.toString(listaAux2.remove(0)));
                        }
                    }  
                    w.write(",");
                }
            //
            
            w.close();
            r1.close();
            b1.close();
            r2.close();
            b2.close();
            
            
            
            /*
            System.out.println("Lista: " + listaAux.size());
            ImprimirLista(listaAux);
            */
            /*++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            x = listaAux.size();
            for(int i = 0; i<x; i++){
                //System.out.println(i);
                if(i == 0){
                    w.write(Integer.toString(listaAux.remove(0)));
                }          
                else
                {
                    w.write(",");
                    w.write(Integer.toString(listaAux.remove(0)));
                }
            }
            w.write(",");
            ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
            // System.out.println("Lista \"Vacia\": " + listaAux.size());
            //ImprimirLista(listaAux);
        
        if(lista1.isEmpty() ){
                
                FileWriter w1 = new FileWriter(F1);
                //FileWriter w2 = new FileWriter(F1);
                
                //escribir todo el restante en el documento vacio
                    
                x = lista2.size();
                for(int i = 0; i<x; i++){
                    //System.out.println(i);
                    if(i == 0){
                        w1.write(Integer.toString(lista2.remove(0)));
                    }          
                    else
                    {
                        w1.write(",");
                        w1.write(Integer.toString(lista2.remove(0)));
                    }         
                }
                w1.write(",");

                w1.close();
                Swap(destino,F2);
                
                //Intento de recursividad+++++++++++++++++++++++++++++++
                //perdida de datos
                //System.out.println("Entro a Lista 1 vacia");
                //Combinacion(F1,F2,destino);
                //Combinacion(F1,destino,F2);
                

                
            }
            else if( lista2.isEmpty()){
                FileWriter w1 = new FileWriter(F2);
                //FileWriter w2 = new FileWriter(F2);
                
                //escribir todo el restante en el documento vacio
                x = lista1.size();
                for(int i = 0; i<x; i++){
                    //System.out.println(i);
                    if(i == 0){
                        w1.write(Integer.toString(lista1.remove(0)));
                    }          
                    else
                    {
                        w1.write(",");
                        w1.write(Integer.toString(lista1.remove(0)));
                    }
                }
                w1.write(",");
                w1.close();
                Swap(destino,F1);
                //Recursividad +++++++++++++++++++++++++++++++++++++++++++++++++
                //Perdida de datos
                //System.out.println("Entro a Lista 2 vacia");
                //Combinacion(F1,F2,destino);
                //Combinacion(F2,destino,F1);
            }
            
        /*
        prev = index;
        index += aux;
        aux = prev;
        */
        /*
        
        */
        
        /*
        while(lista1.isEmpty() == false){
            int[] aux = new int[1];
            aux[0] = lista1.remove(0);
                    for(int i = 0; i<1; i++){
                        if(i == 0){
                            w.write(Integer.toString(aux[i]));
                        }          
                        else
                        {
                            w.write(",");
                            w.write(Integer.toString(aux[i]));
                        }
                    }
                    w.write(",");
        }
        while(lista2.isEmpty() == false){
            int[] aux = new int[1];
            aux[0] = lista2.remove(0);
                    for(int i = 0; i<1; i++){
                        if(i == 0){
                            w.write(Integer.toString(aux[i]));
                        }          
                        else
                        {
                            w.write(",");
                            w.write(Integer.toString(aux[i]));
                        }
                    }
                    w.write(",");
        }
        */
        //w.close();
        /*
        /////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("Estado de lista 1: " + lista2.size());
        /////////////////////////////////////////////////////////////////////////////////////////////////
        if(lista1.isEmpty() == false){
            System.out.println("Entra a file 1");
            FileWriter fw = new FileWriter("W1.txt");
            for(int i = 0; i<lista1.size();i++){
                if(i == 0){
                        fw.write(Integer.toString(lista1.get(i)));
                    }          
                    else
                    {
                        fw.write(",");
                        fw.write(Integer.toString(lista1.get(i)));
                    }
                }
                fw.write(",");
                fw.close();
        }

        /////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("Estado de lista 2: " + lista2.size());
        /////////////////////////////////////////////////////////////////////////////////////////////////
        if(lista2.isEmpty() == false){
            System.out.println("Entra a file 2");
            FileWriter fw = new FileWriter("W2.txt");
            for(int i = 0; i<lista2.size();i++){
                if(i == 0){
                fw.write(Integer.toString(lista2.get(i)));
                }          
                else
                {
                    fw.write(",");
                    fw.write(Integer.toString(lista2.get(i)));
                }
            }
            fw.write(",");
            fw.close();
        }
        
        if(lista1.isEmpty()){ // quiero cambiar W1 con claves
            Swap(destino,F1);
        }
        else if(lista2.isEmpty()){ // quiero cambiar W2 con claves
            Swap(destino,F2);
        }*/
    }
    
    
    public void CombinacionMenor(String F1, String F2, String destino) throws IOException{
        FileWriter w = new FileWriter(destino);
        FileReader r1 = new FileReader(F1);
        BufferedReader b1 = new BufferedReader(r1);
        FileReader r2 = new FileReader(F2);
        BufferedReader b2 = new BufferedReader(r2);
        List<Integer> lista1 = new LinkedList<>();
        List<Integer> lista2 = new LinkedList<>();
        List<Integer> listaAux = new LinkedList<>();
        List<Integer> listaAux2 = new LinkedList<>();
        
        String text1 = b1.readLine();
        String[] claves1 = text1.split(",");
        
        String text2 = b2.readLine();
        String[] claves2 = text2.split(",");
        
        for(int i = 0; i<claves1.length; i++){
            //valor = Integer.valueOf(claves[i]);
            lista1.add(Integer.parseInt(claves1[i]));
        }
        
        for(int i = 0; i<claves2.length; i++){
            //valor = Integer.valueOf(claves[i]);
            lista2.add(Integer.parseInt(claves2[i]));
        }
        
        r1.close();
        b1.close();
        r2.close();
        b2.close();
        
        int x,y;
        boolean first = true;
        
        while( ( lista1.isEmpty() == false ) && ( lista2.isEmpty() == false ) ){
            //int[] aux = new int[4];
            // intercalacion de 2 bloques de 4 elementos
            if( !lista1.isEmpty() && !lista2.isEmpty() ){
                if(lista1.size() > index && lista2. size() > index){
                    x = index;
                    for(int i = 0; i < x; i++){
                        listaAux.add(lista1.remove(0));
                    }
                    for(int i = 0; i < x; i++){
                        listaAux2.add(lista2.remove(0));
                    }
                }
                else{
                    x = lista1.size();
                    y = lista2.size();
                    for(int i = 0; i < x; i++){
                        listaAux.add(lista1.remove(0));
                    }
                    for( int i = 0; i < y; i++){
                        listaAux2.add(lista2.remove(0));
                    }
                }
            }
                
                // En este punto ya tenemos ambas listas auxiliares, procederemos a combinarlas por medio de una intercalacion
                
            
            Comparator<Integer> cmp = Collections.reverseOrder();
            Collections.sort(listaAux, cmp);  
            Collections.sort(listaAux2, cmp);
            
            first = true;
            /*
            end = true;
            for(int i = 0; i < listaAux.size(); i++){
                for( int j = 0; j < listaAux2.size(); j++){
                    if( listaAux.get(i) > listaAux2.get(j) ){
                        System.out.println(listaAux.get(i) + ">" + listaAux2.get(j));
                    }
                    else{
                        System.out.println(listaAux.get(i) + " < " + listaAux2.get(j));
                        end = false;
                    }
                }
            }
            */
            while( !listaAux.isEmpty() && !listaAux2.isEmpty() ){
                if(listaAux.get(0) > listaAux2.get(0) ){
                    //listaAux.remove(0);
                    //System.out.println(i);
                    if(first == true){
                        w.write(Integer.toString(listaAux.remove(0)));
                        first = false;
                    }          
                    else
                    {
                        w.write(",");
                        w.write(Integer.toString(listaAux.remove(0)));
                    }
                }
                else{
                    if(first == true){
                        w.write(Integer.toString(listaAux2.remove(0)));
                        first = false;
                    }          
                    else
                    {
                        w.write(",");
                        w.write(Integer.toString(listaAux2.remove(0)));
                    }
                }
            }
            w.write(",");
            
            if( !listaAux.isEmpty() ){
                //escribir todo el restante en el documento
                x = listaAux.size();
                for(int i = 0; i<x; i++){
                    //System.out.println(i);
                    if(i == 0){
                        w.write(Integer.toString(listaAux.remove(0)));
                    }          
                    else
                    {
                        w.write(",");
                        w.write(Integer.toString(listaAux.remove(0)));
                    }
                }
                w.write(",");
                
            }
            else if( !listaAux2.isEmpty()){
                //Igual :v
                x = listaAux2.size();
                for(int i = 0; i<x; i++){
                    //System.out.println(i);
                    if(i == 0){
                        w.write(Integer.toString(listaAux2.remove(0)));
                    }          
                    else
                    {
                        w.write(",");
                        w.write(Integer.toString(listaAux2.remove(0)));
                    }
                }
                w.write(",");
            }
            /*
            System.out.println("Lista: " + listaAux.size());
            ImprimirLista(listaAux);
            */
            /*++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            x = listaAux.size();
            for(int i = 0; i<x; i++){
                //System.out.println(i);
                if(i == 0){
                    w.write(Integer.toString(listaAux.remove(0)));
                }          
                else
                {
                    w.write(",");
                    w.write(Integer.toString(listaAux.remove(0)));
                }
            }
            w.write(",");
            ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
            // System.out.println("Lista \"Vacia\": " + listaAux.size());
            //ImprimirLista(listaAux);
       }
        prev = index;
        index += aux;
        aux = prev;
        
        /*
        
        */
        
        /*
        while(lista1.isEmpty() == false){
            int[] aux = new int[1];
            aux[0] = lista1.remove(0);
                    for(int i = 0; i<1; i++){
                        if(i == 0){
                            w.write(Integer.toString(aux[i]));
                        }          
                        else
                        {
                            w.write(",");
                            w.write(Integer.toString(aux[i]));
                        }
                    }
                    w.write(",");
        }
        while(lista2.isEmpty() == false){
            int[] aux = new int[1];
            aux[0] = lista2.remove(0);
                    for(int i = 0; i<1; i++){
                        if(i == 0){
                            w.write(Integer.toString(aux[i]));
                        }          
                        else
                        {
                            w.write(",");
                            w.write(Integer.toString(aux[i]));
                        }
                    }
                    w.write(",");
        }
        */
        w.close();
        /*
        /////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("Estado de lista 1: " + lista2.size());
        /////////////////////////////////////////////////////////////////////////////////////////////////
        if(lista1.isEmpty() == false){
            System.out.println("Entra a file 1");
            FileWriter fw = new FileWriter("W1.txt");
            for(int i = 0; i<lista1.size();i++){
                if(i == 0){
                        fw.write(Integer.toString(lista1.get(i)));
                    }          
                    else
                    {
                        fw.write(",");
                        fw.write(Integer.toString(lista1.get(i)));
                    }
                }
                fw.write(",");
                fw.close();
        }

        /////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("Estado de lista 2: " + lista2.size());
        /////////////////////////////////////////////////////////////////////////////////////////////////
        if(lista2.isEmpty() == false){
            System.out.println("Entra a file 2");
            FileWriter fw = new FileWriter("W2.txt");
            for(int i = 0; i<lista2.size();i++){
                if(i == 0){
                fw.write(Integer.toString(lista2.get(i)));
                }          
                else
                {
                    fw.write(",");
                    fw.write(Integer.toString(lista2.get(i)));
                }
            }
            fw.write(",");
            fw.close();
        }
        
        if(lista1.isEmpty()){ // quiero cambiar W1 con claves
            Swap(destino,F1);
        }
        else if(lista2.isEmpty()){ // quiero cambiar W2 con claves
            Swap(destino,F2);
        }*/  
        lista1.clear();
        lista2.clear();
        listaAux.clear();
    }
    
    public int getClaves(String F1) throws FileNotFoundException, IOException{
        FileReader r = new FileReader(F1);
        BufferedReader b = new BufferedReader(r);
        List<Integer> lista = new LinkedList<>();
        List<Integer> listaAux = new LinkedList<>();
        
        String text = b.readLine();
        String[] claves = text.split(",");
        //int[] valor = new int[claves.length];
        
        return claves.length;
    }
    
    public void Swap(String origen, String destino) throws FileNotFoundException, IOException{
            FileReader fr = new FileReader(origen);
            BufferedReader bf = new BufferedReader(fr);
            String text = bf.readLine();
            String[] claves = text.split(",");
            
            FileWriter fw = new FileWriter(destino);
            for(int i = 0; i< claves.length; i++){
                if(i == 0){
                fw.write(claves[i]);
                }          
                else
                {
                    fw.write(",");
                    fw.write(claves[i]);
                }
            }
            
            fr.close();
            bf.close();
            fw.write(",");
            fw.close();
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
    
    public void ImprimirLista(List<Integer> lista){
        for(int i = 0; i < lista.size(); i++){
            System.out.print(lista.get(i) + ", ");
        }
    }
}
