package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {
	
	public RedesController() {
		super();
	}
	
	public String ip(String config) {
		String os = System.getProperty("os.name");
		System.out.println(os);
		try {
			Process p = Runtime.getRuntime().exec(config);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while(linha!=null) {
				if (linha.contains("Ethernet")||linha.contains(os) ||linha.contains("IPv4"))
				System.out.println(linha);
				linha = buffer.readLine();
			}
			fluxo.close();
			leitor.close();
			buffer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return config;
	}

	public String ping(String ping) {
		String os = System.getProperty("os.name");
		System.out.println(os);
		try {
			Process p = Runtime.getRuntime().exec(ping);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			int ind =0;
			String ms;
			double mediams = 0;
			int numero = 0;
			while(ind<11) {
				try {
					if(linha.contains("tempo")) {
						linha = buffer.readLine().substring(36,46);
						ms = linha;
						System.out.println(ms);
						numero = Integer.parseInt(ms.substring(7,9));
						mediams += numero;
					} else {
						linha = buffer.readLine();
						if(!linha.contains("Resposta")) {
							ms = linha;
							System.out.println(ms);					
						} else {
							ms = linha.substring(36,46);
							System.out.println(ms);
							numero = Integer.parseInt(ms.substring(7,9));
							mediams += numero;
						}
					}
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
				ind++;
			}
			mediams = mediams/10;
			System.out.println("Média de ms de : " +mediams);
			fluxo.close();
			leitor.close();
			buffer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ping;
	}
}
