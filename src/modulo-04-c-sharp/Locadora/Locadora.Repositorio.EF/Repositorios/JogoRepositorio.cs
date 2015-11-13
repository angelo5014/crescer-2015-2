using Locadora.Dominio.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Locadora.Dominio;

namespace Locadora.Repositorio.EF.Repositorios
{
    public class JogoRepositorio : IJogoRepositorio
    {
        public int Atualizar(Jogo jogo)
        {
            using (var db = new BancoDeDados())
            {
                db.Entry(jogo).State = System.Data.Entity.EntityState.Modified;
                return db.SaveChanges();
            }
        }

        public Jogo BuscarPorId(int id)
        {
            using (var db = new BancoDeDados())
            {
                return db.Jogo.Find(id);
            }
        }

        public IList<Jogo> BuscarPorNome(string nome)
        {
            using (var db = new BancoDeDados())
            {
                return db.Jogo.Where(j => j.Nome.Contains(nome)).ToList();
            }
        }

        public IList<Jogo> BuscarTodos()
        {
            using (var db = new BancoDeDados())
            {
                return db.Jogo.ToList();
            }
        }

        public int Criar(Jogo jogo)
        {
            using (var db = new BancoDeDados())
            {
                db.Entry(jogo).State = System.Data.Entity.EntityState.Added;
                return db.SaveChanges();
            }
        }

        public int Excluir(int id)
        {
            using (var db = new BancoDeDados())
            {
                Jogo jogo = db.Jogo.Find(id);
                db.Entry(jogo).State = System.Data.Entity.EntityState.Deleted;
                return db.SaveChanges();
            }
        }
    }
}
