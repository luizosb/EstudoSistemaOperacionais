package Main;

import java.util.Scanner;

import controller.Controller;

public class Main {

	public static void main(String[] args) {
		Controller con = new Controller();
		
		int pid = 0;
		String nome;
		int op =0;
		Scanner sc = new Scanner(System.in);
		while(op!=9) {
			System.out.println("\n=============================================="
							 + "\nDigite a opção desejada: "
							 + "\n1- Identificar o sistema operacional"
							 + "\n2- Listar processos ativos"
							 + "\n3- Finalizar um processo(pelo número)"
							 + "\n4- Finalizar um processo(pelo nome)"
							 + "\n9- Finalizar aplicação"
							 + "\n==============================================");
			op = sc.nextInt();
			switch (op) {
			case 1: 
				con.identificarSO();
				break;
			case 2:
				con.listarProcessosAtivos();
				break;
			case 3:
				System.out.print("Digite o número do processo: ");
				pid = sc.nextInt();
				con.selecionarEMatarComandoPorNumero(pid);
				break;
			case 4:
				System.out.print("Digite o nome do processo: ");
				nome = sc.next();
				con.selecionarEMatarComandoPorNome(nome);
				break;
			case 9:
				System.out.println("APLICAÇÃO FINALIZADA");
				break;
			default:
				System.out.println("OPÇÃO INVÁLIDA");
				break;
			}
		}

	}

}
