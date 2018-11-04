package com.pdcg.consolaexplorador;

import java.io.*;
import java.nio.file.*;
import java.text.SimpleDateFormat;
import java.util.Scanner;



//funciones de la consola 
public class ManejadorDirectorio {
	private SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy HH:mm");	
	
	public ManejadorDirectorio() {
	}
	
	public void crearDirectorio(String mdkruta,String iruta, String ruta1) {
		
		if(ruta1.equalsIgnoreCase("C:\\Windows")) {
			System.out.println("No puede Acceder a esta ruta");}
		else {
		File fl = new File (mdkruta);
			if(fl.exists()){
				System.out.println("Ya existe el subdirectorio o el archivo "+iruta+".");
				}else	fl.mkdirs();
		}
	}

	public void leerDirectorioRuta(String ruta1) {
			int dir = 0,arch= 0;
			File fl = new File (ruta1);
			System.out.println ("Directorio de " + ruta1+"\n");
			String s[] = fl.list();
			
			for (int i = 0; i<s.length; i++) {
				File fl2 = new File (ruta1+"\\"+s[i]);
					if(fl2.isDirectory()) {
						System.out.println(fecha.format(fl2.lastModified())+"	<DIR>	"+s[i]);
						dir++;
			     }else {System.out.println(fecha.format(fl2.lastModified())+"	        "+s[i]);
						arch++;}
			}
			System.out.println("	"+arch+" Archivos");
			System.out.println("	"+dir+" Directorios");
		}
	
	public void copiarDir(String oruta,String druta,String ruta1) {
		
		Path origen = Paths.get(ruta1,oruta);
		Path destino = Paths.get(ruta1,druta);
		
		try {
			Files.copy(origen, destino.resolve(origen.getFileName()));
			System.out.println("		Archivo o Directorio copiado");
		} catch (IOException e) {
			System.out.println("El sistema no puede encontrar el archivo especificado.\n");}
		
	}
	
	public void deleteArchivo(String delruta) {
		//solo para archivos de texto
		File archivo = new File (delruta);
		Scanner entrada = new Scanner(System.in);
		if(archivo.exists()) {
		System.out.print("¿Estas seguro S/N?");
		String ch=entrada.next();
		
		if(ch.equalsIgnoreCase("s"))
		archivo.delete();
		}else System.out.println("No se puede encontrar el archivo");
	}
		
	public void moverArchivo(String oruta,String druta,String ruta1){
		
		Path origen = Paths.get(ruta1,oruta);
		Path destino = Paths.get(ruta1,druta);
				try {
					Files.move(origen, destino.resolve(origen.getFileName()));
					System.out.println("		Archivo o Directorio movido");
				} catch (IOException e) {
					System.out.println("El sistema no puede encontrar el archivo especificado.\n");}
		}

	public void echo(String iruta,String texto,String ruta1) {
		String rutaAl=iruta;
		iruta=ruta1+"\\"+iruta;
		boolean b = false ;
		
		File archivo = new File(iruta);
		
	
		
		
		if(archivo.exists()) {
				try {
					archivo.createNewFile();
					FileWriter escribir= new FileWriter(archivo);
					escribir.write(texto);
					escribir.close();
				} catch (IOException e) {
					System.out.println("Error al escribir");}
			}
		
		else System.out.println(rutaAl);
		
		
		
	}
	
}
