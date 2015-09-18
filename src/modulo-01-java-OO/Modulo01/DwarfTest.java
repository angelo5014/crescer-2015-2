
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
        Dwarf dwarf = new Dwarf("jose");
        assertEquals(110, dwarf.getVida());
    }

    @Test
    public void dwarfNullTemAno111(){
        Dwarf dwarf = new Dwarf();
        DataTerceiraEra data = new DataTerceiraEra(1,1,1); 
        assertEquals(data, dwarf.getDataNascimento());
    }

    @Test
    public void dwarfSemDataEh111(){
        Dwarf dwarf = new Dwarf("jose");
        DataTerceiraEra data = new DataTerceiraEra(1,1,1); 
        assertEquals(data, dwarf.getDataNascimento());
    }

    @Test
    public void dwarfComDataEhCorreta(){
        DataTerceiraEra data = new DataTerceiraEra(10,5,2008);
        Dwarf dwarf = new Dwarf("jose", data);
        assertEquals(10, dwarf.getDataNascimento().getDia());
        assertEquals(5, dwarf.getDataNascimento().getMes());
        assertEquals(2008, dwarf.getDataNascimento().getAno());
    }

    @Test
    public void getNumeroSorteSeForBissextoEVidaEntre80E90(){
        DataTerceiraEra data = new DataTerceiraEra(10,5,2008);
        Dwarf dwarf = new Dwarf("jose", data);
        dwarf.receberFlechada();
        dwarf.receberFlechada();
        assertEquals(-3333 , dwarf.getNumeroSorte(), 0.001);
    }

    @Test
    public void naoEhBissextoMasEhSeixasOuMeireles(){
        DataTerceiraEra data = new DataTerceiraEra(10,5,2007);
        Dwarf dwarf1 = new Dwarf("Seixas", data);
        Dwarf dwarf2 = new Dwarf("Meireles", data);
        assertEquals(33 , dwarf1.getNumeroSorte() , 0.001);
    }

    @Test
    public void dwarfAzaradoEComumPerdeVidaComFlechada(){
        Dwarf dwarf = new Dwarf("Macacoloko");
        dwarf.receberFlechada();
        assertEquals(100 , dwarf.getVida());
    }

    @Test
    public void dwarfEntre0E100NaoMudaNada(){
        DataTerceiraEra data = new DataTerceiraEra(10,5,2007);
        Dwarf dwarf = new Dwarf("Seixas", data);
        dwarf.receberFlechada();
        assertEquals(110, dwarf.getVida());
        assertEquals(0, dwarf.getExperiencia());
    }

    @Test
    public void dwarfSortudoGanhaXP(){
        DataTerceiraEra data = new DataTerceiraEra(10,5,2008);
        Dwarf dwarf = new Dwarf("jose", data);
        dwarf.receberFlechada();
        dwarf.receberFlechada();
        dwarf.receberFlechada();
        assertEquals(2, dwarf.getExperiencia());
    }

    @Test
    public void dwarfMorreCom0DeVida(){
        Dwarf dwarf = new Dwarf("reginaldo");
        for(int i=0;i<11;i++){
            dwarf.receberFlechada();
        }
        assertEquals(Status.MORTO, dwarf.getStatus());
    }

    @Test
    public void dwarfMorreTomando12FlechadasEVidaEh0(){
        Dwarf dwarf = new Dwarf("reginaldo");
        for(int i=0;i<12;i++){
            dwarf.receberFlechada();
        }
        assertEquals(Status.MORTO, dwarf.getStatus());
        assertEquals(0, dwarf.getVida());
    }

}
