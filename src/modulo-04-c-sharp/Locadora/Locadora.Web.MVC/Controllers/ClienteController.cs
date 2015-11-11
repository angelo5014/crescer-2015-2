<<<<<<< HEAD
﻿using Locadora.Dominio.Repositorio;
using Locadora.Web.MVC.Models;
using System;
using System.Collections.Generic;
=======
﻿using Locadora.Dominio;
using Locadora.Web.MVC.Models;
using Locadora.Web.MVC.Seguranca;
using System;
using System.Collections.Generic;
using System.Globalization;
>>>>>>> 196bc442c1d9dea6c1835e05199b10a9db08b196
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{
<<<<<<< HEAD
    [Authorize]
    public class ClienteController : Controller
    {
=======
    [Autorizador]
    public class ClienteController : Controller
    {
        //Só pra teste! Não façam uma coisa dessas!
        List<JogoDisponivelModel> exemploDeLista = new List<JogoDisponivelModel>
        {
            //new JogoDisponivelModel(new Dominio.Jogo(1) { Nome = "Mario" }),
            //new JogoDisponivelModel(new Dominio.Jogo(2) { Nome = "Mario 2" })

        };

>>>>>>> 196bc442c1d9dea6c1835e05199b10a9db08b196
        [HttpGet]
        public ActionResult Index()
        {
            return View();
        }

        [HttpGet]
<<<<<<< HEAD
        public ActionResult Manter(int? id)
        {
            if (id.HasValue)
            {
                IClienteRepositorio repositorio = new Repositorio.EF.ClienteRepositorio();
                var model = repositorio.BuscarPorId((int)id);

=======
        [Autorizador(Roles = Permissao.ADMIN)]
        public ActionResult Manter(int? id)
        {            
            ViewBag.ListaJogos = new SelectList(exemploDeLista, "IdJogo", "Nome");
            //OU:
            //ViewBag.ListaJogos = exemploDeLista.Select(x => new SelectListItem() { Value = x.IdJogo.ToString(), Text = x.Nome });

            if (id.HasValue)
            {
                //Busca cliente do banco
                var model = new ClienteModel()
                {
                    Id = 5,
                    Nome = "Didi must die",
                    Email = "didi@didi.com",
                    EmailConfimacao = "didi@didi.com",
                    Idade = 80
                };
>>>>>>> 196bc442c1d9dea6c1835e05199b10a9db08b196

                return View(model);
            }
            else
            {
                return View();
            }
<<<<<<< HEAD
            
        }

        [HttpPost]
        public ActionResult Salvar(ClienteModel model)
        {
            if (ModelState.IsValid)
            {
=======
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

>>>>>>> 196bc442c1d9dea6c1835e05199b10a9db08b196
                return RedirectToAction("Index", "Cliente");
            }
            else
            {
<<<<<<< HEAD
                return View("Index", model);
=======
                //Exemplo de modificação dos dados da model antes de retornar!
                //ModelState.SetModelValue("Nome", new ValueProviderResult("Bob Esponja", "", CultureInfo.InvariantCulture));

                ViewBag.ListaJogos = new SelectList(exemploDeLista, "IdJogo", "Nome");

                return View("Manter", model);
>>>>>>> 196bc442c1d9dea6c1835e05199b10a9db08b196
            }
        }
    }
}