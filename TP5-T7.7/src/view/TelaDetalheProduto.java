package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import control.*;


/**
    *Mostra toda a interface de processos envolvendo os oculos e porta-oculos, incluindo lista, botoes 
    *@author Adne Moretti e Gabriel Moretti - T7.7
    *@version 1.0(Out 2021)
*/

public class TelaDetalheProduto implements ActionListener {		
	private JFrame frame;
	private JLabel titulo;
	private JLabel label1 = new JLabel("ID:");
	private JTextField ID;
	private JLabel label2 = new JLabel("Preco (R$):");
	private JTextField preco;
	private JLabel label3 = new JLabel("Modelo:");
    private JTextField modelo;
	private JLabel label4 = new JLabel("Descricao:");
	private JTextField descricao;
	private JLabel label5 = new JLabel("Tipo:");
	private JTextField tipo = new JTextField(200);
	private JLabel label6 = new JLabel("Cor:");
	private JTextField cor = new JTextField(200);
	private JButton cadastrar = new JButton("Cadastrar");
	private String[] novoCadastro = new String[100];
	private JButton excluir = new JButton("Excluir");
	private static ControleDados controleD;
	private boolean funcionou;
	private int escolha;
	private String texto;
	private int pos;
	/**
    *Lista todos os dados do oculos e porta-oculos selecionado na lista, dando a opcao de editar os seus dados, 
	 essa tela tambem realiza o cadastro de uma nova venda
    *@param dados do tipo ControleDados para pegar dados necessarios e manipula-los
	*@param esc do tipo int, que contem o dado do botao que foi clicado, caso 1 pede os dados para cadastro de oculos, 
				caso esc igual a 2 pede os dados para cadastro de porta-oculos, caso 3 mostra os dados do porta-oculos e permite edicao e caso 4
				mostra os dados do porta-oculos e permite edicao
   	*@param posicao do tipo int que contem a posicao da venda a ser editada e cadastrada
	*/
	public void acoesProduto(ControleDados dados,int esc,int posicao){
		controleD = dados;
		escolha = esc;
		pos = posicao;
			if (escolha == 1) texto = "Cadastro de Oculos";
			if (escolha == 2) texto = "Cadastro de Porta-oculos";
			if (escolha == 3) texto = "Detalhes de Oculos";
			if (escolha == 4) texto = "Detalhes de Porta-oculos";

			frame = new JFrame(texto);
			titulo = new JLabel(texto);

		if(escolha == 3){
		
			ID = new JTextField(String.valueOf(controleD.getOculos()[pos].getId()), 200);
			preco = new JTextField(String.valueOf(controleD.getOculos()[pos].getPreco()), 200);
			modelo = new JTextField(controleD.getOculos()[pos].getModelo(), 200);
			descricao = new JTextField(controleD.getOculos()[pos].getDescricao(), 200);
			tipo = new JTextField(controleD.getOculos()[pos].getTipo(), 200);

		} else if (escolha == 4){
			
			ID = new JTextField(String.valueOf(controleD.getPortaOculos()[pos].getId()), 200);
			preco = new JTextField(String.valueOf(controleD.getPortaOculos()[pos].getPreco()), 200);
			modelo = new JTextField(controleD.getPortaOculos()[pos].getModelo(), 200);
			descricao = new JTextField(controleD.getPortaOculos()[pos].getDescricao(), 200);
			cor = new JTextField(controleD.getPortaOculos()[pos].getCor(), 200);

		} else {
			ID = new JTextField(200);
			preco = new JTextField(200);
			modelo = new JTextField(200);
			descricao = new JTextField(200);
			tipo = new JTextField(200);
			cadastrar.setBounds(300, 470, 120, 35);
		}



		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		label1.setFont(new Font("Asap", Font.BOLD, 15));
		label2.setFont(new Font("Asap", Font.BOLD, 15));
		label3.setFont(new Font("Asap", Font.BOLD, 15));
		label4.setFont(new Font("Asap", Font.BOLD, 15));
		label5.setFont(new Font("Asap", Font.BOLD, 15));
		label6.setFont(new Font("Asap", Font.BOLD, 15));
		titulo.setBounds(300, 10, 250, 30);
		label1.setBounds(200, 50, 180, 35);
		ID.setBounds(350, 50, 180, 35);
		label2.setBounds(200, 110, 180, 35);
		preco.setBounds(350, 110, 180, 35);
		label3.setBounds(200, 170, 180, 35);
		modelo.setBounds(350, 170, 180, 35);
		label4.setBounds(200, 230, 180, 35);
		descricao.setBounds(350, 230, 180, 35);
		label5.setBounds(200, 290, 180, 35);
		tipo.setBounds(350, 290, 180, 35);
		label6.setBounds(200, 290, 180, 35);
		cor.setBounds(350, 290, 180, 35);

		frame.setLayout(null);
		frame.setResizable(false);

			frame.add(titulo);
			frame.add(label1);
			frame.add(ID);
			frame.add(label2);
			frame.add(preco);
			frame.add(label3);
 			frame.add(modelo);
 			frame.add(label4);
			frame.add(descricao);
			frame.add(cadastrar);


		if (escolha == 1 || escolha == 3) {
				frame.add(label5);
				frame.add(tipo);
			}
			if (escolha == 2 || escolha == 4) {
				frame.add(label6);
				frame.add(cor);
			}

			if (escolha == 3 || escolha == 4) {
				cadastrar.setBounds(235, 470, 120, 35);
				excluir.setBounds(390, 470, 120, 35);
				frame.add(excluir);
			}
			
			cadastrar.addActionListener(this);
			excluir.addActionListener(this);
			frame.setSize(800, 600);
			frame.setVisible(true);
			
	}

	/**
    * Captura eventos dos botoes da interface, caso os dados nao estejam corretamente validados, mostra mensagens de erro
	caso estejam, apenas informa que a acao foi bem sucedida
	*(1) Caso o botao de cadastrar seja clicado, passa os dados editados como uma array de strings para o metodo acoesOculos e acoesPortaOculos do ControleDados
	*(3) Caso o botao excluir seja clicado, chama o metodo removerOculos e removerPortaOculos do ControleDados 
	* @param e um evento ActionEvent 
*/
	public void actionPerformed(ActionEvent e) {
		Object botao = e.getSource();

		if(botao == cadastrar) {
			if(escolha == 1)
				novoCadastro[0] = Integer.toString(controleD.getQntOculos());
			else if (escolha == 2) 
				novoCadastro[0] = Integer.toString(controleD.getQntPortaOculos());
			else
				novoCadastro[0] = Integer.toString(pos);
			novoCadastro[1] =  ID.getText();
			novoCadastro[2] =  preco.getText();
			novoCadastro[3] =  modelo.getText();
			novoCadastro[4] =  descricao.getText();
			
			
			try {
			if (escolha == 1 || escolha == 3) {
				novoCadastro[5] =  tipo.getText();
				funcionou = controleD.acoesOculos(novoCadastro);
				if(funcionou) {
					JOptionPane.showMessageDialog(null, "Os dados foram salvos com sucesso!", null, 
						JOptionPane.INFORMATION_MESSAGE);
						frame.dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Nao foi possivel cadastrar o produto!", null, 
							JOptionPane.ERROR_MESSAGE);
				}
				
			} else {
				novoCadastro[5] =  cor.getText();
				funcionou = controleD.acoesPortaO(novoCadastro);
				if(funcionou) {
					JOptionPane.showMessageDialog(null, "Os dados foram salvos com sucesso!", null, 
						JOptionPane.INFORMATION_MESSAGE);
						frame.dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Nao foi possivel cadastrar o produto!", null, 
							JOptionPane.ERROR_MESSAGE);
				}
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

		if(botao == excluir) {

			if (escolha == 3) {
				controleD.removerOculos(pos);
			}
				
			if (escolha == 4){
				controleD.removerPortaO(pos);
			}
			JOptionPane.showMessageDialog(null, "Os dados foram excluidos com sucesso!", null, 
					JOptionPane.INFORMATION_MESSAGE);
			frame.dispose();
			
		}
	}
}
