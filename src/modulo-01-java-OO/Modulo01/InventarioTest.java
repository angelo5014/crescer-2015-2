

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
        dwarf.adicionarItem(item);
        assertEquals(dwarf.getInventario().getItens().get(0), item);
    }
}
