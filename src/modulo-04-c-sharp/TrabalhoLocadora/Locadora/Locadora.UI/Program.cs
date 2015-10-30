using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.UI
{
    class Program
    {
        static void Main(string[] args)
        {
            var db = new Biblioteca();
            var jogo = new Jogo("teste", 1, "rpg");

            db.EditarNomeJogo("Super Metroid", "OLOKO BICHO");

            //var a = db.BuscarPorNome("");
            //foreach (var b in a)
            //{
            //    Console.WriteLine(b.Nome + b.Preco);
            //}
            //Console.Read();
        }
    }
}
