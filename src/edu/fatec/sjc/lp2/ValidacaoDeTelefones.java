package edu.fatec.sjc.lp2;

import java.util.ArrayList;

public class ValidacaoDeTelefones {
	private ArrayList<String> validos =  new ArrayList<String>();
	private ArrayList<String> invalidos = new ArrayList<String>();
	
	public ArrayList<String> getValidos() {
		return validos;
	}

	public void setValidos(ArrayList<String> validos) {
		this.validos = validos;
	}

	public ArrayList<String> getInvalidos() {
		return invalidos;
	}

	public void setInvalidos(ArrayList<String> invalidos) {
		this.invalidos = invalidos;
	}
	
	private boolean validarDigitos(String telefone) {
		
		char anterior = Character.MIN_VALUE;
		
		for(int i=0;i<telefone.length();i++) {
			if(i != 0) {
				if(telefone.charAt(i) == anterior) {
					return false;
				}
			}
			anterior = telefone.charAt(i);
		}
		

		return true;
	}
	
	private boolean validarSoma(String telefone) {
		String[] numeros = telefone.split("");
		
		int sum = 0;
		for(int i = 0;i<numeros.length;i++) {
			sum += Integer.parseInt(numeros[i]);
		}
		if(sum%2 == 0) {
			return true;
		}
		return false;
		
		
	}
	
	private boolean validarPosicoes(String telefone) {
		if(telefone.charAt(0) == telefone.charAt(telefone.length()-1)) {
			return false;
		}
		return true;
	}
	
	
	public void validar(String telefone) {		
		if(validarPosicoes(telefone) && validarSoma(telefone) && validarDigitos(telefone)) {
			getValidos().add(telefone);
		}
		else {
			getInvalidos().add(telefone);
		}
	}
	
	public void imprimirInvalidos() {
		Escritor escritor = new Escritor();
		escritor.escreverInvalidos(getInvalidos());
	}
	
	public void imprimirValidos() {
		Escritor escritor = new Escritor();
		escritor.escreverValidos(getValidos());
	}
	

}
