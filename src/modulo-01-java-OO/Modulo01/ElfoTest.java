

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * A classe de teste ElfoTest.
 *
 * @author  Angelo
 * @version 4.2
 */
public class ElfoTest
{
    @Test
    public void nomeNaoEhNuloOuBranco(){
        Elfo elfo = new Elfo("Roberto");
        assertNotNull(elfo.getNome());
        assertNotSame(elfo.getNome(), "");
    }
    
    @Test
    public void flechasNaoEhZero(){
        Elfo elfo = new Elfo("José");
        Elfo elfo2 = new Elfo("Parcival", 0);
        assertNotSame(null,elfo.getFlechas());
        assertNotSame(null,elfo2.getFlechas());
    }
    
    @Test
    public void elfoAtiraFlechasGanhaXP(){
        Elfo elfo = new Elfo("José");
        Dwarf dwarf = new Dwarf();
        int XPInicial = elfo.getExperiencia();
        assertEquals(XPInicial, elfo.getExperiencia());
        elfo.atirarFlechas(dwarf);
        assertTrue(XPInicial < elfo.getExperiencia());
    }
    
    @Test
    public void elfoAtiraFlechasEDiminuiUma(){
        Elfo elfo = new Elfo("José");
        Dwarf dwarf = new Dwarf();
        int flechasIniciais = elfo.getFlechas();
        elfo.atirarFlechas(dwarf);
        assertTrue(flechasIniciais > elfo.getFlechas());
   }
   
   @Test
   public void metodoToStringNaoMandaNull(){
       Elfo elfo = new Elfo("José");
       assertNotNull(elfo.toString());
    }
    
}
