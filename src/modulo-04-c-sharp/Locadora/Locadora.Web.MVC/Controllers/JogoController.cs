using Locadora.Dominio;
using Locadora.Dominio.Repositorio;
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
    
    public class JogoController : Controller
    {

        [Autorizador]
        public ActionResult Manter(int? id)
        {
            if (id.HasValue)
            {
                var model = JogoParaManterJogoModel(FabricaDeModulos.CriarJogoRepositorio().BuscarPorId((int)id));
                return View(model);
            }
            else
            {
                return View();
            }
        }

        [ValidateAntiForgeryToken]
        [HttpPost]
        [Autorizador]
        public ActionResult Salvar(ManterJogoModel model)
        {
            if (ModelState.IsValid)
            {
                IJogoRepositorio repositorio = FabricaDeModulos.CriarJogoRepositorio();
                var jogo = ManterJogoModelParaJogo(model);

                if (jogo.Id == 0)
                {
                     repositorio.Criar(jogo);
                }
                else
                {
                    repositorio.Atualizar(jogo);
                }
                TempData["Mensagem"] = "Jogo salvo com sucesso!";

                return RedirectToAction("JogosDisponiveis", "Relatorio");
            }
            else
            {
                TempData["Mensagem"] = "O Jogo não é valido";

                return View("Manter", model);
            }
        }

        public ActionResult DetalhesDoJogo(int id)
        {
            Jogo jogoEncontrado = FabricaDeModulos.CriarJogoRepositorio().BuscarPorId(id);

            var jogoModel = new DetalheJogoModel(jogoEncontrado);

            return View(jogoModel);
        }
        private ManterJogoModel JogoParaManterJogoModel(Jogo jogo)
        {
            return new ManterJogoModel()
            {
                Id = jogo.Id,
                Nome = jogo.Nome,
                Categoria = jogo.Categoria,
                Descricao = jogo.Descricao,
                Selo = jogo.Selo,
                Imagem = jogo.UrlImagem,
                Video = jogo.TagVideo
            };
        }

        private Jogo ManterJogoModelParaJogo(ManterJogoModel model)
        {
            Jogo jogo = (model.Id.HasValue) ? new Jogo((int)model.Id) : jogo = new Jogo();

            jogo.Nome = model.Nome;
            jogo.Categoria = model.Categoria;
            jogo.Descricao = model.Descricao;
            jogo.Selo = model.Selo;
            jogo.UrlImagem = model.Imagem;
            jogo.TagVideo = model.Video;

            return jogo;
        }
    }
}