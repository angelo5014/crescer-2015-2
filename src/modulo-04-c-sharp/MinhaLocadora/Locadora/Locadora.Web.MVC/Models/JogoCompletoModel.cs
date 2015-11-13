using Locadora.Dominio;
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
        public string Descricao { get; set; }
        public Categoria Categoria { get; set; } 
        public Selo Selo { get; set; }
        public string Imagem { get; set; } 
        public string Video { get; set; }

        public JogoCompletoModel(Jogo jogo)
        {
            this.Nome = jogo.Nome;
            this.Descricao = jogo.Descricao;
            this.Categoria = jogo.Categoria;
            this.Selo = jogo.Selo;
            this.Imagem = (string.IsNullOrEmpty(jogo.Imagem) ? "~/Content/sem-foto_360.jpg" : jogo.Imagem);
            this.Video = jogo.Video;
        }
    }
}