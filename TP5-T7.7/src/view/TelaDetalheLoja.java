package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import control.*;

/**
    *Mostra toda a interface de processos envolvendo venda e da loja
    *@author Adne Moretti e Gabriel Moretti - T7.7
    *@version 1.0(Out 2021)
*/

public class TelaDetalheLoja implements ActionListener{
private JFrame frame;
private JLabel titulo;
private JButton editar =  new JButton("Editar");
private JButton vender =  new JButton("Vender");
private JButton excluir =  new JButton("Excluir");
private JLabel label1;
private JTextField nome;
private JLabel label2;
private JTextField qntEst;
private JLabel label3;
private JTextField CNPJ;
private JLabel label4;
private JTextField endereco;
private JLabel label5;
private JLabel qntFunc;
private JLabel label6;
private JTextField horario;
private String texto;
private JComboBox<String> clienteVenda;
private String[] clienteNomes;
private JComboBox<String> oculosVenda;
private String[] oculosModelos;
private JComboBox<String> portaOVenda;
private String[] portaOModelos;
private String[] dadosLoja = new String[100];
private int[] dadosVenda = new int[6];
private int escolha, pos;
private String cli, oculos, portaO;
private static ControleDados controleD;
private boolean funcionou;
private int funcionouEstoque;
private JTextField quantidadeOculos;
private JTextField quantidadePortaOculos;

/**
    *Lista todos os dados da loja e da venda, dando a opcao de editar os seus dados, essa tela tambem realiza o cadastro de uma nova venda
    *@param dados do tipo ControleDados para pegar dados necessarios e manipula-los
	*@param esc do tipo int, que contem o dado do botao que foi clicado, caso 1 mostra os dados da loja pra edicao, caso esc igual a 2 
				mostra aos dados da venda selecionada pra edicao e caso esc seja igual a 3 cadastra uma nova venda
   	*@param posicao do tipo int que contem a posicao da venda a ser editada e cadastrada
*/

public void acoesLoja(ControleDados dados,int esc, int posicao){
	controleD = dados;
	escolha = esc;
	pos = posicao;
	
	if (escolha == 1) texto = "Edicao de Loja";
	if (escolha == 3) texto = "Edicao de venda";
	if (escolha == 2) texto = "Cadastro de Venda";
	

	frame = new JFrame(texto);
	titulo = new JLabel(texto);
	
	if (escolha == 2 || escolha == 3){
	if(escolha == 3){
		
		clienteNomes = new ControleCliente(controleD).getNome();
		clienteVenda = new JComboBox<String>(clienteNomes);
		oculosModelos = new ControleOculos(controleD).getModelo();
		quantidadeOculos = new JTextField(String.valueOf(controleD.getVenda()[pos].getQntVendaOculos()), 200);
		oculosVenda = new JComboBox<String>(oculosModelos);
		quantidadePortaOculos = new JTextField(String.valueOf(controleD.getVenda()[pos].getQntVendaPortaOculos()), 200);
		portaOModelos = new ControlePortaO(controleD).getModelo();
		portaOVenda = new JComboBox<String>(portaOModelos);


		cli = controleD.getVenda()[pos].getCliente().getNome();
		oculos = controleD.getVenda()[pos].getOculos().getModelo();
		portaO = controleD.getVenda()[pos].getPortaO().getModelo();

		clienteVenda.setSelectedItem(cli);
		oculosVenda.setSelectedItem(oculos);
		portaOVenda.setSelectedItem(portaO);

		editar.setBounds(300, 470, 120, 35);
		excluir.setBounds(300, 470, 120, 35);
	} else {
		clienteNomes = new ControleCliente(controleD).getNome();
		clienteVenda = new JComboBox<String>(clienteNomes);
		oculosModelos = new ControleOculos(controleD).getModelo();
		quantidadeOculos = new JTextField(200);
		oculosVenda = new JComboBox<String>(oculosModelos);
		quantidadePortaOculos = new JTextField(200);
		portaOModelos = new ControlePortaO(controleD).getModelo();
		portaOVenda = new JComboBox<String>(portaOModelos);

		vender.setBounds(315, 470, 120, 35);
	}

	titulo.setFont(new Font("Arial", Font.BOLD, 20));
	
	label1 = new JLabel("Cliente: ");
	label2 = new JLabel("Oculos: ");
	label3 = new JLabel("Porta-oculos: ");
	label4 = new JLabel("Quantidade: ");
	label5 = new JLabel("Quantidade: ");

	label1.setFont(new Font("Asap", Font.BOLD, 15));
	label2.setFont(new Font("Asap", Font.BOLD, 15));
	label3.setFont(new Font("Asap", Font.BOLD, 15));
	label4.setFont(new Font("Asap", Font.BOLD, 15));
	label5.setFont(new Font("Asap", Font.BOLD, 15));
	
	titulo.setBounds(300, 10, 250, 30);
	label1.setBounds(100, 110, 180, 35);
	clienteVenda.setBounds(220, 110, 180, 35);
	label2.setBounds(100, 170, 180, 35);
	oculosVenda.setBounds(220, 170, 180, 35);
	label3.setBounds(100, 230, 180, 35);
	portaOVenda.setBounds(220, 230, 180, 35);
	label4.setBounds(450, 170, 180, 35);
	quantidadeOculos.setBounds(550, 170, 100, 35);
	label5.setBounds(450, 230, 180, 35);
	quantidadePortaOculos.setBounds(550, 230, 100, 35);
	frame.setLayout(null);
	frame.setResizable(false);

	frame.add(titulo);
	frame.add(label1);
	frame.add(clienteVenda);
	frame.add(label2);
	frame.add(oculosVenda);
	frame.add(label4);
	frame.add(quantidadeOculos);
	frame.add(label3);
	frame.add(portaOVenda);
	frame.add(label5);
	frame.add(quantidadePortaOculos);
	frame.add(vender);
	
	clienteVenda.addActionListener(this);
	oculosVenda.addActionListener(this);
	portaOVenda.addActionListener(this);
	
	
	
	
	}

	if(escolha == 1) {
		nome = new JTextField(controleD.getLoja().getNome(), 200);
		qntEst = new JTextField(String.valueOf(controleD.getLoja().getQntEst()), 200);
		CNPJ = new JTextField(controleD.getLoja().getCNPJ(), 200);
		endereco = new JTextField(controleD.getLoja().getEndereco(), 200);
		qntFunc = new JLabel(String.valueOf(controleD.getQntFunc()));
		horario = new JTextField(controleD.getLoja().getHorarioFunc(), 200);
		
		label1 = new JLabel("Nome: ");
		label2 = new JLabel("Quantidade de Estoque: ");
		label3= new JLabel("CNPJ: ");
		label4 = new JLabel("Endereco: ");
		label5= new JLabel("Quantidade de funcionarios: ");
		label6= new JLabel("Horario: "); 

		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		label1.setFont(new Font("Asap", Font.BOLD, 15));
		label2.setFont(new Font("Asap", Font.BOLD, 15));
		label3.setFont(new Font("Asap", Font.BOLD, 15));
		label4.setFont(new Font("Asap", Font.BOLD, 15));
		label5.setFont(new Font("Asap", Font.BOLD, 15));
		label6.setFont(new Font("Asap", Font.BOLD, 15));
		titulo.setBounds(300, 10, 250, 30);
		label1.setBounds(200, 50, 180, 35);
		nome.setBounds(350, 50, 180, 35);
		label2.setBounds(100, 110, 180, 35);
		qntEst.setBounds(350, 110, 180, 35);
		label3.setBounds(200, 170, 180, 35);
		CNPJ.setBounds(350, 170, 180, 35);
		label4.setBounds(200, 230, 180, 35);
		endereco.setBounds(350, 230, 180, 35);
		label5.setBounds(100, 290, 250, 35);
		qntFunc.setBounds(350, 290, 180, 35);
		label6.setBounds(200, 350, 180, 35);
		horario.setBounds(350, 350, 180, 35);
		editar.setBounds(300, 420, 120, 35);
		
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
		frame.setSize(800, 600);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setVisible(true);
		

		editar.addActionListener(this);

		
	} 

	if (escolha == 3 || escolha == 4) {
		vender.setBounds(200, 470, 120, 35);
		excluir.setBounds(400, 470, 120, 35);
		frame.add(excluir);
	}
	
	excluir.addActionListener(this);

	vender.addActionListener(this);
	frame.setSize(800, 600);
	frame.setVisible(true);
	
    
}
/**
    * Captura eventos dos botoes da interface, caso os dados nao estejam corretamente validados, mostra mensagens de erro
	caso estejam, apenas informa que a acao foi bem sucedida
	*(1) Caso o botao de editar seja clicado, passa os dados editados como uma array de strings para o metodo acoesLoja do ControleDados
	*(2) Caso o botao de vender seja clicado, passa os dados inseridos na Venda como uma array de posicoes para o metodo acoesVenda do ControleDados, 
	esse metodo valida as entradas, cadastra e edita vendas
	*(3) Caso o botao excluir seja clicado, chama o metodo removerVenda do ControleDados
	* @param e um evento ActionEvent 
*/
public void actionPerformed(ActionEvent e) {
	Object src = e.getSource();
	
	if(src == editar){
		try {
		dadosLoja[0] = nome.getText();
		dadosLoja[1] = qntEst.getText();
		dadosLoja[2] = CNPJ.getText();
		dadosLoja[3] = endereco.getText();
		dadosLoja[4] = qntFunc.getText();
		dadosLoja[5] = horario.getText();
		
		funcionou  = controleD.acoesLoja(dadosLoja);
		if(funcionou) {
			JOptionPane.showMessageDialog(null, "Os dados foram salvos com sucesso!", null, 
				JOptionPane.INFORMATION_MESSAGE);
			frame.dispose();
		}
		else {
			JOptionPane.showMessageDialog(null, "Nao foi possivel editar a loja!", null, 
								JOptionPane.ERROR_MESSAGE);
		}
		
		} catch (NullPointerException exc1) {
		JOptionPane.showMessageDialog(null, "Nao foi possível cadastrar dados vazios!", null, 
				JOptionPane.ERROR_MESSAGE);
		
		} catch (NumberFormatException exc2) {
		JOptionPane.showMessageDialog(null, "Nao foi possivel cadastrar!", null, 
				JOptionPane.ERROR_MESSAGE);
		} finally {

		}
	}

	if (src == vender){
		try {
		
		if (escolha == 2){
			dadosVenda[0] = controleD.getQntVendas();
		} else if (escolha == 3){
			dadosVenda[0] = pos;
		}
		dadosVenda[1] = clienteVenda.getSelectedIndex();
		dadosVenda[2] = oculosVenda.getSelectedIndex();
		dadosVenda[3] = portaOVenda.getSelectedIndex();
		dadosVenda[4] = Integer.parseInt(quantidadeOculos.getText());
		dadosVenda[5] = Integer.parseInt(quantidadePortaOculos.getText());
		
		
		funcionouEstoque = controleD.validarQntEst(dadosVenda);
		if(funcionouEstoque == 2){
			JOptionPane.showMessageDialog(null, "A quantidade vendida ultrapassa a quantidade em estoque!", null, 
					JOptionPane.ERROR_MESSAGE);
		} else
		if (funcionouEstoque == 3){
			
			funcionou = controleD.acoesVenda(dadosVenda);
			if(funcionou){
				double multOcu = (controleD.getVenda()[pos].getOculos().getPreco() * (double)dadosVenda[4]);
				double multPortaO = (controleD.getVenda()[pos].getPortaO().getPreco() * (double)dadosVenda[5]);
				if(funcionouEstoque == 1){
					JOptionPane.showMessageDialog(null, "Venda salva com sucesso!\n\nO cliente '"+clienteVenda.getSelectedItem()
					+ "' comprou " + quantidadeOculos.getText() + " oculos do modelo '" + oculosVenda.getSelectedItem() + "'\n" 
					+ "e " + quantidadePortaOculos.getText() + " porta-oculos do modelo '" + portaOVenda.getSelectedItem() + "'."
					+ "\n\nO total de preços de todos os produtos foi R$" + (multOcu + multPortaO)
					+ ".\n\nA quantidade de estoque se esgotou!", null, 
					JOptionPane.INFORMATION_MESSAGE);
						frame.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Venda salva com sucesso!\n\nO cliente '"+clienteVenda.getSelectedItem()
					+ "' comprou " + quantidadeOculos.getText() + " oculos do modelo '" + oculosVenda.getSelectedItem() + "'\n" 
					+ "e " + quantidadePortaOculos.getText() + " porta-oculos do modelo '" + portaOVenda.getSelectedItem() + "'."
					+ "\n\nO total de preços de todos os produtos foi R$" + (multOcu + multPortaO), null, 
						JOptionPane.INFORMATION_MESSAGE);
						frame.dispose();
				}
				}
			else{
				JOptionPane.showMessageDialog(null, "Erro ao cadastrar os dados!", null, 
						JOptionPane.ERROR_MESSAGE);
			}
		}
		
		} catch (NullPointerException exc1) {
			JOptionPane.showMessageDialog(null, "Nao foi possível cadastrar dados vazios!", null, 
					JOptionPane.INFORMATION_MESSAGE);
			
		} catch (NumberFormatException exc2) {
			JOptionPane.showMessageDialog(null, "Nao foi possivel cadastrar!", null, 
					JOptionPane.INFORMATION_MESSAGE);
		} finally {

		}

	}

	if (src == excluir){
		int qntOculVenda = Integer.parseInt(quantidadeOculos.getText());
		int qntPortaOVenda = Integer.parseInt(quantidadePortaOculos.getText());
		controleD.removerVenda(pos, qntOculVenda, qntPortaOVenda);
		JOptionPane.showMessageDialog(null, "Os dados da venda foram excluidos com sucesso!", null, 
				JOptionPane.INFORMATION_MESSAGE);
		frame.dispose();
	}
	
}

}
