using System.Collections.Generic;
using System.Linq;

namespace ConsoleApp
{
    public class Agenda
    {
        private List<Contato> contatos;

        public int PegarQuantidadeDeContatos { get { return contatos.Count; } }

        public Agenda()
        {
            this.contatos = new List<Contato>();

        }

        public void AdicionarContato(Contato contato)
        {
            contatos.Add(contato);
        }

        public void RemoverContatosPorNome(string nomeContato)
        {
            foreach (var contato in contatos)
            {
                if (contato.Nome == nomeContato)
                {
                    contatos.Remove(contato);
                }
            }
        }
        public void RemoverContatosPorNumero(int numeroContato)
        {
            foreach (var contato in contatos)
            {
                if (contato.Numero == numeroContato)
                {
                    contatos.Remove(contato);
                }
            }
        }

        public List<Contato> ListarContatos()
        {
            return contatos;
        }

        public List<Contato> ListarContatosOrdenadoPorNome()
        {
            var contatoOrdenados = contatos.OrderBy(m => m.Nome).ThenBy(m => m.Nome).ToList();
            return contatoOrdenados;

        }

    }
}