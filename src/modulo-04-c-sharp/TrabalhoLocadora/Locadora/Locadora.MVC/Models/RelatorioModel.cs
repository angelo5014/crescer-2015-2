using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Locadora.MVC.Models
{
    public class RelatorioModel
    {
        private Relatorio relatorio;

        public List<Jogo> Relatorio { get { return relatorio.RetornarJogos(); } }

        public RelatorioModel()
        {
        }
    }
}