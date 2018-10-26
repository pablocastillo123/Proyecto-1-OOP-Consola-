package com.pdcg.consolaexplorador;

import java.io.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		String opc;
		String iruta= null ;
		Scanner entrada = new Scanner(System.in);
		ManejadorDirectorio md = new ManejadorDirectorio();
		File f2 =new  File("");
		
		System.out.println(f2.getAbsolutePath());
		do {
		
			
			
			opc = entrada.nextLine();
			
						
			switch(opc){
			
			case "mkdir":
				iruta = entrada.next();
				md.crearDirectorio(iruta);
				System.out.print("\n\n");
				break;
			
			case "dir":
				iruta = entrada.next();
				md.leerDirectorio(iruta);
				System.out.print("\n\n");
				break;
				
			case "del":
				iruta = entrada.next();
				md.deleteArchivo(iruta);
				break;
			
			case "move":
				String oruta =  entrada.next(); 
				String druta =  entrada.next();
				md.moverArchivo(oruta,druta);
				break;
				
			
				default:System.out.println(opc+"no se reconoce como un comando");
				break;
			}
		}
		while(opc != "p");
		entrada.close();
		System.exit(0);
	}
}
