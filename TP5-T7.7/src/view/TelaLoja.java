package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import control.*;
/**
    *Mostra toda a interface de venda e da loja, incluindo lista, botoes 
    *@author Adne Moretti e Gabriel Moretti - T7.7
    *@version 1.0(Out 2021)
*/
public class TelaLoja implements ActionListener, ListSelectionListener {
    private JFrame frame;
	private JLabel titulo;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JButton vender;
	private JButton refreshVenda = new JButton("Refresh");
	private JButton refreshLoja;
	private JButton editar;
	private JLabel nome;
	private JLabel qntEst;
	private JLabel CNPJ;
	private JLabel label4;
	private JLabel endereco;
	private JLabel label5;
	private JLabel qntFunc;
	private JLabel label6;
	private JLabel horario;
    private JList<String> listaVendas;
	private JScrollPane scrollVendas;
    private String[] clientesVendas = new String[100];
    private int escolha;
	private String texto;
	private static ControleDados controleD;
	/**
    *Lista todos as vendas e a loja cadastradas, mostra a opcao de editar e refresh atraves de botoes
    *@param dados do tipo ControleDados para pegar dados necessarios e manipula-los
	*@param esc do tipo int, que contem o dado do botao que foi clicado, caso 1 mostra os dados da loja, ja caso esc igual a 2 mostra a lista de vendas
	*/
    public void mostrarDados(ControleDados dados,int esc){
		controleD = dados;
		escolha = esc;
		if (escolha == 1) texto = "Dados da Loja de oculos";
		if (escolha == 2) texto = "Cadastro de Venda";

		frame = new JFrame(texto);
		titulo = new JLabel(texto);
		frame.setSize(800, 600);
		
		switch (escolha) {
		case 1:
			
			label1 = new JLabel("Nome:");
			label2 = new JLabel("Quantidade em estoque:");
			label3 = new JLabel("CNPJ:");
			label4 = new JLabel("Endereco:");
			label5 = new JLabel("Quantidade de funcionarios:");
			label6 = new JLabel("Horario:");
			refreshLoja = new JButton("Refresh");
			editar =  new JButton("Editar");
			nome = new JLabel(controleD.getLoja().getNome());
			qntEst = new JLabel(String.valueOf(controleD.getLoja().getQntEst()));
			CNPJ = new JLabel(String.valueOf(controleD.getLoja().getCNPJ()));
			endereco = new JLabel(controleD.getLoja().getEndereco());
			qntFunc = new JLabel(String.valueOf(controleD.getQntFunc()));
			horario = new JLabel(String.valueOf(controleD.getLoja().getHorarioFunc()));
			
			titulo.setBounds(300, 10, 450, 30);
			label1.setBounds(200, 50, 180, 35);
			nome.setBounds(350, 50, 180, 35);
			label2.setBounds(100, 110, 200, 35);
			qntEst.setBounds(350, 110, 180, 35);
			label3.setBounds(200, 170, 180, 35);
			CNPJ.setBounds(350, 170, 180, 35);
			label4.setBounds(200, 230, 180, 35);
			endereco.setBounds(350, 230, 180, 35);
			label5.setBounds(100, 290, 250, 35);
			qntFunc.setBounds(350, 290, 200, 35);
			label6.setBounds(200, 350, 180, 35);
			horario.setBounds(350, 350, 180, 35);
			editar.setBounds(235, 450, 120, 35);
			refreshLoja.setBounds(390, 450, 120, 35);

			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			label1.setFont(new Font("Asap", Font.BOLD, 15));
			label2.setFont(new Font("Asap", Font.BOLD, 15));
			label3.setFont(new Font("Asap", Font.BOLD, 15));
			label4.setFont(new Font("Asap", Font.BOLD, 15));
			label5.setFont(new Font("Asap", Font.BOLD, 15));
			label6.setFont(new Font("Asap", Font.BOLD, 15));

			frame.add(titulo);
			frame.add(label1);
			frame.add(nome);
			frame.add(label2);
			frame.add(qntEst);
			frame.add(label3);
 			frame.add(CNPJ);
 			frame.add(label4);
 			frame.add(endereco);
 			frame.add(label5);
 			frame.add(qntFunc);
 			frame.add(label6);
			frame.add(horario);
			frame.add(editar);
			frame.add(refreshLoja);
			
			frame.setLayout(null);
			frame.setVisible(true);
			editar.addActionListener(this);
			refreshLoja.addActionListener(this);
			break;
		case 2:
			frame = new JFrame("Vendas");
			titulo = new JLabel("Vendas");
			vender = new JButton("Vender");
			refreshVenda = new JButton("Refresh");
			if (controleD.getQntClientes() > 0){
			clientesVendas = new ControleVenda(controleD).getCliente();
			listaVendas = new JList<String>(clientesVendas);
			} else {
			String[] clientesVendas = {};
			listaVendas = new JList<String>(clientesVendas);
			}
			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(350, 10, 250, 30);

			vender.setBounds(235, 450, 120, 35);
			listaVendas.setBounds(60, 40, 675, 425);
			listaVendas.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listaVendas.setVisibleRowCount(10);
			refreshVenda.setBounds(390, 450, 120, 35);
			scrollVendas = new JScrollPane(listaVendas);
			frame.setLayout(null);
			scrollVendas.setBounds(200, 100, 150, 200); 
			scrollVendas.setSize(350, 250);
		    scrollVendas.setVisible(true);

			frame.add(titulo);
			frame.add(scrollVendas);
			frame.add(vender);
			frame.add(refreshVenda);
			
			
			frame.setSize(800, 600);  
			frame.setVisible(true);

			vender.addActionListener(this);
			refreshVenda.addActionListener(this);
			listaVendas.addListSelectionListener(this);
			break;
		default:
			break;
		}
        
    }
	/**
    * Captura eventos dos botoes da interface
	*(1) Caso o botao de editar seja clicado, chama o metodo acoesLoja na TelaDetalheLoja, tornando possivel editar
	*(2) Caso o botao de dar refresh na loja seja clicado, recarrega o frame com novos dados
	*(3) Caso o botao vender seja clicado, chama o metodo acoesLoja na TelaDetalheLoja
	*(4) Caso o botao refresh da venda seja clicado, atualiza a lista com novos dados
	* @param e um evento ActionEvent 
     */
    public void actionPerformed(ActionEvent e) {
		Object botao = e.getSource();
		
		if(botao == editar)
			new TelaDetalheLoja().acoesLoja(controleD, 1, 0);
		
		if(botao == refreshLoja) {

			frame.dispose();
			frame.repaint();
			mostrarDados(controleD, 1);
			
		}
		
		if(botao == vender){
			if (controleD.getQntClientes() > 0 && controleD.getQntOculos() > 0 && controleD.getQntPortaOculos() > 0){
				new TelaDetalheLoja().acoesLoja(controleD, 2, 0);
			}else{
				JOptionPane.showMessageDialog(null, "Nao existem dados suficientes para vendas!", null, 
							JOptionPane.ERROR_MESSAGE);
				}
		}
		
		if(botao == refreshVenda) {
			if (controleD.getQntClientes() > 0){
				listaVendas.setListData(new ControleVenda(controleD).getCliente());			
				listaVendas.updateUI();
			}
		}
		
	}
    	
    /**
    * Captura eventos dos itens da lista de Vendas
	* @param e um evento
     */
    public void valueChanged(ListSelectionEvent e) {
    	Object src = e.getSource();
    	
    	if(e.getValueIsAdjusting() && src == listaVendas) {
    		new TelaDetalheLoja().acoesLoja(controleD, 3,
    				listaVendas.getSelectedIndex());
    	}
    	
    }


}