using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Models
{
    public class LocacaoModel
    {
        public Jogo Jogo { get; private set; }
        public Cliente Cliente { get; private set; }
        public DateTime DataLocacao { get; private set; }
        public DateTime? DataDevolucao { get; private set; }

        public LocacaoModel (Locacao locacao)
        {
            this.Jogo = locacao.Jogo;
            this.Cliente = locacao.Cliente;
            this.DataLocacao = DataLocacao;
            this.DataDevolucao = DataDevolucao;
        }

    }
}