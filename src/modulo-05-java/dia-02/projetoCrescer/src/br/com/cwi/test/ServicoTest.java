package br.com.cwi.test;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.cwi.model.Servico;

public class ServicoTest {

	@Test
	public void servicoEhInseridoCorretamente() {
		Servico servico = new Servico();
		servico.setId(1L);
		servico.setDsServico("Teste");
		
		assertEquals("Teste", servico.getDsServico());
	}

}
