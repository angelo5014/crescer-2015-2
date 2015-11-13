using Locadora.Dominio;
using Locadora.Dominio.Servicos;
using Locadora.Infraestrutura.Servicos;
using Locadora.Web.MVC.Helpers;
using Locadora.Web.MVC.Models;
using Locadora.Web.MVC.Seguranca;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{
    [Autorizador]
    public class LocacaoController : Controller
    {
        [HttpGet]
        public ActionResult Index(int? id)
        {
            if (id.HasValue)
            {
                var jogo = FabricaDeModulos.CriarJogoRepositorio().BuscarPorId((int)id);
                LocacaoModel model = JogoParaLocacaoModel(jogo);
                return View(model);
            }
            return View();
        }

        public ActionResult IndexDevolucao()
        {
            return View();
        }

        [HttpPost]
        //[ValidateAntiForgeryToken]
        public ActionResult Locar(LocacaoModel model)
        {
            if (ModelState.IsValid)
            {
                var cliente = FabricaDeModulos.CriarClienteRepositorio()
                                .BuscarPorNome(model.NomeCliente).FirstOrDefault();
                var jogo = FabricaDeModulos.CriarJogoRepositorio()
                            .BuscarPorId(model.IdJogo);

                var locacao = new Locacao(jogo, cliente);

                var repositorio = FabricaDeModulos.CriarLocacaoRepositorio();
                IServicoLocacao servico = new ServicoLocacao(repositorio);

                if (servico.VerificarDisponibilidade(jogo.Id))
                {
                    repositorio.Criar(locacao);
                }

                return RedirectToAction("JogosDisponiveis", "Relatorio");
            }
            return View("Index", model.IdJogo);
        }

        public ActionResult Devolver(LocacaoModel model)
        {
            if (ModelState.IsValid)
            {
                var repositorio = FabricaDeModulos.CriarLocacaoRepositorio();
                var locacao = repositorio
                                .BuscarPorId(repositorio
                                .BuscarIdPorIdJogo(FabricaDeModulos.CriarJogoRepositorio()
                                .BuscarPorNome(model.NomeJogo)[0].Id));

                locacao.DataDevolucao = DateTime.Now;
                repositorio.Atualizar(locacao);
                //return View(LocacaoParaLocacaoModel(locacao));
            }
            return View("IndexDevolucao");
        }

        private Locacao LocacaoModelParaLocacao(LocacaoModel model)
        {
            var jogo = new Jogo(model.IdJogo)
            {
                Nome = model.NomeJogo,
                Categoria = (Categoria)Enum.Parse(typeof(Categoria), model.Categoria),
                Selo = (Selo)Enum.Parse(typeof(Selo), model.Selo),
                Descricao = model.Descricao,
                UrlImagem = model.UrlImagem,
                TagVideo = model.TagVideo
            };

            var cliente = new Cliente(model.IdCliente) { Nome = model.NomeCliente };

            return new Locacao(jogo, cliente);
        }

        private LocacaoModel JogoParaLocacaoModel(Jogo jogo)
        {
            return new LocacaoModel()
            {
                IdJogo = jogo.Id,
                NomeJogo = jogo.Nome,
                Preco = jogo.Preco,
                Selo = jogo.Selo.ToString(),
                Categoria = jogo.Categoria.ToString(),
                Descricao = jogo.Descricao,
                UrlImagem = jogo.UrlImagem,
                TagVideo = jogo.TagVideo,
                TempoMaximo = jogo.TempoMaximo
            };
        }
        
        private Jogo LocacaoModelParaJogo(LocacaoModel model)
        {
            return new Jogo(model.IdJogo)
            {
                Nome = model.NomeJogo,
                Selo = (Selo)Enum.Parse(typeof(Selo), model.Selo),
                Categoria = (Categoria)Enum.Parse(typeof(Categoria), model.Categoria),
                Descricao = model.Descricao,
                UrlImagem = model.UrlImagem,
                TagVideo = model.TagVideo
            };
        }

        private LocacaoModel LocacaoParaLocacaoModel(Locacao loc)
        {
            return new LocacaoModel()
            {
                IdJogo = loc.IdJogo,
                IdCliente = loc.IdCliente,
                DataLocacao = loc.DataLocacao,
                NomeJogo = loc.Cliente.Nome,
                NomeCliente = loc.Jogo.Nome,
                Selo = loc.Jogo.Selo.ToString(),
                Categoria = loc.Jogo.Categoria.ToString(),
                Descricao = loc.Jogo.Descricao,
                UrlImagem = loc.Jogo.UrlImagem,
                TagVideo = loc.Jogo.TagVideo
            };
        }

    }
}