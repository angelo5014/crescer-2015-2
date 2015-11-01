using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.UI
{
    class Program
    {
        static void Main(string[] args)
        {
            const int ADICIONAR = 1;
            const int PESQUISAR = 2;
            const int EDITARNOME = 3;
            const int EDITARPRECO = 4;
            const int EDITARCATEGORIA = 5;
            const int IMPRIMIRRELATORIO = 6;

            var db = new Biblioteca();
            Console.WriteLine("Iniciando Sistema");
            Boolean ativo;
            do
            {
                Console.Clear();
                Console.WriteLine("Escolha uma das opções");
                Console.WriteLine("1. Adicionar Jogo \n2. Pesquisar por nome \n3. Editar nome \n4. Editar preco \n5. Editar Categoria \n6. Imprimir Relatorio");
                int opcao;
                try
                {
                    opcao = int.Parse(Console.ReadLine());
                }
                catch
                {
                    Console.WriteLine("Por favor, digite um numero");
                    opcao = 0;
                }
                Console.Clear();
                string nome;
                double preco;
                Categoria categoria;
                var operacao = new Operations();
                switch (opcao)
                {
                    case ADICIONAR:
                        operacao.adicionar();
                        break;
                    case PESQUISAR:
                        operacao.BuscarPorNome();
                        break;
                    case EDITARNOME:
                        operacao.EditarNome();
                        break;
                    case EDITARPRECO:
                        operacao.EditarPreco();
                        break;
                    case EDITARCATEGORIA:
                        operacao.EditarCategoria();
                        break;
                    case IMPRIMIRRELATORIO:
                        operacao.ImprimirRelatorio();
                        break;
                    default:
                        Console.WriteLine("Opção inválida");
                        break;
                }

                Console.WriteLine("Deseja fazer outra operação \n1-Sim \n2-Nao");
                try
                {
                    ativo = (int.Parse(Console.ReadLine())) == 1 ? true : false;
                }
                catch
                {
                    Console.WriteLine("Escolha inválida.");
                    ativo = true;
                }


                Console.Clear();
            } while (ativo);
        }
    }
}
