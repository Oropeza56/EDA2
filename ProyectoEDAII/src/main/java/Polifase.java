
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
        
        while(lista.isEmpty() == false){
           int x = (int)((lista.size()/2)+1);
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
           x = (int)((lista.size()/2)+1);
           if( (lista.isEmpty() == false) && lista.size() >= x  ){
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
        
        while( ( lista1.isEmpty() == false ) && ( lista2.isEmpty() == false ) ){
            //int[] aux = new int[4];
            int x = lista1.size();
            if( (lista1.isEmpty() == false) && x >= (int)(Math.sqrt(lista1.size())+1) ){
                x = (int)(Math.sqrt(lista1.size())+1);
                for(int i = 0; i <  x; i++){
                    listaAux.add(lista1.remove(0));
                }
                /*
                aux[0] = lista1.remove(0);
                aux[1] = lista1.remove(0);
                aux[2] = lista1.remove(0);
                aux[3] = lista1.remove(0);
                for(int i = 0; i<4; i++){
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
                */
            }
            else if((lista1.isEmpty() == false) && lista1.size() < (int)(Math.sqrt(lista1.size())+1) && lista1.size() > 0){
                x = (int)(Math.sqrt(lista1.size())+1);
                for(int i = 0; i < x; i++){
                    listaAux.add(lista1.remove(0));
                }
                /*
                aux[0] = lista1.remove(0);
                aux[1] = lista1.remove(0);
                aux[2] = lista1.remove(0);
                for(int i = 0; i<3; i++){
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
                */
            }
            /*
            else if( (lista1.isEmpty() == false) && lista1.size() == 2 ){
                aux[0] = lista1.remove(0);
                aux[1] = lista1.remove(0);
                for(int i = 0; i<2; i++){
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
            else if ((lista1.isEmpty() == false)) {
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
            */
            //aux = new int[4];
            x = lista2.size();
            if( (lista2.isEmpty() == false) && x >= (int)(Math.sqrt(lista2.size())+1)  ){
                x = (int)(Math.sqrt(lista2.size())+1);
                for(int i = 0; i < x; i++){
                    listaAux.add(lista2.remove(0));
                }
                /*
                aux[0] = lista2.remove(0);
                aux[1] = lista2.remove(0);
                aux[2] = lista2.remove(0);
                aux[3] = lista2.remove(0);
                for(int i = 0; i<4; i++){
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
                */
            }
            else if((lista2.isEmpty() == false) && x < (int)(Math.sqrt(lista2.size())+1) && lista2.size() > 0){
                x = (int)(Math.sqrt(lista2.size())+1);
                for(int i = 0; i < x; i++){
                    listaAux.add(lista2.remove(0));
                }
                /*
                aux[0] = lista2.remove(0);
                aux[1] = lista2.remove(0);
                aux[2] = lista2.remove(0);
                for(int i = 0; i<3; i++){
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
                */
            }
            /*
            else if((lista2.isEmpty() == false) && lista2.size() == 2){
                aux[0] = lista2.remove(0);
                aux[1] = lista2.remove(0);
                for(int i = 0; i<2; i++){
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
            else if((lista2.isEmpty() == false)){
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
            Collections.sort(listaAux);
            /*
            System.out.println("Lista: " + listaAux.size());
            ImprimirLista(listaAux);
            */
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
            // System.out.println("Lista \"Vacia\": " + listaAux.size());
            //ImprimirLista(listaAux);
       }
        
        if(lista1.isEmpty() == false){
            int x = lista1.size();
            for(int i = 0; i < x ;i++){
                listaAux.add(lista1.remove(0));
            }
            Collections.sort(listaAux);
            /*
            System.out.println("Lista: ");
            ImprimirLista(listaAux);
            */
            x = listaAux.size();
            for(int i = 0; i<x; i++){
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
        if(lista2.isEmpty() == false){
            int x = lista2.size();
            for(int i = 0; i < x;i++){
                listaAux.add(lista2.remove(0));
            }
            /*
            System.out.println("Lista: " + listaAux.size());
            Collections.sort(listaAux);
            */
            x = listaAux.size();
            for(int i = 0; i<x; i++){
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
    
    public void Swap(String origen, String destino) throws FileNotFoundException, IOException{
            FileReader fr = new FileReader(origen);
            BufferedReader bf = new BufferedReader(fr);
            String text = bf.readLine();
            String[] claves = text.split(",");
            fr.close();
            bf.close();
            
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
            fw.write(",");
            fw.close();
            
            fw = new FileWriter(origen);
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
