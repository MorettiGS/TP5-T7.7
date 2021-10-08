package control;

import model.*;
/**
    *Faz o controle dos dados do porta-oculos, compoe a comunicacao entre o pacote modelo e o pacote view 
    *@author Adne Moretti e Gabriel Moretti - T7.7
    *@version 1.0(Out 2021)
*/

public class ControlePortaO {
	private PortaOculos[] portaO;
	private int qntPortaOculos;
	
	public ControlePortaO(ControleDados d) {
		portaO = d.getPortaOculos();
		qntPortaOculos = d.getQntPortaOculos();
		
	}
	
	public String[] getModelo() {
		String[] modelos = new String[qntPortaOculos];
		for(int i = 0; i < qntPortaOculos; i++) {
			modelos[i] = portaO[i].getModelo();
		}
		
		return modelos;
	}
	
	public int getQnt() {
		return qntPortaOculos;
	}

	public void setQnt(int qnt) {
		this.qntPortaOculos = qnt;
	}

    public String getID(int i) {
		String numID = String.valueOf(portaO[i].getId());
		return numID;
	}
	
	public String getModelo(int i) {		
		return portaO[i].getModelo();
	}
    
	public String getPreco(int i) {
		String preco = String.valueOf(portaO[i].getPreco());
		return preco;
	}
	
	public String getDescricao(int i) {		
		return portaO[i].getDescricao();
	}	

	public String getCor(int i) {		
		return portaO[i].getCor();
	}	

	
}
