package model;
	
	/**
    *Classe Loja, que abrange seus atributos, seu construtor e os gets e sets responsaveis pela sua manipulacao 
    *@author Adne Moretti e Gabriel Moretti - T7.7
    *@version 1.0(Out 2021)
 	*/
	 
public class Loja {
	private String nome;
	private int qntEst;
	private String CNPJ;
	private String endereco;
	private int qntFunc = 0;
	private String horarioFunc;
	private Funcionario[] funcionariosCadastrados = new Funcionario[200];
	private Venda[] vendasCadastradas =  new Venda[200]; 

	public Loja(String n, int qE, String c, String e, int qF, String h){
		nome = n;
		qntEst = qE;
		CNPJ = c;
		endereco = e;
		qntFunc = qF;
		horarioFunc = h;
	}

	public double getTotalPrecos(int i) {
		return vendasCadastradas[i].getTotalPrecos();
	}

	public void setTotalPrecos(Venda total, int i) {
		this.vendasCadastradas[i] = total ;
	}

	public Cliente getCliente(int i) {
		return vendasCadastradas[i].getCliente();
	}

	public void setCliente(Venda cliente_compra, int i) {
		this.vendasCadastradas[i] = cliente_compra;
	}

	public Venda[] getVendasCadastradas() {
		return vendasCadastradas;
	}

	public void setVendasCadastradas(Venda[] vendasCadastradas) {
		this.vendasCadastradas = vendasCadastradas;
	}
	 public Funcionario getFuncionariosCadastrados(int i) {
		return funcionariosCadastrados[i];
	}


	public void setFuncionariosCadastrados(int i, Funcionario func) {
		this.funcionariosCadastrados[i] = func;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getQntEst() {
		return qntEst;
	}
	
	public void setQntEst(int qntEst) {
		this.qntEst = qntEst;
	}
	
	public String getCNPJ() {
		return CNPJ;
	}
	
	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public int getQntFunc() {
		return qntFunc;
	}
	
	public void setQntFunc(int qntFunc) {
		this.qntFunc = qntFunc;
	}
	
	public String getHorarioFunc() {
		return horarioFunc;
	}
	
	public void setHorarioFunc(String horarioFunc) {
		this.horarioFunc = horarioFunc;
	}

	
}
