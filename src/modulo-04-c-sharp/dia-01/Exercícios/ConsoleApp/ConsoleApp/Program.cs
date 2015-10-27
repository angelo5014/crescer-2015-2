using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp
{
    class Program
    {
        static void Main(string[] args)
        {
            var agenda = new Agenda();
            Console.WriteLine("Iniciando Sistema");
            Boolean ativo;
            do
            {
                Console.Clear();
                Console.WriteLine("Escolha uma das opções");
                Console.WriteLine("1. Adicionar Conatato \n2. Excluir Contato Por Nome \n3. Excluir Contato Por Numero\n4.Listar Contatos \n5.Listar Contatos Ordenados");
                int opcao = int.Parse(Console.ReadLine());
                Console.Clear();
                string nome;
                int numero;
                switch (opcao)
                {
                    case 1:
                        Console.WriteLine("Digite o Nome do contato a ser adicionado");
                        nome = Console.ReadLine();
                        Console.WriteLine("Digite o Numero do contato a ser adicionado");
                        numero = int.Parse(Console.ReadLine());
                        agenda.AdicionarContato(new Contato() { Nome = nome, Numero = numero });
                        break;
                    case 2:
                        Console.WriteLine("Digite o nome do contato que deseja excluir");
                        nome = Console.ReadLine();
                        agenda.RemoverContatosPorNome(nome);
                        break;
                    case 3:
                        Console.WriteLine("Digite o numero do contato que deseja excluir");
                        numero = int.Parse(Console.ReadLine());
                        agenda.RemoverContatosPorNumero(numero);
                        break;
                    case 4:
                        Console.WriteLine("Listando Nomes");
                        foreach (var contato in agenda.ListarContatos())
                        {
                            Console.WriteLine(contato.Nome + " " + contato.Numero);
                        }
                        break;
                    case 5:
                        Console.WriteLine("Listando contatos ordenados por nome");
                        foreach (var contato in agenda.ListarContatosOrdenadoPorNome())
                        {
                            Console.WriteLine(contato.Nome + " " + contato.Numero);
                        }
                        break;
                }
                Console.WriteLine("Deseja fazer outra operação \n1-Sim \n2-Nao");
                ativo = (int.Parse(Console.ReadLine())) == 1 ? true : false;
                Console.Clear();
            } while (ativo);
        }

    }
}
