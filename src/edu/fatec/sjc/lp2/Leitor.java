package edu.fatec.sjc.lp2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Leitor {
	
	private String path;
	
	public Leitor() {
		this.path = "files/allPhones.txt";
	}
	
	public void lerArquivo() {
		try {
			FileInputStream arquivo = new FileInputStream(this.path);
			InputStreamReader input = new InputStreamReader(arquivo);
			BufferedReader br = new BufferedReader(input);
			ValidacaoDeTelefones vdt = new ValidacaoDeTelefones();
			
			String linha;
			
			do {
				linha = br.readLine();
				if(linha != null) {
					String[] telefone = linha.split(" ");
					for(int i=0;i<telefone.length;i++) {
						vdt.validar(telefone[i]);
					}
				}
			}while(linha != null);

			vdt.imprimirInvalidos();
			vdt.imprimirValidos();
			br.close();
		}catch(Exception erro) {
			System.out.println(erro);
		}
	}
	
	public static void main(String args[]) {
		Leitor leitor = new Leitor();
		leitor.lerArquivo();
	}
}
