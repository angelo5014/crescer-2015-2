using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace Locadora.Dominio.Test
{
    [TestClass]
    public class JogoTest
    {
        [TestMethod]
        public void JogoADeveSerIgualJogoB()
        {
<<<<<<< HEAD:src/modulo-04-c-sharp/Locadora/Locadora.Dominio.Test/JogoTest.cs
            Jogo jogoA = new Jogo(id: 1, ClienteLocacao: null);
            Jogo jogoB = new Jogo(id: 1, ClienteLocacao: null);
=======
            Jogo jogoA = new Jogo(1, "Jogo A", 10, Categoria.RPG, 1);
            Jogo jogoB = new Jogo(1, "Jogo A", 10, Categoria.RPG, 1);
>>>>>>> 196bc442c1d9dea6c1835e05199b10a9db08b196:src/modulo-04-c-sharp/dia-03/Locadora/Locadora.Dominio.Test/JogoTest.cs

            Assert.AreEqual(jogoA, jogoB);
        }

        [TestMethod]
        public void LocacaoParaClienteTemIdCorreto()
        {
            Jogo jogo = new Jogo();

            jogo.LocarPara(new Cliente(1, "Cliente A"));

            Assert.AreEqual(1, jogo.ClienteLocacao.Id);
        }
    }
}
