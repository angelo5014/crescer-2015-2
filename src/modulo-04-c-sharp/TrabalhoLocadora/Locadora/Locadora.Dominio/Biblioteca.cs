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

            //var lastID = jogoXML.LastNode;
            //var teste = lastID.ElementsAfterSelf();

            int LastId = Convert.ToInt32(jogoXML.Elements("jogo").Last().Attribute("id").Value);

            XElement xmlDoCadastro = new XElement("jogo",
                new XElement("nome", jogo.Nome),
                new XElement("preco", jogo.Preco),
                new XElement("categoria", jogo.Categoria));

            xmlDoCadastro.SetAttributeValue("id", LastId + 1);

            jogoXML.Add(xmlDoCadastro);

            jogoXML.Save(URL);
        }

        //public IList<Jogo> BuscarPorNome(string nome)
        //{
        //    XElement jogoXML = XElement.Load(URL);
            
        //    var lista = jogoXML.Elements("jogo").Where(jogo => jogo.Element("nome").Value == nome);
        //    var a = lista.

        //}
    }
}
