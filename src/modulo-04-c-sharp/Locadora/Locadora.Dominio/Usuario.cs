using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio
{
    public class Usuario : EntidadeBase
    {
        public Usuario()
        {
            this.Permissoes = new HashSet<Permissao>();
        }

        public string NomeCompleto { get; set; }

        public string Email { get; set; }

        public string Senha { get; set; }
<<<<<<< HEAD

=======
        
>>>>>>> 196bc442c1d9dea6c1835e05199b10a9db08b196
        public ICollection<Permissao> Permissoes { get; private set; }

        public bool TemPermissao(string nomePermissao)
        {
            return this.Permissoes != null
                   && this.Permissoes.Any(p => p.Nome.Equals(nomePermissao));
        }
<<<<<<< HEAD

        public void AdicionarPermissao(Permissao permissao)
        {
            if (this.Permissoes == null)
=======
        
        public void AdicionarPermissao(Permissao permissao)
        {
            if(this.Permissoes == null)
>>>>>>> 196bc442c1d9dea6c1835e05199b10a9db08b196
            {
                this.Permissoes = new List<Permissao>();
            }

<<<<<<< HEAD
            if (!TemPermissao(permissao.Nome))
=======
            if(!TemPermissao(permissao.Nome))
>>>>>>> 196bc442c1d9dea6c1835e05199b10a9db08b196
            {
                this.Permissoes.Add(permissao);
            }
        }
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 196bc442c1d9dea6c1835e05199b10a9db08b196
