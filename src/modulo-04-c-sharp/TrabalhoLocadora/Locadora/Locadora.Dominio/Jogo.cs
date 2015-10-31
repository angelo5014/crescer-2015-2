using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio
{
    public class Jogo
    {
        public int ID { get; private set; }
        public string Nome { get; private set; }
        public double Preco { get; private set; }
        public Categoria Categoria { get; private set; }

        public Jogo(string nome, double preco, Categoria genero)
        {
            this.Nome = nome;
            this.Preco = preco;
            this.Categoria = genero;
        }
    }
}
