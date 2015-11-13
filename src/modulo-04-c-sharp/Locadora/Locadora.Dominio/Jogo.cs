using System;
using System.Globalization;
using System.Text;

namespace Locadora.Dominio
{
    public class Jogo : EntidadeBase
    {
        public string Nome { get; set; }

        public Categoria Categoria { get; set; }

        public Selo Selo { get; set; }

        public decimal Preco
        {
            get
            {
                if (Selo == Selo.Ouro)
                {
                    return 15;
                }
                else if (Selo == Selo.Prata)
                {
                    return 10;
                }
                else
                {
                    return 5;
                }
            }
        }

        public int TempoMaximo
        {
            get
            {
                if (Selo == Selo.Ouro)
                {
                    return 1;
                }
                else if (Selo == Selo.Prata)
                {
                    return 2;
                }
                else
                {
                    return 3;
                }
            }
        }

        public string Descricao { get; set; }

        public string UrlImagem { get; set; }

        public string TagVideo { get; set; }

        public Jogo()
        {
            this.Selo = Selo.Bronze;
        }

        public Jogo(int id) : base()
        {
            this.Id = id;
        }

        public override string ToString()
        {
            var builder = new StringBuilder();
            builder.AppendLine("Id: " + this.Id);
            builder.AppendLine("Nome: " + this.Nome);
            builder.AppendLine("Categoria: " + this.Categoria);

            return builder.ToString();
        }

        public override int GetHashCode()
        {
            return base.GetHashCode();
        }

        public override bool Equals(object obj)
        {
            if (obj.GetType() == typeof(Jogo))
            {
                Jogo jogoComp = (Jogo)obj;

                return this.Id == jogoComp.Id
                    && this.Nome == jogoComp.Nome
                    && this.Categoria == jogoComp.Categoria
                    && this.Selo == jogoComp.Selo;
            }

            return false;
        }
    }
}
