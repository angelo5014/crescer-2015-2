
using Locadora.Web.MVC.Seguranca;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{
<<<<<<< HEAD
    [Authorize]
=======
    [Autorizador]
>>>>>>> 196bc442c1d9dea6c1835e05199b10a9db08b196
    public class HomeController : Controller
    {        
        public ActionResult Index()
        {
            return View();
        }
    }
}