using Locadora.Dominio.Repositorio;
using Locadora.Dominio.Servicos;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Infraestrutura.Servicos
{
    class ServicoLocacao : IServicoLocacao
    {
        ILocacaoRepositorio usuarioRepositorio;

        public ServicoLocacao(ILocacaoRepositorio repositorio)
        {
            this.usuarioRepositorio = repositorio;
        }

        public bool VerificarDisponibilidade(int idJogo)
        {
            var jogo = usuarioRepositorio.BuscarJogoLivre(idJogo);
            if(jogo != null)
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
