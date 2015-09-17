

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * A classe de teste DwarfTest.
 *
 * @author  (seu nome)
 * @version (um número de versão ou data)
 */
public class DwarfTest
{
    @Test
    public void dwarfNasceCom110DeVida(){
        Dwarf gimli = new Dwarf();
        assertEquals(110, gimli.getVida());
    }
    @Test
    public void dwarfPerdeVidaComFlechada(){
        Dwarf gimli = new Dwarf();
        int vidaOriginal = gimli.getVida();
        gimli.receberFlechada();
        assertNotSame(vidaOriginal, gimli.getVida());
    }
}
