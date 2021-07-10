
//package proyectoordenamientoexterno;


import java.io.*;
import java.util.*;
import java.util.Scanner;
 
public class Radixsort {
    int c[] = new int[500];
    Scanner opcion = new Scanner(System.in);
    
    public int getMax(int arr[], int n)
    {
        int max = arr[0];
        for (int i=1; i<n; i++){
            if (arr[i] > max){
                max = arr[i];
            }
        }    
        return max;
    }
 
    
    public void countAscendente(int arr[], int n, int exp){
        int output[] = new int[n]; 
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);
       
        for(i=0; i<n; i++){
            count[(arr[i] / exp) % 10]++;
        }
        
        for(i=1; i<10; i++){
            count[i] += count[i - 1];
        }
        
        for(i=n-1; i>=0; i--) {
            output[--count[(arr[i] / exp) % 10] ] = arr[i];
        }

        for(i =0; i<n; i++){
            arr[i] = output[i];
        }
    }

    public void countDescendente(int arr[], int n, int exp){
        int output[] = new int[n]; 
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);
       
        for(i=0; i<n; i++){
            count[9-(arr[i] / exp) % 10]++;
        }
        
        for(i=1; i<10; i++){
            count[i] += count[i - 1];
        }
        
        for(i=n-1; i>=0; i--) {
            output[--count[9-(arr[i] / exp) % 10] ] = arr[i];
        }

        for(i =0; i<n; i++){
            arr[i] = output[i];
        }
    }
    
    public void radix(String nombrearchivo)throws FileNotFoundException, IOException{
        FileReader lectura = new FileReader(nombrearchivo);
        BufferedReader buff = new BufferedReader(lectura);
        String linea = buff.readLine();
        String[] key = linea.split(",");
        
        for(int i=0; i<key.length; i++){
            c[i]=Integer.parseInt(key[i]);
        }
        radixsort(c, 500);
    }
    
    public void radixsort(int arr[], int n)throws IOException{
        int x = getMax(arr, n);
        System.out.println("Seleccione en que orden desea ordenar el documento\n1)Ascendente\n2)Descendente");
        int y = opcion.nextInt();
        switch(y){
            case 1:
                for(int exp=1; x/exp>0; exp*=10){
                    countAscendente(arr, n, exp);
                }
                break;
            case 2:
                for(int exp=1; x/exp>0; exp*=10){
                    countDescendente(arr, n, exp);
                }
                break;
            default: 
                System.out.println("Opcion no valida");
        }
        FileWriter archivo = new FileWriter("ArchivoOrdenado.txt");
        int cantidad = 500;
        
        for(int i=0; i<cantidad; i++){
            archivo.write(c[i]+",");
        }
        archivo.close();
        System.out.println("Archivo Ordenado Correctamente");
    }  
}
