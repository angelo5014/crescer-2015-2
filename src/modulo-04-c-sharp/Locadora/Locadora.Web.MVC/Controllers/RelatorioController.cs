using Locadora.Web.MVC.Models;
using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using Locadora.Dominio.Repositorio;
using Locadora.Repositorio.ADO;

namespace Locadora.Web.MVC.Controllers
{
    public class RelatorioController : Controller
    {
        private IJogoRepositorio repositorio = new Repositorio.ADO.JogoRepositorio();

        public ActionResult JogosDisponiveis(string nome)
        {
            var model = new RelatorioModel();
            bool buscarNome = string.IsNullOrEmpty(nome);

            var resultado = buscarNome ? repositorio.BuscarTodos() : repositorio.BuscarPorNome(nome);

            foreach (var jogo in resultado)
            {
                var jogoModel = new JogoModel(jogo.Nome, jogo.Preco, jogo.Categoria.ToString()) { Id = jogo.Id};
                model.Jogos.Add(jogoModel);
            }

            model.QuantidadeDeJogos = model.Jogos.Count();

            var maiorPreco = model.Jogos.Max(jogo => jogo.Preco);
            var menorPreco = model.Jogos.Min(jogo => jogo.Preco);
            model.JogoMaisCaro = model.Jogos.First(jogo => jogo.Preco == maiorPreco).Nome;
            model.JogoMaisBarato = model.Jogos.First(jogo => jogo.Preco == menorPreco).Nome;

            model.PrecoMedio = model.Jogos.Average(jogo => jogo.Preco);

            return View(model);
        }
    }
}