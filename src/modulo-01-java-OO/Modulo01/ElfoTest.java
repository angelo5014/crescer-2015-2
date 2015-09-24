
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
        elfo.atacar(dwarf);
        assertEquals(1 , elfo.getExperiencia());
    }

    @Test
    public void elfoAtiraFlechasEDiminuiUma(){
        Elfo elfo = new Elfo("José");
        Dwarf dwarf = new Dwarf("Bifur");
        elfo.atacar(dwarf);
        assertEquals(41 , elfo.getFlechas());
    }

    @Test
    public void dwarfTomaDano(){
        Elfo elfo = new Elfo("José");
        Dwarf dwarf = new Dwarf("Bifur");
        elfo.atacar(dwarf);
        assertEquals(100 , dwarf.getVida(),0);
    }
    //
    @Test
    public void elfoCriadoComNomeNasceCom42Flechas() {
        Elfo celeborn = new Elfo("Celeborn");
        assertEquals(42, celeborn.getFlechas());
    }

    @Test
    public void elfoCriadoComNomeNull() {
        Elfo elrond = new Elfo(null);
        assertNull(elrond.getNome());
    }
    
    @Test
    public void elfoNasceVivo() {
        Elfo legolas = new Elfo("Legolas");
        assertEquals(Status.VIVO, legolas.getStatus());
    }
    @Test
    public void elfoNasceComInventarioVazio() {
        Elfo legolas = new Elfo("Legolas");
        assertEquals(equals(new Inventario()), equals(legolas.getInventario()));
    }
    @Test
    public void elfoCriadoNasceCom0DeExperiencia() {
        Elfo legolas = new Elfo("Legolas II");
        assertEquals(0, legolas.getExperiencia());
    }

    @Test
    public void elfoCriadoComNomeVazio() {
        Elfo elrond = new Elfo("");
        assertEquals("", elrond.getNome());
    }

    @Test
    public void elfoCriadoComNomeEPoucasFlechas() {
        Elfo elfoHumilde = new Elfo("Elfo Humilde", 2);
        assertEquals("Elfo Humilde", elfoHumilde.getNome());
        assertEquals(2, elfoHumilde.getFlechas());
    }

    @Test
    public void elfoCriadoComNomeEComMuitasFlechas() {
        Elfo elfoHumilde = new Elfo("Elfo Bacana", 349857);
        assertEquals("Elfo Bacana", elfoHumilde.getNome());
        assertEquals(349857, elfoHumilde.getFlechas());
    }

    @Test
    public void elfoCriadoComNomeEDevendoFlechas() {
        Elfo elfoHumilde = new Elfo("Elfo Devedor", -349857);
        assertEquals("Elfo Devedor", elfoHumilde.getNome());
        assertEquals(-349857, elfoHumilde.getFlechas());
    }

    @Test
    public void elfoAtiraFlechaEmDwarf() {
        // Arrange
        Elfo elfo = new Elfo("Elfo caçador");
        Dwarf balin = new Dwarf();
        int qtdFlechasEsperada = 41;
        int experienciaEsperada = 1;
        int vidaEsperada = 100;
        // Act
        elfo.atacar(balin);
        // Assert
        assertEquals(qtdFlechasEsperada, elfo.getFlechas());
        assertEquals(experienciaEsperada, elfo.getExperiencia());
        assertEquals(vidaEsperada, balin.getVida(),0);
    }

    @Test
    public void elfoAtiraEmDoisAnoes() {
        // Arrange
        Elfo elfo = new Elfo("Elfo caçador");
        Dwarf balin = new Dwarf();
        Dwarf filhoDeBalin = new Dwarf();
        int qtdFlechasEsperada = 40;
        int experienciaEsperada = 2;
        int vidaEsperada = 100;
        // Act
        elfo.atacar(balin);
        elfo.atacar(filhoDeBalin);
        // Assert
        assertEquals(qtdFlechasEsperada, elfo.getFlechas());
        assertEquals(experienciaEsperada, elfo.getExperiencia());
        assertEquals(vidaEsperada, balin.getVida(),0);
        assertEquals(vidaEsperada, filhoDeBalin.getVida(),0);
    }

    @Test
    public void doisElfosAtiramEmDoisDwarves() {
        // Arrange
        Elfo elfo1 = new Elfo("Elfo caçador");
        Elfo elfo2 = new Elfo("Segundo elfo");
        Dwarf balin = new Dwarf();
        Dwarf filhoDeBalin = new Dwarf();
        int qtdFlechasEsperada = 40;
        int experienciaEsperada = 2;
        int vidaEsperada = 90;
        // Act
        elfo1.atacar(balin);
        elfo1.atacar(filhoDeBalin);
        elfo2.atacar(balin);
        elfo2.atacar(filhoDeBalin);
        // Assert
        assertEquals(qtdFlechasEsperada, elfo1.getFlechas());
        assertEquals(experienciaEsperada, elfo1.getExperiencia());
        assertEquals(qtdFlechasEsperada, elfo2.getFlechas());
        assertEquals(experienciaEsperada, elfo2.getExperiencia());
        assertEquals(vidaEsperada, balin.getVida(),0);
        assertEquals(vidaEsperada, filhoDeBalin.getVida(),0);
    }

    @Test
    public void elfoComUmaFlechaInformadaToString() {
        Elfo elfo1 = new Elfo("Monoflecha", 1);
        String textoEsperado = "Monoflecha possui 1 flecha e 0 níveis de experiência.";
        assertEquals(textoEsperado, elfo1.toString());
    }
    
    @Test
    public void elfoComUmDeExperienciaToString() {
        Elfo elfo1 = new Elfo(null);
        elfo1.atacar(new Dwarf());
        String textoEsperado = "null possui 41 flechas e 1 nível de experiência.";
        assertEquals(textoEsperado, elfo1.toString());
    }
    
    @Test
    public void elfoRecebeEspadadaDoOrcUrukHai(){
        Orc orc = new UrukHai();
        Elfo elfo = new Elfo(null);
        
        orc.atacar(elfo);
        
        assertEquals(88, elfo.getVida(),0);
    }
    
    @Test
    public void elfoRecebeFlechadaDoOrcSnaga(){
        Orc orc = new Snaga();
        Elfo elfo = new Elfo(null);
        
        orc.atacar(elfo);
        
        assertEquals(92, elfo.getVida(),0);
    }
    
    
    
}
