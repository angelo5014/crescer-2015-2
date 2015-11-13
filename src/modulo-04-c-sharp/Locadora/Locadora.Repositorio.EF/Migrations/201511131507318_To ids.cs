namespace Locadora.Repositorio.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class Toids : DbMigration
    {
        public override void Up()
        {
            DropForeignKey("dbo.Locacao", "IdCliente", "dbo.Cliente");
            DropForeignKey("dbo.Locacao", "IdJogo", "dbo.Jogo");
            AddForeignKey("dbo.Locacao", "IdCliente", "dbo.Cliente", "Id", cascadeDelete: true);
            AddForeignKey("dbo.Locacao", "IdJogo", "dbo.Jogo", "Id", cascadeDelete: true);
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Locacao", "IdJogo", "dbo.Jogo");
            DropForeignKey("dbo.Locacao", "IdCliente", "dbo.Cliente");
            AddForeignKey("dbo.Locacao", "IdJogo", "dbo.Jogo", "Id");
            AddForeignKey("dbo.Locacao", "IdCliente", "dbo.Cliente", "Id");
        }
    }
}
