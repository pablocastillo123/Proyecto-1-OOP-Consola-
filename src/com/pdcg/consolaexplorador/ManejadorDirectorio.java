package com.pdcg.consolaexplorador;

import java.io.*;
import java.nio.file.*;
import java.util.Scanner;



//funciones de la consola 
public class ManejadorDirectorio {
	
	
	public ManejadorDirectorio() {
		
	}
	

	
	public void crearDirectorio(String mdkruta, String iruta) {
		
		File fl = new File (mdkruta);
		
		if(fl.exists()){
			System.out.println("Ya existe el subdirectorio o el archivo "+iruta+".");
		}else	fl.mkdirs();
	}

	
	public void leerDirectorioRuta(String ruta1) {
		
			File fl = new File (ruta1);
			System.out.println ("Directorio de " + ruta1+"\n");
			String s[] = fl.list();
			for (int i = 0; i<s.length; i++) {
				System.out.println(s[i]);
			}
		}
	
	public void deleteArchivo(String delruta) {
		//solo para archivos .txt
		File ruta = new File (delruta);
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("¿Estas seguro S/N?");
		String ch=entrada.next();
		
		if(ch.equalsIgnoreCase("s"))
		ruta.delete();
		}

	
	public void moverArchivo(String oruta,String druta,String ruta1){
		Path origen = Paths.get(ruta1,oruta);
		Path destino = Paths.get(ruta1,druta);
		
			
				try {
					Files.move(origen, destino.resolve(origen.getFileName()));
				} catch (IOException e) {
					// TODO Auto-generated catch block
				
					System.out.println("El sistema no puede encontrar el archivo especificado.\n");
				}
		
	
	}



	
	
}
