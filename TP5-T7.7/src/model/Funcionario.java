package model;

	/**
    *Classe filha (da classe Pessoa) Funcionario, que abrange seus atributos, seu construtor e os gets e sets responsaveis pela sua manipulacao 
    *@author Adne Moretti e Gabriel Moretti - T7.7
    *@version 1.0(Out 2021)
 	*/

public class Funcionario extends Pessoa {
	private String cargo;
	private double salario;

	public Funcionario(int i, String n, String c, String em, String en, Telefone t, String ca, double s){
		id = i;
		nome = n;
		CPF = c;
		email = em;
		endereco = en;
		numTel = t;
		cargo = ca;
		salario = s;
	}

	public String getCargo() {
		return cargo;
	}
	
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public double getSalario() {
		return salario;
	}
	
	public void setSalario(double salario) {
		this.salario = salario;
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
