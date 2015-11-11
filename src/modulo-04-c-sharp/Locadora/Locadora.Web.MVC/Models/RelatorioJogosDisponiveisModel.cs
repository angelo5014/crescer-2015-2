using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Models
{
    public class RelatorioJogosDisponiveisModel
    {
        public List<JogoDisponivelModel> Jogos { get; private set; }

        public int QuantidadeTotalDeJogos { get; private set; }
        public decimal ValorMedio { get; private set; }
        public JogoDisponivelModel JogoMaisCaro { get; private set; }
        public JogoDisponivelModel JogoMaisBarato { get; private set; }

        public RelatorioJogosDisponiveisModel(IList<Jogo> jogosDisponiveis)
        {
            this.Jogos = new List<JogoDisponivelModel>();

            if(jogosDisponiveis != null && jogosDisponiveis.Count > 0)
            {
                foreach (Jogo jogo in jogosDisponiveis)
                {
                    var jogoModel = new JogoDisponivelModel(jogo);
                    this.Jogos.Add(jogoModel);
                }

                this.QuantidadeTotalDeJogos = jogosDisponiveis.Count;
                this.ValorMedio = jogosDisponiveis.Average(j => j.Preco);
                decimal maiorPreco = jogosDisponiveis.Max(j => j.Preco);
                decimal menorPreco = jogosDisponiveis.Min(j => j.Preco);

                this.JogoMaisCaro = this.Jogos.First(j => j.Preco == maiorPreco);
                this.JogoMaisBarato = this.Jogos.First(j => j.Preco == menorPreco);
            }
            
        }     
    }    

    public class JogoDisponivelModel
    {
        public int IdJogo { get; private set; }
        public string Nome { get; private set; }
        public decimal Preco { get; private set; }
        public Categoria Categoria { get; private set; }
        public Selo Selo { get; private set; }

        public JogoDisponivelModel(Jogo jogo)
        {
            this.IdJogo = jogo.Id;
            this.Nome = jogo.Nome;
            this.Preco = jogo.Preco;
            this.Categoria = jogo.Categoria;
            this.Selo = jogo.Selo;
        }
    }
}