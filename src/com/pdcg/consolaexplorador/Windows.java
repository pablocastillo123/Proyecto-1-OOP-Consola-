package com.pdcg.consolaexplorador;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Windows extends ManejadorDirectorio{
	
	private String opc,texto;
	private String iruta,ruta1,delruta,mkdruta;
	private boolean win = true;
	Scanner entrada = new Scanner(System.in);
	ManejadorDirectorio md = new ManejadorDirectorio();
	String c ="C:\\Users\\pablo\\desktop\\prueba";
	String cw = "C:\\Windows";
	
public String des(String ruta1,String a) {
	char []ch = new char[a.length()];
	for(int i=0;i<a.length();i++) {
		
		if(i==0){
			ruta1=ruta1+"\\";
		}
		
			ch[i]=a.charAt(i);
		    ruta1=ruta1+ch[i];
	  }
	return ruta1;
	}
	
public String desDirectorio(String ruta1,File ruta2,String s ) {
	Scanner sn1 = new Scanner(s);
	
	if(sn1.hasNext()) {
		
		if(s.trim().equals("..")){
			ruta1=ruta2.getParent();}
		
		else ruta1=des(ruta1,s);
	}return ruta1;
	
}
	
	
	
	
	public void wmenu() {
	
		File vaio = new File("C:\\Users\\pablo");
		ruta1=vaio.getAbsolutePath();
	

	while(win){
		File ruta2=new File(ruta1);
		System.out.print(ruta2+">");
		opc = entrada.next();
		
		
		if(opc.equalsIgnoreCase("cd")) {
			ruta1=desDirectorio(ruta1,ruta2,entrada.next());
		}
		else if(opc.equalsIgnoreCase("prub")) {ruta1=c;}
			
		else if(opc.equalsIgnoreCase("mkdir")) {
				
			if(ruta1.equalsIgnoreCase(cw)) {
				System.out.println("No puede Acceder a esta ruta");}
	    	else {
				iruta = entrada.next();
				mkdruta=ruta1+"\\"+iruta;
				md.crearDirectorio(mkdruta,iruta,ruta1);
				System.out.print("\n");
	    	}
		}
			
		else if(opc.equalsIgnoreCase("dir")) {
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
		
		
	   
		else if(opc.equalsIgnoreCase("del")) {
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
		else if (opc.equalsIgnoreCase("copy")) {
			
			if(ruta1.equalsIgnoreCase(cw)) {
				System.out.println("No puede Acceder a esta ruta");}
			
			else {
				String oruta = entrada.next(); 
				String druta = entrada.next();
				md.copiarDir(oruta,druta,ruta1);
				System.out.print("\n");
			}
		}
		
		else if(opc.equalsIgnoreCase("move")) {
			
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