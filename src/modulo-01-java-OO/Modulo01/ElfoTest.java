
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
    public void elfoCriadoComNomeNulo(){
        Elfo elfo = new Elfo(null);
        assertNull(elfo.getNome());
    }

    @Test
    public void elfoRecebeNome(){
        Elfo elfo = new Elfo("Romero");
        assertEquals("Romero", elfo.getNome());
    }

    @Test
    public void elfoEstaVivo(){
        Elfo elfo = new Elfo("Romero");
        assertEquals(Status.VIVO, elfo.getStatus());
    }

    @Test
    public void elfoRecebeNomeVazio(){
        Elfo elfo = new Elfo("");
        assertEquals("", elfo.getNome());
    }

    @Test
    public void flechasNaoEhZero(){
        Elfo elfo = new Elfo("José");
        Elfo elfo2 = new Elfo("Parcival", 0);
        assertNotSame(null,elfo.getFlechas());
        assertNotSame(null,elfo2.getFlechas());
    }

    @Test
    public void comecaCom42Flechas(){
        Elfo elfo = new Elfo("José");
        assertEquals(42,elfo.getFlechas());
    }

    @Test
    public void nasceCom0DeXP(){
        Elfo elfo = new Elfo("José");
        assertEquals(0, elfo.getExperiencia());
    }

    @Test
    public void elfoAtiraFlechasGanhaXP(){
        Elfo elfo = new Elfo("José");
        Dwarf dwarf = new Dwarf("Gloin");
        elfo.atirarFlechas(dwarf);
        assertEquals(1 , elfo.getExperiencia());
    }

    @Test
    public void elfoAtiraEmDoisDwarf(){
        Elfo elfo = new Elfo("José");
        Dwarf dwarf = new Dwarf("Oin");
        Dwarf dwarf2 = new Dwarf("Balin");
        elfo.atirarFlechas(dwarf);
        elfo.atirarFlechas(dwarf2);
        assertEquals(100, dwarf.getVida());
        assertEquals(100, dwarf2.getVida());
        assertEquals(2 , elfo.getExperiencia());
        assertEquals(40, elfo.getFlechas());
    }

    @Test
    public void doisElfosAtiramEmDoisDwarf(){
        Elfo elfo = new Elfo("José");
        Elfo elfo1 = new Elfo("Josnei");
        Dwarf dwarf = new Dwarf("Bofur");
        Dwarf dwarf2 = new Dwarf("Gimli");
        elfo.atirarFlechas(dwarf);
        elfo1.atirarFlechas(dwarf2);
        elfo.atirarFlechas(dwarf);
        elfo1.atirarFlechas(dwarf2);
        assertEquals(90, dwarf.getVida());
        assertEquals(90, dwarf2.getVida());
        assertEquals(2 , elfo.getExperiencia());
        assertEquals(40, elfo.getFlechas());
        assertEquals(2 , elfo1.getExperiencia());
        assertEquals(40, elfo1.getFlechas());
    }

    @Test
    public void elfoAtiraFlechasEDiminuiUma(){
        Elfo elfo = new Elfo("José");
        Dwarf dwarf = new Dwarf("Bifur");
        elfo.atirarFlechas(dwarf);
        assertEquals(41 , elfo.getFlechas());
    }

    @Test
    public void dwarfTomaDano(){
        Elfo elfo = new Elfo("José");
        Dwarf dwarf = new Dwarf("Bifur");
        elfo.atirarFlechas(dwarf);
        assertEquals(100 , dwarf.getVida());
    }

    @Test
    public void elfoComNomeEFlechasInformadasToString(){
        Elfo elfo = new Elfo("José");
        assertEquals("José possui 42 flechas e 0 níveis de experiencia", elfo.toString());
    }

    @Test
    public void elfoComNomeEUmaFlechasInformadasToString(){
        Elfo elfo = new Elfo("José", 1);
        assertEquals("José possui 1 flecha e 0 níveis de experiencia", elfo.toString());
    }

    @Test
    public void elfoComUmDeXPToString(){
        Elfo elfo = new Elfo("José", 1);
        elfo.atirarFlechas(new Dwarf("Oin"));
        assertEquals("José possui 0 flechas e 1 nível de experiencia", elfo.toString());
    }

    @Test
    public void elfoComUmDeXPEUmaFlechaToString(){
        Elfo elfo = new Elfo("José", 2);
        elfo.atirarFlechas(new Dwarf("Oin"));
        assertEquals("José possui 1 flecha e 1 nível de experiencia", elfo.toString());
    }
    
}
