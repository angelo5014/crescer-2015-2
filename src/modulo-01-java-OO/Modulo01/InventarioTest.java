
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InventarioTest
{
    @Test
    public void adicionarUmItem(){
        Dwarf dwarf = new Dwarf("reginaldo");
        Item item = new Item("Espada", 1);
        dwarf.getInventario().adicionarItem(item);
        assertEquals(dwarf.getInventario().getItens().get(0).getDescricao(), "Espada");
    }

    @Test
    public void adicionaItemFunciona(){
        Item item = new Item("Espada", 1);
        Dwarf dwarf = new Dwarf("reginaldo");

        dwarf.getInventario().adicionarItem(item);

        assertEquals("Espada", dwarf.getInventario().getItens().get(0).getDescricao());
    }

    @Test
    public void perdeItemFunciona(){
        Item item = new Item("Espada",1);
        Item item2 = new Item("Escudo",1);
        Dwarf dwarf = new Dwarf("reginaldo");

        dwarf.getInventario().adicionarItem(item);
        dwarf.getInventario().adicionarItem(item2);
        dwarf.getInventario().perderItem(item);

        assertEquals("Escudo", dwarf.getInventario().getItens().get(0).getDescricao());
    }

    @Test
    public void imprimeDescricaoCorretamente(){
        Item item = new Item("Espada",1);
        Item item2 = new Item("Escudo",1);
        Item item3 = new Item("Jabulani",1);
        Dwarf dwarf = new Dwarf("reginaldo");

        dwarf.getInventario().adicionarItem(item);
        dwarf.getInventario().adicionarItem(item2);
        dwarf.getInventario().adicionarItem(item3);

        assertEquals("Espada,Escudo,Jabulani", dwarf.getInventario().getDescricoesItens());      
    }

    @Test
    public void ordenarInventarioCom5Itens(){
        Dwarf dwarf = new Dwarf("teste");
        Inventario inv = dwarf.getInventario();
        Item item1 = new Item("a",5);
        Item item2 = new Item("b",1);
        inv.adicionarItem(item1);
        inv.adicionarItem(item2);
        dwarf.getInventario().ordenarItens();
        assertEquals(1, inv.getItens().get(0).getQuantidade());

    }

    @Test 
    public void itensOrdenadosDeFormaAscendente1(){
        Inventario invDoThorin = new Inventario();
        invDoThorin.adicionarItem(new Item("Pedra Arken",3));
        invDoThorin.adicionarItem(new Item("Tererê de barba",5));
        invDoThorin.adicionarItem(new Item("Espada emprestada do brother Légolas",1));
        invDoThorin.ordenarItens();
        assertEquals(1, invDoThorin.getItens().get(0).getQuantidade());

    }

    @Test 
    public void itensOrdenadosDeFormaAscendente2(){
        Inventario invDoThorin = new Inventario();
        invDoThorin.adicionarItem(new Item("Pedra Arken", 3));
        invDoThorin.adicionarItem(new Item("Tererê de barba", 5));
        invDoThorin.adicionarItem(new Item("Espada emprestada do brother Légolas", 1));
        invDoThorin.ordenarItens();

        assertEquals(3, invDoThorin.getItens().get(1).getQuantidade());

    }

    @Test 
    public void itensOrdenadosDeFormaAscendente3(){
        Inventario invDoThorin = new Inventario();
        invDoThorin.adicionarItem(new Item("Pedra Arken", 3));
        invDoThorin.adicionarItem(new Item("Tererê de barba", 5));
        invDoThorin.adicionarItem(new Item("Espada emprestada do brother Légolas", 1));
        invDoThorin.ordenarItens();

        assertEquals(5, invDoThorin.getItens().get(2).getQuantidade());
    }

}
