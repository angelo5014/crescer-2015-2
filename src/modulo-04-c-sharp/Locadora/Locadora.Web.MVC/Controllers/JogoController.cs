using Locadora.Dominio.Repositorio;
using Locadora.Web.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{
    public class JogoController : Controller
    {
        IJogoRepositorio repositorio = new Repositorio.ADO.JogoRepositorio();
        public ActionResult DetalhesDoJogo(int id)
        {
            var jogo = repositorio.BuscarPorId(id);
            var model = new JogoCompletoModel(jogo.Nome, jogo.Preco, jogo.Descricao,
                                              jogo.Categoria.ToString(), jogo.Selo.ToString(),
                                              jogo.Imagem, jogo.Video)
            { Id = jogo.Id };
            return View(model);
        }
    }
}