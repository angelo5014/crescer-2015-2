using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio
{
    public class Locacao : EntidadeBase
    {

        public Jogo Jogo { get; private set; }
        public Cliente Cliente { get; private set; }
        public DateTime DataLocacao { get; private set; }
        public DateTime? DataDevolucao { get; private set; }

        public Locacao(Jogo jogo, Cliente cliente)
        {
            this.Jogo = jogo;
            this.Cliente = cliente;
            this.DataLocacao = DateTime.Now;
        }

    }
}
