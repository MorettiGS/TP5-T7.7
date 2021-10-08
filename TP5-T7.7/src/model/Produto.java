package model;

	/**
    *Classe pai abstrata Produto, que abrange os atributos, gets e sets passados para suas classes filhas
    *@author Adne Moretti e Gabriel Moretti - T7.7
    *@version 1.0(Out 2021)
 	*/

public abstract class Produto {
	protected int id;
	protected double preco;
	protected String modelo;
	protected String descricao;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public double getPreco() {
		return preco;
	}
	
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}

