using Locadora.Dominio;
using Locadora.Dominio.Repositorio;
using Locadora.Web.MVC.Helpers;
using Locadora.Web.MVC.Models;
using Locadora.Web.MVC.Seguranca;
using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{
    [Autorizador]
    public class ClienteController : Controller
    {
        //Só pra teste! Não façam uma coisa dessas!
        List<JogoDisponivelModel> exemploDeLista = new List<JogoDisponivelModel>
        {            //new JogoDisponivelModel(new Dominio.Jogo(1) { Nome = "Mario" }),
            //new JogoDisponivelModel(new Dominio.Jogo(2) { Nome = "Mario 2" })

        };

        [HttpGet]
        public ActionResult Index()
        {
            return View();
        }

        [HttpGet]
        [Autorizador(Roles = Permissao.ADMIN)]
        public ActionResult Manter(int? id)
        {
            return View();
        }

        [ValidateAntiForgeryToken]
        [HttpPost]
        public ActionResult Salvar(ClienteModel model)
        {
            //ModelState.AddModelError("Nome", "Nome já existe no banco de dados!");
            //ModelState.AddModelError("", "Tem coisa errada aí...");

            if (ModelState.IsValid)
            {
                //salvar no banco
                TempData["Mensagem"] = "Cliente salvo com sucesso!";

                return RedirectToAction("Index", "Cliente");
            }
            else
            {
                //Exemplo de modificação dos dados da model antes de retornar!
                //ModelState.SetModelValue("Nome", new ValueProviderResult("Bob Esponja", "", CultureInfo.InvariantCulture));

                ViewBag.ListaJogos = new SelectList(exemploDeLista, "IdJogo", "Nome");

                return View("Manter", model);
            }
        }
        public JsonResult ClientesAutocomplete(string term)
        {
            IList<Cliente> ClientesEncontrados = ObterClientesPorFiltro(term);

            var json = ClientesEncontrados.Select(x => new { label = x.Nome });

            return Json(json, JsonRequestBehavior.AllowGet);
        }

        private IList<Cliente> ObterClientesPorFiltro(string nome)
        {
            IClienteRepositorio clienteRepositorio = FabricaDeModulos.CriarClienteRepositorio();

          if (string.IsNullOrEmpty(nome))
                return clienteRepositorio.BuscarTodos();
            else
                return clienteRepositorio.BuscarPorNome(nome);
        }
    }
}