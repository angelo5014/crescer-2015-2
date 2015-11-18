package br.com.cwi.test;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.cwi.model.Cliente;

public class ClienteTest {

	@Test
	public void clienteEhInseridoCorretamente() {
		Cliente cliente = new Cliente();
		cliente.setId(1L);
		cliente.setNmCliente("Jesus");
		cliente.setNrCpf("000");
		
		assertEquals("Jesus", cliente.getNmCliente());
		assertEquals("000", cliente.getNrCpf());
	}

}
