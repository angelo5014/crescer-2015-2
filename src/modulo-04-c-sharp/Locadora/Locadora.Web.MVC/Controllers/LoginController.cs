using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Web.Security;
using WebApplication1.Models;

namespace Locadora.Web.MVC.Models
{
    public class LoginController : Controller
    {
        
        public ActionResult Index(string usuario, string senha)
        {
            return View();
        }

        public ActionResult Login(string usuario, string senha)
        {
            //TODO: validar usuario

            if (usuario == "angelo" && senha == "123")
            {
                var usuarioLogadoModel = new UsuarioLogado("angelo", new string[] { "DETALHE" });

                FormsAuthentication.SetAuthCookie(usuario, true);
                Session["USUARIO_LOGADO"] = usuarioLogadoModel;
            }

            return RedirectToAction("Index", "Home");
        }

    }
}