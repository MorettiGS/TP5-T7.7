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
    *Mostra toda a interface de processos envolvendo os clientes e funcionarios, incluindo lista, botoes 
    *@author Adne Moretti e Gabriel Moretti - T7.7
    *@version 1.0(Out 2021)
*/
public class TelaDetalhePessoa implements ActionListener {		
	private JFrame frame;
	private JLabel titulo;
	private JLabel label1 = new JLabel("ID:");
	private JTextField ID;
	private JLabel label2 = new JLabel("Nome:");
	private JTextField nome;
	private JLabel label3 = new JLabel("CPF:");
	private JTextField CPF;
	private JLabel label4 = new JLabel("Email:");
	private JTextField email;
	private JLabel label5 = new JLabel("Endereco:");
	private JTextField endereco;
	private JLabel label6 = new JLabel("Telefone:");
	private JTextField DDD;
	private JTextField telefone;
	private JLabel label7 = new JLabel("Grau:");
	private JTextField grau = new JTextField(200);
	private JLabel label8 = new JLabel("Cargo:");
	private JTextField cargo = new JTextField(200);
	private JLabel label9 = new JLabel("Salario:");
	private JTextField salario = new JTextField(200);
	private JButton cadastrar = new JButton("Cadastrar");;
	private JButton excluir = new JButton("Excluir");
	private String[] novoCadastro = new String[100];
	private static ControleDados controleD;
	private int escolha;
	private String texto;
	private int pos;
	private boolean funcionou;

	/**
    *Lista todos os dados dos clientes e funcionarios, dando a opcao de editar os seus dados.
	*Nessa tela tambem sao realizados os cadastros de clientes e funcionarios
    *@param dados do tipo ControleDados para pegar dados necessarios e manipula-los
	*@param esc do tipo int, que contem o dado do botao que foi clicado, caso 1 mostra os dados da loja pra edicao, caso esc igual a 2 
				mostra aos dados da venda selecionada pra edicao e caso esc seja igual a 3 cadastra uma nova venda
   	*@param posicao do tipo int para pegar a posicao a ser manipulada
	*/
	public void acoesPessoa(ControleDados dados,int esc, int posicao){
		controleD = dados;
		escolha = esc;
		pos = posicao;
		
			if (escolha == 1) texto = "Cadastro de Cliente";
			if (escolha == 2) texto = "Cadastro de Funcionario";
			if (escolha == 3) texto = "Detalhes de Cliente";
			if (escolha == 4) texto = "Detalhes de Funcionario";

			frame = new JFrame(texto);
			titulo = new JLabel(texto);
			
			if(escolha == 3){
				ID = new JTextField(String.valueOf(controleD.getClientes()[pos].getId()), 200);
				nome = new JTextField(controleD.getClientes()[pos].getNome(), 200);
				CPF = new JTextField(String.valueOf(controleD.getClientes()[pos].getCPF()), 200);
				email = new JTextField(controleD.getClientes()[pos].getEmail(), 200);
				endereco = new JTextField(controleD.getClientes()[pos].getEndereco(), 200);
				DDD =  new JTextField(String.valueOf(controleD.getClientes()[pos].getNumTel().getDdd()), 200);
				telefone = new JTextField(String.valueOf(controleD.getClientes()[pos].getNumTel().getNumero()), 200);
				grau = new JTextField(String.valueOf(controleD.getClientes()[pos].getGrau()), 200);
			} else if (escolha == 4){
				ID = new JTextField(String.valueOf(controleD.getFuncionarios()[pos].getId()), 200);
				nome = new JTextField(controleD.getFuncionarios()[pos].getNome(), 200);
				CPF = new JTextField(String.valueOf(controleD.getFuncionarios()[pos].getCPF()), 200);
				email = new JTextField(controleD.getFuncionarios()[pos].getEmail(), 200);
				endereco = new JTextField(controleD.getFuncionarios()[pos].getEndereco(), 200);
				DDD =  new JTextField(String.valueOf(controleD.getFuncionarios()[pos].getNumTel().getDdd()), 200);
				telefone = new JTextField(String.valueOf(controleD.getFuncionarios()[pos].getNumTel().getNumero()), 200);
				cargo = new JTextField(controleD.getFuncionarios()[pos].getCargo(), 200);
				salario = new JTextField(String.valueOf(controleD.getFuncionarios()[pos].getSalario()), 200);
			} else {
				ID = new JTextField(200);
				nome = new JTextField(200);
				CPF = new JTextField(200);
				email = new JTextField(200);
				endereco = new JTextField(200);
				DDD =  new JTextField(200);
				telefone = new JTextField(200);
				
				cadastrar.setBounds(300, 470, 120, 35);
			}

			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			label1.setFont(new Font("Asap", Font.BOLD, 15));
			label2.setFont(new Font("Asap", Font.BOLD, 15));
			label3.setFont(new Font("Asap", Font.BOLD, 15));
			label4.setFont(new Font("Asap", Font.BOLD, 15));
			label5.setFont(new Font("Asap", Font.BOLD, 15));
			label6.setFont(new Font("Asap", Font.BOLD, 15));
			label7.setFont(new Font("Asap", Font.BOLD, 15));
			label8.setFont(new Font("Asap", Font.BOLD, 15));
			label9.setFont(new Font("Asap", Font.BOLD, 15));
			titulo.setBounds(300, 10, 250, 30);
			label1.setBounds(200, 50, 180, 35);
			ID.setBounds(350, 50, 180, 35);
			label2.setBounds(200, 100, 180, 35);
			nome.setBounds(350, 100, 180, 35);
			label3.setBounds(200, 150, 180, 35);
			CPF.setBounds(350, 150, 180, 35);
			label4.setBounds(200, 200, 180, 35);
			email.setBounds(350, 200, 180, 35);
			label5.setBounds(200, 250, 180, 35);
			endereco.setBounds(350, 250, 180, 35);
			label6.setBounds(200, 300, 180, 35);
			DDD.setBounds(350, 300, 50, 35);
			telefone.setBounds(400, 300, 130, 35);
			label7.setBounds(200, 350, 180, 35);
			grau.setBounds(350, 350, 180, 35);
			label8.setBounds(200, 350, 180, 35);
			cargo.setBounds(350, 350, 180, 35);
			label9.setBounds(200, 400, 180, 35);
			salario.setBounds(350, 400, 180, 35);

			frame.setLayout(null);
			frame.setResizable(false);

			frame.add(titulo);
			frame.add(label1);
			frame.add(ID);
			frame.add(label2);
			frame.add(nome);
			frame.add(label3);
 			frame.add(CPF);
 			frame.add(label4);
 			frame.add(email);
 			frame.add(label5);
 			frame.add(endereco);
 			frame.add(label6);
			frame.add(DDD);
			frame.add(telefone);
			frame.add(cadastrar);
			
			if (escolha == 1 || escolha == 3) {
				frame.add(label7);
				frame.add(grau);
			}
			if (escolha == 2 || escolha == 4) {
				frame.add(label8);
				frame.add(cargo);
				frame.add(label9);
				frame.add(salario);
				frame.add(excluir);
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
	*(1) Caso o botao de cadastrar seja clicado, passa os dados editados como uma array de strings para os metodos acoesCliente ou acoesFunc do ControleDados
	*(2) Caso o botao excluir seja clicado, chama o metodo removerVenda do ControleDados na TelaDetalheLoja para dois casos diferentes
	, dependendo se for uma exclusao de clientes ou funcionarios
	* @param e um evento ActionEvent 
	*/
	public void actionPerformed(ActionEvent e) {
		Object botao = e.getSource();

		if(botao == cadastrar) {
			if(escolha == 1)
				novoCadastro[0] = Integer.toString(controleD.getQntClientes());
			else if (escolha == 2) 
				novoCadastro[0] = Integer.toString(controleD.getQntFunc());
			else
				novoCadastro[0] = Integer.toString(pos);

			novoCadastro[1] =  ID.getText();
			novoCadastro[2] =  nome.getText();
			novoCadastro[3] =  CPF.getText();
			novoCadastro[4] =  email.getText();
			novoCadastro[5] =  endereco.getText();
			novoCadastro[6] =  DDD.getText(); 
			novoCadastro[7] =  telefone.getText();
			
			
			try {
				if (escolha == 1 || escolha == 3) {
				
					novoCadastro[8] =  grau.getText();
					funcionou = controleD.acoesCliente(novoCadastro);
					if(funcionou) {
						JOptionPane.showMessageDialog(null, "Os dados foram salvos com sucesso!", null, 
							JOptionPane.INFORMATION_MESSAGE);
						frame.dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "Nao foi possivel cadastrar o cliente!", null, 
								JOptionPane.ERROR_MESSAGE);
					}
				}
			 	else {
				novoCadastro[8] =  cargo.getText();
				novoCadastro[9] =  salario.getText();
				funcionou = controleD.acoesFunc(novoCadastro);
				if(funcionou){
					JOptionPane.showMessageDialog(null, "Os dados foram salvos com sucesso!", null, 
						JOptionPane.INFORMATION_MESSAGE);
					frame.dispose();
					} else {
					JOptionPane.showMessageDialog(null, "Nao foi possivel cadastrar o funcionario!", null, 
							JOptionPane.ERROR_MESSAGE);}
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
				controleD.removerCli(pos);
			}
				
			if (escolha == 4){ 
				controleD.removerFunc(pos);
			}
			JOptionPane.showMessageDialog(null, "Os dados foram excluidos com sucesso!", null, 
					JOptionPane.INFORMATION_MESSAGE);
			frame.dispose();
			
		}
	
	}
}
