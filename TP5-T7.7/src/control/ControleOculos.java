package control;

import model.*;
/**
    *Faz o controle dos dados do oculos, compoe a comunicacao entre o pacote modelo e o pacote view 
    *@author Adne Moretti e Gabriel Moretti - T7.7
    *@version 1.0(Out 2021)
*/

public class ControleOculos {
	private Oculos[] oculos;
	private int qntOculos;
	
	public ControleOculos(ControleDados d) {
		oculos = d.getOculos();
		qntOculos = d.getQntOculos();
		
	}
	
	public String[] getModelo() {
		String[] modelos = new String[qntOculos];
		for(int i = 0; i < qntOculos; i++) {
			modelos[i] = oculos[i].getModelo();
		}
		
		return modelos;
	}
	
	public int getQnt() {
		return qntOculos;
	}

	public void setQnt(int qnt) {
		this.qntOculos = qnt;
	}

    public String getID(int i) {
		String numID = String.valueOf(oculos[i].getId());
		return numID;
	}
	
	public String getModelo(int i) {		
		return oculos[i].getModelo();
	}
    
	public String getPreco(int i) {
		String preco = String.valueOf(oculos[i].getPreco());
		return preco;
	}
	
	public String getDescricao(int i) {		
		return oculos[i].getDescricao();
	}	

	public String getCor(int i) {		
		return oculos[i].getTipo();
	}	

	
}

