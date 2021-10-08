package model;

	/**
    *Classe Telefone, que abrange os atributos, gets e sets passados para a classe Pessoa
    *@author Adne Moretti e Gabriel Moretti - T7.7
    *@version 1.0(Out 2021)
 	*/
	
public class Telefone {
	private int ddd;
	private int numero;

	public Telefone(int d, int n){
		ddd = d;
		numero = n;
	}

	public int getDdd() {
		return ddd;
	}
	
	public void setDdd(int ddd) {
		this.ddd = ddd;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
}
