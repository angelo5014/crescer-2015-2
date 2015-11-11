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
                        Nome = c.String(nullable: false, maxLength: 200),
                    })
                .PrimaryKey(t => t.Id);

            CreateTable(
                "dbo.Categoria",
                c => new
                {
                    Id = c.Int(nullable: false, identity: false),
                    Descricao = c.String(nullable: false)
                })
                .PrimaryKey(t => t.Id);

            CriarCategorias();

            CreateTable(
                "dbo.Selo",
                c => new
                {
                    Id = c.Int(nullable: false, identity: false),
                    Descricao = c.String(nullable: false)
                })
                .PrimaryKey(t => t.Id);

            CriarSelos();

            CreateTable(
                "dbo.Jogo",
                c => new
                {
                    Id = c.Int(nullable: false, identity: true),
                    Nome = c.String(nullable: false),
                    Preco = c.Decimal(nullable: false, precision: 18, scale: 2),
                    Descricao = c.String(nullable: false),
                    IdCategoria = c.Int(nullable: false),
                    IdSelo = c.Int(nullable: false),
                    Imagem = c.String(),
                    Video = c.String(),
                    IdClienteLocacao = c.Int(),
                })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Cliente", t => t.IdClienteLocacao)
                .ForeignKey("dbo.Categoria", t => t.IdCategoria)
                .ForeignKey("dbo.Selo", t => t.IdSelo)
                .Index(t => t.IdClienteLocacao)
                .Index(t => t.IdSelo)
                .Index(t => t.IdCategoria);

        }

        public void CriarSelos()
        {
            Sql("INSERT INTO Selo VALUES(1, 'Ouro')");
            Sql("INSERT INTO Selo VALUES(2, 'Prata')");
            Sql("INSERT INTO Selo VALUES(3, 'Bronze')");
        }

        public void CriarCategorias()
        {
            Sql("INSERT INTO Categoria(Id, Descricao) VALUES(1, 'RPG')");
            Sql("INSERT INTO Categoria(Id, Descricao) VALUES(2, 'Corrida')");
            Sql("INSERT INTO Categoria(Id, Descricao) VALUES(3, 'Aventura')");
            Sql("INSERT INTO Categoria(Id, Descricao) VALUES(4, 'Luta')");
            Sql("INSERT INTO Categoria(Id, Descricao) VALUES(5, 'Esporte')");
        }

        public override void Down()
        {
            DropForeignKey("dbo.Jogo", "IdClienteLocacao", "dbo.Cliente");
            DropForeignKey("dbo.Jogo", "IdCategoria", "dbo.Categoria");
            DropForeignKey("dbo.Jogo", "IdSelo", "dbo.Selo");
            DropIndex("dbo.Jogo", new[] { "IdClienteLocacao", "IdSelo", "IdCategoria" });
            DropTable("dbo.Jogo");
            DropTable("dbo.Cliente");
            DropTable("dbo.Selo");
            DropTable("dbo.Categoria");
        }
    }
}
