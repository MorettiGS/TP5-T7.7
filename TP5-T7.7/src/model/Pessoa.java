package model;

	/**
    *Classe pai abstrata Pessoa, que abrange os atributos, gets e sets passados para suas classes filhas
    *@author Adne Moretti e Gabriel Moretti - T7.7
    *@version 1.0(Out 2021)
 	*/

public abstract class Pessoa {
	protected String nome;
	protected int id;
	protected String CPF;
	protected String email;
	protected String endereco;
	protected Telefone numTel;
	
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
		
	}
	
	
}

