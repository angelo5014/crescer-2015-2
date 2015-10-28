using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace ConsoleApp.test
{
    [TestClass]
    public class AgendaTestes
    {
        [TestMethod]
        public void AgendaTemUmContato()
        {
            var agenda = new Agenda();
            var contato = new Contato { Nome = "Angelo", Numero = 111 };

            agenda.AdicionarContato(contato);

            Assert.AreEqual(agenda.PegarQuantidadeDeContatos, 1);
        }
        [TestMethod]
        public void AgendaRecebeContatosOrganizados()
        {
            var agenda = new Agenda();
            var contato1 = new Contato { Nome = "Fabricio", Numero = 222 };
            var contato2 = new Contato { Nome = "Angelo", Numero = 111 };
            var contato3 = new Contato { Nome = "Ben-Hur", Numero = 666 };

            agenda.AdicionarContato(contato1);
            agenda.AdicionarContato(contato2);
            agenda.AdicionarContato(contato3);

            var arrayOrdenado = agenda.ListarContatosOrdenadoPorNome();

            Assert.AreEqual(arrayOrdenado[0], contato2);
            Assert.AreEqual(arrayOrdenado[1], contato3);
            Assert.AreEqual(arrayOrdenado[2], contato1);

        }
        [TestMethod]
        public void ContatoEhAdicionadoEListado()
        {
            var agenda = new Agenda();
            var contato1 = new Contato { Nome = "Fabricio", Numero = 222 };
            var contato2 = new Contato { Nome = "Angelo", Numero = 111 };
            var contato3 = new Contato { Nome = "Ben-Hur", Numero = 666 };

            agenda.AdicionarContato(contato1);
            agenda.AdicionarContato(contato2);
            agenda.AdicionarContato(contato3);

            var arrayDesordenado = agenda.ListarContatos();

            Assert.AreEqual(arrayDesordenado[0], contato1);
            Assert.AreEqual(arrayDesordenado[1], contato2);
            Assert.AreEqual(arrayDesordenado[2], contato3);
        }
    }
}