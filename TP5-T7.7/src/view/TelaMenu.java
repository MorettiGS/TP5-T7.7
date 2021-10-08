package view;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import control.*;
/**
    *Mostrar a tela inicial(menu) para a escolha das opcoes
    *@author Adne Moretti e Gabriel Moretti - T7.7
    *@version 1.0(Out 2021)
 */

public class TelaMenu implements ActionListener{
    private static JFrame frame = new JFrame("Menu");
    private static JLabel titulo = new JLabel("Loja de Oculos");
    private static JButton cliente = new JButton("Clientes");
    private static JButton oculos = new JButton("Oculos");
    private static JButton portaOculos = new JButton("Porta-oculos");
    private static JButton func = new JButton("Funcionarios");
    private static JButton loja = new JButton("Loja");
    private static JButton vender = new JButton("Vender");
    private static ControleDados controleD = new ControleDados();
    
    public TelaMenu(){
        titulo.setFont(new Font("Comic_Sans", Font.BOLD, 35));
    	titulo.setBounds(275, 50, 500, 40);
    	cliente.setFont(new Font("Comic_Sans", Font.BOLD, 15));
		cliente.setBounds(300, 140, 200, 40);
		oculos.setFont(new Font("Comic_Sans", Font.BOLD, 15));
		oculos.setBounds(300, 200, 200, 40);
		portaOculos.setFont(new Font("Comic_Sans", Font.BOLD, 15));
		portaOculos.setBounds(300, 260, 200, 40);
		func.setFont(new Font("Comic_Sans", Font.BOLD, 15));
        func.setBounds(300, 320, 200, 40);
        loja.setFont(new Font("Comic_Sans", Font.BOLD, 15));
		loja.setBounds(300, 380, 200, 40);
        vender.setFont(new Font("Comic_Sans", Font.BOLD, 15));
		vender.setBounds(300, 440, 200, 40);		

        frame.add(titulo);
        frame.add(cliente);
        frame.add(oculos);
        frame.add(portaOculos);
        frame.add(func);
        frame.add(loja);
        frame.add(vender);
        
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    /**
    * Adiciona os eventos de botoes do menu e chama as telas correspondentes a cada botao clicado
    * @param a um array de strings padrao para a main
     */
    public static void main(String[] a){
        TelaMenu menu =  new TelaMenu();
        cliente.addActionListener(menu);
		func.addActionListener(menu);
		oculos.addActionListener(menu);
        portaOculos.addActionListener(menu);
        loja.addActionListener(menu);
        vender.addActionListener(menu);

    }
    /**
    * Captura eventos dos botoes da interface
	*(1) Caso o botao de cliente seja clicado, chama a funcao mostrarDados da TelaPessoa para o caso 1
	*(2) Caso o botao de portaOculos seja clicado, chama a funcao mostrarDados da TelaProduto para o caso 2
    *(3) Caso o botao de oculos seja clicado, chama a funcao mostrarDados da TelaProduto para o caso 1
    *(4) Caso o botao de funcionario seja clicado, chama a funcao mostrarDados da TelaPessoa para o caso 2
    *(5) Caso o botao de loja seja clicado, chama a funcao mostrarDados da TelaLoja para o caso 1
    *(6) Caso o botao de vender seja clicado, chama a funcao mostrarDados da TelaLoja para o caso 2
	* @param e um evento ActionEvent 
     */
    public void actionPerformed(ActionEvent e) {
		Object botao = e.getSource();
		if(botao == cliente)
			 new TelaPessoa().mostrarDados(controleD, 1);
		if(botao == portaOculos)
			new TelaProduto().mostrarDados(controleD,2);
        if(botao == oculos)
        	new TelaProduto().mostrarDados(controleD,1);
        if(botao == func)
        	new TelaPessoa().mostrarDados(controleD,2);
        if(botao == loja)
        	new TelaLoja().mostrarDados(controleD,1);
        if(botao == vender)
        	new TelaLoja().mostrarDados(controleD,2);
     
	}
}
