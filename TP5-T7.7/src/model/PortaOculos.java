package model;

	/**
    *Classe filha (da classe Produto) PortaOculos, que abrange seus atributos, seu construtor e os gets e sets responsaveis pela sua manipulacao 
    *@author Adne Moretti e Gabriel Moretti - T7.7
    *@version 1.0(Out 2021)
 	*/
	
public class PortaOculos extends Produto {
	private String cor;

	public PortaOculos(int i, double p, String m, String d, String c){
		id = i;
		preco = p;
		modelo = m;
		descricao = d;
		cor = c;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
	
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
