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

        public Locacao BuscarJogoLivre(int idJogo)
        {
            using (var db = new BancoDeDados())
            {
                var b = db.Locacao.FirstOrDefault(m => m.Id == idJogo && m.DataDevolucao == null);
                return b;
            }
        }

        public int Criar(Locacao locacao)
        {
            using (var db = new BancoDeDados())
            {
                db.Entry(locacao).State = System.Data.Entity.EntityState.Added;
                return db.SaveChanges();
            }

        }

        public int Atualizar(Locacao locacao)
        {
            throw new NotImplementedException();
        }
    }
}
