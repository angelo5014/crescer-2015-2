using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Repositorio.EF.Mapping
{
    class UsuarioMap : EntityTypeConfiguration<Usuario>
    {
        public UsuarioMap()
        {
            ToTable("Usuario");

            HasKey(u => u.Id);

            Property(u => u.Email).IsRequired().HasMaxLength(200);
            Property(u => u.Senha).IsRequired().HasMaxLength(200);
            Property(u => u.NomeCompleto).IsRequired().HasMaxLength(200);

            HasMany(u => u.Permissoes).WithMany(p => p.Usuarios)
                                      .Map(m =>
                                      {
                                          m.ToTable("Usuario_Permissao");
                                          m.MapLeftKey("IdUsuario");
                                          m.MapRightKey("IdPermissao");
                                      });
        }
    }
}
