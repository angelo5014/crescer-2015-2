
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoVerdeTest{
    @Test
    public void elfoVerdeRecebe2XPQuandoAtira(){
        ElfoVerde verde = new ElfoVerde("Elfo");
        Dwarf dwarf = new Dwarf();
        verde.atacar(dwarf);
        assertEquals(2,verde.getExperiencia());
    }

    @Test
    public void elfoVerdeRecebe10XPQuandoAtira5(){
        ElfoVerde verde = new ElfoVerde("Elfo");
        Dwarf dwarf = new Dwarf();
        verde.atacar(dwarf);
        verde.atacar(dwarf);
        verde.atacar(dwarf);
        verde.atacar(dwarf);
        verde.atacar(dwarf);
        assertEquals(10,verde.getExperiencia());
    }

}
