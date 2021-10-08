package control;

import model.*;

/**
    *Faz o controle dos dados do cliente, compoe a comunicacao entre o pacote modelo e o pacote view 
    *@author Adne Moretti e Gabriel Moretti - T7.7
    *@version 1.0(Out 2021)
*/
public class ControleCliente {
	private Cliente[] cli;
	private int qntClientes;
	
	public ControleCliente(ControleDados d) {
		cli = d.getClientes();
		qntClientes = d.getQntClientes();
		
	}
	
	public String[] getNome() {
		String[] s = new String[qntClientes];
		for(int i = 0; i < qntClientes; i++) {
			s[i] = cli[i].getNome();
		}
		
		return s;
	}
	
	public int getQnt() {
		return qntClientes;
	}

	public void setQnt(int qnt) {
		this.qntClientes = qnt;
	}
	
	public String getNome(int i) {		
		return cli[i].getNome();
	}
	
	public String getCPF(int i) {
		String numCPF = String.valueOf(cli[i].getCPF());
		return numCPF;
	}
	
	public String getID(int i) {
		String numID = String.valueOf(cli[i].getId());
		return numID;
	}
	
	public Telefone getTelefone(int i) {
		return cli[i].getNumTel();
	}

	public void setqntClientes(int qntClientes) {
		this.qntClientes = qntClientes;
	}
	
	
	public String getEndereco(int i) {		
		return cli[i].getEndereco();
	}	
	
}
