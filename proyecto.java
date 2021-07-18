//package mezclaEquilibrada;

import java.util.*;
import java.io.*;

class inicio{
	public static void main (String[] args)throws IOException{
 try{
   
  System.out.print("\n Ingresa el nombre del archivo, agregando extension: ");
	Scanner sc = new Scanner(System.in);
	String s = sc.nextLine();
		File f = new File (s);
		boolean resp =true;
do{ 
   	System.out.println("\n¿Que algoritmo desea ocupar?: \n(1) RadixSort\n(2) Mezcla Equilibrada");
   		Scanner qw = new Scanner(System.in);
   		int opci = qw.nextInt();
   
   		switch(opci){
   			case 1:
   			Radixsort r = new Radixsort();
   			r.radix(s);
   			break;
   
   			case 2:
   
   		System.out.println("En orden ascendente(1) o descendente(2))");
   	  Scanner ss = new Scanner(System.in);
   	  int opc = ss.nextInt();
   
   	  switch(opc){
   	  	case 1:
   		 	mezclaEquilA m = new mezclaEquilA();
   			System.out.print("F0: ");   
   			m.imprimirArchivo(f);  //Imprime el archivo con las claves 
   			while(m.revision(f)==false){  //Mientras las claves no estan ordenadas de manera ascendente
   					m.mezcla(f); // Entra al metodo de mezcla equilibrada
   		  }
   	  	break;
   
   	  	case 2:
   		  mezclaEquilD mi = new mezclaEquilD();
   			System.out.print("F0: ");
   			mi.imprimirArchivo(f);  //Imprime el archivo con las claves 
   			while(mi.revision(f)==false){  //Mientras las claves no estan ordenadas de manera descendente
   					mi.mezcla(f); // Entra al metodo de mezcla equilibrada
   		  }
   	  	break;
   	  }
   
   			break;
   
   		}
   		System.out.print("¿Desea probar con otro metodo? s/n");
   		Scanner we = new Scanner(System.in);
   		String res = we.nextLine();
   		if("s".equals(res)){
   			resp = true;
   		}
   		else if("n".equals(res)){
   			resp = false;
   		}

   	}while(resp == true);
    }catch (Exception e2){
     e2.printStackTrace();
    }		
	}
}


class mezclaEquilA{
	public static void mezcla(File f) throws FileNotFoundException, IOException{
	
	  FileWriter fw= null;
	    
	if (f.exists()){ // Se verifica si el archivo existe 
//	SI EXISTE EL ARCHIVO..
       List<Integer> elementos = new LinkedList<>(); //Todas las claves del archivo F0 se almacenaran en esta lista 

  try{	 
	  //SE CREAN LOS ARCHIVOS AUXILIARES f1 Y f2
  File f1 = new File ("num01.txt");  //
	  File f2 = new File ("num02.txt");
  		

      	FileReader fr = new FileReader(f);
	     BufferedReader b = new BufferedReader(fr);

	    String linea = b.readLine();	//Se leen todas las claves del archivo y se guardan en un String
	    String[] key = linea.split(","); //Se guardan las claves en un array de String, omitiendo las comas
	     for(int i = 0; i<key.length; i++){
           
            elementos.add(Integer.parseInt(key[i])); // Se convierte cada string de ese array en un dato de tipo int, y se guarda en la lista
		     //En esta lista (elementos) siempre se guardan los datos del archivo F0
        }

	     particion(elementos, f1, f2); // Se hace la llamada al metodo particion, se ocupa la lista de elementos y dos archivos auxiliares 
	     fusion(f, f1, f2); //Despues de hacer la particion, se realiza la fusion, en este metodo ocupamos el archivo original, y los dos archivos auxiliares
	   
	   
		}catch (Exception e2){
	       e2.printStackTrace();
		}
			
	}else{
		System.out.println("El archivo no existe");
	}

  }


public static void particion(List <Integer> l, File f1, File f2){
  	// Aqui se realiza la particion de los elemntos del archivo F0
  		try{
  		int i=0;
	     BufferedWriter bw1 = new BufferedWriter(new FileWriter (f1));
	     BufferedWriter bw2 = new BufferedWriter(new FileWriter (f2));

  		 List<List> listaT = new LinkedList<>();
  	     List<Integer> aux = new LinkedList<>();
  	     List<Integer> aux2 = new LinkedList<>();
  	     int indice =0;
  	     int ind =0;
  	     int indi=0;
  	     int izquierda=0;
  	     int izq=0;
  	     int derecha = l.size()-1;
  	     int der =derecha;
 bw1.flush();
  	while (izquierda < derecha){ //Se recorre toda la lista de claves del archivo F0 
  		izq = izquierda;
  		 while (izq < derecha && l.get(izq) <= l.get(izq+1)){ //Se verifica que aun no se llegue al final de la lista y 
  		 	izq++;                                        //que los elementos se tomen de manera ascendente 
			 					     // Se detiene cuando el elemento anterior es mayor que el siguiente
  		 }

  		 bw1.write("[");
  		  while (indice<= izq ){
  		 	aux.add(indi, l.get(indice));
  		 	bw1.write(Integer.toString(aux.get(indi)));  //Con ayuda de la variable IZQ sacamos los elementos de la lista principal por medio del indice
			  					    // Y los escribimos en el primer archivo auxiliar F1
	    	bw1.write(",");					   // Los elementos que saquemos de la lista principal van entre corchetes y separados por comas
  		 	indice++;				   // [a,b,c,d ]	
  		 	indi++;
  		 }
	    bw1.write("]");

  		 der =izq + 1;        //Para la siguiente particion, tomamos la posicion donde habiamos llegado en la particion para el archivo 1
  		 while( der < derecha && l.get(der)<= l.get(der+1)){ // Se verifica que aun no se llegue al final de la lista, y que los elementos que se lleguen  
  		 	der++;					     // a tomar, esten ordenados de manera ascendente
  		 }

  		 bw2.write("[");
  		 while(indice <= der && indice <= derecha){         //Con ayuda del la variable DER sacamos los elementos de la lista principal por medio del indice
  		 	aux2.add(ind, l.get(indice));		   // Y los escribimos en el archivo auxiliar F2	
  		 	bw2.write(Integer.toString(aux2.get(ind))); // De igual manera los elementos que saquemos de la lista principal para F2, van separados
	    	bw2.write(",");					   // por comas y entre corchetes
  		 	indice++;
  		 	ind++;
  		 }
  		 bw2.write("]");

  		 izquierda = der +1; //Se actualiza la posicion en la lista
  	}
  	  	 //Cuando terminamos de revisar toda la lista, y de haber realizado todas las particiones necesarias...
	    bw1.close();  // Cerramos el archivo F1 y F2
	    bw2.close();
	    System.out.print("\nF1: ");
	    imprimirArchivo(f1); // Imprimimos las bloques de claves de los archivos auxiliares F1 y F2
			// Practicamente se verian asi:  [a,b,c],[d,e,f],[z], 
	    
	    System.out.print("\nF2: ");
	    imprimirArchivo(f2); 
	    
  	}catch (Exception e2){
	       e2.printStackTrace();
		}

  }

  public static void fusion (File f, File f1, File f2)throws FileNotFoundException, IOException{ 
  //Aqui realizamos la fusion de los bloques de los archivos f1 y f2
  try{
  BufferedWriter bw = new BufferedWriter(new FileWriter (f));
  
    	FileReader fr1 = new FileReader(f1);
	     BufferedReader b1 = new BufferedReader(fr1);
	     	FileReader fr2 = new FileReader(f2);
	     		BufferedReader b2 = new BufferedReader(fr2);
	          List<String> l = new LinkedList<>(); //Lista aux 1
   	          List<String> l2 = new LinkedList<>(); // Lista aux 2


    String linea = b1.readLine(); // se lee el contenido de archivo F1 Y F2	      
     String[] key = linea.split("\\]"); //Se guardan los datos por bloques en arreglos, omitiendo "]"
       String linea2 =b2.readLine();
        String[] key2 = linea2.split("\\]");

     for (int i= 0; i< key.length || i<key2.length; i++ ) { //Como condicion estan el tamaño de ambas listas
     	l.add(i,key[i].replace("[", "") + key2[i].replace("[", "") ); //Se agrega en la lista aux1, el (primer, segundo, tercer, ..., n) bloque de datos de ambos arreglos
     								      //se concatenan los datos y  se les quita el "["
	     l2.add(i , ordenar(l.get(i))); //En la lista aux2, se agregan los datos ya concatenados y se llama al metodo ordenar, el cual pide un String
	     					//Cuando se agregan elementos en la lista aux2, se agregan ya ordenados 
     }

	  //Cuando se termina de fusionar y ordenar los elementos... 
       for(int i = 0; i <l2.size(); i++){
       	bw.write(l2.get(i)); // Se escriben todos los datos de la lista aux2, en el archivo F0
	    	bw.write(","); //Se separan por comas
       }

       bw.close(); //Se cierra el archivo F0
      System.out.print("\nF0: ");
       imprimirArchivo(f);  //Se imprime el archivo F0

     }catch (Exception e2){
	       e2.printStackTrace();
		 }
  }

  public static void imprimirArchivo(File f) throws FileNotFoundException, IOException{ //Con este metodo imprimimos el contenido de los archivos
  	String cadena;
  		FileReader fr = new FileReader(f);
	     BufferedReader b = new BufferedReader(fr);
	     while((cadena = b.readLine()) != null){
	     	System.out.println(cadena);
	     }
	     b.close();

  }

  public static String ordenar(String l1){ // Se ocupa el string que obtuvimos en el metodo fusion 
  	String r = null;
  	 String a = null;  
   	   String[] arr = l1.split(","); //Guardamos cada dato del string en un arreglo, omitiendo las comas 
		     	int[] arre = new int[arr.length]; 

       for (int j= 0; j< arr.length; j++ ) {
		     	arre[j] =Integer.parseInt(arr[j]); //Cada elemento del arreglo de String, lo convertimos en un int y lo guardamos en el arreglo "arre"
	     }
		 
		 sortR(arre); //Con dicho arreglo, llamamos al metodo sortR para ordenar dicho arreglo de manera ascendente, se ocupa SelectionSort para ordenar el arreglo
		
		 r = Arrays.toString(arre); //convertimos el arreglo en un string, el cual lo convierte de esto a,b,c a esto [a,b,c]
		 a = r.replace("[", ""); //Quitamos "[" 
		 r = a.replace("]", ""); //Luego quitamos este "]"
		 a =r.replace(" ", ""); // Y quitamos todos los espacios 

		 return a; //Devolvemos un string con los datos ya ordenados
  }
 public static int[] sortR (int[] a){ //Con este metodo ordenamos los arreglos que nos pase el metodo ordenar 

   int n = a.length;
   for (int i =0; i < n-1 ; i++) {
   	int min = i;
   	for(int j= i+1; j < n; j++ ) {

   		if(a[j] < a[min]){
   			min = j;
   		}
   	}
   	if(i != min){
   		int t = a[i];
   		a[i]= a[min];
   		a[min]=t;
   	}
   }
   
   return a; //Regresamos el array ordenado
 }

  public static boolean revision (File f)throws FileNotFoundException, IOException{ //Con este metodo verificamos si el archivo a sido ordenado de manera 
  	boolean rev = true;								// ascendente, comparando el elemento anterior con el elemento siguiente
  	FileReader fr = new FileReader(f);
	  BufferedReader b = new BufferedReader(fr);
    List<Integer> lista = new LinkedList<>();

	    String linea = b.readLine();	
	    String[] key = linea.split(",");
	     
	     for(int i = 0; i<key.length; i++){
           lista.add(Integer.parseInt(key[i]));
        }

  	int j=0;
  	while(rev && j<lista.size()-1){
  			if (lista.get(j) <= lista.get(j+1)){
  			  rev = true;
  			}else{
  				rev = false;
  			}
  			j++;
  		}

  		return rev;
  }

}

class mezclaEquilD{
	public static void mezcla(File f) throws FileNotFoundException, IOException{
	
	
	  FileWriter fw= null;
	    
	if (f.exists()){

       List<Integer> elementos = new LinkedList<>();
	     List<Integer> element = new LinkedList<>();

	     List<Integer> el2 = new LinkedList<>();	     
  		 List<List> lista = new LinkedList<>();  	

  try{	 
  File f1 = new File ("num01.txt");
	  File f2 = new File ("num02.txt");
  		

      	FileReader fr = new FileReader(f);
	     BufferedReader b = new BufferedReader(fr);

	    String linea = b.readLine();	
	    String[] key = linea.split(",");
	     for(int i = 0; i<key.length; i++){
           
            elementos.add(Integer.parseInt(key[i]));
        }

	     particion(elementos, f1, f2);
	     fusion(f, f1, f2);
	   
	   
		}catch (Exception e2){
	       e2.printStackTrace();
		}
			
	}else{
		System.out.println("El archivo no existe");
	}

  }


public static void particion(List <Integer> l, File f1, File f2){
  	
  		try{
  		int i=0;
	     BufferedWriter bw1 = new BufferedWriter(new FileWriter (f1));
	     BufferedWriter bw2 = new BufferedWriter(new FileWriter (f2));

  		 List<List> listaT = new LinkedList<>();
  	     List<Integer> aux = new LinkedList<>();
  	     List<Integer> aux2 = new LinkedList<>();
  	     int indice =0;
  	     int ind =0;
  	     int indi=0;
  	     int izquierda=0;
  	     int izq=0;
  	     int derecha = l.size()-1;
  	     int der =derecha;
 bw1.flush();
  	while (izquierda < derecha){
  		izq = izquierda;
  		 while (izq < derecha && l.get(izq) >= l.get(izq+1)){
  		 	izq++;
  		 }

  		 bw1.write("[");
  		  while (indice<= izq ){
  		 	aux.add(indi, l.get(indice));
  		 	bw1.write(Integer.toString(aux.get(indi)));
	    	bw1.write(",");
  		 	indice++;
  		 	indi++;
  		 }
	    bw1.write("]");

  		 der =izq + 1;
  		 while( der < derecha && l.get(der) >= l.get(der+1)){
  		 	der++;
  		 }

  		 bw2.write("[");
  		 while(indice <= der && indice <= derecha){
  		 	aux2.add(ind, l.get(indice));
  		 	bw2.write(Integer.toString(aux2.get(ind)));
	    	bw2.write(",");
  		 	indice++;
  		 	ind++;
  		 }
  		 bw2.write("]");

  		 izquierda = der +1;
  	}
  	  	 
	    bw1.close();
	    bw2.close();
	    System.out.print("F1: ");
	    imprimirArchivo(f1);
	    
	    System.out.print("F2: ");
	    imprimirArchivo(f2);
	    
  	}catch (Exception e2){
	       e2.printStackTrace();
		}

  }

  public static void fusion (File f, File f1, File f2)throws FileNotFoundException, IOException{
  
  try{
  BufferedWriter bw = new BufferedWriter(new FileWriter (f));
  
    	FileReader fr1 = new FileReader(f1);
	     BufferedReader b1 = new BufferedReader(fr1);
	     	FileReader fr2 = new FileReader(f2);
	     		BufferedReader b2 = new BufferedReader(fr2);
	          List<String> l = new LinkedList<>();
   	          List<String> l2 = new LinkedList<>();


    String linea = b1.readLine();	      
     String[] key = linea.split("\\]");
       String linea2 =b2.readLine();
        String[] key2 = linea2.split("\\]");


     for (int i= 0; i< key.length || i<key2.length; i++ ) {
     	l.add(i,key[i].replace("[", "") + key2[i].replace("[", "") );
     	l2.add(i , ordenar(l.get(i)));
     }

       for(int i = 0; i <l2.size(); i++){
       	bw.write(l2.get(i));
	    	bw.write(",");
       }

       bw.close();
      System.out.print("\nF0: ");
       imprimirArchivo(f);

     }catch (Exception e2){
	       e2.printStackTrace();
		 }
  }

  public static void imprimirArchivo(File f) throws FileNotFoundException, IOException{
  	String cadena;
  		FileReader fr = new FileReader(f);
	     BufferedReader b = new BufferedReader(fr);
	     while((cadena = b.readLine()) != null){
	     	System.out.println(cadena);
	     }
	     b.close();

  }

  public static String ordenar(String l1){
  	String r = null;
  	 String a = null;  
   	   String[] arr = l1.split(",");
		     	int[] arre = new int[arr.length];

       for (int j= 0; j< arr.length; j++ ) {
		     	arre[j] =Integer.valueOf(arr[j]);
	     }

	  sortR(arre);

		 r = Arrays.toString(arre);
		 a = r.replace("[", "");
		 r = a.replace("]", "");
		 a =r.replace(" ", "");

		 return a;
  }

   public static int[] sortR (int[] a){

   int n = a.length;
   for (int i =0; i < n-1 ; i++) {
   	int min = i;
   	for(int j= i+1; j < n; j++ ) {
   			//System.out.print(a[min] + " < " + a[j]  );

   		if(a[j] > a[min]){
   			min = j;
   		}
   	}
   	if(i != min){
   		int t = a[i];
   		a[i]= a[min];
   		a[min]=t;
   	}
   }
   
   return a;
 }


  public static boolean revision (File f)throws FileNotFoundException, IOException{
  	boolean rev = true;
  	FileReader fr = new FileReader(f);
	  BufferedReader b = new BufferedReader(fr);
    List<Integer> lista = new LinkedList<>();

	    String linea = b.readLine();	
	    String[] key = linea.split(",");
	     
	     for(int i = 0; i<key.length; i++){
           lista.add(Integer.parseInt(key[i]));
        }

  	int j=0;
  	while(rev && j<lista.size()-1){
  			if (lista.get(j) >= lista.get(j+1)){
  			  rev = true;
  			}else{
  				rev = false;
  			}
  			j++;
  		}

  		return rev;
  }

}



class Radixsort {
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
            count[(arr[i]/exp) % 10]++;
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

    public void countDescendente(int arr[], int n, int exp)throws IOException{
        FileWriter archivo = new FileWriter("F0.txt");
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
        
        for(i=n-1; i>=0; i--){
            output[--count[9-(arr[i] / exp) % 10] ] = arr[i];
        }

        for(i =0; i<n; i++){
            arr[i] = output[i];
            
        }
        archivo.close();
    }
    
    public void radix(String nombrearchivo)throws FileNotFoundException, IOException{
        FileReader lectura = new FileReader(nombrearchivo);
        BufferedReader buff = new BufferedReader(lectura);
        String linea = buff.readLine();
        String[] key = linea.split(",");
        int c[] = new int[key.length];
        for(int i=0; i<key.length; i++){
            c[i]=Integer.parseInt(key[i]);
        }
        radixsort(c, c.length);
    }
    
    public void radixsort(int arr[], int n)throws IOException{
        int x = getMax(arr, n);
        FileWriter fq = new FileWriter("FQ.txt");
        System.out.println("Seleccione en que orden desea ordenar el documento\n1)Ascendente\n2)Descendente");
        int y = opcion.nextInt();
        switch(y){
            case 1:
                for(int exp=1; x/exp>0; exp*=10){
                    countAscendente(arr, n, exp);
                    System.out.println("FQ:");
                    print(arr, arr.length);
                    for(int i=0; i<arr.length; i++){
                        fq.write(arr[i]+",");
                    }
                }
                break;
            case 2:
                for(int exp=1; x/exp>0; exp*=10){
                    countDescendente(arr, n, exp);
                    System.out.println("FQ:");
                    print(arr, arr.length);
                    for(int i=0; i<arr.length; i++){
                        fq.write(arr[i]+",");
                    }
                }
                break;
            default: 
                System.out.println("Opcion no valida");
        }
        FileWriter archivo = new FileWriter("ArchivoOrdenado.txt");
        
        for(int i=0; i<arr.length; i++){
            archivo.write(arr[i]+",");
        }
        archivo.close();
        fq.close();
        System.out.println("Archivo Ordenado Correctamente");
    }  
    
    public void print(int arr[], int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.print("\n");
    }
}

class Polifase {
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
        int[] Array = new int[4],Array2 = new int[4];
        List<Integer> listaAux = new LinkedList<>();
        List<Integer> listaAux2 = new LinkedList<>();
        MergeSort merge = new MergeSort();
        
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
                if(lista1.size() >= 4 && lista2.size() >= 4){
                    for(int i = 0; i < 4; i++){
                        listaAux.add(lista1.remove(0));
                    } 
                    for(int i = 0; i < 4; i++){
                        listaAux2.add(lista2.remove(0));
                    }
                }
                else{
                    if((x = lista1.size()) >= 4){
                        for( int i = 0; i<4; i++){
                            listaAux.add(lista1.remove(0));
                        }
                    }
                    else{
                        x = lista1.size();
                        for(int i = 0; i < x ; i++){
                            listaAux.add(lista1.remove(0));
                        }
                    }
                    if((x = lista2.size()) >= 4){
                        for( int i = 0; i<4; i++){
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
            }
                
               
                // En este punto ya tenemos ambas listas auxiliares, procederemos a combinarlas por medio de una intercalacion
                int cont,cont2;
                for(int i = 0; i < (cont = listaAux.size()); i++){
                    Array[i] = listaAux.get(i);
                }
                for(int i = 0; i<(cont2 = listaAux2.size()); i++){
                    Array2[i] = listaAux2.get(i);
                }
                
                
                merge.sort(Array, 0, Array.length-1, true);
                merge.sort(Array2, 0, Array2.length-1, true);
                
                listaAux.clear();
                listaAux2.clear();
                
                for(int i = 0; i<cont; i++){
                    listaAux.add(Array[i]);
                }
                for(int i = 0; i<cont2; i++){
                    listaAux2.add(Array2[i]);
                }
            //Collections.sort(listaAux);
            //Collections.sort(listaAux2);
            
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
            while( listaAux.isEmpty() == false || listaAux2.isEmpty()== false ){
                if( (!listaAux.isEmpty()) && (!listaAux2.isEmpty()) && listaAux.get(0) <= listaAux2.get(0) ){
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
                else if((!listaAux.isEmpty()) && (!listaAux2.isEmpty()) && listaAux.get(0) > listaAux2.get(0)){
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
                else if(listaAux.isEmpty() && !listaAux2.isEmpty() ){
                    if(first == true){
                        w.write(Integer.toString(listaAux2.remove(0)));
                        first = false;
                    }          
                    else
                    {
                        w.write(",");
                        w.write(Integer.toString(listaAux2.remove(0)));
                    }
                }else if(!listaAux.isEmpty() && listaAux2.isEmpty()){
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
        System.out.println("Lista 1: " + lista1);
        System.out.println("Lista 2: " + lista2);
        System.out.println();
        System.out.println();
        System.out.println("Lista Aux: " + listaAux);
        System.out.println("Lista Aux2: " + listaAux2);
        System.out.println();
        System.out.println();
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
                System.out.println("Entra Swap F2");
                
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
                System.out.println("Entra Swap F1");

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


 class MergeSort {
    
    void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i] + " "); 
        System.out.println(); 
    } 
    
    void merge(int arr[], int l, int m, int r, boolean x) 
    { 
        int n1 = m - l + 1; 
        int n2 = r - m; 
  
        int L[] = new int [n1]; 
        int R[] = new int [n2];
  
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];         
        for (int j=0; j<n2; ++j) 
            R[j] = arr[m + 1+ j];
        int i = 0, j = 0; 
  
        int k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
                arr[k] = L[i]; 
                i++; 
            } 
            else
            { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
  
        while (i < n1) { 
            arr[k] = L[i]; 
            i++; 
            k++;
        } 
  
        while (j < n2) { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        }
    } 
  
    void sort(int arr[], int l, int r, boolean k) {
        if ( k == true)
        {
            k = false;
        }
        else
        {
            k = true;
        }
        if (l < r) { 
            int m = (l+r)/2; 
  
            sort(arr, l, m, k);
            sort(arr , m+1, r, k);
            merge(arr, l, m, r, k); 
        } 
    }
   
}
