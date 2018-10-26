package com.pdcg.consolaexplorador;

import java.io.*;
import java.nio.file.*;

//funciones de la consola 
public class ManejadorDirectorio {
	private String ruta;
	
	public ManejadorDirectorio() {
		ruta = "C:/Users/pablo/Desktop/pruebaC";
	}
	
	



	public void crearDirectorio(String iruta) {
		File fl = new File (iruta);
		
		if (fl.mkdirs())
			System.out.println ("directorio fue creado existe");
		else
			System.out.println ("directorio no fue creado");
	}

	public void leerDirectorio(String iruta) {
		leerDirectorioRuta(iruta);
	}
	
	public void leerDirectorio() {
		leerDirectorioRuta(ruta);
	}
	
	public void leerDirectorioRuta(String nomdir) {
		try {
			File fl = new File (nomdir);
		
				System.out.println ("Directorio de " + nomdir+"\n");
				
				String s[] = fl.list();
				for (int i = 0; i<s.length; i++) {
					System.out.println(s[i]);
				}
		} 
		catch (Exception e) {
			System.out.println ("\n\nNo ingreso un nombre de directorio\n\n");
		}
	}
	
	
	public void deleteArchivo(String iruta) {
		File ruta = new File (iruta);
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
