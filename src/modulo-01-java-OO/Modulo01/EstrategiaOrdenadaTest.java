
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class EstrategiaOrdenadaTest{
    @Test
    public void estrategiaOrdenada2Elfos1Dwarves() {
        // Arrange
        Dwarf d1 = new Dwarf(); 
        ArrayList<Dwarf> alvos = new ArrayList<Dwarf>(Arrays.asList(d1));
        Elfo soldado = new ElfoVerde("Verde");
        Elfo soldado2 = new ElfoNoturno("Noturno");
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        // Act
        exercito.mudarEstrategiaDeAtaque(new EstrategiaOrdenada());
        exercito.alistar(soldado2);
        exercito.alistar(soldado);
        exercito.atacar(alvos);
        // Assert
        assertEquals(new ArrayList<Elfo>(Arrays.asList(soldado, soldado2)), exercito.getOrdemDoUltimoAtaque());

        assertEquals(90, d1.getVida(), .0);

    }
    @Test
    public void estrategiaOrdenada5Elfos5Dwarves(){
        Dwarf d1= new Dwarf();
        Dwarf d2= new Dwarf();
        Dwarf d3= new Dwarf();
        Dwarf d4= new Dwarf();
        Dwarf d5= new Dwarf();
        ArrayList<Dwarf> alvos = new ArrayList<>(Arrays.asList(d1,d2,d3,d4,d5));
        Elfo soldado1 = new ElfoVerde("1");
        Elfo soldado2 = new ElfoVerde("2");
        Elfo soldado3 = new ElfoNoturno("3");
        Elfo soldado4 = new ElfoNoturno("4");
        Elfo soldado5 = new ElfoNoturno("5");
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        
        exercito.mudarEstrategiaDeAtaque(new EstrategiaOrdenada());
        exercito.alistar(soldado3);
        exercito.alistar(soldado5);
        exercito.alistar(soldado1);
        exercito.alistar(soldado4);
        exercito.alistar(soldado2);
        exercito.atacar(alvos);
        
        assertEquals(new ArrayList<Elfo>(Arrays.asList(soldado1,soldado2,soldado3,soldado4,soldado5)), exercito.getOrdemDoUltimoAtaque());
        assertEquals(new ArrayList<Dwarf>(Arrays.asList(d1,d2,d3,d4,d5)), alvos);   
    }
}
