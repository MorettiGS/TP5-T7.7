package model;

	/**
    *Classe filha (da classe Pessoa) Cliente, que abrange seus atributos, seu construtor e os gets e sets responsaveis pela sua manipulacao 
    *@author Adne Moretti e Gabriel Moretti - T7.7
    *@version 1.0(Out 2021)
 	*/

public class Cliente extends Pessoa {
	private double grau;

	public Cliente(int i, String n, String c, String em, String en, Telefone t, double g){
		id = i;
		nome = n;
		CPF = c;
		email = em;
		endereco = en;
		numTel = t;
		grau = g;
	}

	public double getGrau() {
		return grau;
	}

	public void setGrau(double grau) {
		this.grau = grau;
	} 
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCPF() {
		return CPF;
	}
	
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public Telefone getNumTel() {
		return numTel;
	}
	
	public void setNumTel(Telefone numTel) {
		this.numTel = numTel;
	}


}
