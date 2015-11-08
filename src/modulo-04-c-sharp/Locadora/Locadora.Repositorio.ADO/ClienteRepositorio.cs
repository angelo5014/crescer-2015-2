using Locadora.Dominio.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Locadora.Dominio;
using System.Data;

namespace Locadora.Repositorio.ADO
{
    public class ClienteRepositorio : RepositorioBase,IClienteRepositorio
    {
        private const string BASE_SELECT = "SELECT Id, Nome FROM Jogo ";


        public int Atualizar(Cliente entidade)
        {
            throw new NotImplementedException();
        }

        public Cliente BuscarPorId(int id)
        {
            //    using (IDbConnection conexao = CriarConexao())
            //    {
            //        IDbCommand comando = conexao.CreateCommand();
            //        comando.CommandText = BASE_SELECT + " WHERE Id = @paramId";
            //        comando.AddParam("paramId", id);

            //        conexao.Open();
            //        IDataReader reader = comando.ExecuteReader();

            //        return LerClienteDoDataReader(reader).FirstOrDefault();
            //    }
            throw new NotImplementedException();
        }

        public IList<Cliente> BuscarPorNome(string nome)
        {
            throw new NotImplementedException();
        }

        public IList<Cliente> BuscarTodos()
        {
            throw new NotImplementedException();
        }

        public int Criar(Cliente entidade)
        {
            throw new NotImplementedException();
        }

        public int Excluir(int id)
        {
            throw new NotImplementedException();
        }

        //private IList<Cliente> LerClienteDoDataReader(IDataReader reader)
        //{
        //    IList<Cliente> clientesLidos = new List<Cliente>();

        //    while (reader.Read())
        //    {
        //        clientesLidos.Add(ConverterDataReaderEmCliente(reader));
        //    }

        //    return clientesLidos;
        //}

        //private Cliente ConverterDataReaderEmCliente(IDataReader reader)
        //{
        //    var cliente = new Cliente(
        //        id: Convert.ToInt32(reader["Id"]),
                
        //        );

        //    jogo.Nome = reader["Nome"].ToString();
        //    jogo.Preco = Convert.ToDecimal(reader["Preco"]);
        //    jogo.Descricao = reader["Descricao"].ToString();
        //    jogo.Selo = (Selo)Convert.ToInt32(reader["IdSelo"]);
        //    jogo.Categoria = (Categoria)Convert.ToInt32(reader["IdCategoria"]);
        //    jogo.Imagem = reader["Imagem"].ToString();
        //    jogo.Video = reader["Video"].ToString();

        //    return jogo;
        //}


    }
}
