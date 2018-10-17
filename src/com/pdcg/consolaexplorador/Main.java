package com.pdcg.consolaexplorador;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opc = 0;
		String nomdir= null ;
		Scanner entrada = new Scanner(System.in);
		ManejadorDirectorio md = new ManejadorDirectorio();
		
		do {
			System.out.println("1) Crear un directorio");
			System.out.println("2) leer directorio");
			System.out.println("3) Desplazarse entre directorios");
			System.out.println("4) Crear un archivo");
			System.out.println("5) Leer un archivo");
			System.out.println("6) Copiar un archivo");
			System.out.println("7) Borrar un archivo");
			System.out.println("8) Mover un archivo");
			System.out.println("9) Salir");
			
			System.out.print("Ingrese una opcion: ");
			opc = entrada.nextInt();
			
			
			switch(opc){
			
			case 1:
				System.out.print("Ingrese el nombre del directorio:");
				nomdir = entrada.next();
				md.crearDirectorio(nomdir);
				break;
			case 2:
				md.leerDirectorio();
				break;
			case 3:System.out.println("Esperando...3");
				System.out.print("Ingrese el nombre del directorio:");
				nomdir = entrada.next();
				md.desplazarDirectorio(nomdir);
				break;
			case 4:System.out.println("Esperando...4");
				break;
			case 5:System.out.println("Esperando...5");
				break;
			case 6:System.out.println("Esperando...6");
				break;
			case 7:System.out.println("Esperando...7");
				break;
			case 8:System.out.println("Esperando...8");
				break;
			
			case 9:System.out.println("fin del programa...");
				break;
				
				default:System.out.println("Opcion incorrecta");				
			}
		}
		while(opc != 9);
		entrada.close();
		System.exit(0);
	}
}
