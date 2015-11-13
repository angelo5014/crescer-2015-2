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
                DetalheJogoModel model = new DetalheJogoModel(
                    FabricaDeModulos.CriarJogoRepositorio().BuscarPorId((int)id)
                    );
                return View(model);
            }
            return View();
        }

        [HttpPost]
        public ActionResult Locar(int idJogo, int idCliente)
        {


            return View();
        }
    }
}