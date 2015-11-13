using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio
{
    public class Locacao : EntidadeBase
    {
        public int IdJogo { get; set; }
        public Jogo Jogo { get; private set; }
        public int IdCliente { get; set; }
        public Cliente Cliente { get; private set; }
        public DateTime DataLocacao { get; private set; }
        public DateTime? DataDevolucao { get; set; }

        public Locacao() { }

        public Locacao(Jogo jogo, Cliente cliente)
        {
            this.IdJogo = jogo.Id;
            this.IdCliente = cliente.Id;
            this.DataLocacao = DateTime.Now;
        }

    }
}
