using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio
{
    public class Permissao : EntidadeBase
    {
        public const string ADMIN = "ADMIN";

        public string Nome { get; private set; }

        public ICollection<Usuario> Usuarios { get; private set; }

        public Permissao(string nome)
        {
            this.Nome = nome;
        }

        private Permissao() { }
<<<<<<< HEAD

        public override bool Equals(object obj)
        {
            if (obj != null)
=======
        
        public override bool Equals(object obj)
        {
            if(obj != null)
>>>>>>> 196bc442c1d9dea6c1835e05199b10a9db08b196
            {
                Permissao permissaoComp = obj as Permissao;

                return permissaoComp.Id == this.Id
                       && permissaoComp.Nome == this.Nome
                       && permissaoComp.Usuarios == this.Usuarios;
            }

            return false;
        }
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 196bc442c1d9dea6c1835e05199b10a9db08b196
