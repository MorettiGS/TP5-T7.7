package control;

import model.*;
/**
    *Faz o controle dos dados do funcionario, compoe a comunicacao entre o pacote modelo e o pacote view 
    *@author Adne Moretti e Gabriel Moretti - T7.7
    *@version 1.0(Out 2021)
*/

public class ControleFuncionario {
	private Funcionario[] func;
	private int qntFuncionarios;
	
	public ControleFuncionario(ControleDados d) {
		func = d.getFuncionarios();
		qntFuncionarios = d.getQntFunc();
		
	}
	
	public String[] getNome() {
		String[] nomes = new String[qntFuncionarios];
		for(int i = 0; i < qntFuncionarios; i++) {
			nomes[i] = func[i].getNome();
		}
		
		return nomes;
	}
	
	public int getQnt() {
		return qntFuncionarios;
	}

	public void setQnt(int qnt) {
		this.qntFuncionarios = qnt;
	}

    public String getID(int i) {
		String numID = String.valueOf(func[i].getId());
		return numID;
	}
	
	public String getNome(int i) {		
		return func[i].getNome();
	}
	
	public String getCPF(int i) {
		String numCPF = String.valueOf(func[i].getCPF());
		return numCPF;
	}
	
	
	public Telefone getTelefone(int i) {
		return func[i].getNumTel();
	}
	
	
	public String getEndereco(int i) {		
		return func[i].getEndereco();
	}	

	public String getCargo(int i) {		
		return func[i].getCargo();
	}	

    public String getSalario(int i){		
		String salario = String.valueOf(func[i].getSalario());
		return salario;
	}	
	
}

