package tests;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import control.*;

public class TesteControleDados {


	ControleDados d = new ControleDados();
	String testes[] = new String[100];
	String testes2[] = new String[100];
	@Test
	public void testacoesCliente() {
		String testes[] = {"1", "alo","cliente 1", "27483929119","email 1", "endereco", "27", "numteleee", "grau"};
		assertFalse(d.acoesCliente(testes));
		String testes2[] = {"1", "1","cliente 1", "27483929119","email 1", "endereco", "27", "995376544", "5"};
		assertTrue(d.acoesCliente(testes2));
	}
	public void testacoesFunc() {
		String testes[] = {"1", "id 1","cliente 1", "27483929119","email 1", "endereco", "27", "numteleee", "cargo1", "salario1"};
		assertFalse(d.acoesFunc(testes));
		String testes2[] = {"1", "1","cliente 1", "27483929119","email 1", "endereco", "27", "995376544", "cargo1 ", "200"};
		assertTrue(d.acoesFunc(testes2));
	}
	public void testacoesOculos() {
		String testes[] = {"1", "id 1","preco","modelo", "descricao", "tipo"};
		assertFalse(d.acoesOculos(testes));
		String testes2[] = {"1", "1","33", "modelo 1","descricao 1", "tipo"};
		assertTrue(d.acoesOculos(testes2));
	}
	public void testacoesPortaOculos() {
		String testes[] = {"1", "id 1","preco","modelo", "descricao", "cor"};
		assertFalse(d.acoesPortaO(testes));
		String testes2[] = {"1", "1","33","modelo", "descricao", "tipo"};
		assertTrue(d.acoesPortaO(testes2));
	}
	public void testacoesVendas() {
		int testes[] = {};
		assertFalse(d.acoesVenda(testes));
		int testes2[] = {};
		assertTrue(d.acoesVenda(testes2));
	}
	public void testacoesLoja() {
		String testes[] = {"nome", "qnt","cnpj","endereco", "qntFunc", "horario"};
		assertFalse(d.acoesLoja(testes));
		String testes2[] = {"nome", "1","cnpj","endereco", "qntFunc", "horario"};
		assertTrue(d.acoesLoja(testes2));
	}
}

