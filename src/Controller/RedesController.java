package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {
	public RedesController() {
		super();
	}
	
	public int os() {
		int operacao = 0;
		String os = System.getProperty("os.name");
		System.out.println(os);
		
		
		if (os.contains("Windows")) {
			operacao = 1;
		}else {
			operacao = 2;
		}
		return operacao;
		
	}//fecha os
	
	
	public void readProcess(String process) {
		String vetor[] = new String[5];
		String ipv4[] = new String[5];
		int cont = 0, i = 0;
		int[] guarda = new int[5];
		
		try {
			Process p = Runtime.getRuntime().exec(process);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			
			while (linha != null) { 
				
				if (linha.contains("Adaptador")){
					vetor[cont] = linha;
					cont++;
				}//fecha if
				
				if (linha.contains("IPv4")){
					String[] vetorPalavras = linha.split(" ");
					ipv4[i] = vetorPalavras[vetorPalavras.length-1];
					guarda[i] = cont-1; //guarda o índice do vetor que tem adaptador com Ipv4
					i++;
				}//fehca if
				
				linha = buffer.readLine();
				
			}//fecha while
			
			//fecha tudo
			buffer.close();
			leitor.close();
			fluxo.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}//fecha catch	
		
		for (i = 0; i < guarda.length; i++){
			if (guarda[i] != 0){
				System.out.println(vetor[guarda[i]] + "\nIpva4: " + ipv4[i]);	
			}//fecha if
		}//fecha for
		
	}//fecha readProcess
		
	
}//fecha classe RedesController 
