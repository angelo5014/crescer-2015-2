using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Models
{
    public class JogoCompletoModel : RelatorioModel
    {
        public int Id { get; set; }
        public string Nome { get; set; }
        public decimal Preco { get; set; }
        public string Descricao { get; set; }
        public string Categoria { get; set; } 
        public string Selo { get; set; }
        public string Imagem { get; set; } 
        public string Video { get; set; }

        public JogoCompletoModel(string nome, decimal preco, string descricao, string categoria, string selo, string imagem, string video)
        {
            this.Nome = nome;
            this.Preco = preco;
            this.Descricao = descricao;
            this.Categoria = categoria;
            this.Selo = selo;
            this.Imagem = (imagem == null || imagem == "" ? "~/Content/sem-foto_360.jpg" : imagem);
            this.Video = video;
        }
    }
}