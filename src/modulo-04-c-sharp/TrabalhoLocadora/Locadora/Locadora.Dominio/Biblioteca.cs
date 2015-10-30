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
            int LastId = Convert.ToInt32(jogoXML.Elements("jogo").Last().Attribute("id").Value);

            XElement xmlDoCadastro = new XElement("jogo",
                new XElement("nome", jogo.Nome),
                new XElement("preco", jogo.Preco),
                new XElement("categoria", jogo.Categoria));

            xmlDoCadastro.SetAttributeValue("id", LastId + 1);
            jogoXML.Add(xmlDoCadastro);
            jogoXML.Save(URL);
        }

        public IList<Jogo> BuscarPorNome(string nome)
        {
            XElement jogoXML = XElement.Load(URL);
            var listaXelements = jogoXML.Elements("jogo").Where(jogo => jogo.Element("nome").Value.Contains(nome)).ToList();
            return ConvertXelToJogo(listaXelements);
        }

        public void EditarNomeJogo(string nome, string novoNome)
        {
            XElement jogoXML = XElement.Load(URL);
            var jogoEscolhido = jogoXML.Elements("jogo").FirstOrDefault(jogo => jogo.Element("nome").Value == nome);
            jogoEscolhido.Element("nome").SetValue(novoNome);
            jogoXML.Save(URL);
        }

        public void EditarPrecoJogo(string nome, double novoPreco)
        {
            XElement jogoXML = XElement.Load(URL);
            var jogoEscolhido = jogoXML.Elements("jogo").FirstOrDefault(jogo => jogo.Element("nome").Value == nome);
            jogoEscolhido.Element("preco").SetValue(novoPreco);
            jogoXML.Save(URL);
        }

        public void EditarCategoriaJogo(string nome, string novaCategoria)
        {
            XElement jogoXML = XElement.Load(URL);
            var jogoEscolhido = jogoXML.Elements("jogo").FirstOrDefault(jogo => jogo.Element("nome").Value == nome);
            jogoEscolhido.Element("categoria").SetValue(novaCategoria);
            jogoXML.Save(URL);
        }

        private List<Jogo> ConvertXelToJogo(List<XElement> listaXelements)
        {
            List<Jogo> listaJogos = new List<Jogo>();
            foreach (var att in listaXelements)
            {
                listaJogos.Add(new Jogo(att.Element("nome").Value,
                    double.Parse(att.Element("preco").Value),
                    att.Element("categoria").Value));
            }
            return listaJogos;
        }
        private Jogo ConvertXelToJogo(XElement Xelement)
        {
            return new Jogo(Xelement.Element("nome").Value,
                    double.Parse(Xelement.Element("preco").Value),
                    Xelement.Element("categoria").Value);
        }
           
    }
}
