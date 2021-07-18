
//package proyectoordenamientoexterno;

import java.io.*;
import java.util.*;
import java.util.Scanner;
 
public class Radixsort {
    Scanner opcion = new Scanner(System.in);//escanes para la opcion de ascendente o descendente
    
    public int getMax(int arr[], int n)//esta funcion sirve para encontrar el numero maximo del arreglo
    {
        int max = arr[0];
        for (int i=1; i<n; i++){
            if (arr[i] > max){ //compara todo el arreglo hasta encontrar el maximo
                max = arr[i]; //se guarda el numero maximo
            }
        }    
        return max;
    }
 
    
    public void countAscendente(int arr[], int n, int exp){
        int output[] = new int[n]; //este se utiliza para guardar las iteraciones con el tamaño del arreglo
        int i;//el indice
        int count[] = new int[10];//este va a contar y guardar los numeros dependiendo su orden de 0,1,2 etc
        Arrays.fill(count, 0);//cambia todos los elementos del arreglo por un valor estatico, de hecho no hace nada debi borrarlo xd
       
        for(i=0; i<n; i++){
            count[(arr[i]/exp) % 10]++; //cuenta cuantas veces se repiten y guarda los numeros 0,1,2,etc en unidades, decenas y centenas dependiendo la iteracion exp valdra 1, 10, 100 etc
        }
        
        for(i=1; i<10; i++){
            count[i] += count[i - 1];//acomoda las posiciones reales para contruir el output
        }
        
        for(i=n-1; i>=0; i--) {
            output[--count[(arr[i] / exp) % 10] ] = arr[i]; //aqui es donde se arregla,el indice de output es lo guardado en count
        }                                                   //el -- es porque cada iteracion tiene que ir del 0,1,2 etc
                                                            //si en el indice de los 0 se encuentra un cero del arr se va a guardar en el output

        for(i =0; i<n; i++){
            arr[i] = output[i]; //guarda el output ordenado en el arreglo original
        }
    }

    public void countDescendente(int arr[], int n, int exp)throws IOException{
        int output[] = new int[n]; //este se utiliza para guardar las iteraciones con el tamaño del arreglo
        int i;
        int count[] = new int[10];//este va a contar y guardar los numeros dependiendo su orden pero ahora en 9,8,7 etc
        Arrays.fill(count, 0);//cambia todos los elementos del arreglo por un valor estatico, de hecho no hace nada debi borrarlo xd
       
        for(i=0; i<n; i++){
            count[9-(arr[i] / exp) % 10]++; //cuenta cuantas veces se va a repetir pero ahora va en 9,8,7,6 etc 
        }
        
        for(i=1; i<10; i++){
            count[i] += count[i - 1];//acomoda las posiciones reales para contruir el output
        }
        
        for(i=n-1; i>=0; i--){
            output[--count[9-(arr[i] / exp) % 10] ] = arr[i];//aqui es donde se arregla,el indice de output es lo guardado en count
        }                                                   //el -- es porque cada iteracion tiene que ir del 9,8,7 etc
                                                            //si en el indice de los 9 se encuentra un cero del arr se va a guardar en el output
        

        for(i =0; i<n; i++){
            arr[i] = output[i];//guarda el output ordenado en el arreglo original
            
        }
    }
    
    public void radix(String nombrearchivo)throws FileNotFoundException, IOException{
        FileReader lectura = new FileReader(nombrearchivo);//aqui lee el archivo 
        BufferedReader buff = new BufferedReader(lectura);
        String linea = buff.readLine();
        String[] key = linea.split(",");
        int c[] = new int[key.length]; //estas lineas sirven para pasar el documento a un arreglo
        for(int i=0; i<key.length; i++){
            c[i]=Integer.parseInt(key[i]);
        }
        radixsort(c, c.length);
    }
    
    public void radixsort(int arr[], int n)throws IOException{
        int x = getMax(arr, n); //se encuentra el numero maximo para mas adelante usarlo en el ciclo 
        FileWriter fq = new FileWriter("FQ.txt");
        System.out.println("Seleccione en que orden desea ordenar el documento\n1)Ascendente\n2)Descendente");
        int y = opcion.nextInt();
        switch(y){
            case 1:
                for(int exp=1; x/exp>0; exp*=10){//aqui al dividirlo con exp saca unidades, decenas y centenas
                    countAscendente(arr, n, exp);//lo manda al metodo que saca el metodo ascendente
                    System.out.println("FQ:");
                    print(arr, arr.length);
                    for(int i=0; i<arr.length; i++){//guarda las iteraciones
                        fq.write(arr[i]+",");
                    }
                }
                break;
            case 2:
                for(int exp=1; x/exp>0; exp*=10){//lo mismo con el ciclo de arriba
                    countDescendente(arr, n, exp);//lo manda al metodo que saca el metodo descendente
                    System.out.println("FQ:");
                    print(arr, arr.length);
                    for(int i=0; i<arr.length; i++){//guarda las iteraciones
                        fq.write(arr[i]+",");
                    }
                }
                break;
            default: 
                System.out.println("Opcion no valida");
        }
        FileWriter archivo = new FileWriter("ArchivoOrdenado.txt");
        
        for(int i=0; i<arr.length; i++){
            archivo.write(arr[i]+",");//guarda el archivo ordenado
        }
        archivo.close();
        fq.close();
        System.out.println("Archivo Ordenado Correctamente");
    }  
    
    public void print(int arr[], int n)//imprime los arreglos
    {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.print("\n");
    }
}
