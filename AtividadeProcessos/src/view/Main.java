package view;

import java.util.Scanner;

import controller.RedesController;

public class Main{

	public static void main(String[] args) {
		
		RedesController procController = new RedesController();
		int op = 0;
		Scanner sc = new Scanner(System.in);
		while(op!=9) {
			System.out.println("O que deseja fazer no sistema?"
							 + "\n1- Saber quais Adaptadores tem IPV4"
							 + "\n2- Saber o ping do site GOOGLE e sua média"
							 + "\n9- Encerrar aplicação");
			op = sc.nextInt();
			switch (op) {
			case 1:
				String config = "ipconfig";
				String ip = procController.ip(config);
				System.out.println("=============================================================================");
				break;
			case 2:
				String site = "PING -t10 www.google.com.br";
				String ping = procController.ping(site);
				System.out.println("=============================================================================");
				break;
			case 9:
				System.out.println("ENCERRADA O SISTEMA");
				System.out.println("=============================================================================");
			default:
				System.out.println("OPERAÇÃO INVÁLIDA");
				System.out.println("=============================================================================");
				break;
			}
			
		}

		
		
		
	} 
}
