package control;

import model.*;

/**
    *Faz o controle dos dados das vendas, compoe a comunicacao entre o pacote modelo e o pacote view 
    *@author Adne Moretti e Gabriel Moretti - T7.7
    *@version 1.0(Out 2021)
*/

public class ControleVenda {
	private Venda[] venda;
	private int qntVendas;
	
	public ControleVenda(ControleDados d) {
		venda = d.getVenda();
		qntVendas = d.getQntVendas();
		
	}
	
	public String[] getCliente() {
		String[] vendas = new String[qntVendas];
		for(int i = 0; i < qntVendas; i++) {
			vendas[i] = venda[i].getCliente().getNome();
		}
		
		return vendas;
	}
	
	public int getQnt() {
		return qntVendas;
	}

	public void setQnt(int qnt) {
		this.qntVendas = qnt;
	}
	
}

