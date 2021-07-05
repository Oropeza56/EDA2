//package mezclaEquilibrada;

import java.util.*;
import java.io.*;

class inicio{
	public static void main (String[] args)throws IOException{
     System.out.print("\n Ingresa el nombre del archivo, agregando extension: ");
	Scanner sc = new Scanner(System.in);
	String nombreArchivo = sc.nextLine();
		mezclaEquil m = new mezclaEquil();
		m.mezcla(nombreArchivo);

	}
}


class mezclaEquil{
	public void mezcla(String s ) throws FileNotFoundException, IOException{
	
	File f = new File (s);
	    
	if (f.exists()){

      	FileReader fr = new FileReader(s);
	     BufferedReader b = new BufferedReader(fr);
	     FileWriter fw1 = new FileWriter ("num01.txt");
	     FileWriter fw2 = new FileWriter ("num02.txt");
	     List<Integer> elementos = new LinkedList<>();

	     String linea = b.readLine();
	     String[] key = linea.split(",");

	     for (int i= 0; i< key.length; i++ ) {
	     	elementos.add(Integer.parseInt(key[i]));
	     }

	     while(elementos.isEmpty()== false){
	     	int i =0;
	     	while(elementos.get(i) <= elementos.get(i+1)){

	     		fw1.write(Integer.toString(elementos.remove(i)));
	     		
	     		i++;

	     }
	   }



	}else{
		System.out.println("El archivo no existe");
	}

  }



}







