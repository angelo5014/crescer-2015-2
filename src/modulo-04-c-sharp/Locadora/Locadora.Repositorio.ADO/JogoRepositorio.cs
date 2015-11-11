using Locadora.Dominio.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Locadora.Dominio;
using System.Data.SqlClient;
using System.Data;

namespace Locadora.Repositorio.EF
{
    public class JogoRepositorio : RepositorioBase,  IJogoRepositorio
    {
<<<<<<< HEAD
        private const string BASE_SELECT = "SELECT Id, Nome, Preco, Descricao, IdSelo, IdCategoria, Imagem, Video, IdClienteLocacao FROM Jogo ";
=======
        private const string BASE_SELECT = " SELECT Id, Nome, Preco, IdCategoria, IdClienteLocacao, IdSelo, " +
                                                  " Descricao, Url_Imagem, Tag_Video " +
                                           " FROM Jogo ";
>>>>>>> 196bc442c1d9dea6c1835e05199b10a9db08b196

        public int Atualizar(Jogo entidade)
        {
            using (IDbConnection conexao = CriarConexao())
            {                
                var sql = new StringBuilder();
                sql.Append(" UPDATE Jogo set ");
                sql.Append(" Nome = @paramNome, ");
                sql.Append(" Preco = @paramPreco, ");
                sql.Append(" Descricao = @paramDescricao, ");
                sql.Append(" IdSelo = @paramIdSelo, ");
                sql.Append(" IdCategoria = @paramIdCategoria, ");
<<<<<<< HEAD
                sql.Append(" Imagem = @paramImagem, ");
                sql.Append(" Video = @paramVideo, ");
                sql.Append(" IdClienteLocacao = @paramIdClienteLocacao ");
=======
                sql.Append(" IdClienteLocacao = @paramIdClienteLocacao, ");
                sql.Append(" IdSelo = @paramIdSelo, ");
                sql.Append(" Descricao = @paramDescricao, ");
                sql.Append(" Url_Imagem = @paramUrlImagem, ");
                sql.Append(" Tag_Video = @paramTagVideo ");
>>>>>>> 196bc442c1d9dea6c1835e05199b10a9db08b196
                sql.Append(" WHERE Id = @paramId ");

                IDbCommand comando = conexao.CreateCommand();
                comando.CommandText = sql.ToString();
                comando.AddParam("paramNome", entidade.Nome);
                comando.AddParam("paramPreco", entidade.Preco);
                comando.AddParam("paramDescricao", entidade.Descricao);
                comando.AddParam("paramIdSelo", (int)entidade.Selo);
                comando.AddParam("paramIdCategoria", (int)entidade.Categoria);
<<<<<<< HEAD
                comando.AddParam("paramImagem", entidade.Imagem);
                 comando.AddParam("paramVideo", entidade.Video);
                //TODO: ajustar mimi pq deu pau na aula do benhur soh
               // comando.AddParam("paramIdClienteLocacao", entidade.IdClienteLocacao);
=======
                comando.AddParam("paramIdClienteLocacao", entidade.IdClienteLocacao);
                comando.AddParam("paramIdSelo", (int)entidade.Selo);
                comando.AddParam("paramDescricao", entidade.Descricao);
                comando.AddParam("paramUrlImagem", entidade.UrlImagem);
                comando.AddParam("paramTagVideo", entidade.TagVideo);
>>>>>>> 196bc442c1d9dea6c1835e05199b10a9db08b196
                comando.AddParam("paramId", entidade.Id);

                conexao.Open();

                return comando.ExecuteNonQuery();
            }
        }

        public Jogo BuscarPorId(int id)
        {
            using (IDbConnection conexao = CriarConexao())
            {
                IDbCommand comando = conexao.CreateCommand();
                comando.CommandText = BASE_SELECT + " WHERE Id = @paramId";
                comando.AddParam("paramId", id);

                conexao.Open();
                IDataReader reader = comando.ExecuteReader();

                return LerJogosDoDataReader(reader).FirstOrDefault();
            }
        }

        public IList<Jogo> BuscarPorNome(string nome)
        {
            using (IDbConnection conexao = CriarConexao())
            {
                IDbCommand comando = conexao.CreateCommand();
                comando.CommandText = BASE_SELECT + " WHERE Nome like @paramNome";
                comando.AddParam("paramNome", String.Format("%{0}%", nome));

                conexao.Open();
                IDataReader reader = comando.ExecuteReader();

                return LerJogosDoDataReader(reader);
            }
        }

        public IList<Jogo> BuscarTodos()
        {
            using (IDbConnection conexao = CriarConexao())
            {
                IDbCommand comando = conexao.CreateCommand();
                comando.CommandText = BASE_SELECT;

                conexao.Open();
                IDataReader reader = comando.ExecuteReader();

                return LerJogosDoDataReader(reader);
            }
        }

        public int Criar(Jogo entidade)
        {
            using (IDbConnection conexao = CriarConexao())
            {
                var sql = new StringBuilder();
<<<<<<< HEAD
                sql.Append(" INSERT INTO Jogo (Nome, Preco, Descricao, IdSelo, IdCategoria, Imagem, Video, IdClienteLocacao) ");
                sql.Append(" VALUES (@paramNome, @paramPreco, @paramDescricao, @paramIdSelo, @paramIdCategoria, @paramImagem, @paramVideo, @paramIdClienteLocacao) ");
=======
                sql.Append(" INSERT INTO Jogo (Nome, Preco, Categoria, IdClienteLocacao, IdSelo, Descricao, Url_Imagem, Tag_Video) ");
                sql.Append(" VALUES (@paramNome, @paramPreco, @paramCategoria, @paramIdClienteLocacao, @paramIdSelo, @paramDescricao, @paramUrlImagem, @paramTagVideo) ");
>>>>>>> 196bc442c1d9dea6c1835e05199b10a9db08b196

                IDbCommand comando = conexao.CreateCommand();
                comando.CommandText = sql.ToString();
                comando.AddParam("paramNome", entidade.Nome);
                comando.AddParam("paramPreco", entidade.Preco);
                comando.AddParam("paramDescricao", entidade.Descricao);
                comando.AddParam("paramIdSelo", (int)entidade.Selo);
                comando.AddParam("paramIdCategoria", (int)entidade.Categoria);
<<<<<<< HEAD
                //TODO: Deu pau nesse bagulho
                //comando.AddParam("paramIdClienteLocacao", entidade.IdClienteLocacao);
                comando.AddParam("paramImagem", entidade.Imagem);
                comando.AddParam("paramVideo", entidade.Video);
=======
                comando.AddParam("paramIdClienteLocacao", entidade.IdClienteLocacao);
                comando.AddParam("paramIdSelo", (int)entidade.Selo);
                comando.AddParam("paramDescricao", entidade.Descricao);
                comando.AddParam("paramUrlImagem", entidade.UrlImagem);
                comando.AddParam("paramTag_Video", entidade.TagVideo);
>>>>>>> 196bc442c1d9dea6c1835e05199b10a9db08b196

                conexao.Open();
                return comando.ExecuteNonQuery();
            }
        }

        public int Excluir(int id)
        {
            using (IDbConnection conexao = CriarConexao())
            {
                IDbCommand comando = conexao.CreateCommand();
                comando.CommandText = "DELETE FROM Jogos WHERE Id = @paramId";
                comando.AddParam("paramId", id);

                conexao.Open();
                return comando.ExecuteNonQuery();
            }
        }

        private IList<Jogo> LerJogosDoDataReader(IDataReader reader)
        {
            IList<Jogo> jogosLidos = new List<Jogo>();

            while (reader.Read())
            {
                jogosLidos.Add(ConverterDataReaderEmJogo(reader));
            }

            return jogosLidos;
        }

        private Jogo ConverterDataReaderEmJogo(IDataReader reader)
        {
            var jogo = new Jogo(
                id: Convert.ToInt32(reader["Id"])//,
                //TODO: Deu pau no bagulho
                //idClienteLocacao: reader["IdClienteLocacao"].ToString().ToNullable<int>()
                );

            jogo.Nome = reader["Nome"].ToString();
            jogo.Preco = Convert.ToDecimal(reader["Preco"]);
            jogo.Descricao = reader["Descricao"].ToString();
            jogo.Selo = (Selo)Convert.ToInt32(reader["IdSelo"]);
            jogo.Categoria = (Categoria)Convert.ToInt32(reader["IdCategoria"]);
<<<<<<< HEAD
            jogo.Imagem = reader["Imagem"].ToString();
            jogo.Video = reader["Video"].ToString();
=======
            jogo.Selo = (Selo)Convert.ToInt32(reader["IdSelo"]);
            jogo.Descricao = reader["Descricao"].ToString();
            jogo.UrlImagem = reader["Url_Imagem"].ToString();
            jogo.TagVideo = reader["Tag_Video"].ToString();
>>>>>>> 196bc442c1d9dea6c1835e05199b10a9db08b196

            return jogo;
        }

    }
}
