using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using DbFuncionarios;
using System.Collections.Generic;

namespace BaseDeDadosTest
{
    [TestClass]
    public class UnitTest1
    {
        [TestMethod]
        public void FuncionariosSaoOrdenadosPorCargo()
        {
            BaseDeDados bd = new BaseDeDados();
            IList<Funcionario> funcionarios = bd.Funcionarios;

            IList<Funcionario> ordenados = bd.OrdenadosPorCargo();

            Assert.AreEqual("Gabriel Alboy", ordenados[0].Nome);
            Assert.AreEqual("Carlos Henrique", ordenados[1].Nome);

        }

        [TestMethod]
        public void BuscaProNomeLucas()
        {
            BaseDeDados bd = new BaseDeDados();
            var f = bd.BuscarPorNome("Lucas");

            Assert.AreEqual("Lucas Leal", f[0].Nome);
            Assert.AreEqual("Lucas Kauer", f[1].Nome);
        }

        [TestMethod]
        public void BuscaSimplesRetornaOrdermCerta()
        {
            BaseDeDados bd = new BaseDeDados();
            var listaRapida = bd.BuscaRapida();

            Assert.AreEqual("Lucas Leal", listaRapida[0].Nome);
        }
    }
}
