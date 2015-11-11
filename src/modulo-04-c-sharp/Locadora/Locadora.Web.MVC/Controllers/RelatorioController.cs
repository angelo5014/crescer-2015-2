<<<<<<< HEAD
﻿using Locadora.Web.MVC.Models;
using Locadora.Dominio;
=======
﻿using Locadora.Dominio;
using Locadora.Dominio.Repositorio;
using Locadora.Web.MVC.Helpers;
using Locadora.Web.MVC.Models;
using Locadora.Web.MVC.Seguranca;
>>>>>>> 196bc442c1d9dea6c1835e05199b10a9db08b196
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using Locadora.Dominio.Repositorio;
using Locadora.Repositorio.EF;

namespace Locadora.Web.MVC.Controllers
{
<<<<<<< HEAD
    [Authorize]
    public class RelatorioController : Controller
    {
        private IJogoRepositorio repositorio = new Locadora.Repositorio.EF.JogoRepositorio();

        public ActionResult JogosDisponiveis(string nome)
        {
            var model = new RelatorioModel();
            bool buscarNome = string.IsNullOrEmpty(nome);

            try
            {
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
=======
    [Autorizador]
    public class RelatorioController : Controller
    {
        public ActionResult JogosFiltradosPorId(int id)
        {
            return View();
        }
        
        public ActionResult JogosDisponiveis(string nome)
        {
            IList<Jogo> jogosEncontrados = null;
            IJogoRepositorio jogoRepositorio = FabricaDeModulos.CriarJogoRepositorio();

            if(string.IsNullOrEmpty(nome))
            {
                jogosEncontrados = jogoRepositorio.BuscarTodos();
            }
            else
            {
                jogosEncontrados = jogoRepositorio.BuscarPorNome(nome);
            }

            RelatorioJogosDisponiveisModel model = new RelatorioJogosDisponiveisModel(jogosEncontrados);
>>>>>>> 196bc442c1d9dea6c1835e05199b10a9db08b196

            return View(model);
            }
            catch
            {
                TempData["Mensagem"] = "Nenhum jogo Encontrado";
                return View();
            }
        }
        

    }
}