<<<<<<< HEAD
﻿using System;
=======
﻿using Locadora.Dominio;
using Locadora.Repositorio.EF.Mapping;
using System;
>>>>>>> 196bc442c1d9dea6c1835e05199b10a9db08b196
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
<<<<<<< HEAD
using Locadora.Dominio;
using System.Data.Entity.ModelConfiguration;
=======
>>>>>>> 196bc442c1d9dea6c1835e05199b10a9db08b196

namespace Locadora.Repositorio.EF
{
    class BancoDeDados : DbContext
    {
<<<<<<< HEAD
        public BancoDeDados() : base("LOCADORA")
        {

        }
        public DbSet<Jogo> Jogo { get; set; }
        public DbSet<Cliente> Cliente { get; set; }
        public DbSet<Usuario> Usuario { get; set; }
        public DbSet<Usuario> Permissao { get; set; }
=======
        public BancoDeDados() : base("LOCADORA_EF")
        {
            
        }

        public DbSet<Jogo> Jogo { get; set; }
        public DbSet<Cliente> Cliente { get; set; }
        public DbSet<Usuario> Usuario { get; set; }
        public DbSet<Permissao> Permissao { get; set; }

>>>>>>> 196bc442c1d9dea6c1835e05199b10a9db08b196

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Configurations.Add(new JogoMap());
            modelBuilder.Configurations.Add(new ClienteMap());
            modelBuilder.Configurations.Add(new PermissaoMap());
            modelBuilder.Configurations.Add(new UsuarioMap());
<<<<<<< HEAD
            base.OnModelCreating(modelBuilder);
        }
    }

    class JogoMap : EntityTypeConfiguration<Jogo>
    {
        public JogoMap()
        {
            ToTable("Jogo");
            HasKey(p => p.Id);

            Property(p => p.Nome).IsRequired();
            Property(p => p.Preco).IsRequired();
            Property(p => p.Descricao).IsRequired();
            Property(p => p.Categoria).IsRequired().HasColumnName("IdCategoria");
            Property(p => p.Selo).IsRequired().HasColumnName("IdSelo");
            Property(p => p.Imagem).IsOptional();
            Property(p => p.Video).IsOptional();
            HasOptional(p => p.ClienteLocacao).WithOptionalDependent().Map(m => m.MapKey("IdClienteLocacao"));

        }


    }

    class ClienteMap : EntityTypeConfiguration<Cliente>
    {
        public ClienteMap()
        {
            ToTable("Cliente");
            HasKey(c => c.Id);
            Property(p => p.Nome).IsRequired().HasMaxLength(200);
        }
    }

    class UsuarioMap : EntityTypeConfiguration<Usuario>
    {
        public UsuarioMap()
        {
            ToTable("Usuario");

            HasKey(u => u.Id);

            Property(u => u.Email).IsRequired().HasMaxLength(200);
            Property(u => u.Senha).IsRequired().HasMaxLength(200);

            HasMany(u => u.Permissoes).WithMany(p => p.Usuarios)
                                                .Map(m =>
                                                {
                                                    m.ToTable("Usuario_permissao");
                                                    m.MapLeftKey("IdUsuario");
                                                    m.MapRightKey("IdPermissao");
                                                });
        }
    }

    class PermissaoMap : EntityTypeConfiguration<Permissao>
    {
        public PermissaoMap()
        {
            ToTable("Permissao");
            HasKey(u => u.Id);
            Property(u => u.Nome).IsRequired().HasMaxLength(50);
        }
    }

=======

            base.OnModelCreating(modelBuilder);
        }
    }
>>>>>>> 196bc442c1d9dea6c1835e05199b10a9db08b196
}
