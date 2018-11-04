package com.pdcg.consolaexplorador;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		int m;
		Windows wm = new Windows();
		Unix um = new Unix();
		System.out.print("Windows(1) Unix(2):");
		Scanner entrada = new Scanner(System.in);
		
		m = entrada.nextInt();
		
		switch(m) {
		
		case 1:
			wm.wmenu();
			break;
		case 2:
			um.umenu();
			break;
		
		}
		
	}

	
}
