using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Repositorio.EF.Mapping
{
    class LocacaoMap : EntityTypeConfiguration<Locacao>
    {
        public LocacaoMap()
        {
            ToTable("Locacao");

            HasKey(m => m.Id);
            HasRequired(m => m.Jogo).WithMany().HasForeignKey(m => m.IdJogo);//.WithRequiredDependent().Map(m => m.MapKey("IdJogo"));
            HasRequired(m => m.Cliente).WithMany().HasForeignKey(m => m.IdCliente);//.WithRequiredDependent().Map(m => m.MapKey("IdCliente"));
            Property(m => m.DataLocacao).IsRequired();
            Property(m => m.DataDevolucao).IsOptional();
        }

    }
}
