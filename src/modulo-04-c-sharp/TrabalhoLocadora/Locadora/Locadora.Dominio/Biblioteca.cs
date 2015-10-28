using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;

namespace Locadora.Dominio
{
    public class Biblioteca
    {
        private const string URL = @"C:\Users\Angelo\Documents\crescer-2015-2\src\modulo-04-c-sharp\TrabalhoLocadora\Locadora\game_store.xml";

        public void CadastrarJogo(Jogo jogo)
        {
            XElement jogoXML = XElement.Load(URL);

            XElement xmlDoCadastro = new XElement("jogo", 
                new XElement("nome", jogo.Nome),
                new XElement("preco", jogo.Preco),
                new XElement("categoria", jogo.Categoria));

            jogoXML.Add(xmlDoCadastro);

            jogoXML.Save(URL);
        }

        //public List<Jogo> BuscarPorNome(string nome)
        //{
        //    XElement jogoXML = XElement.Load(URL);
        //    foreach (XElement jogo in xmlJogos.Elements("jogo"))
        //    {
        //        XElement nome = jogo.Element("nome");
        //        Console.WriteLine(jogo.Attribute("id"));
        //        Console.WriteLine(nome.Value);
        //    }
        //}
    }
}
