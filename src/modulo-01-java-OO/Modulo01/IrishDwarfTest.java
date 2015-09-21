
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IrishDwarfTest
{
    @Test
    public void irishDwarfTem3EFicaCom1009(){
        DataTerceiraEra data = new DataTerceiraEra(1,1,2000);
        IrishDwarf dwarf = new IrishDwarf("ose", data);
        dwarf.receberFlechada();
        dwarf.receberFlechada();
        Item item = new Item("batata", 3);
        dwarf.getInventario().adicionarItem(item);
        dwarf.tentarSorte();
        assertEquals(6003, dwarf.getInventario().getItens().get(0).getQuantidade());
    }

    @Test
    public void irishDwrafTem10EFicaCom90010(){
        DataTerceiraEra data = new DataTerceiraEra(1,1,2000);
        IrishDwarf dwarf = new IrishDwarf("ose", data);
        dwarf.receberFlechada();
        dwarf.receberFlechada();
        Item item = new Item("batata", 10);
        dwarf.getInventario().adicionarItem(item);
        dwarf.tentarSorte();
        assertEquals(90010, dwarf.getInventario().getItens().get(0).getQuantidade());
    }

    @Test
    public void irishDwrafTem1000EFicaCom90010(){
        DataTerceiraEra data = new DataTerceiraEra(1,1,2000);
        IrishDwarf dwarf = new IrishDwarf("ose", data);
        dwarf.receberFlechada();
        dwarf.receberFlechada();
        Item item = new Item("batata", 1000);
        dwarf.getInventario().adicionarItem(item);
        dwarf.tentarSorte();
        assertEquals(999001000, dwarf.getInventario().getItens().get(0).getQuantidade());
    }

    @Test public void irishDwrafTem3EContinuaCom3(){
        DataTerceiraEra data = new DataTerceiraEra(1,1,2090);
        IrishDwarf dwarf = new IrishDwarf("ose", data);
        dwarf.receberFlechada();
        dwarf.receberFlechada();
        Item item = new Item("batata", 3);
        dwarf.getInventario().adicionarItem(item);
        dwarf.tentarSorte();
        assertEquals(3, dwarf.getInventario().getItens().get(0).getQuantidade());
    }

    @Test public void irishDwrafTem1000EContinuaCom1000(){
        DataTerceiraEra data = new DataTerceiraEra(1,1,2090);
        IrishDwarf dwarf = new IrishDwarf("ose", data);
        dwarf.receberFlechada();
        dwarf.receberFlechada();
        Item item = new Item("batata", 3);
        dwarf.getInventario().adicionarItem(item);
        dwarf.tentarSorte();
        assertEquals(3, dwarf.getInventario().getItens().get(0).getQuantidade());

    }
}