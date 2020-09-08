package controller;

public class Controller {

	public Controller() {}

	public void identificarSO() {
		String os = System.getProperty("os.name");
		System.out.print("Sistema operacional: " + os);
	}
	
	public void listarProcessosAtivos() {
		String procAtivos = System.getProperty("tasklist");
		System.out.println("Lista dos processos ativos: " + procAtivos);
	}
	
	public void selecionarEMatarComandoPorNumero(int pid) {
		String cmdPid = "TASKKILL/ PID";
		StringBuffer buffer = new StringBuffer();

		pid = Integer.parseInt(cmdPid);
		buffer.append(cmdPid);
		buffer.append(" ");
		buffer.append(pid);
		
		
	}
	
	public void selecionarEMatarComandoPorNome(String nome) {
		String cmdNome = "TASKKILL/ IM";
		StringBuffer buffer = new StringBuffer();
		
		buffer.append(cmdNome);
		buffer.append(" ");
		buffer.append(nome);
	}
}
