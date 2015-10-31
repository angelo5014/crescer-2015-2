using System;
using System.Collections.Generic;
using System.IO;
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

        public void EditarCategoriaJogo(string nome, Categoria novaCategoria)
        {
            XElement jogoXML = XElement.Load(URL);
            var jogoEscolhido = jogoXML.Elements("jogo").FirstOrDefault(jogo => jogo.Element("nome").Value == nome);
            jogoEscolhido.Element("categoria").SetValue(novaCategoria.ToString());
            jogoXML.Save(URL);
        }

        public List<Jogo> ConvertXelToJogo(List<XElement> listaXelements)
        {
            List<Jogo> listaJogos = new List<Jogo>();
            foreach (var att in listaXelements)
            {
                var jogo = new Jogo(att.Element("nome").Value,
                    double.Parse(att.Element("preco").Value, System.Globalization.CultureInfo.InvariantCulture),
                    (Categoria)Enum.Parse(typeof(Categoria), att.Element("categoria").Value));
                jogo.Disponivel = att.Element("disponivel").Value == "SIM" ? true : false;
                listaJogos.Add(jogo);
            }
            return listaJogos;
        }

        public Jogo ConvertXelToJogo(XElement Xelement)
        {
            var jogo = new Jogo(Xelement.Element("nome").Value,
                    double.Parse(Xelement.Element("preco").Value, System.Globalization.CultureInfo.InvariantCulture),
                    (Categoria)Enum.Parse(typeof(Categoria),Xelement.Element("categoria").Value));
            jogo.Disponivel = Xelement.Element("disponivel").Value == "SIM" ? true : false;
            return jogo;
        }

        public int totalJogos()
        {
            XElement jogoXML = XElement.Load(URL);
            return Convert.ToInt32(jogoXML.Elements("jogo").Count());
        }

        public int totalJogosDisp()
        {
            XElement jogoXML = XElement.Load(URL);
            var a = Convert.ToInt32(jogoXML.Elements("jogo").Where(jogo => jogo.Element("disponivel").Value == "SIM").Count());
            return a;
        }
        public double valorMedio()
        {
            XElement jogoXML = XElement.Load(URL);
            return jogoXML.Elements("jogo").Average(jogo => double.Parse(jogo.Element("preco").Value, System.Globalization.CultureInfo.InvariantCulture));
        }
        public string jogoMaisCaro()
        {
            XElement jogoXML = XElement.Load(URL);
            var maiorValor = jogoXML.Elements("jogo")
                .Max(jogo => double.Parse(
                    jogo.Element("preco").Value, 
                    System.Globalization.CultureInfo.InvariantCulture));

            var jogoEncontrado = jogoXML.Elements("jogo")
                .First(jogo => 
                double.Parse(jogo.Element("preco").Value, 
                System.Globalization.CultureInfo.InvariantCulture) == maiorValor);

            return jogoEncontrado.Element("nome").Value;
        }
        public string jogoMaisBarato()
        {
            XElement jogoXML = XElement.Load(URL);
            var MenorValor =  jogoXML.Elements("jogo")
                .Min(jogo => double.Parse(jogo.Element("preco").Value,
                System.Globalization.CultureInfo.InvariantCulture));

            var jogoEncontrado = jogoXML.Elements("jogo")
                .First(jogo =>
                double.Parse(jogo.Element("preco").Value,
                System.Globalization.CultureInfo.InvariantCulture) == MenorValor);

            return jogoEncontrado.Element("nome").Value;
        }
    }
 }
