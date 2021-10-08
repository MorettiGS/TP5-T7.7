package model;
	/**
    *Classe onde ficam todos os dados do projeto, e os gets e sets responsaveis pela sua manipulacao 
    *@author Adne Moretti e Gabriel Moretti - T7.7
    *@version 1.0(Out 2021)
 	*/
	public class Dados {
	private Cliente[] clientesCadastrados = new Cliente[200];
    private Oculos[] oculosCadastrados = new Oculos[200];
    private PortaOculos[] portaOculosCadastrados = new PortaOculos[200];
	private Funcionario[] funcCadastrados = new Funcionario[200];
	private Loja[] loja = new Loja[1];
	private Venda[] vendasCadastradas = new Venda[200];
	private int qntClientes = 0;
	private int qntOculos = 0;
	private int qntPortaOculos = 0;
	private int qntFuncionarios = 0;
	private int qntVendas = 0;

	/**
    *Pre cadastrada 10 dados para cada classe do programa, preenchendo valores aleatorios dentro de um for
 	*/

	public void preencherDados(){
		for(int i=1; i< 11;i++){
			Telefone tel = new Telefone(i*111, 900000000 + (i*10000000));
            clientesCadastrados[i-1] = new Cliente(i, "Cliente " + i, "329489",
            		"Email " + i, "Endereco " + i, tel, 0.5 * i);
            funcCadastrados[i-1] = new Funcionario(i, "Funcionario " + i, "329489" ,
            		"Email " + i, "Endereco " + i, tel, "Cargo " + i, 432 * i);
			oculosCadastrados[i-1] = new Oculos(i, i * 2.00, "modelo"+i, "descricao"+i, "tipo"+i); 
			portaOculosCadastrados[i-1] = new PortaOculos(i, i * 2.00, "modelo"+i, "descricao"+i, "cor"+i);
			vendasCadastradas[i-1] = new Venda(clientesCadastrados[i-1], oculosCadastrados[i-1],oculosCadastrados[i-1].getPreco() +
				portaOculosCadastrados[i-1].getPreco(),portaOculosCadastrados[i-1], i, i*2);
			qntClientes = 10;
			qntOculos = 10;
			qntPortaOculos = 10;
			qntFuncionarios = 10;
			qntVendas = 10;
		}

		
		loja[0] = new Loja("Loja de Oculos", 2432, "39374827000134", "Avenida 9 Setor Sul" , qntFuncionarios, "8h as 22h");
	}
  
    public void cadastrarCliente(Cliente cli, int i) {
		this.clientesCadastrados[i] = cli;
		if(i == qntClientes) qntClientes++;
	}
    
    public void cadastrarOculos(Oculos ocul, int i) {
		this.oculosCadastrados[i] = ocul;
		if(i == qntOculos) qntOculos++;
	}
    
	public void cadastrarPortaOculos(PortaOculos portaO, int i) {
		this.portaOculosCadastrados[i] = portaO;
		if(i == qntPortaOculos) qntPortaOculos++;
	}
    
	public void cadastrarFuncionario(Funcionario func, int i) {
		this.funcCadastrados[i] = func;
		if(i == qntFuncionarios) qntFuncionarios++;
	}
	
	public void cadastrarVenda(Venda venda, int i) {
		this.vendasCadastradas[i] = venda;
		if(i == qntVendas) qntVendas++;
	}
    
	public Cliente[] getClientes() {
		return clientesCadastrados;
	}

	public Oculos[] getOculos() {
		return oculosCadastrados;
	}

	public PortaOculos[] getPortaOculos() {
		return portaOculosCadastrados;
	}

	public Funcionario[] getFuncionarios() {
		return funcCadastrados;
	}
	
	public Loja getLoja() {
		return loja[0];
	}
	
	public Venda[] getVendas() {
		return vendasCadastradas;
	}

  public Cliente getClientesCadastrados(int i) {
		return clientesCadastrados[i];
	}


	public void setClientesCadastrados(int i, Cliente cli) {
		this.clientesCadastrados[i] = cli;
	}


	public Oculos getOculosCadastrados(int i) {
		return oculosCadastrados[i];
	}


	public void setOculosCadastrados(int i, Oculos ocul) {
		this.oculosCadastrados[i] = ocul;
	}


	public PortaOculos getPortaOculosCadastrados(int i) {
		return portaOculosCadastrados[i];
	}


	public void setPortaOculosCadastrados(int i, PortaOculos pOculos) {
		this.portaOculosCadastrados[i] = pOculos;
	}

	public int getQntClientes() {
		return qntClientes;
	}
	
	public void setQntClientes(int qntClientes) {
		this.qntClientes = qntClientes;
	}
	public int getQntOculos() {
		return qntOculos;
	}
	
	public void setQntOculos(int qntOculos) {
		this.qntOculos = qntOculos;
	
	}public int getQntPortaOculos() {
		return qntPortaOculos;
	}
	
	public void setQntPortaOculos(int qntPortaOculos) {
		this.qntPortaOculos = qntPortaOculos;
	}

	public int getQntFunc() {
		return this.qntFuncionarios;
	}

	public void setQntFunc(int qntFunc) {
		this.qntFuncionarios = qntFunc;
	}

	public void setLoja(Loja loja) {
		this.loja[0] = loja;
	}

	public void setVendasCadastradas(Venda[] vendasCadastradas) {
		this.vendasCadastradas = vendasCadastradas;
	}

	public int getQntVendas() {
		return qntVendas;
	}

	public void setQntVendas(int qntVendas) {
		this.qntVendas = qntVendas;
	}
	
}
