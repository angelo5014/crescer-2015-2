using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Locadora.Dominio;

namespace LocadoraTest
{
    [TestClass]
    public class BibliotecaTest
    {
        [TestMethod]
        public void JogoEhInseridoCorretamente()
        {
            var db = new Biblioteca();
            var jogo = new Jogo("teste", 1, "rpg");
            db.CadastrarJogo(jogo);
        }
    }
}
