namespace Locadora.Repositorio.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;

    public partial class Initial : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Cliente",
                c => new
                {
                    Id = c.Int(nullable: false, identity: true),
                    Nome = c.String(nullable: false, maxLength: 250),
                })
                .PrimaryKey(t => t.Id);

            CreateTable(
                "dbo.Selo",
                c => new
                {
                    Id = c.Int(nullable: false, identity: false),
                    Nome = c.String(nullable: false, maxLength: 250),
                })
                .PrimaryKey(t => t.Id);

            CriarSelos();


            CreateTable(
                "dbo.Categoria",
                c => new
                {
                    Id = c.Int(nullable: false, identity: false),
                    Nome = c.String(nullable: false, maxLength: 250),
                })
                .PrimaryKey(t => t.Id);

            CriarCategorias();

            CreateTable(
                "dbo.Jogo",
                c => new
                {
                    Id = c.Int(nullable: false, identity: true),
                    Nome = c.String(nullable: false, maxLength: 200),
                    Preco = c.Decimal(nullable: false, precision: 18, scale: 2),
                    IdCategoria = c.Int(nullable: false),
                    IdSelo = c.Int(nullable: false),
                    Descricao = c.String(nullable: false),
                    UrlImagem = c.String(),
                    TagVideo = c.String(),
                    IdClienteLocacao = c.Int(),
                })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Cliente", t => t.IdClienteLocacao)
                .ForeignKey("dbo.Selo", t => t.IdSelo)
                .ForeignKey("dbo.Categoria", t => t.IdCategoria)
                .Index(t => t.IdSelo)
                .Index(t => t.IdClienteLocacao)
                .Index(t => t.IdCategoria);
        }

        public override void Down()
        {
            DropForeignKey("dbo.Jogo", "IdClienteLocacao", "dbo.Cliente");
            DropForeignKey("dbo.Jogo", "IdSelo", "dbo.Selo");
            DropForeignKey("dbo.Jogo", "IdCategoria", "dbo.Categoria");
            DropIndex("dbo.Jogo", new[] { "IdClienteLocacao", "IdSelo", "IdCategoria" });
            DropTable("dbo.Jogo");
            DropTable("dbo.Cliente");
            DropTable("dbo.Categoria");
            DropTable("dbo.Selo");
        }

        private void CriarSelos()
        {
            Sql("INSERT INTO Selo (Id, Nome) VALUES (1, 'Bronze')");
            Sql("INSERT INTO Selo (Id, Nome) VALUES (2, 'Prata')");
            Sql("INSERT INTO Selo (Id, Nome) VALUES (3, 'Ouro')");
        }

        private void CriarCategorias()
        {
            Sql("INSERT INTO Categoria (Id, Nome) VALUES (1, 'RPG')");
            Sql("INSERT INTO Categoria (Id, Nome) VALUES (2, 'Corrida')");
            Sql("INSERT INTO Categoria (Id, Nome) VALUES (3, 'Aventura')");
            Sql("INSERT INTO Categoria (Id, Nome) VALUES (4, 'Luta')");
            Sql("INSERT INTO Categoria (Id, Nome) VALUES (5, 'Esporte')");
        }
    }
}
