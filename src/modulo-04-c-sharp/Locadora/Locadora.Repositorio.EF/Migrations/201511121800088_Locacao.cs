namespace Locadora.Repositorio.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class Locacao : DbMigration
    {
        public override void Up()
        {
            DropForeignKey("dbo.Jogo", "IdClienteLocacao", "dbo.Cliente");
            DropIndex("dbo.Jogo", new[] { "IdClienteLocacao" });
            CreateTable(
                "dbo.Locacao",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        DataLocacao = c.DateTime(nullable: false),
                        DataDevolucao = c.DateTime(),
                        IdCliente = c.Int(nullable: false),
                        IdJogo = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Cliente", t => t.IdCliente)
                .ForeignKey("dbo.Jogo", t => t.IdJogo)
                .Index(t => t.IdCliente)
                .Index(t => t.IdJogo);
            
            DropColumn("dbo.Jogo", "IdClienteLocacao");
        }
        
        public override void Down()
        {
            AddColumn("dbo.Jogo", "IdClienteLocacao", c => c.Int());
            DropForeignKey("dbo.Locacao", "IdJogo", "dbo.Jogo");
            DropForeignKey("dbo.Locacao", "IdCliente", "dbo.Cliente");
            DropIndex("dbo.Locacao", new[] { "IdJogo" });
            DropIndex("dbo.Locacao", new[] { "IdCliente" });
            DropTable("dbo.Locacao");
            CreateIndex("dbo.Jogo", "IdClienteLocacao");
            AddForeignKey("dbo.Jogo", "IdClienteLocacao", "dbo.Cliente", "Id");
        }
    }
}
