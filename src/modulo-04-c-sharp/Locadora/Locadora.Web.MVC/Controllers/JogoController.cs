using Locadora.Dominio;
using Locadora.Dominio.Repositorio;
using Locadora.Web.MVC.Models;
using Locadora.Web.MVC.Seguranca.Filter;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{
    [Authorize]
    public class JogoController : Controller
    {
        IJogoRepositorio repositorio = new Repositorio.EF.JogoRepositorio();

        [HttpGet]
        public ActionResult Manter(int? id)
        {
            if (id.HasValue)
            {
                var jogo = repositorio.BuscarPorId((int)id);
                var model = JogoParaManterJogoModel(jogo);
                return View(model);
            }
            else
            {
                return View();
            }
        }

        [Autorizador(Roles = "DETALHE")]
        [HttpGet]
        public ActionResult DetalhesDoJogo(int id)
        {
            var jogo = repositorio.BuscarPorId(id);
            var model = new JogoCompletoModel(jogo)
            { Id = jogo.Id };
            return View(model);
        }

        [ValidateAntiForgeryToken]
        [HttpPost]
        public ActionResult Salvar(ManterJogoModel model)
        {
            if (ModelState.IsValid)
            {
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

        private ManterJogoModel JogoParaManterJogoModel(Jogo jogo)
        {
            return new ManterJogoModel()
            {
                Id = jogo.Id,
                Nome = jogo.Nome,
                Categoria = jogo.Categoria,
                Preco = jogo.Preco,
                Descricao = jogo.Descricao,
                Selo = jogo.Selo,
                Imagem = jogo.Imagem,
                Video = jogo.Video
            };
        }

        private Jogo ManterJogoModelParaJogo(ManterJogoModel model)
        {
            Jogo jogo = (model.Id.HasValue) ? new Jogo((int)model.Id) : jogo = new Jogo();

            jogo.Nome = model.Nome;
            jogo.Categoria = model.Categoria;
            jogo.Preco = model.Preco;
            jogo.Descricao = model.Descricao;
            jogo.Selo = model.Selo;
            jogo.Imagem = model.Imagem;
            jogo.Video = model.Video;

            return jogo;
        }

    }
}