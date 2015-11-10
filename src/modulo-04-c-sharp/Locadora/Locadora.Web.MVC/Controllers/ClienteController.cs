using Locadora.Dominio.Repositorio;
using Locadora.Web.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{
    [Authorize]
    public class ClienteController : Controller
    {
        [HttpGet]
        public ActionResult Index()
        {
            return View();
        }

        [HttpGet]
        public ActionResult Manter(int? id)
        {
            if (id.HasValue)
            {
                IClienteRepositorio repositorio = new Repositorio.EF.ClienteRepositorio();
                var model = repositorio.BuscarPorId((int)id);


                return View(model);
            }
            else
            {
                return View();
            }
            
        }

        [HttpPost]
        public ActionResult Salvar(ClienteModel model)
        {
            if (ModelState.IsValid)
            {
                return RedirectToAction("Index", "Cliente");
            }
            else
            {
                return View("Index", model);
            }
        }
    }
}