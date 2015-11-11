using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Optimization;

namespace Locadora.Web.MVC.App_Start
{
    public class BundleConfig
    {
        public static void RegisterBundles(BundleCollection bundles)
        {
            bundles.Add(new ScriptBundle("~/bundles/jquery").Include(
                        "~/Scripts/jquery-{version}.js"));

            bundles.Add(new ScriptBundle("~/bundles/modernizr").Include(
                        "~/Scripts/modernizr-*"));

            bundles.Add(new ScriptBundle("~/bundles/bootstrap").Include(
<<<<<<< HEAD
                        "~/Scripts/bootstrap.js"));
=======
                        "~/Scripts/bootstrap.js"));            
>>>>>>> 196bc442c1d9dea6c1835e05199b10a9db08b196

            bundles.Add(new StyleBundle("~/Content/css").Include(
                        "~/Content/bootstrap.css",
                        "~/Content/site.css"));
        }
<<<<<<< HEAD

        internal static void RegisterBundles(object bundles)
        {
            throw new NotImplementedException();
        }
=======
>>>>>>> 196bc442c1d9dea6c1835e05199b10a9db08b196
    }

}