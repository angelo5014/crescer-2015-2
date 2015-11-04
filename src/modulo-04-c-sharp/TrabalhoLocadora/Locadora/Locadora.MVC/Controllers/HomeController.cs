using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.MVC.Controllers
{
    public class HomeController : Controller
    {
        public ActionResult Index()
        {
            Console.WriteLine("teste");
            return View();
        }
        public ActionResult Teste()
        {
            return View("ViewPage1");
        }
    }
}