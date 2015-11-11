using Locadora.Dominio;
using Locadora.Dominio.Servicos;
using Locadora.Web.MVC.Helpers;
using Locadora.Web.MVC.Models;
using Locadora.Web.MVC.Seguranca;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Web.Security;

namespace Locadora.Web.MVC.Controllers
{
    public class LoginController : Controller
    {
        public ActionResult Index()
        {
            return View();
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Login(LoginModel loginModel)
        {
            if (ModelState.IsValid)
            {
<<<<<<< HEAD
                //ServicoAutenticacao servicoAutenticacao = FabricaDeModulos.CriarServicoAutenticacao();

                //Usuario usuarioAutenticado = servicoAutenticacao.BuscarPorAutenticacao(loginModel.Email, loginModel.Password);

                //if (usuarioAutenticado != null)
                //{
                //    ControleDeSessao.CriarSessaoDeUsuario(usuarioAutenticado);
                //    return RedirectToAction("Index", "Home");
                //}
=======
                ServicoAutenticacao servicoAutenticacao = FabricaDeModulos.CriarServicoAutenticacao();

                Usuario usuarioAutenticado = servicoAutenticacao.BuscarPorAutenticacao(loginModel.Email, loginModel.Password);

                if (usuarioAutenticado != null)
                {
                    ControleDeSessao.CriarSessaoDeUsuario(usuarioAutenticado);
                    return RedirectToAction("Index", "Home");
                }
>>>>>>> 196bc442c1d9dea6c1835e05199b10a9db08b196
            }

            ModelState.AddModelError("INVALID_LOGIN", "Usuário ou senha inválidos.");
            return View("Index", loginModel);
        }

        public void Sair()
        {
            ControleDeSessao.Encerrar();
        }
<<<<<<< HEAD

=======
        
>>>>>>> 196bc442c1d9dea6c1835e05199b10a9db08b196
    }
}