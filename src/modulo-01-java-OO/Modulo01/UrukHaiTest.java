
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

    public class UrukHaiTest
    {
        @Test
        public void criaUrukHai(){
            Orc orc = new UrukHai();

            int vidaEsperada = 150;
            Inventario inventarioEsperado = new Inventario();
            inventarioEsperado.adicionarItem(new Item(1, "Espada"));
            inventarioEsperado.adicionarItem(new Item(1, "Escudo Uruk-Hai"));


            assertEquals(vidaEsperada, orc.getVida(), 0);
            assertEquals(inventarioEsperado, orc.getInventario());
        }

        @Test
        public void orcUrukHaiRecebeAtaqueEPerde6DeVida(){
            Orc orc = new UrukHai();

            orc.receberAtaque();

            assertEquals(144, orc.getVida(), 0);
        }

        @Test
        public void orcUrukHaiRecebeAtaqueEPerde10DeVidaPorquePerdeuEscudo(){
            Orc orc = new UrukHai();

            orc.perderItem(new Item(1, "Escudo Uruk-Hai"));

            orc.receberAtaque();

            assertEquals(140, orc.getVida(), 0);
        }

        @Test
        public void orcUrukHaiPerdeEspadaEAtacaComArcoQueGanhouEUmaFlecha(){
            Orc orc = new UrukHai();
            Dwarf anao = new Dwarf();
            orc.perderItem(new Item(1, "Espada"));
            orc.adicionarItem(new Item(1, "Arco"));
            orc.adicionarItem(new Item(1, "Flecha"));
            Inventario inventarioEsperado = new Inventario();
            inventarioEsperado.adicionarItem(new Item(1, "Escudo Uruk-Hai"));
            inventarioEsperado.adicionarItem(new Item(1, "Arco"));

            orc.atacar(anao);

            assertEquals(102, anao.getVida(), 0);
            assertEquals(inventarioEsperado, orc.getInventario());
        }

        @Test
        public void orcUrukHaiFogePorqueNaoTemArmaParaAtacar(){
            Orc orc = new UrukHai();
            orc.perderItem(new Item(1, "Espada"));
            Elfo legolas = new Elfo("Legolas");

            orc.atacar(legolas);

            assertEquals(Status.FUGINDO, orc.getStatus());
            assertEquals(100, legolas.getVida(), 0);
        }

        @Test
        public void orcUrukHaiRecebeAtaqueDeUrukHai(){
            Orc urukHaiAlvo = new UrukHai();
            Orc urukHaiAtacante = new UrukHai();

            urukHaiAlvo.receberAtaqueDoOrc(urukHaiAtacante);

            assertEquals(urukHaiAlvo.getVida(), 0, 144);
        }

        @Test
        public void orcUrukHaiRecebeAtaqueDeSnaga(){
            Orc urukHaiAlvo = new UrukHai();
            Orc snagaAtacante = new Snaga();

            urukHaiAlvo.receberAtaqueDoOrc(snagaAtacante);

            assertEquals(urukHaiAlvo.getVida(), 0, 144);
        }
    }
