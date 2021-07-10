//package mezclaEquilibrada;

import java.util.*;
import java.io.*;

class inicio{
	public static void main (String[] args)throws IOException{
     System.out.print("\n Ingresa el nombre del archivo, agregando extension: ");
	Scanner sc = new Scanner(System.in);
	String s = sc.nextLine();
		File f = new File (s);
		
		System.out.println("En orden ascendente(1) o descendente(2))");
	  Scanner ss = new Scanner(System.in);
	  int opc = ss.nextInt();

	  switch(opc){
	  	case 1:
		 	mezclaEquilA m = new mezclaEquilA();
			System.out.print("F0: ");
			m.imprimirArchivo(f);
			while(m.revision(f)==false){
					m.mezcla(f);
		  }
	  	break;

	  	case 2:
		  mezclaEquilD mi = new mezclaEquilD();
			System.out.print("F0: ");
			mi.imprimirArchivo(f);
			while(mi.revision(f)==false){
					mi.mezcla(f);
		  }
	  	break;
	  }
	}
}


class mezclaEquilA{
	public static void mezcla(File f) throws FileNotFoundException, IOException{
	
	
	  FileWriter fw= null;
	    
	if (f.exists()){

       List<Integer> elementos = new LinkedList<>();
	    // List<Integer> element = new LinkedList<>();

	     //List<Integer> el2 = new LinkedList<>();	     
//  		 List<List> lista = new LinkedList<>();  	

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
  		 while (izq < derecha && l.get(izq) <= l.get(izq+1)){
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
  		 while( der < derecha && l.get(der)<= l.get(der+1)){
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
		     	arre[j] =Integer.parseInt(arr[j]);
	     }
		 
		 Arrays.sort(arre);
		 r = Arrays.toString(arre);
		 a = r.replace("[", "");
		 r = a.replace("]", "");
		 a =r.replace(" ", "");

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
		     	Integer[] arre = new Integer[arr.length];

       for (int j= 0; j< arr.length; j++ ) {
		     	arre[j] =Integer.valueOf(arr[j]);
	     }

	   Arrays.sort(arre, Collections.reverseOrder());

		 r = Arrays.toString(arre);
		 a = r.replace("[", "");
		 r = a.replace("]", "");
		 a =r.replace(" ", "");

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







