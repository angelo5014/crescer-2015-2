import java.util.*;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PedidoTest
{
    @Test
    public void trocoDe50menos4350eh650(){
        Cliente cliente = new Cliente("José", "Av.Sapucaia", "9999-9999");
        Pedido pedido = new Pedido(cliente, 50);
        pedido.adicionarProduto(new PizzaGrande("Salada"));
        pedido.adicionarProduto(new RefriLata(SaborRefri.COCA));
        assertEquals(2.0,pedido.getTroco(),0);
    }

    @Test
    public void clienteRecebeDescontoAcimaDe100(){
        Cliente cliente = new Cliente("José", "Av.Sapucaia", "9999-9999");
        Pedido pedido = new Pedido(cliente, 110);
        pedido.adicionarProduto(new PizzaGrande("Salada"));
        pedido.adicionarProduto(new PizzaGrande("Salada"));
        pedido.adicionarProduto(new PizzaPequena("Salada"));
        pedido.adicionarProduto(new RefriLata(SaborRefri.COCA));
        assertEquals(16.85,pedido.getTroco(),0.00000001);
    }
}
