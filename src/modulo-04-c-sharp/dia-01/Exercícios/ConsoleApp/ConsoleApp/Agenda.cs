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
            var contatosParaRemover = new List<Contato>();

            for (int i = 0; i < contatos.Count; i++)
            {
                if (contatos[i].Nome == nomeContato)
                    contatosParaRemover.Add(contatos[i]);
            }

            foreach (var contato in contatosParaRemover)
            {
                contatos.Remove(contato);
            }
        }
        public void RemoverContatosPorNumero(int numeroContato)
        {
            var contatosParaRemover = new List<Contato>();

            for (int i = 0; i < contatos.Count; i++)
            {
                if (contatos[i].Numero == numeroContato)
                    contatosParaRemover.Add(contatos[i]);
            }

            foreach (var contato in contatosParaRemover)
            {
                contatos.Remove(contato);
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