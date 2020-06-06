package edu.fatec.sjc.lp2;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Escritor {
	
	public void escreverValidos(ArrayList<String> telefone) {
		try {
			FileOutputStream arquivo = new FileOutputStream("validos.txt");
			PrintWriter pr = new PrintWriter(arquivo);
			
			telefone.forEach((numero)->{
				pr.println(numero);
			});
			
			pr.close();
			arquivo.close();

		}catch(Exception erro) {
			System.out.println(erro);
		}
		
	}
	
	public void escreverInvalidos(ArrayList<String> telefone) {
		try {
			FileOutputStream arquivo = new FileOutputStream("invalidos.txt");
			PrintWriter pr = new PrintWriter(arquivo);
			
			telefone.forEach((numero)->{
				pr.println(numero);
			});
			
			pr.close();
			arquivo.close();

		}catch(Exception erro) {
			System.out.println(erro);
		}
		
	}
}
