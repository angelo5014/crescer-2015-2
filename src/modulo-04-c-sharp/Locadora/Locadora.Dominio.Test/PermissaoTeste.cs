using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace Locadora.Dominio.Test
{
    [TestClass]
    public class PermissaoTeste
    {
        [TestMethod]
        public void PermissaoAdminEhCriada()
        {
            var permissao = new Permissao(Permissao.ADMIN);
            Assert.AreEqual(Permissao.ADMIN, permissao.Nome);
            Assert.IsNull(permissao.Usuarios);
        }

        [TestMethod]
        public void PermissaoEhIgualAOutra()
        {
            var permissaoA = new Permissao(Permissao.ADMIN);
            var permissaoB = new Permissao(Permissao.ADMIN);

            Assert.AreEqual(permissaoA, permissaoB);
        }
    }
}
