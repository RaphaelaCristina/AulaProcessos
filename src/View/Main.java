package View;

import javax.swing.JOptionPane;

import Controller.RedesController;

public class Main {

	public static void main(String[] args) {
		
		RedesController rController = new RedesController();
		
		int sistema = 0;
		String process = " ";
		int menu = 5;
		
		while(menu != 3) {
			
			menu = Integer.parseInt(JOptionPane.showInputDialog("Digite uma opção: 1 - obter SO / 2 - obter Ethernet e IPVa4 / 3 - encerrar programa"));
			
			switch (menu) {
			case 1: sistema = rController.os();break;
			
			case 2: 
					sistema = rController.os();
					if (sistema == 1) {
						process = "ipconfig"; //windows
					} else {
						process = "ifconfig"; //linux
					}//fecha else

					rController.readProcess(process);
			break;
			
			case 3: System.out.println("Programa encerrado!");break;
			
			
			default:System.out.println("Opção inválida!");
			}
		
		

		}

	}
}
