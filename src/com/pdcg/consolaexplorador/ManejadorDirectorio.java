package com.pdcg.consolaexplorador;

import java.io.File;

public class ManejadorDirectorio {
	private String directorioActual;
	
	public ManejadorDirectorio() {
		directorioActual = "C://Dev-Cpp";
	}
	
	public void crearDirectorio(String nomdir) {
		File fl = new File (nomdir);
		
		if (fl.mkdirs())
			System.out.println ("directorio fue creado existe");
		else
			System.out.println ("directorio no fue creado");
	}

	public void leerDirectorio(String nomdir) {
		leerDirectorioRuta(nomdir);
	}
	
	public void leerDirectorio() {
		leerDirectorioRuta(directorioActual);
	}
	
	public void leerDirectorioRuta(String nomdir) {
		try {
			File fl = new File (nomdir);
			if (fl.isDirectory()) {
				System.out.println ("Directorio de " + nomdir);
				String s[] = fl.list();
				for (int i = 0; i<s.length; i++) {
					File f = new File (nomdir + "/" + s[i]);
					if (f.isDirectory()) {
						System.out.println (s[i] + " es un directorio");
					} 
					else {
						System.out.println(s[i] + " es un archivo");
					}
				}
			} 
			else {
				System.out.println (nomdir + " no es un directorio");
			}
		} 
		catch (Exception e) {
			System.out.println ("\n\nNo ingreso un nombre de directorio\n\n");
		}
	}
	
	public void desplazarDirectorio(String nomdir) {
		directorioActual = nomdir;
		leerDirectorio(nomdir);
	}
	
}
