

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SnagaTest{
    @Test
    public void snagaRecebeFlechadaDeElfoEPerdeVida(){
        Snaga snaga = new Snaga();
        Elfo elfo = new Elfo("Calvin");
        elfo.atirarFlechas(snaga);
        assertEquals(62, snaga.getVida());
    }
    @Test
    public void snagaRecebeMachadadaDeDwarf(){
        Snaga snaga = new Snaga();
        Dwarf dwarf = new Dwarf();
        dwarf.darMachadada(snaga);
        assertEquals(60,snaga.getVida());
    }
    @Test
    public void snagaDaFlechadaEmElfo(){
        Snaga snaga = new Snaga();
        Elfo elfo = new Elfo("Calvin");
        snaga.atacarInimigo(elfo);
        assertEquals(72, elfo.getVida());
    }
    @Test
    public void snagaDaFlechadaEmDwarf(){
        Snaga snaga = new Snaga();
        Dwarf dwarf = new Dwarf();
        snaga.atacarInimigo(dwarf);
        assertEquals(102, dwarf.getVida());
    }
}
