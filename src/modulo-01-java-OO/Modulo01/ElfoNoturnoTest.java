
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoNoturnoTest{

    @Test
    public void elfoNoturnoGanha3DeXP(){
        ElfoNoturno ef = new ElfoNoturno("teste");
        ef.atacar(new Snaga());
        assertEquals(3, ef.getExperiencia(), 0.00001);
    }

    @Test 
    public void elfoNoturnoFicaCom95AposFlechada(){
        ElfoNoturno ef = new ElfoNoturno("loko");
        ef.atacar(new Snaga());
        assertEquals(95, ef.getVida(), 0.00001);
    }

    @Test 
    public void elfoNoturnoFicaCom9025AposFlechada(){
        ElfoNoturno ef = new ElfoNoturno("loko");
        ef.atacar(new Snaga());
        ef.atacar(new Snaga());
        assertEquals(90.25, ef.getVida(), 0.00001);
    }

    @Test
    public void elfoMorreComMenosQue1(){
        ElfoNoturno ef = new ElfoNoturno("loko");
        int teste=0;
        while(teste != 150){
            ef.atacar(new Snaga());
            teste++;
        }
        assertEquals(Status.MORTO, ef.getStatus());
    }

    @Test
    public void elfoFicaComMenosDezeroCom100Felchadas(){
        ElfoNoturno ef = new ElfoNoturno("loko");
        int teste=0;
        while(teste != 100){
            ef.atacar(new Snaga());
            teste++;
        }
        assertEquals(0,ef.getVida(),0);
    }
}