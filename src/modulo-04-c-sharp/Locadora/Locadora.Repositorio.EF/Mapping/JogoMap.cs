using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Repositorio.EF.Mapping
{
    class JogoMap : EntityTypeConfiguration<Jogo>
    {
        public JogoMap()
        {
            ToTable("Jogo");

            HasKey(j => j.Id);

            Property(j => j.Nome).IsRequired().HasMaxLength(200);
            Property(j => j.Preco).IsRequired();
            Property(j => j.Categoria).IsRequired().HasColumnName("IdCategoria");
            Property(j => j.Selo).IsRequired().HasColumnName("IdSelo");
            Property(j => j.Descricao).IsRequired().HasMaxLength(8000);
            Property(j => j.UrlImagem).HasMaxLength(8000);
            Property(j => j.TagVideo);

            HasOptional(j => j.ClienteLocacao).WithOptionalDependent().Map(m => m.MapKey("IdClienteLocacao"));
        }
    }
}
