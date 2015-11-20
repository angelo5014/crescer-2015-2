package br.com.cwi.crescer;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MatematicaTest {

	@Test
	public void somar(){
		assertEquals(4, new Matematica().somar(2, 2));
	}
	
}
