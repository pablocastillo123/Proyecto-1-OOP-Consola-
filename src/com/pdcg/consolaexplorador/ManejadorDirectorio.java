package com.pdcg.consolaexplorador;

import java.io.*;
import java.nio.file.*;
import java.util.Scanner;



//funciones de la consola 
public class ManejadorDirectorio {
	
	
	public ManejadorDirectorio() {
		
	}
	

	
	public void crearDirectorio(String mdkruta, String iruta,String ruta1) {
		int i = 0;
		
		File fl = new File (mdkruta);
		File fl2 = new File (ruta1);
		
		
		
		String s[] = fl.list();
		if(iruta.equals(s[i])){
		try {
			while(iruta.equals(s[i])) {
			s[i].equals(iruta);
			i++;
			}
		System.out.println("Ya existe el subdirectorio o el archivo"+iruta);
		}
		catch(Exception e) {System.out.println("La sintaxis del comando no es correcta.");}
		 
		}else	fl.mkdirs();
	}

	public void leerDir(String ruta){
		leerDirectorioRuta(ruta);
		
	}
	
	public void leerDirectorioRuta(String iruta) {
		try {
			
			File fl = new File (iruta);
			
				System.out.println ("Directorio de " + iruta+"\n");
				String s[] = fl.list();
				for (int i = 0; i<s.length; i++) {
					System.out.println(s[i]);
				}
		
		}catch (Exception e) {
			System.out.println ("\n\nNo se encuentra el archivo \n\n");
		
	  }
	}
	
	public void deleteArchivo(String delruta) {
		File ruta = new File (delruta);
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("¿Estas seguro S/N?");
		String ch=entrada.next();
		
		if(ch.equalsIgnoreCase("s"))
		ruta.delete();
		}

	
	public void moverArchivo(String oruta,String druta) {
		Path origen = Paths.get(oruta);
		Path destino = Paths.get(druta);
		try {
			Files.move(origen, destino.resolve(origen.getFileName()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}



	
	
}
