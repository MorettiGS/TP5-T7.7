package model;

	/**
    *Classe Venda, que abrange os seus atributos, seu construtor e os gets e sets responsaveis pela sua manipulacao 
    *@author Adne Moretti e Gabriel Moretti - T7.7
    *@version 1.0(Out 2021)
 	*/

public class Venda {
	private double totalPrecos;
	private Oculos oculos;
	private PortaOculos portaO;
	private Cliente cliente;
	private int qntVendaOculos;
	private int qntVendaPortaOculos;

	public Venda(Cliente c, Oculos o, double t, PortaOculos p, int qo, int qp){
		cliente = c;
		oculos = o;
		totalPrecos = t;
		portaO = p;
		qntVendaOculos = qo;
		qntVendaPortaOculos = qp;
	}
	
	public Oculos getOculos() {
		return oculos;
	}
	
	public void setOculos(Oculos oculos) {
		this.oculos = oculos;
	}
	
	public PortaOculos getPortaO() {
		return portaO;
	}
	
	public void setPortaO(PortaOculos portaO) {
		this.portaO = portaO;
	}

	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public double getTotalPrecos() {
		return totalPrecos;
	}
	
	public void setTotalPrecos(double totalPrecos) {
		this.totalPrecos = totalPrecos;
	}
	
	public int getQntVendaOculos() {
		return qntVendaOculos;
	}

	public void setQntVendaOculos(int qntOculos) {
		this.qntVendaOculos = qntOculos;
	}

	public int getQntVendaPortaOculos() {
		return qntVendaPortaOculos;
	}

	public void setQntVendaPortaOculos(int qntPortaOculos) {
		this.qntVendaPortaOculos = qntPortaOculos;
	}
	
}
