using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Models
{
    public class LocacaoModel
    {
        public int IdJogo { get; set; }

        public int IdCliente { get; set; }

        public string NomeJogo { get; set; }

        public string NomeCliente { get; set; }

        public string Selo { get; set; }

        public string Categoria { get; set; }

        public string Descricao { get; set; }

        public string UrlImagem { get; set; }

        public string TagVideo { get; set; }

        public int TempoMaximo { get; set; }

        public DateTime DataLocacao { get; set; }

        public DateTime DataPrevista { get { return DataLocacao.AddDays(TempoMaximo); } }

        public decimal Preco { get; set; }
    }
}