using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Repositorio.EF
{
    class RepositorioBase
    {
        protected BancoDeDados CriarConexao()
        {
            return new BancoDeDados();
        }
    }
}
