import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.HashMap;
import java.util.ArrayList;

public class ExercitoDeElfosTest{
    
     @Test
    public void elfoVerdeAlistado(){
        ExercitoDeElfos exercitoDeElfos = new ExercitoDeElfos();
        ElfoVerde verde = new ElfoVerde("Verdinho");
        exercitoDeElfos.alistarElfo(verde);
        assertEquals(verde, exercitoDeElfos.getExercito().get("Verdinho"));
    }
    
    @Test
    public void elfoNightcrawlerAlistado(){
        ExercitoDeElfos exercitoDeElfos = new ExercitoDeElfos();
        ElfoNoturno noturno = new ElfoNoturno("Nigtcrawler");
        exercitoDeElfos.alistarElfo(noturno);
        assertEquals(noturno, exercitoDeElfos.getExercito().get("Nigtcrawler"));
    }
    
    @Test
    public void umElfoDeCadaTipoAlistado(){
        ExercitoDeElfos exercitoDeElfos = new ExercitoDeElfos();
        ElfoNoturno noturno = new ElfoNoturno("Nigtcrawler");
        ElfoVerde verde = new ElfoVerde("Verdinho");
        exercitoDeElfos.alistarElfo(verde);
        exercitoDeElfos.alistarElfo(noturno);
        assertEquals(noturno, exercitoDeElfos.getExercito().get("Nigtcrawler"));
        assertEquals(verde, exercitoDeElfos.getExercito().get("Verdinho"));
    }
    
}
