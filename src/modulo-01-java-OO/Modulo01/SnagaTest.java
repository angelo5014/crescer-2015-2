

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SnagaTest{
    @Test
    public void snagaRecebeFlechadaDeElfoEPerdeVida(){
        Snaga snaga = new Snaga();
        Elfo elfo = new Elfo("Calvin");
        elfo.atacar(snaga);
        assertEquals(60, snaga.getVida(), 0);
    }
    
    
    @Test
    public void snagaDaFlechadaEmElfoEPerdeFlecha(){
        Snaga snaga = new Snaga();
        Elfo elfo = new Elfo("Calvin");
        snaga.atacarElfo(elfo);
        assertEquals(92, elfo.getVida(),0);
        assertEquals(4,snaga.getInventario().getItemPelaDescricao("Flecha").getQuantidade());
    }
    @Test
    public void snagaDaFlechadaEmDwarf(){
        Snaga snaga = new Snaga();
        Dwarf dwarf = new Dwarf();
        snaga.atacarDwarf(dwarf);
        assertEquals(102, dwarf.getVida(),0);
    }
}
