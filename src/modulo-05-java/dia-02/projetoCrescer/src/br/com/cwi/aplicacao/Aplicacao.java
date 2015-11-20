package br.com.cwi.aplicacao;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import br.com.cwi.dao.ClienteDao;
import br.com.cwi.dao.DaoFactory;
import br.com.cwi.dao.PedidoDao;
import br.com.cwi.model.Cliente;
import br.com.cwi.model.Pedido;

public class Aplicacao {

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		System.out.println("***Iniciando Sistema***");
		int continuar = 1;
		while(continuar == 1){
		System.out.println("1-Inserir pedido \n2-Listar pedidos de cliente \n3-Buscar pedido por id");
		int escolha = in.nextInt();
		
		switch (escolha) {
		case 1:
			inserirPedido();
			break;
		case 2:
			listarPedidos();
			break;
		case 3:
			buscarPedido();
			break;
		default:
			System.out.println("Opção inválida");
			break;
		}
		
		System.out.println("Deseja fazer mais alguma operacao? 1-Sim 2-Nao");
		continuar = in.nextInt();
		}
		in.close();
	}
	
	
	private static void inserirPedido() throws SQLException{
		Scanner in = new Scanner(System.in);
		
		ClienteDao dao = DaoFactory.createClienteDao();
		
		System.out.println("1-Cadastrar novo Cliente \n2-Listar Clientes");
		int escolha = in.nextInt();
		
		Long idClienteFinal = 0L;
		
		if(escolha == 1){
			Cliente cliente = new Cliente();
			System.out.println("Digite o nome do cliente");
			cliente.setNmCliente(in.next());
			System.out.println("Digite o Cpf do cliente");
			cliente.setNrCpf(in.next());
			dao.add(cliente);
			idClienteFinal = dao.findByName(cliente.getNmCliente()).getId();
		}else if (escolha == 2) {
			listarClientes();
			System.out.println("Escolha um cliente");
			idClienteFinal = in.nextLong();
		}
		
		
		System.out.println("Escreva a descricao do pedido");
		String dsPedido = in.nextLine();
		
		Pedido pedido = new Pedido();
		pedido.setIdCliente(idClienteFinal);
		pedido.setDsPedido(dsPedido);
		
		DaoFactory.createPedidoDao().add(pedido);
		in.close();
	}
	
	public static void listarPedidos() throws SQLException {
		Scanner in = new Scanner(System.in);
		System.out.println("Escolha um cliente");
		listarClientes();
		Long idCliente = in.nextLong();
		List<Pedido> lista = DaoFactory.createPedidoDao().listPedidoByIdCliente(idCliente);
		for (Pedido pedido : lista) {
			System.out.print(pedido.getId() +  " - ");
			System.out.print(pedido.getIdCliente() + " -- ");
			System.out.println(pedido.getDsPedido());
		}
		in.close();
	}
	
	private static void buscarPedido() throws SQLException{
		Scanner in = new Scanner(System.in);
		System.out.println("Digote o id do pedido");
		Pedido pedido = DaoFactory.createPedidoDao().findById(in.nextLong());
		System.out.println(pedido.getId() + " - " + pedido.getIdCliente() + " -- " + pedido.getDsPedido());
		in.close();
	}
	
	private static void listarClientes() throws SQLException {
		List<Cliente> lista = DaoFactory.createClienteDao().listAll();
		for (Cliente cliente : lista) {
			System.out.println(cliente.getId() + " - " + cliente.getNmCliente());
		}
	}
}
