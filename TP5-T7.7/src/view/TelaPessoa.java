package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;
import control.*;

/**
    *Mostra toda a interface de clientes e funcionarios, incluindo lista, botoes 
    *@author Adne Moretti e Gabriel Moretti - T7.7
    *@version 1.0(Out 2021)
*/

public class TelaPessoa implements ActionListener, ListSelectionListener {		
	private JFrame frame;
	private JLabel titulo;
	private JTextField nomeProcura;
	private JButton cadastroFunc;
	private JButton cadastroCli;
	private JButton refreshCli;
	private JButton refreshFunc;
	private JScrollPane scrollCli;
	private JScrollPane scrollFunc;
	private JList<String> listaCli;
	private JList<String> listaFunc;
    private String[] nomes = new String[100];
	private static ControleDados controleD;
	private JLabel Procura;
	/**
    *Lista todos os clientes e funcionarios ja cadastrados, mostra a opcao de editar e refresh atraves de botoes
    *@param dados do tipo ControleDados para pegar dados necessarios e manipula-los
	*@param escolha do tipo int, que contem o dado do botao que foi clicado, caso 1 mostra os dados de clientes e caso 2 de funcionarios
	*/
	public void mostrarDados(ControleDados dados, int escolha){
		controleD = dados;

		switch (escolha) {
		case 1:

			frame = new JFrame("Clientes");
			titulo = new JLabel("Clientes");
			cadastroCli = new JButton("Cadastrar");
			refreshCli = new JButton("Refresh");
			nomes = new ControleCliente(controleD).getNome();
			listaCli = new JList<String>(nomes);
			nomeProcura = new JTextField(200);
			Procura = new JLabel("Digite o nome: ");
			
			nomeProcura.getDocument().addDocumentListener(new DocumentListener(){
		        public void insertUpdate(DocumentEvent e){
		            pesquisarListaCli(nomeProcura.getText()); 
		          }
		      
		          public void removeUpdate(DocumentEvent e){
		            pesquisarListaCli(nomeProcura.getText());  
		          }
		   
		          public void changedUpdate(DocumentEvent e){}
		        });
			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			Procura.setFont(new Font("Asap",Font.BOLD, 15));
			titulo.setBounds(350, 10, 250, 30);
			
			scrollCli = new JScrollPane(listaCli);

			cadastroCli.setBounds(235, 450, 120, 35);
			listaCli.setBounds(60, 60, 675, 60);
			listaCli.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listaCli.setVisibleRowCount(10);
			refreshCli.setBounds(390, 450, 120, 35);
			nomeProcura.setBounds(350, 50, 200, 30);
		    scrollCli.setBounds(200, 100, 150, 200);  
		    Procura.setBounds(200,50,120,20);
		    scrollCli.setSize(350, 250);
		    scrollCli.setVisible(true);

			frame.setLayout(null);
			frame.setResizable(false);

			frame.add(titulo);
			frame.add(Procura);
			frame.add(nomeProcura);
			frame.add(scrollCli);
			frame.add(cadastroCli);
			frame.add(refreshCli);
			
			
			frame.setSize(800, 600);  
			frame.setVisible(true);

			cadastroCli.addActionListener(this);
			refreshCli.addActionListener(this);
			listaCli.addListSelectionListener(this);
			

			break;

		case 2:
		frame = new JFrame("Funcionarios");
		titulo = new JLabel("Funcionarios");
		cadastroFunc = new JButton("Cadastrar");
		refreshFunc = new JButton("Refresh");
		nomes = new ControleFuncionario(controleD).getNome();
		listaFunc = new JList<String>(nomes);
		nomeProcura = new JTextField(200);
		Procura = new JLabel("Digite o nome: ");
		
		nomeProcura.getDocument().addDocumentListener(new DocumentListener(){
			public void insertUpdate(DocumentEvent e){
				pesquisarListaFunc(nomeProcura.getText()); 
			  }
		  
			  public void removeUpdate(DocumentEvent e){
				pesquisarListaFunc(nomeProcura.getText());  
			  }
	   
			  public void changedUpdate(DocumentEvent e){}
			});
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		Procura.setFont(new Font("Asap",Font.BOLD, 15));
		titulo.setBounds(350, 10, 250, 30);
		
		scrollFunc = new JScrollPane(listaFunc);

		cadastroFunc.setBounds(235, 450, 120, 35);
		listaFunc.setBounds(60, 60, 675, 425);
		listaFunc.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listaFunc.setVisibleRowCount(10);
		refreshFunc.setBounds(390, 450, 120, 35);
		nomeProcura.setBounds(350, 50, 200, 30);;
		scrollFunc.setBounds(200, 100, 150, 200);  
		Procura.setBounds(200,50,120,20);
		scrollFunc.setSize(350, 250);
		scrollFunc.setVisible(true);

		frame.setLayout(null);
		frame.setResizable(false);

		frame.add(titulo);
		frame.add(Procura);
		frame.add(nomeProcura);
		frame.add(scrollFunc);
		frame.add(cadastroFunc);
		frame.add(refreshFunc);
		
		
		frame.setSize(800, 600);  
		frame.setVisible(true);

		cadastroFunc.addActionListener(this);
		refreshFunc.addActionListener(this);
		listaFunc.addListSelectionListener(this);
		
			
			break;
		default:
			JOptionPane.showMessageDialog(null,"Opcao nao encontrada!", null, 
					JOptionPane.ERROR_MESSAGE);
		}
		 

	}
	/**
    * Pesquisa um cliente na lista de clientes cadastrados
	* @param texto uma string que contem o nome que se deseja pesquisar na lista
     */
	public void pesquisarListaCli(String texto){
		if (controleD.getQntClientes() > 0){
	    int pos = listaCli.getNextMatch(texto, 0, Position.Bias.Forward);
	    listaCli.setSelectedIndex(pos);
	    listaCli.ensureIndexIsVisible(pos);
		}
	}
	/**
    * Pesquisa um funcionario na lista de funcionarios cadastrados
	* @param texto uma string que contem o nome que se deseja pesquisar na lista
     */
	public void pesquisarListaFunc(String texto){
		if (controleD.getQntFunc() > 0){
	    int pos = listaFunc.getNextMatch(texto, 0, Position.Bias.Forward);
	    listaFunc.setSelectedIndex(pos);
	    listaFunc.ensureIndexIsVisible(pos);
		}
	}

	/**
    * Captura eventos dos botoes da interface
	*(1) Caso o botao de cadastrar cliente seja clicado, chama o metodo acoesPessoa na TelaDetalhePessoa e e possivel cadastrar
	*(2) Caso o botao de dar refresh nos clientes seja clicado, atualiza as listas com os novos dados
	*(3) Caso o botao de cadastrar funcionario seja clicado, chama o metodo acoesPessoa na TelaDetalhePessoa e e possivel cadastrar
	*(4) Caso o botao refresh dos funcionarios seja clicado, atualiza a lista com novos dados
	* @param e um evento ActionEvent 
     */
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == cadastroCli)
			new TelaDetalhePessoa().acoesPessoa(controleD, 1, 0);
		
		if(src == refreshCli) {
			listaCli.setListData(new ControleCliente(controleD).getNome());			
			listaCli.updateUI();
		}
		if(src == cadastroFunc)
			new TelaDetalhePessoa().acoesPessoa(controleD, 2, 0);
		
		if(src == refreshFunc) {
			listaFunc.setListData(new ControleFuncionario(controleD).getNome());			
			listaFunc.updateUI();
		}
	}

/**
    * Captura eventos dos itens da lista de clientes e funcionarios
	* @param e um evento
     */	
public void valueChanged(ListSelectionEvent e) {
	Object src = e.getSource();
	
	if(e.getValueIsAdjusting() && src == listaCli) {
		new TelaDetalhePessoa().acoesPessoa(controleD, 3,
				listaCli.getSelectedIndex());
	}

	if(e.getValueIsAdjusting() && src == listaFunc) {
		new TelaDetalhePessoa().acoesPessoa(controleD, 4,
		listaFunc.getSelectedIndex());
	}
	
}

}
