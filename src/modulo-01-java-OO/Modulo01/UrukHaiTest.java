

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UrukHaiTest{
    @Test
    public void urukHaiRecebeFlechadaDeElfo(){
        UrukHai urukHai = new UrukHai();
        Elfo elfo = new Elfo("Korok");
        elfo.atirarFlechas(urukHai);
        assertEquals(142, urukHai.getVida());
    }
    @Test
    public void urukHaiRecebeMachadadaDeDwarf(){
        UrukHai urukHai = new UrukHai();
        Dwarf dwarf = new Dwarf("Korok");
        dwarf.darMachadada(urukHai);
        assertEquals(145, urukHai.getVida());
    }
    @Test
     public void urukHaiSemEscudoRecebeMachadadaDeDwarf(){
        UrukHai urukHai = new UrukHai();
        Dwarf dwarf = new Dwarf();
        urukHai.getInventario().getItens().remove(urukHai.getInventario().retornarIndicePorNome("Escudo Uruk-Hai"));
        dwarf.darMachadada(urukHai);
        assertEquals(140, urukHai.getVida());
    }
    
}
