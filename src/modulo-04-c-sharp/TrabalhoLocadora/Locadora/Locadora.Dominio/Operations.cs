using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio
{
    public class Operations
    {
        public void adicionar()
        {
            var db = new Biblioteca();
            Console.WriteLine("Digite o Nome do jogo a ser adicionado");
            var nome = Console.ReadLine();
            Console.WriteLine("Digite o preço do jogo a ser adicionado");
            double preco;
            try
            {
                preco = Convert.ToDouble(Console.ReadLine(),
                                                System.Globalization.CultureInfo.InvariantCulture);
            }
            catch (Exception e)
            {
                Console.WriteLine("O campo preço aceita somente numeros");
                return;
            }

            Console.WriteLine("Digite a categoria do jogo");
            Categoria categoria;
            try
            {
                categoria = (Categoria)Enum.Parse(typeof(Categoria), Console.ReadLine().ToUpper());
            }
            catch
            {
                Console.WriteLine("A categoria digitada não existe");
                return;
            }
            
                var jogo = new Jogo(nome, preco, categoria);
                db.CadastrarJogo(jogo);
        }
        public void BuscarPorNome()
        {
            var db = new Biblioteca();
            Console.WriteLine("Digite o nome do jogo");
            var nome = Console.ReadLine();
            var lista = db.BuscarPorNome(nome);
            foreach(var jogo in lista)
            {
                Console.WriteLine(jogo.Nome + "  -  " + jogo.Preco + "  -  " + jogo.Categoria);
            }
        }
        public void EditarNome()
        {
            var db = new Biblioteca();
            Console.WriteLine("Digite o nome do jogo");
            var antigoNome = Console.ReadLine();
            if (ValidaJogo(antigoNome)) {
                Console.WriteLine("Digite o novo nome");
                var novoNome = Console.ReadLine();
                db.EditarNomeJogo(antigoNome, novoNome);
            }
            else
            {
                Console.WriteLine("Jogo não existente");
            }
        }
        public void EditarPreco()
        {
            var db = new Biblioteca();
            Console.WriteLine("Digite o nome do jogo");
            var nome = Console.ReadLine();
            if (ValidaJogo(nome))
            {
                Console.WriteLine("Digite o novo preco");
                double novoPreco;
                try
                {
                    novoPreco = Convert.ToDouble(Console.ReadLine(),
                                                    System.Globalization.CultureInfo.InvariantCulture);
                }
                catch (Exception e)
                {
                    Console.WriteLine("O campo preço aceita somente numeros");
                    return;
                }
                db.EditarPrecoJogo(nome, novoPreco);
            }
            else
            {
                Console.WriteLine("Jogo não existente");
            }
        }
        public void EditarCategoria()
        {
            var db = new Biblioteca();
            Console.WriteLine("Digite o nome do jogo");
            var nome = Console.ReadLine();
            if (ValidaJogo(nome))
            {
                Console.WriteLine("Digite a nova categoria");
                Categoria categoria;
                try
                {
                    categoria = (Categoria)Enum.Parse(typeof(Categoria), Console.ReadLine().ToUpper());
                }
                catch
                {
                    Console.WriteLine("A categoria digitada não existe");
                    return;
                }

                db.EditarCategoriaJogo(nome, categoria);
            }
            else
            {
                Console.WriteLine("Jogo não existente");
            }
        }
        public void ImprimirRelatorio()
        {
            var db = new Biblioteca();
            var relatorio = new Relatorio();
            relatorio.ExportarRelatorio(db);
            Console.WriteLine("Relatorio impresso");
        }
        private bool ValidaJogo(string nome)
        {
            var db = new Biblioteca();
            var jogo = db.BuscarPorNomeIdentico(nome);
            return jogo != null ? true : false;
        }
    }
}
