using Locadora.Dominio.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Locadora.Dominio;

namespace Locadora.Repositorio.EF
{
    class JogoRepositorio : RepositorioBase, IJogoRepositorio
    {
        public int Atualizar(Jogo jogo)
        {
            using (var db = CriarConexao())
            {
                db.Entry(jogo).State = System.Data.Entity.EntityState.Modified;
                return db.SaveChanges();
            }
        }

        public Jogo BuscarPorId(int id)
        {
            using (var db = CriarConexao())
            {
                return db.Jogo.Find(id);
            }
        }

        public IList<Jogo> BuscarPorNome(string nome)
        {
            using (var db = CriarConexao())
            {
                return db.Jogo.Where(jogo => jogo.Nome.Contains(nome)).ToList();
            }
        }

        public IList<Jogo> BuscarTodos()
        {
            using (var db = CriarConexao())
            {
                return db.Jogo.Select(jogo => jogo).ToList();
            }
        }

        public int Criar(Jogo jogo)
        {
            using (var db = CriarConexao())
            {
                db.Entry(jogo).State = System.Data.Entity.EntityState.Added;
                return db.SaveChanges();
            }
        }

        public int Excluir(int id)
        {
            using (var db = CriarConexao())
            {
                db.Entry(new Jogo(id)).State = System.Data.Entity.EntityState.Deleted;
                return db.SaveChanges();
            }
        }
    }
}
