package com.pdcg.consolaexplorador;

import java.io.File;
import java.util.Scanner;

public class Unix {
	private String opc,texto;
	private String iruta,ruta1,p,delruta,mkdruta;
	private boolean win = true;
	Scanner entrada = new Scanner(System.in);
	ManejadorDirectorio md = new ManejadorDirectorio();
	String c ="C:\\Users\\pablo\\desktop\\prueba";
	String cw = "C:\\Windows";
	
	Windows wm = new Windows();

	public void umenu() {
		
		
		File vaio = new File("");
		ruta1=vaio.getAbsolutePath();
	

	while(win){
		p="";
		for(int i=0;i<ruta1.length();i++) {
			char b[];
			b = new char[ruta1.length()];
			if(ruta1.charAt(i)=='\\') {
				b[i]='/';
			}
			else {
				b[i]=ruta1.charAt(i);
			}
			
			p=p+b[i];
		}
		File ruta2 = new File(ruta1);
		p=p.toUpperCase().replaceAll("C:/users".toUpperCase(), "~");
		System.out.print("\n"+p+" $");
		opc = entrada.next();
		
		
		if(opc.equalsIgnoreCase("cd")) {
			ruta1=wm.desDirectorio(ruta1,ruta2,entrada.next());
		}
		else if(opc.equalsIgnoreCase("prub")) {ruta1=c;}
			
		else if(opc.equalsIgnoreCase("mkdir")) {
			iruta = entrada.next();
			
			if(ruta1.equalsIgnoreCase(cw)) {
				System.out.println("No puede Acceder a esta ruta");}
			else {
				mkdruta=ruta1+"\\"+iruta;
				md.crearDirectorio(mkdruta,iruta,ruta1);
				System.out.print("\n");
			}
		}
			
		else if(opc.equalsIgnoreCase("is")) {
			md.leerDirectorioRuta(ruta1);
			System.out.print("\n");
		}
			
		else if(opc.equalsIgnoreCase("echo")) {
	    	iruta = entrada.next();
	    	
	    	if(ruta1.equalsIgnoreCase(cw)) {
				System.out.println("No puede Acceder a esta ruta");}
	    	else {
	    		texto = entrada.nextLine();
	    		md.echo(iruta,texto,ruta1);
	    		System.out.print("\n");
	    	}
	    }
	   
		else if(opc.equalsIgnoreCase("rm")) {
			iruta=entrada.next();
			
			if(ruta1.equalsIgnoreCase(cw)) {
				System.out.println("No puede Acceder a esta ruta");}
			else {
				delruta=ruta1+"\\"+iruta;
				md.deleteArchivo(delruta);
				System.out.print("\n");
			}
		}
		else if(opc.equalsIgnoreCase("exit")) {
			win=false;
		}
		else if (opc.equalsIgnoreCase("cp")) {
			
			if(ruta1.equalsIgnoreCase(cw)) {
				System.out.println("No puede Acceder a esta ruta");}
			
			else {
				String oruta = entrada.next(); 
				String druta = entrada.next();
				md.copiarDir(oruta,druta,ruta1);
				System.out.print("\n");
			}
		}
		
		else if(opc.equalsIgnoreCase("mv")) {
			
			if(ruta1.equalsIgnoreCase(cw)) {
				System.out.println("No puede Acceder a esta ruta");}
			
			else {
				String oruta = entrada.next(); 
				String druta = entrada.next();
				md.moverArchivo(oruta,druta,ruta1);
				System.out.print("\n");
			}
		}
		else System.out.println("("+opc+") No se reconoce como comando interno o externo \n");
		
	   }
	}
}
