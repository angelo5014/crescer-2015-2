using Locadora.Dominio;
using Locadora.Dominio.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Repositorio.EF.Repositorios
{
    public class LocacaoRepositorio : ILocacaoRepositorio
    {
        public Locacao BuscarPorId(int id)
        {
            using (var db = new BancoDeDados())
            {
                return db.Locacao.Find(id);
            }
        }
    }
}
