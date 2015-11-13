using Locadora.Dominio;
using Locadora.Dominio.Repositorio;
using Locadora.Dominio.Servicos;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Infraestrutura.Servicos
{
    public class ServicoLocacao : IServicoLocacao
    {
        ILocacaoRepositorio locacaoRepositorio;
        IJogoRepositorio jogoRepositorio;
        IClienteRepositorio clienteRepositorio;

        public ServicoLocacao(ILocacaoRepositorio locacaoRepositorio)
        {
            this.locacaoRepositorio = locacaoRepositorio;
        }

        public bool VerificarDisponibilidade(int idJogo)
        {
            var jogo = locacaoRepositorio.BuscarJogoLivre(idJogo);
            if(jogo == null)
            {
                return true;
            }
            else
            {
                return false;
            }
        }  

    }
}
