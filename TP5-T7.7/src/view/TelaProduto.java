package view;

import java.awt.*;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;
import control.*;
/**
    *Mostrar a lista de porta oculos e oculos 
    *@author Adne Moretti e Gabriel Moretti - T7.7
    *@version 1.0(Out 2021)
 */
public class TelaProduto implements ActionListener, ListSelectionListener {		
	private JFrame frame;
	private JLabel titulo;
	private JTextField nomeProcura;
	private JButton cadastroPortaO;
	private JButton cadastroOculos;
	private JButton refreshOculos;
	private JButton refreshPortaO;
	private JList<String> listaOcul;
	private JList<String> listaPortaO;
    private String[] modelosOculos = new String[100];
    private String[] modelosPortaO = new String[100];
	private JLabel Procura;
	private static ControleDados controleD;
	/**
    * Mostra a lista de oculos cadastrados, os botoes de cadastrar e refresh
    * @param dados do tipo ControleDados para pegar os dados necessarios 
	* @param escolha do tipo int para pegar a opcao de acordo com o botao clicado, caso 1 mostra dados do oculos e 2 do porta oculos
     */
	public void mostrarDados(ControleDados dados, int escolha){
		controleD = dados;

		switch (escolha) {
		case 1:frame = new JFrame("Oculos");
		titulo = new JLabel("Oculos");
		cadastroOculos = new JButton("Cadastrar");
		refreshOculos = new JButton("Refresh");
		modelosOculos = new ControleOculos(controleD).getModelo();
		listaOcul = new JList<String>(modelosOculos);
		nomeProcura = new JTextField(200);
		Procura = new JLabel("Digite o modelo: ");
		
		nomeProcura.getDocument().addDocumentListener(new DocumentListener(){
			public void insertUpdate(DocumentEvent e){
				pesquisarlistaOcul(nomeProcura.getText()); 
			  }
		  
			  public void removeUpdate(DocumentEvent e){
				pesquisarlistaOcul(nomeProcura.getText());  
			  }
	   
			  public void changedUpdate(DocumentEvent e){}
			});
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		Procura.setFont(new Font("Asap",Font.BOLD, 15));
		titulo.setBounds(350, 10, 250, 30);
		
		JScrollPane scrollOcul = new JScrollPane(listaOcul);

		cadastroOculos.setBounds(235, 450, 120, 35);
		listaOcul.setBounds(60, 60, 675, 425);
		listaOcul.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listaOcul.setVisibleRowCount(10);
		refreshOculos.setBounds(390, 450, 120, 35);
		nomeProcura.setBounds(350, 50, 200, 30);
		scrollOcul.setBounds(200, 100, 150, 200);  
		Procura.setBounds(200,50,120,20);
		scrollOcul.setSize(350, 250);
		scrollOcul.setVisible(true);

		frame.setLayout(null);
		frame.setResizable(false);

		frame.add(titulo);
		frame.add(Procura);
		frame.add(nomeProcura);
		frame.add(scrollOcul);
		frame.add(cadastroOculos);
		frame.add(refreshOculos);
		
		
		frame.setSize(800, 600);  
		frame.setVisible(true);

		cadastroOculos.addActionListener(this);
		refreshOculos.addActionListener(this);
		listaOcul.addListSelectionListener(this);
		
			

			break;

		case 2:
		frame = new JFrame("Porta-Oculos");
		titulo = new JLabel("Porta-Oculos");
		cadastroPortaO = new JButton("Cadastrar");
		refreshPortaO = new JButton("Refresh");
		modelosPortaO = new ControlePortaO(controleD).getModelo();
		listaPortaO = new JList<String>(modelosPortaO);
		nomeProcura = new JTextField(200);
		Procura = new JLabel("Digite o modelo: ");
		
		nomeProcura.getDocument().addDocumentListener(new DocumentListener(){
			public void insertUpdate(DocumentEvent e){
				pesquisarListaPortaO(nomeProcura.getText()); 
			  }
		  
			  public void removeUpdate(DocumentEvent e){
				pesquisarListaPortaO(nomeProcura.getText());  
			  }
	   
			  public void changedUpdate(DocumentEvent e){}
			});
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		Procura.setFont(new Font("Asap",Font.BOLD, 15));
		titulo.setBounds(350, 10, 250, 30);
		
		JScrollPane scrollPortaO = new JScrollPane(listaPortaO);

		cadastroPortaO.setBounds(235, 450, 120, 35);
		listaPortaO.setBounds(60, 60, 675, 425);
		listaPortaO.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listaPortaO.setVisibleRowCount(10);
		refreshPortaO.setBounds(390, 450, 120, 35);
		nomeProcura.setBounds(350, 50, 200, 30);
		scrollPortaO.setBounds(200, 100, 150, 200);  
		Procura.setBounds(200,50,120,20);
		scrollPortaO.setSize(350, 250);
		scrollPortaO.setVisible(true);

		frame.setLayout(null);
		frame.setResizable(false);
		
		frame.add(titulo);
		frame.add(Procura);
		frame.add(nomeProcura);
		frame.add(scrollPortaO);
		frame.add(cadastroPortaO);
		frame.add(refreshPortaO);
		
		
		frame.setSize(800, 600);  
		frame.setVisible(true);

		cadastroPortaO.addActionListener(this);
		refreshPortaO.addActionListener(this);
		listaPortaO.addListSelectionListener(this);
		

			break;
		default:
			JOptionPane.showMessageDialog(null,"Opcao nao encontrada!", null, 
					JOptionPane.ERROR_MESSAGE);
		}

	}
	/**
    * Pesquisa um oculos na lista de oculos
	* @param texto uma string que contem o modelo que se deseja pesquisar na lista
     */

	public void pesquisarlistaOcul(String texto){
		if (controleD.getQntOculos() > 0){
	    int pos = listaOcul.getNextMatch(texto, 0, Position.Bias.Forward);
	    listaOcul.setSelectedIndex(pos);
	    listaOcul.ensureIndexIsVisible(pos);
		}
	}
	/**
    * Pesquisa um porta oculos na lista de porta oculos
	* @param texto uma string que contem o modelo que se deseja pesquisar na lista
     */
	public void pesquisarListaPortaO(String texto){
		if (controleD.getQntPortaOculos() > 0){
	    int pos = listaPortaO.getNextMatch(texto, 0, Position.Bias.Forward);
	    listaPortaO.setSelectedIndex(pos);
	    listaPortaO.ensureIndexIsVisible(pos);
		}
	}

	/**
    * Captura eventos dos botoes da interface
	*(1) Caso o botao de cadastrar oculos seja clicado, chama o metodo acoesProduto na TelaDetalheProduto, tornando possivel cadastrar
	*(2) Caso o botao de dar refresh nos oculos seja clicado, atualiza as listas com os novos dados
	*(3) Caso o botao de cadastrar porta-oculos seja clicado, chama o metodo acoesProduto na TelaDetalheProduto, tornando possivel cadastrar
	*(4) Caso o botao refresh dos porta-oculos seja clicado, atualiza a lista com novos dados
	* @param e um evento ActionEvent 
     */
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == cadastroOculos)
			new TelaDetalheProduto().acoesProduto(controleD, 1, 0);
		
		if(src == refreshOculos) {
			listaOcul.setListData(new ControleOculos(controleD).getModelo());			
			listaOcul.updateUI();
		}
		if(src == cadastroPortaO)
			new TelaDetalheProduto().acoesProduto(controleD, 2, 0);
		
		if(src == refreshPortaO) {
			listaPortaO.setListData(new ControlePortaO(controleD).getModelo());			
			listaPortaO.updateUI();
		}
	}
	/**
    * Captura eventos dos itens da lista de Oculos e Porta Oculos
	* @param e um evento
     */
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();
	
		if(e.getValueIsAdjusting() && src == listaOcul) {
			new TelaDetalheProduto().acoesProduto(controleD, 3,
			listaOcul.getSelectedIndex());
		}

		if(e.getValueIsAdjusting() && src == listaPortaO) {
			new TelaDetalheProduto().acoesProduto(controleD, 4,
			listaPortaO.getSelectedIndex());
			}
	
}

}
