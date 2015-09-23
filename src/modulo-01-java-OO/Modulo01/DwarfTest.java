import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DwarfTest
{
    @Test
    public void dwarfNasceCom110DeVida(){
        Dwarf dwarf = new Dwarf("jose");
        assertEquals(110, dwarf.getVida(),0);
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
    public void getNumeroSorteComNomeNull(){
        Dwarf dwarf = new Dwarf();
        assertEquals(101, dwarf.getNumeroSorte(), 0);
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
        assertEquals(100 , dwarf.getVida(),0);
    }

    @Test
    public void dwarfEntre0E100NaoMudaNada(){
        DataTerceiraEra data = new DataTerceiraEra(10,5,2007);
        Dwarf dwarf = new Dwarf("Seixas", data);
        dwarf.receberFlechada();
        assertEquals(110, dwarf.getVida(),0);
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
        assertEquals(0, dwarf.getVida(),0);
    }
    
    @Test
    public void tentarSorteCom2ItemEConsegue(){
        DataTerceiraEra data = new DataTerceiraEra(10,5,2008);
        Dwarf dwarf = new Dwarf(null, data);
        dwarf.receberFlechada();
        dwarf.receberFlechada();
        Item estrelaDaMorte = new Item("Estrela da morte",1);
        Item ring = new Item("Anel",12);
        dwarf.getInventario().adicionarItem(estrelaDaMorte);
        dwarf.getInventario().adicionarItem(ring);
        dwarf.tentarSorte();
        assertEquals(1001, dwarf.getInventario().getItens().get(0).getQuantidade());
        assertEquals(1012, dwarf.getInventario().getItens().get(1).getQuantidade());
    }
    
    @Test
    public void dwarfTentaASorteEFalha(){
        Dwarf dwarf = new Dwarf();
        Item item1 = new Item("Stormtrooper",500000);
        Item item2 = new Item("LightSaber",5);
        Item item3 = new Item("DarthVader",1);
        dwarf.getInventario().adicionarItem(item1);
        dwarf.getInventario().adicionarItem(item2);
        dwarf.getInventario().adicionarItem(item3);
        
        dwarf.receberFlechada();
        dwarf.receberFlechada();

        dwarf.tentarSorte();

        assertEquals(500000,dwarf.getInventario().getItens().get(0).getQuantidade());
        assertEquals(5,item2.getQuantidade());
        assertEquals(1,item3.getQuantidade());
    }
    
    /*@Test
    public void itemMaisPopular*/

}
