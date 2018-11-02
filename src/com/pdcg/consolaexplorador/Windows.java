package com.pdcg.consolaexplorador;

import java.io.File;
import java.util.Scanner;

public class Windows extends ManejadorDirectorio{
	private String opc;
	private String iruta,ruta1,delruta,mkdruta;
	private Scanner sn1; 
	private boolean win = true;
	Scanner entrada = new Scanner(System.in);
	ManejadorDirectorio md = new ManejadorDirectorio();
	String c ="C:\\Users\\pablo\\desktop\\prueba";
	
	
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
		}
		
	return ruta1;
}	
	
	
	
	
	public void wmenu() {
	
		File vaio = new File("");
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
			 
			iruta = entrada.next();
			if(iruta.equals("")) {
				System.out.println("La sintaxis del comando no es correcta.");
			}else 
			mkdruta=ruta1+"\\"+iruta;
			md.crearDirectorio(mkdruta,iruta,ruta1);
			System.out.print("\n");
		}
			
		else if(opc.equalsIgnoreCase("dir")) {
			//iruta=entrada.next();
			
			md.leerDirectorioRuta(ruta1);
			System.out.print("\n");
		}
			
		else if(opc.equalsIgnoreCase("echo")) {
	    	iruta = entrada.next();
	    	System.out.println(iruta);
		}
	   
		else if(opc.equalsIgnoreCase("del")) {
			iruta=entrada.next();
			delruta=ruta1+"\\"+iruta;
			md.deleteArchivo(delruta);
		}
		
		else if(opc.equalsIgnoreCase("move")) {
			String oruta = entrada.next(); 
			String druta = entrada.next();
			md.moverArchivo(oruta,druta);
		}
		//else System.out.println(opc+"no se reconoce como un comando interno o extenor");
		
		//	default:System.out.println(opc+" no se reconoce como un comando");
			//break;
		
	}
	
  }
}