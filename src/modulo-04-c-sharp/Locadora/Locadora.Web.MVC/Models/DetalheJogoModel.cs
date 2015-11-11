using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Models
{
    public class DetalheJogoModel
    {
        public int IdJogo { get; private set; }
        public string Nome { get; private set; }
        public decimal Preco { get; private set; }
        public Categoria Categoria { get; private set; }
        public Selo Selo { get; private set; }
        public string UrlImagem { get; private set; }
        public string TagVideo { get; private set; }

        public DetalheJogoModel(Jogo jogo)
        {
            this.IdJogo = jogo.Id;
            this.Nome = jogo.Nome;
            this.Preco = jogo.Preco;
            this.Categoria = jogo.Categoria;
            this.Selo = jogo.Selo;
            this.UrlImagem = !String.IsNullOrEmpty(jogo.UrlImagem) ? jogo.UrlImagem : "http://cdn.123i.com.br/img/sem-foto-vertical.jpg";
            this.TagVideo = jogo.TagVideo;
        }
    }
}