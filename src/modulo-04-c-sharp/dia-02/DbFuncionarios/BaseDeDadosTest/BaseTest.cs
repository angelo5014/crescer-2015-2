using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using DbFuncionarios;
using System.Collections.Generic;

namespace BaseDeDadosTest
{
    [TestClass]
    public class BaseTest
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
        public void BuscaSimplesRetornaOrdemCerta()
        {
            BaseDeDados bd = new BaseDeDados();
            var listaRapida = bd.BuscaRapida();
            var quantidade = listaRapida.Count;

            Assert.AreEqual(11, quantidade);
        }

        [TestMethod]
        public void OrdenadosPorCategoriaTest()
        {
            BaseDeDados dados = new BaseDeDados();
            IList<Funcionario> funcionariosPorCategoria = dados.OrdenadosPorCargo();
            Assert.AreEqual("Analista", funcionariosPorCategoria[0].Cargo.Titulo);
            Assert.AreEqual("Gerente", funcionariosPorCategoria[dados.Funcionarios.Count - 1].Cargo.Titulo);
        }

        [TestMethod]
        public void BuscarPorTurnoSemParametroTest()
        {
            BaseDeDados dados = new BaseDeDados();
            IList<Funcionario> funcionarios = dados.BuscarPorTurno();
            Assert.AreEqual(0, funcionarios.Count);
        }

        [TestMethod]
        public void BuscarNoTurnoDaNoiteTest()
        {
            BaseDeDados dados = new BaseDeDados();
            IList<Funcionario> funcionarios = dados.BuscarPorTurno(TurnoTrabalho.Noite);
            Assert.AreEqual(2, funcionarios.Count);
        }

        [TestMethod]
        public void BuscarPorCargoTest()
        {
            BaseDeDados dados = new BaseDeDados();
            IList<Funcionario> funcionarios = dados.BuscarPorCargo(new Cargo("Gerente", 550.5));
            Assert.AreEqual("Margarete Ricardo", funcionarios[0].Nome);
            Assert.AreEqual(1, funcionarios.Count);
        }

        [TestMethod]
        public void FiltrarPorIdadeAproximadaTest()
        {
            BaseDeDados dados = new BaseDeDados();
            Funcionario margarete = dados.BuscarPorNome("Margarete Ricardo")[0];
            Funcionario atual = dados.FiltrarPorIdadeAproximada(40)[0];
            Assert.AreEqual(margarete, atual);
        }

        [TestMethod]
        public void SalarioMedioDeTodosOsFuncionariosTest()
        {
            BaseDeDados dados = new BaseDeDados();
            double esperado = 233.68;
            double atual = dados.SalarioMedio(null);
            Assert.AreEqual(esperado, atual, 0.2);
        }

        [TestMethod]
        public void SalarioMedioDoTurnoDaNoiteTest()
        {
            BaseDeDados dados = new BaseDeDados();
            double esperado = 190.0;
            double atual = dados.SalarioMedio(TurnoTrabalho.Noite);
            Assert.AreEqual(esperado, atual);
        }

        [TestMethod]
        public void AniversariantesDoMesTest()
        {
            BaseDeDados dados = new BaseDeDados();
            Funcionario funcionario = dados.AniversariantesDoMes()[0];
            Assert.AreEqual("Margarete Ricardo", funcionario.Nome);
        }
    }
}
