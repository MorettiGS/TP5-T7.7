package control;

import model.*;
/**
    *Faz o controle de todos os dados do projeto, compoe a comunicacao entre os dados e o pacote view 
    *@author Adne Moretti e Gabriel Moretti - T7.7
    *@version 1.0(Out 2021)
 */

public class ControleDados {
	private Dados d = new Dados();
	
	public ControleDados() {
		d.preencherDados();
	}
	
	public Dados getDados() {
		return d;
	}
	public void setDados(Dados d) {
		this.d = d;
	}

	public Venda[] getVenda() {
		return this.d.getVendas();
	}
	
	public int getQntVendas() {
		return this.d.getQntVendas();
	}
	
	public Cliente[] getClientes() {
		return this.d.getClientes();
	}
	
	public int getQntClientes() {
		return this.d.getQntClientes();
	}

    public void setQntClientes(int i) {
		this.d.setQntClientes(i);
	}
	
	public int getQntFunc() {
		return this.d.getQntFunc();
	}
	
	public Funcionario[] getFuncionarios() {
		return this.d.getFuncionarios();
	}
	
	public Oculos[] getOculos() {
		return this.d.getOculos();
	}
	public int getQntOculos() {
		return this.d.getQntOculos();
	}

	public PortaOculos[] getPortaOculos() {
		return this.d.getPortaOculos();
	}
	public int getQntPortaOculos() {
		return this.d.getQntPortaOculos();
	}

    public void setQntOculos(int i) {
		this.d.setQntOculos(i);
	}
    
    public Loja getLoja() {
		return this.d.getLoja();
	}
 

    
    /**
    *Recebe os valores de funcionarios cadastrados ou editados, criando um novo funcionario e colocando/substituindo no array de Funcionarios
	*(1) Verifica se os dados inteiros tem apenas caracteres de 0 a 9
	*(2) Caso seja validado, cria um novo objeto Funcionario e edita as informacoes atraves do cadastrarFuncionario
    *@param dadosFuncionarios um array de strings que recebe todos os dados dos funcionarios cadastrados e editados
    *@return verdadeiro ou falso, indicando se a string de dados foi validada de acordo com os dados
 	*/
    public boolean acoesFunc(String[] dadosFuncionarios) {
		if(!dadosFuncionarios[1].matches("[0-9]+") || !dadosFuncionarios[3].matches("[0-9]+")
		|| !dadosFuncionarios[6].matches("[0-9]+") || !dadosFuncionarios[7].matches("[0-9]+")
		|| Integer.parseInt(dadosFuncionarios[1]) <= 0  || Integer.parseInt(dadosFuncionarios[6]) > 999   
		|| Integer.parseInt(dadosFuncionarios[7]) > 999999999 || Double.parseDouble(dadosFuncionarios[9]) <= 0) {
				return false;
		} else {
				Funcionario func = new Funcionario(Integer.parseInt(dadosFuncionarios[1]),dadosFuncionarios[2], dadosFuncionarios[3],dadosFuncionarios[4], 
						dadosFuncionarios[5], new Telefone(Integer.parseInt(dadosFuncionarios[6]),Integer.parseInt(dadosFuncionarios[7])),dadosFuncionarios[8], Double.parseDouble(dadosFuncionarios[9]));
				d.cadastrarFuncionario(func, Integer.parseInt(dadosFuncionarios[0]));
				return true;
	}
	}
	/**
    *Recebe os valores dos clientes cadastrados ou editados, criando um novo cliente e colocando/substituindo no array de Clientes
	*(1) Verifica se os dados inteiros e double tem apenas caracteres de 0 a 9
	*(2) Caso seja validado, cria um novo objeto Cliente e edita as informacoes atraves do cadastrarCliente
    *@param dadosClientes um array de strings que recebe todos os dados dos clientes cadastrados e editados, cada dado ocupa uma posicao do array 
    *@return verdadeiro ou falso, indicando se a string de dados foi validada de acordo com os dados
 	*/
	
	public boolean acoesCliente(String[] dadosClientes) {
		if(dadosClientes[4].startsWith("@")) {
			return false;
		}
		if(!dadosClientes[1].matches("[0-9]+") || !dadosClientes[3].matches("[0-9]+") || 
			!dadosClientes[6].matches("[0-9]+") || !dadosClientes[7].matches("[0-9]+")
			|| Integer.parseInt(dadosClientes[1]) <= 0  || Integer.parseInt(dadosClientes[6]) > 999   
			|| Integer.parseInt(dadosClientes[7]) > 999999999 || Double.parseDouble(dadosClientes[8]) <= 0) {
				return false;

		} else {
		Cliente cli = new Cliente(Integer.parseInt(dadosClientes[1]),dadosClientes[2], dadosClientes[3], 
				dadosClientes[4], dadosClientes[5], new Telefone(Integer.parseInt(dadosClientes[6]),Integer.parseInt(dadosClientes[7])),
					Double.parseDouble(dadosClientes[8]));
		d.cadastrarCliente(cli, Integer.parseInt(dadosClientes[0]));
			return true;
		}
	} 
	/**
    *Recebe os valores dos oculos cadastrados ou editados, criando um novo oculos e colocando/substituindo no array de Oculos
	*(1) Verifica se os dados inteiros e double tem apenas caracteres de 0 a 9
	*(2) Caso seja validado, cria um novo objeto Oculos e edita as informacoes atraves do cadastrarOculos
    *@param dadosOculos um array de strings que recebe todos os dados dos oculos cadastrados e editados, cada dado ocupa uma posicao do array 
    *@return verdadeiro ou falso, indicando se a string de dados foi validada de acordo com os dados
 	*/
	public boolean acoesOculos(String[] dadosOculos) {
		if(!dadosOculos[1].matches("[0-9]+") || Double.parseDouble(dadosOculos[2]) <= 0) {
			return false;
		} else {
			Oculos ocul = new Oculos(Integer.parseInt(dadosOculos[1]),Double.parseDouble(dadosOculos[2]),dadosOculos[3], 
						dadosOculos[4], dadosOculos[5]);
				d.cadastrarOculos(ocul, Integer.parseInt(dadosOculos[0]));
			return true;
		}
	} 
	/**
    *Recebe os valores dos porta oculos cadastrados ou editados, criando um novo porta oculos e colocando/substituindo no array de Porta oculos
	*(1) Verifica se os dados inteiros e double tem apenas caracteres de 0 a 9
	*(2) Caso seja validado, cria um novo objeto portaOculos e edita as informacoes atraves do cadastrarPortaOculos
    *@param dadosPortaOculos um array de strings que recebe todos os dados dos porta oculos cadastrados e editados, cada dado ocupa uma posicao do array 
    *@return verdadeiro ou falso, indicando se a string de dados foi validada de acordo com os dados
 	*/
	public boolean acoesPortaO(String[] dadosPortaOculos) {
		if(!dadosPortaOculos[1].matches("[0-9]+") || Double.parseDouble(dadosPortaOculos[2]) <= 0) {
			return false;
		} else {
			PortaOculos portaO = new PortaOculos(Integer.parseInt(dadosPortaOculos[1]),Double.parseDouble(dadosPortaOculos[2]),dadosPortaOculos[3], 
						dadosPortaOculos[4], dadosPortaOculos[5]);
				d.cadastrarPortaOculos(portaO, Integer.parseInt(dadosPortaOculos[0]));
				return true;
		}
	}
	/**
    *Recebe os valores da Loja editada, criando um novo objeto Loja e substituindo nos dados da Loja
	*(1) Verifica se os dados inteiros tem apenas caracteres de 0 a 9
	*(2) Caso seja validado, cria um novo objeto loja e edita as informacoes atraves do setLoja
    *@param dadosLoja um array de strings que recebe todos os dados da loja, cada dado ocupa uma posicao do array 
    *@return verdadeiro ou falso, indicando se o arraya string de dados foi validada de acordo com os dados
 	*/
	public boolean acoesLoja(String[] dadosLoja) {
		if(!dadosLoja[1].matches("[0-9]+") || Double.parseDouble(dadosLoja[1]) < 0) {
			return false;
		} else {
				Loja loja = new Loja(dadosLoja[0],Integer.parseInt(dadosLoja[1]),dadosLoja[2], dadosLoja[3], 
						Integer.parseInt(dadosLoja[4]),dadosLoja[5]);
				d.setLoja(loja);
			return true;
		}
	}
	/**
    *Recebe os valores da Venda editada ou cadastrada,valida e cria um novo objeto Loja e substituindo nos dados da Venda
	*(1) Verifica se os dados inteiros tem apenas caracteres de 0 a 9
	*(2) Caso seja validado, cria um novo objeto Venda e edita as informacoes atraves do cadastrar venda dos dados
    *@param posicoes um array de int que recebe as posicoes dos clientes, porta oculos e oculos selecionados em uma nova venda ou edicao de venda
    *@return verdadeiro ou falso, indicando se o array de dados foi validado de acordo com os dados
 	*/
	public boolean acoesVenda(int[] posicoes) {

		if(!String.valueOf(posicoes[4]).matches("[0-9]+") || !String.valueOf(posicoes[5]).matches("[0-9]+")
		|| posicoes[4] < 0 || posicoes[5] < 0) {
			return false;
		}
		else{
			
			int quantidade;
			Cliente cli =  d.getClientesCadastrados(posicoes[1]); 
			Oculos oculos = d.getOculosCadastrados(posicoes[2]);
			PortaOculos portaO =  d.getPortaOculosCadastrados(posicoes[3]);
			int quantidadeOculos = posicoes[4];
			int quantidadePortaOculos = posicoes[5];
			
			quantidade = d.getLoja().getQntEst(); 
			if (posicoes[0] != d.getQntVendas()){
				quantidade += d.getVendas()[posicoes[0]].getQntVendaOculos() + d.getVendas()[posicoes[0]].getQntVendaPortaOculos();
				quantidade -= (posicoes[4]+posicoes[5]);
			} else {
				quantidade -= (posicoes[4]+posicoes[5]);
			}
			
			d.getLoja().setQntEst(quantidade);

			double totalP;
			totalP = oculos.getPreco() + portaO.getPreco();

			Venda venda = new Venda(cli, oculos, totalP, portaO, quantidadeOculos, quantidadePortaOculos);

			d.cadastrarVenda(venda, posicoes[0]);
			return true;
			
	}}
	/**
    * Verifica se, caso a operação de venda ocorra, a quantidade de estoque se tornaria 0 ou menor do que zero
	*(1) Verifica se estamos tratando uma situacao de edicao ou cadastro, utilizando a quantidade de vendas
	*(2) Verifica se o resultado da operação respectiva, resultante do item 1, seria igual, maior ou menor que zero,
	retornando o resultado da verificacao como um numero inteiro
    *@param posicoes um array de int que recebe as posicoes dos clientes, porta oculos e oculos selecionados em uma nova venda ou edicao de venda
    *@return int 1, 2 e 3 representando se a venda foi validada, caso nao, o motivo pelo qual nao foi
 	*/
	public int validarQntEst(int[] posicoes){
		int quantidade;
		quantidade = d.getLoja().getQntEst();
		if (posicoes[0] != d.getQntVendas()){
			if(quantidade + d.getVendas()[posicoes[0]].getQntVendaOculos() + d.getVendas()[posicoes[0]].getQntVendaPortaOculos()
			- (posicoes[4]+posicoes[5])== 0){
				return 1;
			} else if (quantidade + d.getVendas()[posicoes[0]].getQntVendaOculos() + d.getVendas()[posicoes[0]].getQntVendaPortaOculos()
			- (posicoes[4]+posicoes[5]) < 0){
				return 2;
			} else {
				return 3;
			}
		} else {
			if(quantidade - (posicoes[4]+posicoes[5]) == 0){
				return 1;
			} else if (((posicoes[4]+posicoes[5])-quantidade) > 0 ){
				return 2;
			} else {
				return 3;
			}
		}
	}
	/**
    * Método para remover um cliente do array de clientes
	*(1) Exclui o cliente caso o cliente que se deseja remover esteja no final do array
	*(2) Exclui o cliente caso o cliente que se deseja remover esteja no meio do array
	*(3) Rotina swap, move todos as posicoes do array para uma posicao a menos
    *@param i int que contem a posicao do cliente que se deseja remover
 	*/
	
	public void removerCli(int i) {
		String clienteRemovido = d.getClientes()[i].getNome();
		
		if(i == (d.getQntClientes() - 1)) { 
			d.setQntClientes(d.getQntClientes() - 1);
			d.getClientes()[d.getQntClientes()] = null;

		} else { 
			int cont = 0;
			while(d.getClientes()[cont].getNome().compareTo(clienteRemovido) != 0) {
				cont++;
			}
			
			for(int j = cont; j < d.getQntClientes() - 1; j++) {
				d.getClientes()[j] = null;
				d.getClientes()[j] = d.getClientes()[j+1];
			}
			d.getClientes()[d.getQntClientes()] = null;
			d.setQntClientes(d.getQntClientes() - 1);

		}
	}
	/**
    * Método para remover uma venda do array de vendas
	*(1) Exclui a venda caso a venda que se deseja remover esteja no final do array
	*(2) Exclui a venda caso a venda que se deseja remover esteja no meio do array
	*(3) Rotina swap, move todos as posicoes do array para uma posicao a menos
    *@param i do tipo int, contem a posicao da venda que se deseja excluir
	*@param qntOV do tipo int que contem a quantidade de oculos vendidos em uma unica venda
	*@param qntPOV do tipo int que contem a quantidade de porta-oculos vendidos em uma unica venda
 	*/
	public void removerVenda(int i, int qntOV, int qntPOV) {
		String vendaRemovida = d.getVendas()[i].getCliente().getNome();
		
		if(i == (d.getQntVendas() - 1)) { 
			d.setQntVendas(d.getQntVendas() - 1);
			d.getVendas()[d.getQntVendas()] = null;
			
		} else { 
			int cont = 0;
			while(d.getVendas()[cont].getCliente().getNome().compareTo(vendaRemovida) != 0) {
				cont++;
			}
			
			for(int j = cont; j < d.getQntVendas() - 1; j++) {
				d.getVendas()[j] = null;
				d.getVendas()[j] = d.getVendas()[j+1];
			}
			d.getVendas()[d.getQntVendas()] = null;
			d.setQntVendas(d.getQntVendas() - 1);

		}

		d.getLoja().setQntEst( d.getLoja().getQntEst() + (qntOV + qntPOV) );
	}
	/**
    * Método para remover um funciomario do array de funcionarios
	*(1) Exclui o funcionario caso o funcionario que se deseja remover esteja no final do array
	*(2) Exclui o funcionario caso o funcionario que se deseja remover esteja no meio do array
	*(3) Rotina swap, move todos as posicoes do array para uma posicao a menos
    *@param i do tipo int, contem a posicao da venda que se deseja excluir
 	*/
	 public void removerFunc(int i) {
		String funcRemovido = d.getFuncionarios()[i].getNome();

		if(i == (d.getQntFunc() - 1)) { // O prof a ser removido estï¿½ no final do array
			d.setQntFunc(d.getQntFunc() - 1);
			d.getFuncionarios()[d.getQntFunc()] = null;
		} else { // o prof a ser removido estï¿½ no meio do array
			int cont = 0;
			while(d.getFuncionarios()[cont].getNome().compareTo(funcRemovido) != 0)
				cont++;
			//Rotina swap
			for(int j = cont; j < d.getQntFunc() - 1; j++) {
				d.getFuncionarios()[j] = null;
				d.getFuncionarios()[j] = d.getFuncionarios()[j+1];
			}
			d.getFuncionarios()[d.getQntFunc()] = null;
			d.setQntFunc(d.getQntFunc() - 1);
		}
	}
	/**
    * Método para remover um oculos do array de oculos
	*(1) Exclui o oculos caso o que se deseja remover esteja no final do array
	*(2) Exclui o oculos caso o que se deseja remover esteja no meio do array
	*(3) Rotina swap, move todos as posicoes do array para uma posicao a menos
    *@param i do tipo int, contem a posicao do oculos que se deseja excluir
 	*/
     
     public void removerOculos(int i) {
 		String oculosRemovido = d.getOculos()[i].getModelo();
 		
 		if(i == (d.getQntOculos() - 1)) { // O prof a ser removido estï¿½ no final do array
 			d.setQntOculos(d.getQntOculos() - 1);
 			d.getOculos()[d.getQntOculos()] = null;

 		} else { // o prof a ser removido estï¿½ no meio do array
 			int cont = 0;
 			while(d.getOculos()[cont].getModelo().compareTo(oculosRemovido) != 0)
 				cont++;
 			//Rotina swap
 			for(int j = cont; j < d.getQntOculos() - 1; j++) {
 				d.getOculos()[j] = null;
 				d.getOculos()[j] = d.getOculos()[j+1];
 			}
 			d.getOculos()[d.getQntOculos()] = null;
 			d.setQntOculos(d.getQntOculos() - 1);

 		}
 	}
	 /**
    * Método para remover um porta-oculos do array de porta-oculos
	*(1) Exclui o porta-oculos caso o que se deseja remover esteja no final do array
	*(2) Exclui o porta-oculos caso o que se deseja remover esteja no meio do array
	*(3) Rotina swap, move todos as posicoes do array para uma posicao a menos
    *@param i do tipo int, contem a posicao do porta-oculos que se deseja excluir
 	*/
     
     public void removerPortaO(int i) {
  		String portaORemovido = d.getOculos()[i].getModelo();

  		if(i == (d.getQntPortaOculos() - 1)) { // O prof a ser removido estï¿½ no final do array
  			d.setQntPortaOculos(d.getQntPortaOculos() - 1);
  			d.getPortaOculos()[d.getQntPortaOculos()] = null;
  		} else { // o prof a ser removido estï¿½ no meio do array
  			int cont = 0;
  			while(d.getPortaOculos()[cont].getModelo().compareTo(portaORemovido) != 0)
  				cont++;
  			//Rotina swap
  			for(int j = cont; j < d.getQntPortaOculos() - 1; j++) {
  				d.getPortaOculos()[j] = null;
  				d.getPortaOculos()[j] = d.getPortaOculos()[j+1];
  			}
  			d.getPortaOculos()[d.getQntPortaOculos()] = null;
  			d.setQntPortaOculos(d.getQntPortaOculos() - 1);
  		}
  	}
}
