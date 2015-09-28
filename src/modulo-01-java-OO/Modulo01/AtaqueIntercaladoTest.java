

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class AtaqueIntercaladoTest{
    
    @Test
    public void quatroElfosIntercalamAtacandoUmDwarf(){
        Dwarf d1 = new Dwarf();
        
        ArrayList<Dwarf> alvos = new ArrayList<>(Arrays.asList(d1));
        
        Elfo e1 = new ElfoVerde("1");
        Elfo e2 = new ElfoVerde("2");
        Elfo e3 = new ElfoNoturno("3");
        Elfo e4 = new ElfoNoturno("4");
        
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.alistar(e1);
        exercito.alistar(e2);
        exercito.alistar(e3);
        exercito.alistar(e4);
        
        exercito.mudarEstrategiaDeAtaque(new AtaqueIntercalado());
        exercito.atacar(alvos);
        
        assertEquals(70, d1.getVida(), 0);
        assertEquals(new ArrayList<Elfo>(Arrays.asList(e1,e3,e2,e4)),exercito.getOrdemDoUltimoAtaque());
        
    }
    
    @Test
    public void seisElfosIntercalamAtacandoDoisDwarf(){
        ArrayList<Dwarf> alvos = new ArrayList<>(Arrays.asList(new Dwarf(), new Dwarf()));
        
        Elfo e1 = new ElfoVerde("1");
        Elfo e2 = new ElfoVerde("2");
        Elfo e3 = new ElfoNoturno("3");
        Elfo e4 = new ElfoNoturno("4");
        Elfo e5 = new ElfoVerde("5");
        Elfo e6 = new ElfoNoturno("6");
        
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.alistar(e1);
        exercito.alistar(e2);
        exercito.alistar(e3);
        exercito.alistar(e4);
        exercito.alistar(e5);
        exercito.alistar(e6);
        
        
        exercito.mudarEstrategiaDeAtaque(new AtaqueIntercalado());
        exercito.atacar(alvos);
        
        assertEquals(new ArrayList<Elfo>(Arrays.asList(e1,e3,e2,e4,e5,e6)),exercito.getOrdemDoUltimoAtaque());
        
    }
    
}
