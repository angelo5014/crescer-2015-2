
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InventarioTest
{
    @Test
    public void adicionarUmItem(){
        Dwarf dwarf = new Dwarf("reginaldo");
        Item item = new Item(1 , "Espada");
        dwarf.getInventario().adicionarItem(item);
        assertEquals(dwarf.getInventario().getItens().get(0).getDescricao(), "Espada");
    }

    @Test
    public void adicionaItemFunciona(){
        Item item = new Item(1 , "Espada");
        Dwarf dwarf = new Dwarf("reginaldo");

        dwarf.getInventario().adicionarItem(item);

        assertEquals("Espada", dwarf.getInventario().getItens().get(0).getDescricao());
    }

    @Test
    public void perdeItemFunciona(){
        Item item = new Item(1 , "Espada");
        Item item2 = new Item(1 , "Escudo");
        Dwarf dwarf = new Dwarf("reginaldo");

        dwarf.getInventario().adicionarItem(item);
        dwarf.getInventario().adicionarItem(item2);
        dwarf.getInventario().perderItem(item);

        assertEquals("Escudo", dwarf.getInventario().getItens().get(0).getDescricao());
    }

    @Test
    public void imprimeDescricaoCorretamente(){
        Item item = new Item(1 , "Espada");
        Item item2 = new Item(1 , "Escudo");
        Item item3 = new Item(1 , "Jabulani");
        Dwarf dwarf = new Dwarf("reginaldo");

        dwarf.getInventario().adicionarItem(item);
        dwarf.getInventario().adicionarItem(item2);
        dwarf.getInventario().adicionarItem(item3);

        assertEquals("Espada,Escudo,Jabulani", dwarf.getInventario().getDescricoesItens());      
    }
}
